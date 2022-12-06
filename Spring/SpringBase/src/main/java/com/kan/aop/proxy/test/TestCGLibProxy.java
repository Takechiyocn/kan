package com.kan.aop.proxy.test;

import com.kan.aop.proxy.business.interfaces.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * SpringAOP解析步骤
 *   1. Spring容器启动加载Spring配置文件
 *   2. 为配置文件中所有的bean创建对象
 *   3. Spring容器解析aop:config配置
 *      a. 解析切入点表达式，用切入点表达式和纳入Spring容器中的bean做匹配
 *         i. 匹配成功，准备为该bean创建代理对象，代理对象的方法=目标方法+通知
 *         ii. 匹配不成功，不创建代理对象
 *   4. 客户端用context.getBean获取对象时
 *      a. 有代理对象：返回代理对象
 *      b. 没有代理对象：返回目标对象(不做代理)
 *         i. 代理对象未实现代理接口，Spring容器采用CGLib代理
 *         ii.代理对象实现代理接口，Spring容器采用JDK动态代理
 *  此处采用CGLib代理
 * @author moku
 */
public class TestCGLibProxy {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringAOPConfig.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.addUser(null);
    }
}
