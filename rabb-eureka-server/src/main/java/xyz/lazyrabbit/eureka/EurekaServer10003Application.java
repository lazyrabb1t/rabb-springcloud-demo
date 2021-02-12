package xyz.lazyrabbit.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer10003Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer10003Application.class, args);
    }

}
