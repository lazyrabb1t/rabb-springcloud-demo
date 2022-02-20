package xyz.lazyrabbit.sentinel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lazyrabbit.sentinel.service.TestService;

@RestController
public class TestController {
    @Autowired
    private TestService service;

    @GetMapping()
    public String index() {
        return service.doSomething();
    }

    @GetMapping("hello")
    public String hello(String name) {
        return service.hello(name);
    }

    @GetMapping("e")
    public String error() {
        return service.doSomethingError();
    }

    @GetMapping("t")
    public String timeout() throws InterruptedException {
        return service.doSomethingTimeout();
    }
}
