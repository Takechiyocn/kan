package tacos.data;
import tacos.Ingredient;

/**
 *
 */
public interface IngredientRepository {
    Iterable<Ingredient> findAll();

    /**
     * find Ingredient
     * @param id  id
     * @return Ingredient
     */
    Ingredient findOne(String id);

    /**
     * find Ingredient
     * @param ingredient ingredient
     * @return ingredient
     */
    Ingredient save(Ingredient ingredient);

    /**
     * find Ingredient
     * @param id id
     * @return Ingredient
     */
    Ingredient findById(String id);
}
