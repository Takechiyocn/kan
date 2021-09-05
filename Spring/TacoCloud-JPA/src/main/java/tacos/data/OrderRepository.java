package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.Order;

public interface OrderRepository
        extends CrudRepository<Order, Long> {
    // 自定义JPA
//    List<Order> findByDeliveryZip(String deliveryZip);

//    List<Order> readOrderByDeliveryZipAndPlacedAtBetween(
//            String deliveryZip, Date startDate, Date endDate);
//
//    int countByDeliveryZipAndPlacedAtBetween(
//            String deliveryZip, Date startDate, Date endDate);
//
//    List<Order> findByDeliveryToAndDeliveryCityAllIgnoresCase(
//            String deliveryTo, String deliveryCity);
//
//    // Query注解明确表明要执行的查询
////    @Query("Order o where o.deliveryCity='Seattle'")
//    List<Order> readOrdersDeliveredInSeattle();
}
