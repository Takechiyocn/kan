package reflection.executeMethodFromDb;

import common.ConstantsBase;
import lombok.extern.slf4j.Slf4j;
import occupation.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


/**
 * TODO: 方法调用invoke追加
 * https://code.yamarou.com/java-reflection/
 * TODO：数据库追加
 */
@Slf4j
public class exeMethodFromDb {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        eReflection();
    }

    public static void eReflection() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 构造对象list
        ArrayList<Object> objList = new ArrayList<>();

        // 获取class对象
        Class<?> cls = Class.forName("occupation.Employee");
        // 获取函数构造信息
        Constructor[] constructors = cls.getConstructors();
        // 获取参数列表
        for (Constructor con : constructors) {
            // 参数list
            ArrayList<String> list = new ArrayList<>();

            Class[] clz = con.getParameterTypes();
            for (Class c : clz) {
                list.add(c.getName());
            }
            log.info(list.toString());
            String[] parameterArray = list.toArray(new String[0]);
            // TODO:优化
            // 参数长度：0
            if (parameterArray.length == 0) {
                objList.add(con.newInstance());
            }
            // 参数长度：1
            if (parameterArray.length == 1) {
                if (ConstantsBase.STRING_PARAMETER.equals(parameterArray[0])) {
                    // Employee(String)
                    objList.add(con.newInstance("testuser1"));
                }
            }
            // 参数长度：2
            if (parameterArray.length == 2) {
                if (ConstantsBase.STRING_PARAMETER.equals(parameterArray[0]) &&
                        ConstantsBase.DOUBLE_PARAMETER.equals(parameterArray[1])) {
                    objList.add(con.newInstance("testuser2", 10000));
                }
            }
            // 参数长度：5
            if (parameterArray.length == 5) {
                if (ConstantsBase.STRING_PARAMETER.equals(parameterArray[0]) &&
                        ConstantsBase.DOUBLE_PARAMETER.equals(parameterArray[1]) &&
                        ConstantsBase.INTEGER_PARAMETER.equals(parameterArray[2]) &&
                        ConstantsBase.INTEGER_PARAMETER.equals(parameterArray[3]) &&
                        ConstantsBase.INTEGER_PARAMETER.equals(parameterArray[4])) {
                    objList.add(con.newInstance("testuser3", 20000,1992,1,1));
                }
            }
            // 参数长度：n
        }

        // Employee对象查看
        for (Object o : objList) {
            log.info("name=" + ((Employee)o).getName() + ",id=" + ((Employee)o).getId() + ",salary=" + ((Employee)o).getSalary() + ",hireDay=" + ((Employee)o).getHireDay());
        }
    }
}
