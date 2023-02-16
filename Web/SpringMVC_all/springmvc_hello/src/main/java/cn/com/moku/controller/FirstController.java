package cn.com.moku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName FirstController
 * @Description
 * @Author moku
 * @Date 2023/2/12 2:07
 * @Version 1.0
 */
@Controller
@RequestMapping("/moku")
public class FirstController {
    @RequestMapping("/firstController.do")
    public String firstController() {
        System.out.println("this is firstController");
        return "/first.jsp";
    }
}
