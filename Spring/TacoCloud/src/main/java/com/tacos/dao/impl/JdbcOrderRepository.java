package com.tacos.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tacos.entity.Order;
import com.tacos.entity.Taco;
import com.tacos.dao.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcOrderRepository implements OrderRepository {

    private SimpleJdbcInsert orderInserter;
    private SimpleJdbcInsert orderTacoInserter;
    private ObjectMapper objectMapper;

    @Autowired
    public JdbcOrderRepository(JdbcTemplate jdbc) {
        this.orderInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Taco_Order")
                .usingGeneratedKeyColumns("id");
        this.orderTacoInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Taco_Order_Tacos");
        this.objectMapper = new ObjectMapper();
    }

    /**
     * 更新数据2：SimpleJdbcInsert(该类对JdbcTemplate进行了包装)
     *
     * @param order
     * @return
     */
    @Override
    public Order save(Order order) {
        order.setPlacedAt(new Date());
        // 同一客户可有多个不同订单（Taco）
        long orderId = saveOrderDetails(order);
        order.setId(orderId);
        List<Taco> tacos = order.getTacos();
        tacos.forEach(taco -> saveTacoToOrder(taco, orderId));
        return order;
    }

    private long saveOrderDetails(Order order) {
        @SuppressWarnings("unchecked")
        Map<String, Object> values =
                objectMapper.convertValue(order, Map.class);
        values.put("placedAt", order.getPlacedAt());
        return orderInserter.executeAndReturnKey(values).longValue();
    }

    private void saveTacoToOrder(Taco taco, long orderId) {
        Map<String, Object> values = new HashMap<>();
        values.put("tacoOrder", orderId);
        values.put("taco", taco.getId());
        orderTacoInserter.execute(values);
    }
}
