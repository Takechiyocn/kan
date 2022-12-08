package com.moku.servlet01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ForwardServlet
 * @Description TODO
 * @Author moku
 * @Date 2022/11/26 1:47
 * @Version 1.0
 */
@WebServlet(urlPatterns = "/morning")
public class ForwardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("forward");
        req.getRequestDispatcher("/hello").forward(req, resp);
    }
}
