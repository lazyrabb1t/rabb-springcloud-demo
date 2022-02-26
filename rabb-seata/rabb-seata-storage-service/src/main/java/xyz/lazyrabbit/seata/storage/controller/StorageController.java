package xyz.lazyrabbit.seata.storage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import xyz.lazyrabbit.common.pojo.vo.Response;
import xyz.lazyrabbit.common.util.ResponseUtils;

@RestController
@RequestMapping("storage")
@Slf4j
public class StorageController {

    @GetMapping("{id}")
    public Response manage(@PathVariable Integer id, @RequestParam Integer count) {
        log.info("操作库存，商品：{}，数量：{}", id, count);
        return ResponseUtils.success("商品：" + id + "，减少库存数量：" + count);
    }
}
