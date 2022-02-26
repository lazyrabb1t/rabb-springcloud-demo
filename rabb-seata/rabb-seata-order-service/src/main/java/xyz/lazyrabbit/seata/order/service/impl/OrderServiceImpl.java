package xyz.lazyrabbit.seata.order.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import xyz.lazyrabbit.common.pojo.vo.Response;
import xyz.lazyrabbit.seata.order.api.StorageService;
import xyz.lazyrabbit.seata.order.entity.Order;
import xyz.lazyrabbit.seata.order.mapper.OrderMapper;
import xyz.lazyrabbit.seata.order.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
    public void place(String orderName, Integer skuId, Integer count) {
        // 减少库存
        Response response = storageService.manage(skuId, count);
        log.info("调用减少库存接口，返回结果：{}", response);
        // 创建订单
        Order order = new Order();
        order.setSkuId(skuId);
        order.setOrderName(orderName);
        order.setCreateTime(LocalDateTime.now());
        this.saveOrUpdate(order);
    }

    @Override
    @Transactional
    public void placeWithLocalTransaction(String orderName, Integer skuId, Integer count) {
        Order order = new Order();
        order.setSkuId(skuId);
        order.setOrderName(orderName);
        order.setCreateTime(LocalDateTime.now());
        this.saveOrUpdate(order);
        int i = 10 / 0;
    }
}
