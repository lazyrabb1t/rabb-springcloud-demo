package xyz.lazyrabbit.seata.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.lazyrabbit.common.pojo.vo.Response;
import xyz.lazyrabbit.seata.order.api.StorageService;
import xyz.lazyrabbit.seata.order.entity.Order;
import xyz.lazyrabbit.seata.order.mapper.OrderMapper;
import xyz.lazyrabbit.seata.order.service.OrderService;

import java.util.Random;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author rabb
 * @since 2022-02-26
 */
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    StorageService storageService;

    @Override
    @GlobalTransactional
    public void place(String orderName, Integer skuId, Integer count) {
        // 减少库存
        Response response = storageService.manage(skuId, count);
        log.info("调用减少库存接口，返回结果：{}", response);
        // 创建订单
        Order order = new Order();
        order.setSkuId(skuId);
        order.setOrderName(orderName);
//        order.setCreateTime(LocalDateTime.now());
        this.saveOrUpdate(order);
        // 随机抛出异常
        if (new Random().nextBoolean()) {
            log.info("下单接口抛出异常");
            throw new RuntimeException("hhh");
        }
    }

    @Override
    @Transactional
    public void placeWithLocalTransaction(String orderName, Integer skuId, Integer count) {
        Order order = new Order();
        order.setSkuId(skuId);
        order.setOrderName(orderName);
//        order.setCreateTime(LocalDateTime.now());
        this.saveOrUpdate(order);
        int i = 10 / 0;
    }
}
