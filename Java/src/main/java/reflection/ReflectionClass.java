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
public class ReflectionClass {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        // 1.获取类名：通过对象
        Employee el = new Employee("employee1");
        Manager mn = new Manager("manager1", 1000, 1991, 1, 1);
        Class clmn = mn.getClass();

        log.info("el:" + el.getClass().getName());
        log.info("mn:" + clmn.getName());

        // 2.获取雷鸣：静态方法，通过类名（字符串）
        //  --> 当类名保存在字符串中且在运行中可变
        String className = "occupation.Manager";
        // 获取class对象
        Class clmn2 = Class.forName(className);
        log.info("mn2:" + clmn2.getName());

        // 3.T.class
        Class cl1 = Random.class;
        // int不是类，但int.class是一个Class类型的对象
        Class cl2 = int.class;
        Class cl3 = Integer.class;
        Class cl4 = double.class;
        Class cl5 = Double.class;
        log.info(cl1.getName());
        log.info(cl2.getName());
        log.info(cl3.getName());
        log.info(cl4.getName());
        log.info(cl5.getName());

        // class类型数组无法正常显示
        log.info("Array double:" + Double[].class.getName());
        log.info("Array int:" + int[].class.getName());

        // 类型比较==
        if (el.getClass() == Employee.class) {
            log.info("Equals");
        } else {
            log.info("Not equals");
        }

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

            // class类型数组无法正常显示，需要重新获取
            Class[] parameterTypes = cons.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i > 0) {
                    parameters.append(", ");
                }
                parameters.append(parameterTypes[i].getName());
            }
            // 构造器：修饰符+方法签名（构造函数名+参数列表）
            log.info("构造器：" + Modifier.toString(cons.getModifiers()) +
                    cons.getName() + "(" +
                    parameters + ")");
        }
    }
}
