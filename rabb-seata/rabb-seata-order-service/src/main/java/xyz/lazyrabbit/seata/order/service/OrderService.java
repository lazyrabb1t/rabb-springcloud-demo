package xyz.lazyrabbit.seata.order.service;

import xyz.lazyrabbit.seata.order.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author rabb
 * @since 2022-02-26
 */
public interface OrderService extends IService<Order> {

    /**
     * 下单
     *
     * @param orderName
     * @param skuId
     * @param count
     */
    void place(String orderName, Integer skuId, Integer count);

    /**
     * 下单 开启本地事务
     *
     * @param orderName
     * @param skuId
     * @param count
     */
    void placeWithLocalTransaction(String orderName, Integer skuId, Integer count);
}
