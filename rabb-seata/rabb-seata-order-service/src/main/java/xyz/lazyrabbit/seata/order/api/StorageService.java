package xyz.lazyrabbit.seata.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import xyz.lazyrabbit.common.pojo.dto.User;
import xyz.lazyrabbit.common.pojo.vo.Response;
import xyz.lazyrabbit.common.util.ResponseUtils;

@FeignClient(value = "${rabb.service.storage-service}", fallbackFactory = StorageFallbackFactoryService.class)
public interface StorageService {

    @GetMapping("/storage/sku/{id}")
    Response manage(@PathVariable(value = "id") Integer id, @RequestParam(value = "count") Integer count);

}
