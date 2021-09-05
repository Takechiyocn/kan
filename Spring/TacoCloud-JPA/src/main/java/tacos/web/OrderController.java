package tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import tacos.Order;
import tacos.User;
import tacos.data.OrderRepository;

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
    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    /**
     * 表单提交的Order对象亦即session中持有的Object对象
     * AuthenticationPrincipal注解使user变成认证的principal
     * 注入User(已认证用户)
     * 1. 注入Principal对象到控制器方法中
     * public String processOrder(@Valid Order order, Errors errors,
     * SessionStatus sessionStatus,
     * Principal principal)
     * User user = userRepository.findByUsername(principal.getName());
     * -> 在与安全无关的功能中参杂安全性代码
     * 2. 注入Authentication对象到控制器方法中
     * public String processOrder(@Valid Order order, Errors errors,
     * SessionStatus sessionStatus,
     * Authentication authentication)
     * User user = (User)authentication.getPrincipal();
     * 3. 使用SecurityContextHolder来获取安全上下文
     *   Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
     *   User user = (User) authentication.getPrincipal();
     * ->充满安全性代码，可以在程序任何地方使用，适合在较低级别的代码中使用
     * 4. 使用@AuthenticationPrincipal注解来标注方法
     *
     * @param order
     * @param errors
     * @param sessionStatus
     * @param user
     * @return
     */
    @PostMapping
    public String processOrder(@Valid Order order, Errors errors,
                               SessionStatus sessionStatus,
                               @AuthenticationPrincipal User user) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        order.setUser(user);
        orderRepo.save(order);
        // 删除session中对象order
        sessionStatus.setComplete();
        log.info("Order submitted: " + order);

        return "redirect:/";
    }
}
