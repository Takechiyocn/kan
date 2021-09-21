package com.tacos.dao;

import com.tacos.entity.Order;

public interface OrderRepository {
    Order save(Order order);
}
