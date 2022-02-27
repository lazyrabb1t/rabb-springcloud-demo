package xyz.lazyrabbit.seata.order;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.lazyrabbit.seata.order.entity.Order;
import xyz.lazyrabbit.seata.order.service.OrderService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@Slf4j
class SeataOrderServiceApplicationTests {

    @Autowired
    OrderService orderService;

    @Test
    void contextLoads() {
        Order order = new Order();
        order.setOrderName("订单A");
        order.setSkuId(13);
//        order.setCreateTime(LocalDateTime.now());
        orderService.saveOrUpdate(order);
        List<Order> list = orderService.list();
        log.info("list:{}", list);
    }

    @Test
    void testTransaction() {
        orderService.placeWithLocalTransaction("订单_" + UUID.randomUUID().toString(), 1, 1);
    }
}
