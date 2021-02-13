package xyz.lazyrabbit.openfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import xyz.lazyrabbit.common.pojo.dto.User;
import xyz.lazyrabbit.common.pojo.vo.Response;

//@FeignClient(value = "RABB-EUREKA-PROVIDER", fallback = OpenFeignFallbackService.class)
@FeignClient(value = "RABB-EUREKA-PROVIDER", fallbackFactory = OpenFeignFallbackFactoryService.class)
public interface OpenFeignService {

    @PostMapping("/openfeign/user")
    Response create(@RequestBody User user);

    @GetMapping("/openfeign/user/{id}")
    Response get(@PathVariable Integer id);

    @PutMapping("/openfeign/user/{id}")
    Response update(@PathVariable Integer id);

    @DeleteMapping("/openfeign/user/{id}")
    Response delete(@PathVariable Integer id);
}
