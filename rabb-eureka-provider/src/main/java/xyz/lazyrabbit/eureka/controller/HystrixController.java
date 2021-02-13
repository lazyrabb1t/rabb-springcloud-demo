package xyz.lazyrabbit.eureka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/hystrix")
@Slf4j
public class HystrixController {

    @GetMapping
    public String normal() {
        return "hello hystrix!";
    }

    @GetMapping("/timeout")
    public String timeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return "hello hystrix!";
    }

    @GetMapping("/exception")
    public String exception() {
        int i = 10 / 0;
        return "hello hystrix!";
    }
}
