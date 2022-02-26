package xyz.lazyrabbit.seata.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lazyrabbit.common.pojo.vo.Response;
import xyz.lazyrabbit.common.util.ResponseUtils;
import xyz.lazyrabbit.seata.order.api.StorageService;

@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

    @Autowired
    StorageService storageService;

    @GetMapping("create")
    public Response createOrder() {
        log.info("减少库存");
        Response r = storageService.manage(1, 1);
        log.info("创建订单，response：{}", r);
        return ResponseUtils.success("创建成功");
    }
}
