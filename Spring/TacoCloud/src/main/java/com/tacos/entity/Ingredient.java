package com.tacos.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author kan
 */
@Data
@RequiredArgsConstructor
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        /**
         * WRAP：包裹物
         * PROTEIN：蛋白质
         * VEGGIES：蔬菜
         * CHEESE：奶酪
         * SAUCE：调味汁/酱汁
         */
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
