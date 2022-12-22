package com.kan.annonation.customize;

import java.lang.reflect.Field;

/**
 * @ClassName FruitInfoUtil
 * @Description 注解处理器
 * @Author moku
 * @Date 2022/12/22 19:31
 * @Version 1.0
 */
public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz) {
        String strFruitProvider = "供应商信息：";
        // 通过反射获取处理注解
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fp = f.getAnnotation(FruitProvider.class);
                strFruitProvider = "供应商编号" + fp.id()
                        + ", 供应商名称：" + fp.name()
                        + ", 供应商地址：" + fp.address();
                System.out.println(strFruitProvider);
            }
        }
    }
}
