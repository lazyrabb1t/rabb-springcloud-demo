package xyz.lazyrabbit.consul.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class ConsulProviderApplication {

    @Value("${server.port}")
    String port;

    public static void main(String[] args) {
        SpringApplication.run(ConsulProviderApplication.class, args);
    }

    @GetMapping
    public String hello() {
        log.info("调用提供者hello接口");
        return "Hello SpringCloud! from port:" + port;
    }
}
