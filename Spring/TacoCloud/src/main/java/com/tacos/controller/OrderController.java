package com.tacos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import com.tacos.entity.Order;
import com.tacos.service.OrderRepository;

import javax.validation.Valid;

/**
 * @author kan
 */
@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepo;

    // 注入OrderRepository
    // TODO:此处不用Autowired？ SimpleJdbcInsert的原因？
    @Autowired
    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm() {
        // 被解析为视图的逻辑名
        return "orderForm";
    }

    /**
     * 表单提交的Order对象亦即session中持有的Object对象
     */
    @PostMapping
    public String processOrder(@Valid Order order, Errors errors,
                               SessionStatus sessionStatus) {

        if (errors.hasErrors()) {
            return "orderForm";
        }

        orderRepo.save(order);
        // 删除session中对象order
        sessionStatus.setComplete();
        log.info("Order submitted: " + order);

        return "redirect:/";
    }
}
