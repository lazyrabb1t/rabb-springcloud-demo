package xyz.lazyrabbit.gateway.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayNacosSentinelApplication {

    public static void main(String[] args) {
        System.setProperty("csp.sentinel.app.type","1");
        SpringApplication.run(GatewayNacosSentinelApplication.class, args);
    }
}
