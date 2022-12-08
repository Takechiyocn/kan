package com.moku.servlet02;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName Servlet02
 * @Description TODO
 * @Author moku
 * @Date 2022/11/26 10:17
 * @Version 1.0
 */
public class Servlet02 implements Servlet {
    // 1. 声明ServletConfig对象
    private ServletConfig config;
    @Override
    public void init(ServletConfig config) throws ServletException {
        // 2. 初始化ServletConfig对象
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String s = this.config.getInitParameter("desc");
        // 1. 通过ServletConfig对象调用getServletContext()获取ServletContext对象
        // 2. 通过ServletContext对象调用使用其方法：此处ServletContext对象=this.config.getServletContext()
        String s2 = this.config.getServletContext().getInitParameter("gdesc");

        System.out.println("Servlet config: " + s);
        System.out.println("Context config: " + s2);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
    }
}
