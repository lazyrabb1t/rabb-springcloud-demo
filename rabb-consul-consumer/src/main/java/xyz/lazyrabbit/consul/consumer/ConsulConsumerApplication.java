package xyz.lazyrabbit.consul.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@Slf4j
@RestController
@RefreshScope
public class ConsulConsumerApplication {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    RestTemplate restTemplate2;
    @Value("${service-url.provider}")
    String providerService;
    @Autowired
    DiscoveryClient discoveryClient;
    @Value("${name}")
    String url;

    public static void main(String[] args) {
        SpringApplication.run(ConsulConsumerApplication.class, args);
    }

    @GetMapping("ip")
    public String hello() {
        log.info("调用消费者hello接口");
        return "INVOKE PROVIDER HELLO METHOD：" + restTemplate2.getForEntity("http://127.0.0.1:19000", String.class).getBody();
    }

    @GetMapping("name")
    public String hello2() {
        log.info("调用消费者hello接口");
        return "INVOKE PROVIDER HELLO METHOD：" + restTemplate.getForEntity(providerService, String.class).getBody();
    }

    @GetMapping("services")
    public List<String> services() {
        return discoveryClient.getServices();
    }

    @GetMapping("url")
    public String config() {
        return url;
    }
}
