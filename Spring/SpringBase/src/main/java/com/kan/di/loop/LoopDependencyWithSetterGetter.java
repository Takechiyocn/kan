package com.kan.di.loop;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName LoopDependencyWithSetterGetter
 * @Description
 * @Author moku
 * @Date 2022/12/14 0:53
 * @Version 1.0
 */
public class LoopDependencyWithSetterGetter {
        private static final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        System.out.println(getBean(A.class).getB());
        System.out.println(getBean(B.class).getA());
    }

    private static <T> T getBean(Class<T> beanClass) throws InstantiationException, IllegalAccessException {
        String beanName = beanClass.getSimpleName().toLowerCase();
        // Bean实例是否已经创建
        if (singletonObjects.containsKey(beanName)) {
            return (T) singletonObjects.get(beanName);
        }

        // 1. 半成品Bean创建：实例化对象存入缓存
        Object o = beanClass.newInstance();
        singletonObjects.put(beanName, o);

        // 2. 属性填充
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field f : fields) {
            // 更改域成员访问属性
            f.setAccessible(true);
            // 获取域成员属性
            Class<?> cl = f.getType();
            // 此处明确域成员为Object类型，故使用cl.getSimpleName()
            String fName = cl.getSimpleName().toLowerCase();
            f.set(o, singletonObjects.containsKey(fName) ? singletonObjects.get(fName) : getBean(cl));
            f.setAccessible(false);
        }
        return (T) o;
    }
}

class A {
    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}

class B {
    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}