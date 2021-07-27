package xyz.lazyrabbit.eureka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableEurekaClient
@Slf4j
public class EurekaConsumerApplication {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping
    public String hello() {
        log.info("调用消费者hello接口");
//        return "INVOKE PROVIDER HELLO METHOD：" + restTemplate.getForEntity("http://localhost:10000", String.class).getBody();
        restTemplate.getForEntity("http://RABB-EUREKA-PROVIDER", String.class).getBody();
        return "INVOKE PROVIDER HELLO METHOD：" + restTemplate.getForEntity("http://RABB-EUREKA-PROVIDER", String.class).getBody();
    }

}
