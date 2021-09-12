package com.tacos.service.impl;

import com.tacos.entity.Ingredient;
import com.tacos.entity.Taco;
import com.tacos.service.TacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

@Repository
public class JdbcTacoRepository implements TacoRepository {

    private final JdbcTemplate jdbc;

    /**
     * 注入JdbcTemplate组件
     * @param jdbc
     */
    @Autowired
    public JdbcTacoRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Taco save(Taco taco) {
        long tacoId = saveTacoInfo(taco);
        taco.setId(tacoId);
        for (Ingredient ingredient : taco.getIngredients()) {
            saveIngredientToTaco(ingredient, tacoId);
        }
        return taco;
    }

    private long saveTacoInfo(Taco taco) {
        taco.setCreatedAt(new Date());
        // PreparedStatementCreator
        PreparedStatementCreatorFactory preparedStatementCreatorFactory =
                new PreparedStatementCreatorFactory(
                        "insert into Taco (name, createdAt) values (?, ?)",
                        Types.VARCHAR, Types.TIMESTAMP
                );
        preparedStatementCreatorFactory.setReturnGeneratedKeys(true);
        PreparedStatementCreator psc =
                preparedStatementCreatorFactory.newPreparedStatementCreator(
                        Arrays.asList(
                                taco.getName(),
                                new Timestamp(taco.getCreatedAt().getTime())
                        )
                );
        // 每个不同的Taco生成不同的Taco id
        KeyHolder keyHolder = new GeneratedKeyHolder();
        // 更新keyHolder(ID)到Taco表
        jdbc.update(psc, keyHolder);
        return keyHolder.getKey().longValue();
    }

    /**
     * JdbcTemplate更新数据1：JdbcTemplate.update
     *
     * @param ingredient
     * @param tacoId
     */
    private void saveIngredientToTaco(Ingredient ingredient, long tacoId) {
        jdbc.update(
                "insert into Taco_Ingredients (taco, ingredient)" +
                        "values (?, ?)",
                tacoId, ingredient.getId()
        );
    }
}
