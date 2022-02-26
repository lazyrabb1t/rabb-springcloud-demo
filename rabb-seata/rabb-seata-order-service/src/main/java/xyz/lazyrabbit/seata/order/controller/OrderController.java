package xyz.lazyrabbit.seata.order.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import xyz.lazyrabbit.common.pojo.vo.Response;
import xyz.lazyrabbit.common.util.ResponseUtils;
import xyz.lazyrabbit.seata.order.service.OrderService;

import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author rabb
 * @since 2022-02-26
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public Response place(Integer skuId, Integer count) {
        orderService.place(randomName(), skuId, count);
        return ResponseUtils.success("下单成功");
    }

    private String randomName() {
        return "订单_" + UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }
}
