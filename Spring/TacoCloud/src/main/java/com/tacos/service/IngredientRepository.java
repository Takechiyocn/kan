package com.tacos.service;
import com.tacos.entity.Ingredient;

/**
 *
 */
public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    /**
     * find Ingredient by id
     * @param id  id
     * @return Ingredient
     */
    Ingredient findOne(String id);

    /**
     * save Ingredient
     * @param ingredient ingredient
     * @return ingredient
     */
    Ingredient save(Ingredient ingredient);

    /**
     * find Ingredient by id
     * @param id id
     * @return Ingredient
     */
    Ingredient findById(String id);
}
