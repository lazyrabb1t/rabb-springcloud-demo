package xyz.lazyrabbit.nacos.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import xyz.lazyrabbit.common.pojo.dto.User;
import xyz.lazyrabbit.common.pojo.vo.Response;
import xyz.lazyrabbit.common.util.ResponseUtils;

@RestController
@RequestMapping("/openfeign")
public class OpenFeignController {

    @Value("${server.port}")
    String port;

    @PostMapping("/user")
    public Response create(@RequestBody User user) {
        return ResponseUtils.success(user);
    }

    @GetMapping("/user/{id}")
    public Response get(@PathVariable Integer id) {
        return ResponseUtils.success(new User(id, "lazyrabbit_get_port_" + port));
    }

    @PutMapping("/user/{id}")
    public Response update(@PathVariable Integer id) {
        return ResponseUtils.success(new User(id, "lazyrabbit_update"));
    }

    @DeleteMapping("/user/{id}")
    public Response delete(@PathVariable Integer id) {
        return ResponseUtils.success("delete:" + id);
    }

    @GetMapping("/test/{id}")
    public Response test(@PathVariable Integer id) {
        return ResponseUtils.success(new User(id, "test_lazyrabbit_get_port_" + port));
    }

}


