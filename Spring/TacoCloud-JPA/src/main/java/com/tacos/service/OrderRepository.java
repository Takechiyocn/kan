package com.tacos.service;

import com.tacos.domain.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository
        extends CrudRepository<Order, Long> {

    /**
     * 自定义JPA Repository：通过邮编查找
     *
     * @param deliveryZip
     * @return
     */
    List<Order> findByDeliveryZip(String deliveryZip);

    /**
     * 自定义JPA Repository：通过邮编查找和地址范围
     *
     * @param deliveryZip
     * @param startDate
     * @param endDate
     * @return
     */
//    List<Order> readOrderByDeliveryZipAndPlacedAtBetween(
//            String deliveryZip, Date startDate, Date endDate);

    /**
     * 自定义JPA Repository：查找数量
     *
     * @param deliveryZip
     * @param startDate
     * @param endDate
     * @return
     */
//    int countByDeliveryZipAndPlacedAtBetween(
//            String deliveryZip, Date startDate, Date endDate);

    /**
     * 自定义JPA Repository：忽略大小写
     *
     * @param deliveryTo
     * @param deliveryCity
     * @return
     */
//    List<Order> findByDeliveryToAndDeliveryCityAllIgnoresCase(
//            String deliveryTo, String deliveryCity);

    /**
     * JPA Query注解明确表明要执行的查询
     *
     * @return
     */
//    @Query("Select * From Taco_Order o where o.deliveryCity='Seattle'")
//    List<Order> readOrdersByDeliveredInSeattle();
}
