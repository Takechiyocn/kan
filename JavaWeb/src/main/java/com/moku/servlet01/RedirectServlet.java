package com.moku.servlet01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName RedirectServlet
 * @Description TODO
 * @Author moku
 * @Date 2022/11/26 1:36
 * @Version 1.0
 */
@WebServlet(urlPatterns = "/hi")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 构造重定向路径
        String name = req.getParameter("name");
//        String redirectToUrl = "/hello" + (name == null ? "" : "?name=" + name);
        String redirectToUrl = "/JavaWeb_war_exploded/hello";
        System.out.println("redirect");
        // 发送重定向响应
        resp.sendRedirect(redirectToUrl);
    }
}
