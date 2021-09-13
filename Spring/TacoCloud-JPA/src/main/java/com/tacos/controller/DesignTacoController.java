package com.tacos.controller;

import com.tacos.domain.Ingredient;
import com.tacos.domain.Order;
import com.tacos.domain.Taco;
import com.tacos.service.IngredientRepository;
import com.tacos.service.TacoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kan
 */
@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {
    private final IngredientRepository ingredientRepo;
    private TacoRepository designRepo;

    @Autowired
    public DesignTacoController(
            IngredientRepository ingredientRepo,
            TacoRepository designRepo) {
        this.ingredientRepo = ingredientRepo;
        this.designRepo = designRepo;
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        // lambda
        // 方法引用：forEach(ingredients::add)
        ingredientRepo.findAll().forEach(i -> ingredients.add(i));

        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type)
            );
        }
        return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processDesign(
            @Valid Taco design,
            Errors errors,
            @ModelAttribute Order order) {  // ModelAttribute表明order值应该来自模型，Spring不会尝试将请求参数绑定到它上面

        // TODO: 输入错误时，画面再显示
        if (errors.hasErrors()) {
            return "design";
        }

        if (design.getCreatedAt() == null) {
            design.setCreatedAt(new Date());
        }

        Taco saved = designRepo.save(design);
        // 将Taco对象保存到session里面的Order中，直到提交/更新到数据库(sessionStatus.setComplete();)
        order.addDesign(saved);
        log.info("Processing design: " + design);

        return "redirect:/orders/current";
    }
}
