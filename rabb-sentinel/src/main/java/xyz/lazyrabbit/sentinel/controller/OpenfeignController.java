package xyz.lazyrabbit.sentinel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lazyrabbit.common.pojo.dto.User;
import xyz.lazyrabbit.common.pojo.vo.Response;
import xyz.lazyrabbit.sentinel.service.OpenFeignService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/feign")
public class OpenfeignController {

    @Autowired
    OpenFeignService openFeignService;

    @GetMapping("/create")
    public Response create() {
        User user = new User(1, "lazyrabbit-" + LocalDateTime.now().toString());
        return openFeignService.create(user);
    }

    @GetMapping("/get")
    public Response get() {
        return openFeignService.get(2);
    }

    @GetMapping("/update")
    public Response update() {
        return openFeignService.update(3);
    }

    @GetMapping("/delete")
    public Response delete() {
        return openFeignService.delete(4);
    }

}
