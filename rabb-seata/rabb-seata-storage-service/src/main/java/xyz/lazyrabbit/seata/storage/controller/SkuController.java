package xyz.lazyrabbit.seata.storage.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import xyz.lazyrabbit.common.pojo.vo.Response;
import xyz.lazyrabbit.common.util.ResponseUtils;
import xyz.lazyrabbit.seata.storage.service.SkuService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author rabb
 * @since 2022-02-26
 */
@RestController
@RequestMapping("/storage/sku")
@Slf4j
public class SkuController {
    @Autowired
    SkuService skuService;

    @GetMapping("{id}")
    public Response manage(@PathVariable Integer id, @RequestParam Integer count) {
        log.info("操作库存，商品：{}，数量：{}", id, count);
        skuService.manage(id, count);
        return ResponseUtils.success("商品：" + id + "，减少库存数量：" + count);
    }
}
