package com.kan.di.annotation.service4;

import com.kan.di.annotation.interfaces.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName UserFilter
 * @Description
 * @Author moku
 * @Date 2022/12/12 10:34
 * @Version 1.0
 */
@Service
public class UserFilter implements Filter {
    // UserFilter被SpringBoot默认ComponentScan组件扫描注入，此后对于所有Web应用，Filter的init会优先于DispatcherServlet执行

    // IUser注入时，Filter初始化(init)还没完成
//    @Autowired
//    private IUser user;
    // 解决方案：
    //  1. 取消@Autowired注解
    //  1. 通过WebApplicationContextUtils.getWebApplicationContext获取当前的ApplicationContext
    //  2. 通过1获取的ApplicationContext获取bean实例
    private IUser user;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
        this.user = (IUser) (context.getBean("diMultiBean2Impl1"));
        user.say();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    }

    @Override
    public void destroy() {
    }
}
