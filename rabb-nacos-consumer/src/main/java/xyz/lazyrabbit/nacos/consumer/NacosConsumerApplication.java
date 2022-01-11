package xyz.lazyrabbit.nacos.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class NacosConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerApplication.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RestController
    // 实现配置自动更新
    @RefreshScope
    public class TestController {

        private final RestTemplate restTemplate;
        @Value("${rabb.service-name}")
        private String serviceName;
        @Value("${rabb.url}")
        private String url;

        @Autowired
        public TestController(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        @GetMapping
        public String hello() {
            return restTemplate.getForObject("http://" + serviceName, String.class);
        }

        @GetMapping("c")
        public String configTest() {
            return url;
        }
    }
}
