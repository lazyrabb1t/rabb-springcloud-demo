package xyz.lazyrabbit.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eureka10004ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Eureka10004ServerApplication.class, args);
    }

}
