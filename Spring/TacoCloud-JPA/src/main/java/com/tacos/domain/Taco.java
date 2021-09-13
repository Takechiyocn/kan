package com.tacos.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author kan
 */
@Data
@Entity
public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    /**
     * 如果Column注解定义的字段名和属性名一样，会被忽略。
     */
    @Column(name = "createdAt")
    private Date createdAt;

    /**
     * 声明Taco与其关联的Ingredient列表的关系
     *  a.每个Taco可以有多个Ingredient
     *  b.每个Ingredient可以是多个Taco的组成部分
     */
    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
