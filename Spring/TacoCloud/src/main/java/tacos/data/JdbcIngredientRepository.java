package tacos.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import tacos.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author kan
 */
@Slf4j
@Repository
public class JdbcIngredientRepository implements IngredientRepository {
    private JdbcTemplate jdbc;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbc.query("select id, name, type from Ingredient",
                this::mapRowToIngredient);
    }

    /**
     * Find by id with Lambda function
     *
     * @param id id
     * @return Ingredient
     */
    @Override
    public Ingredient findOne(String id) {
        return jdbc.queryForObject(
                "select id, name, type from Ingredient where id=?",
                (resultSet, i) -> new Ingredient(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        Ingredient.Type.valueOf(resultSet.getString("type")))
                , id);
    }

    /**
     * Find by id with Anonymous function
     */
    @Override
    public Ingredient findById(String id) {
        return jdbc.queryForObject(
                "select id, name, type from Ingredient where id=?",
                new RowMapper<>() {
                    @Override
                    public Ingredient mapRow(ResultSet resultSet, int i) throws SQLException {
                        return new Ingredient(
                                resultSet.getString("id"),
                                resultSet.getString("name"),
                                Ingredient.Type.valueOf(resultSet.getString("type"))
                        );
                    }
                },
                id);
    }


    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbc.update(
                "insert into Ingredient (id, name, type) values (?, ?, ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }

    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
        return new Ingredient(
                rs.getString("id"),
                rs.getString("name"),
                Ingredient.Type.valueOf(rs.getString("type"))
        );
    }
}
