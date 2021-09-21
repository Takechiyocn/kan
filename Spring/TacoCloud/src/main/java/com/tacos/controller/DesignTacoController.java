package com.tacos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import com.tacos.entity.Ingredient;
import com.tacos.entity.Ingredient.Type;
import com.tacos.entity.Order;
import com.tacos.entity.Taco;
import com.tacos.dao.IngredientRepository;
import com.tacos.dao.TacoRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类级别的SessionAttributes能够指定模型对象（order：订单属性）要保存在session中，才能跨请求使用
 *
 * @author kan
 */
@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;
    private TacoRepository designRepo;

    /**
     * 注入IngredientRepository，TacoRepository
     *
     * @param ingredientRepo
     * @param designRepo
     */
    @Autowired
    public DesignTacoController(
            IngredientRepository ingredientRepo,
            TacoRepository designRepo) {
        this.ingredientRepo = ingredientRepo;
        this.designRepo = designRepo;
    }

    // 确保在模型中创建一个Order对象
    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    // 确保在模型中创建一个Taco对象
    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    /**
     * Model属性中的数据会复制到Servlet Response中，以便视图使用
     * @param model
     * @return
     */
    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(ingredients::add);

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type)
            );
        }
        return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    /**
     * ModelAttribute表明order值应该来自模型，Spring不会尝试将请求参数绑定到它上面
     * @param design
     * @param errors
     * @param order
     * @return
     */
    @PostMapping
    public String processDesign(
            @Valid Taco design,
            Errors errors,
            @ModelAttribute Order order) {

        // TODO: 输入错误时，画面再显示
        if (errors.hasErrors()) {
            return "design";
        }

        Taco saved = designRepo.save(design);
        // 将Taco对象保存到session里面的Order中，直到提交/更新到数据库(sessionStatus.setComplete)
        order.addDesign(saved);
        log.info("Processing design: " + design);

        return "redirect:/orders/current";
    }
}
