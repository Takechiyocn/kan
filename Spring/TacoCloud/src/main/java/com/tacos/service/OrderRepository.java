package com.tacos.service;

import com.tacos.entity.Order;

public interface OrderRepository {
    Order save(Order order);
}
