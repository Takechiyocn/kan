package com.kan.ioc.initial.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 容器创建对象的时机
 *   1. 启动Spring容器便创建对象(遇到bean便创建对象)
 *      -> 某些bean过早放入内存，如果有数据则会增大内存消耗
 *         启动Spring容器时，检查Spring配置文件的正确性，前期容易发现错误(如Spring无法正常启动则tomcat则启动失败)
 * @author moku
 */
public class TestCreateObjectTimingDefault {
    public static void main(String[] args) {
        // 工厂方法先于实体构造器方法执行(配置文件已定义3个HelloIoc类的bean)
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringIOCConfig.xml");
    }
}
