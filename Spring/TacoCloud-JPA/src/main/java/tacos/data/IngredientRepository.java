package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.Ingredient;

/**
 * Ingredient：要持久化的实体类型
 * String：实体ID属性类型
 */
public interface IngredientRepository
        extends CrudRepository<Ingredient, String> {
}
