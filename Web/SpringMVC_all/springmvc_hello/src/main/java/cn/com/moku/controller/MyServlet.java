package cn.com.moku.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @ClassName MyServlet
 * @Description
 * @Author moku
 * @Date 2023/2/12 1:48
 * @Version 1.0
 */
@WebServlet("/myServlet.do")
public class MyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("创建servlet并跳转至jsp页面");
        // 创建普通Servlet，然后跳转至JSP

        //添加数据
        req.setAttribute("msg","Hello FreeMarker!");

        //boolean（布尔）类型
        req.setAttribute("flag",true);

        // 日期类型  new Data()表示获取现在电脑的时间
        req.setAttribute("createDate",new Date());

        // 数值类型
        req.setAttribute("age",18); // 数值型
        req.setAttribute("salary",10000); // 数值型
        req.setAttribute("avg",0.545); // 浮点型

        // 字符串类型
        req.setAttribute("msg1","Hello ");
        req.setAttribute("msg2","freemarker");

//        req.getRequestDispatcher("first.jsp").forward(req, resp);
        req.getRequestDispatcher("templates/f01.ftl").forward(req, resp);
    }
}
