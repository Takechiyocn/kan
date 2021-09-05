package reflection;

import java.lang.reflect.*;
import java.util.Scanner;

/**
 *
 */
public class ReflectionMethodFieldClass {
    public static void main(String[] args) throws ClassNotFoundException {
        String name;

        // 类名字符串获取：参数传递
        if (args.length > 0) {
            name = args[0];
        } else {
            // 类名字符串获取：输入
            Scanner in = new Scanner(System.in);
            System.out.print("Enter class name(eg.java.util.Date):");
            name = in.next();
        }


        // 类名
        Class<?> cl = getClass(name);

        // 构造器列表
        getConstructors(cl);

        // 方法列表
        getMethods(cl);

        // 域列表
        getFields(cl);

        System.out.println("}");
    }

    /**
     *
     */
    public static Class getClass(String name) throws ClassNotFoundException {
        // 控制器
        StringBuilder constructorName = new StringBuilder();
        // 类对象
        Class<?> cl = Class.forName(name);
        // 超类
        Class<?> supercl = cl.getSuperclass();
        // 访问修饰符
        String modifier = Modifier.toString(cl.getModifiers());

        // 有修饰符
        if (modifier.length() > 0) {
            constructorName.append(modifier);
            constructorName.append(" ");
        }
        constructorName.append("class ");
        constructorName.append(name);

        // 超类有无
        if (null != supercl && supercl != Object.class) {
            constructorName.append(" extends ");
            constructorName.append(supercl.getName());
        }
        constructorName.append(" {");
        System.out.println(constructorName);

        return cl;
    }

    /**
     *
     */
    public static void getConstructors(Class<?> cl) {
        // 构造器列表
        Constructor<?>[] constructors = cl.getDeclaredConstructors();

        // 构造器：访问修饰符+方法签名（方法名+参数类型）
        for (Constructor<?> c : constructors) {
            // 构造器
            StringBuilder constructorName = new StringBuilder();
            constructorName.append("    ");
            // 访问修饰符
            String modifier = Modifier.toString(c.getModifiers());
            // 构造器名
            String name = c.getName();

            // 有修饰符
            if (modifier.length() > 0) {
                constructorName.append(modifier);
                constructorName.append(" ");
            }
            constructorName.append(name);
            constructorName.append("(");

            // 参数列表
            Class<?>[] parameterTypes = c.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                // 参数分隔符
                if (i > 0) {
                    constructorName.append(", ");
                }
                // 参数类型为数组
                if (parameterTypes[i].isArray()) {
                    constructorName.append(parameterTypes[i].getComponentType().getName());
                    constructorName.append("[]");
                } else {
                    constructorName.append(parameterTypes[i].getName());
                }
            }
            constructorName.append(");");
            System.out.println(constructorName);
        }
    }

    /**
     * @Description 获取方法
     *
     */
    public static void getMethods(Class<?> cl) {
        System.out.println();
        // 方法列表
        Method[] methods = cl.getDeclaredMethods();

        // 方法：访问修饰符+返回类型+方法签名（方法名+参数类型）
        for (Method m : methods) {
            // 方法
            StringBuilder methodName = new StringBuilder();
            methodName.append("    ");
            // 访问修饰符
            String modifier = Modifier.toString(m.getModifiers());
            // 返回类型
            String retType;
            // 方法名
            String name = m.getName();

            // 有修饰符
            if (modifier.length() > 0) {
                methodName.append(modifier);
                methodName.append(" ");

            }
            // 返回类型为数组
            if (m.getReturnType().isArray()) {
                retType = m.getReturnType().getComponentType().getName() + "[]";
            } else {
                retType = m.getReturnType().getName();
            }
            methodName.append(retType);
            methodName.append(" ");
            methodName.append(name);
            methodName.append("(");

            // 参数列表
            Class<?>[] parameterTypes = m.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i > 0) {
                    methodName.append(", ");
                }
                // 参数类型为数组
                if (parameterTypes[i].isArray()) {
                    methodName.append(parameterTypes[i].getComponentType().getName() + "[]");
                } else {
                    methodName.append(parameterTypes[i].getName());
                }
            }
            methodName.append(");");
            System.out.println(methodName);
        }
    }

    /**
     * @Description 获取域
     */
    public static void getFields(Class<?> cl) {
        System.out.println();
        // 域列表
        Field[] fields = cl.getDeclaredFields();
        // 实例域：访问修饰符+类型+域名
        for (Field f : fields) {
            // 域
            StringBuilder filedName = new StringBuilder();
            filedName.append("    ");
            // 访问修饰符
            String modifier = Modifier.toString(f.getModifiers());
            // 域(值)类型：数组或者其他非数组类型
            String typeName = "";
            //
            // isArray操作对象：类对象
            Class<?> type = f.getType();
            if (type.isArray()) {
                // 域(值)类型为基本类型数组
                typeName = type.getComponentType().getName() + "[]";
            } else {
                typeName += type.getName();
            }
            // 域名
            // TODO 域名/返回类型也是Object类型如何获取完整域名？
            // TODO: List等等泛型。。
            String name = f.getName();

            // 有修饰符
            if (modifier.length() > 0) {
                filedName.append(modifier);
                filedName.append(" ");
            }
            filedName.append(typeName);
            filedName.append(" ");
            filedName.append(name);
            filedName.append(";");
            System.out.println(filedName);
        }
    }
}
