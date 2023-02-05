package reflection;

import lombok.extern.slf4j.Slf4j;
import occupation.Employee;
import occupation.Manager;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Random;

/**
 * @description: 能够分析类能力的程序称为反射
 * @author: Kan
 * @date: 2021/2/23 23:34
 */
@Slf4j
public class ReflectionBase {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        // 获取类对象
        getClazz();

        // 类对象比较
        clazzCompare();

        // 基本类型和包装类型
        primitiveAndWrapper();

        // 基本类型和包装类型数组
        primitiveAndWrapperArray();

        // 创建类实例（对象）: newInstance(调用默认构造器:无参构造器)
        Object m = Class.forName("occupation.Employee").newInstance();
        log.info("Name:" + ((Employee) m).getName() + ",id:" + ((Employee) m).getId());

        // 获取Class对象：Constructor类（有参构造器）
        Class<?> cls = Class.forName("occupation.Employee");
        // 获取类某一构造方法
        Constructor constructor = cls.getConstructor(new Class[]{String.class, double.class});
        // 构造函数信息
        log.info("修饰符：" + Modifier.toString(constructor.getModifiers()));
        log.info("构造函数名：" + constructor.getName());
        // class类型数组无法正常显示
        log.info("参数列表：" + constructor.getParameterTypes());
        Object n = Class.forName("occupation.Employee").getConstructor(new Class[]{String.class, double.class}).newInstance("test", 1000);
        log.info("通过指定参数类型获取构造器创建对象：name:" + ((Employee) n).getName() + ",salary:" + ((Employee) n).getSalary());

        // 获取类所有构造方法
        Constructor[] constructors = cls.getConstructors();
        // 获取所有参数列表
        for (Constructor cons : constructors) {
            StringBuilder parameters = new StringBuilder();

            // 获取构造器参数列表
            // TODO：class类型数组无法正常显示，需要重新获取
            Class[] parameterTypes = cons.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i > 0) {
                    parameters.append(", ");
                }
                parameters.append(parameterTypes[i].getName());
            }
            // 构造器：修饰符+方法签名（构造函数名+参数列表）
            log.info("构造器：" + Modifier.toString(cons.getModifiers()) + " " +
                    cons.getName() + "(" +
                    parameters + ")");
        }
    }

    private static void primitiveAndWrapperArray() {
        // class类型数组无法正常显示
        log.info("基本类型int数组:" + int[].class.getName());
        log.info("包装类型Integer数组:" + Integer[].class.getName());
        log.info("基本类型double数组:" + double[].class.getName());
        log.info("包装类型Double数组:" + Double[].class.getName());
    }

    private static void primitiveAndWrapper() {
        // int不是类，但int.class是一个Class类型的对象
        log.info("基本类型int:" + int.class.getName());
        log.info("包装类型Integer:" + Integer.class.getName());
        log.info("基本类型double:" + double.class.getName());
        log.info("包装类型Double:" + Double.class.getName());
    }

    private static void clazzCompare() throws ClassNotFoundException {
        Employee el = new Employee("e");
        Employee el2 = new Employee("e2");
        Class cl1 = el.getClass();
        Class cl2 = Class.forName("occupation.Employee");
        Class cl3 = Employee.class;
        Class cl4 = el2.getClass();

        // 类型比较==
        // true
        if (cl1 == cl2 && cl2 == cl3 && cl3 == cl4) {
            log.info("类对象比较：Java运行时每一个类只会生成一个Class对象");
        } else {
            log.info("Not equals");
        }
    }

    /**
     *
     * 获取类对象：1. 通过类实例即 clazz = instance.getClass();
     *           2. clazz = Class.forName("完整类路径")
     *           3. 类T.class
     */
    private static void getClazz() throws ClassNotFoundException {
        // 1. 通过类对象/实例即 clazz = instance.getClass();
        Employee el = new Employee("employee1");
        Manager mn = new Manager("manager1", 1000, 1991, 1, 1);
        Class c = mn.getClass();

        log.info("获取类对象方法1：el=" + el.getClass().getName());
        log.info("获取类对象方法1：mn=" + c.getName());

        // 2. clazz = Class.forName("完整类路径")
        //    当类名保存在字符串中且在运行中可变
        String className = "occupation.Manager";
        Class c2 = Class.forName(className);
        log.info("获取类对象方法2：mn2=" + c2.getName());

        // 3. T.class
        Class cl1 = Random.class;
        log.info("获取类对象方法3：cl1=" + cl1.getName());
    }
}
