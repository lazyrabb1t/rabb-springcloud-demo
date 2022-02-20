package xyz.lazyrabbit.sentinel.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import xyz.lazyrabbit.common.pojo.dto.User;
import xyz.lazyrabbit.common.pojo.vo.Response;

@FeignClient(value = "${rabb.service.provider-service}", fallbackFactory = OpenFeignFallbackFactoryService.class)
public interface OpenFeignService {

    @PostMapping("/openfeign/user")
    Response create(@RequestBody User user);

    @GetMapping("/openfeign/user/{id}")
    Response get(@PathVariable(value = "id") Integer id);

    @PutMapping("/openfeign/user/{id}")
    Response update(@PathVariable(value = "id") Integer id);

    @DeleteMapping("/openfeign/user/{id}")
    Response delete(@PathVariable(value = "id") Integer id);
}
