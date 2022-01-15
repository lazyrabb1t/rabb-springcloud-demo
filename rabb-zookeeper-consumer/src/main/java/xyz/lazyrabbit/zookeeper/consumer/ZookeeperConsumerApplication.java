package xyz.lazyrabbit.zookeeper.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import xyz.lazyrabbit.zookeeper.consumer.config.ZookeeperConfig;

@SpringBootApplication
@RestController
@Slf4j
@EnableConfigurationProperties
public class ZookeeperConsumerApplication {

    @Autowired
    RestTemplate restTemplate;
    @Value("${service-url.provider}")
    String providerService;
    // 从配置中心获取的配置
    @Value("${url}")
    String url;

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperConsumerApplication.class, args);
    }

    @GetMapping
    public String hello() {
        log.info("调用消费者hello接口");
        return "INVOKE PROVIDER HELLO METHOD：" + restTemplate.getForEntity(providerService, String.class).getBody();
    }

    @GetMapping("url")
    public String url() {
        return url;
    }
}
