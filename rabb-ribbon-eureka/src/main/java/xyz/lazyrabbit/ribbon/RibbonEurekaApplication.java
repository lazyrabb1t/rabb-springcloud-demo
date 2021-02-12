package xyz.lazyrabbit.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class RibbonEurekaApplication {

    @Autowired
    RestTemplate restTemplate;
    @Value("${rabb.service.test}")
    private String testService;

    public static void main(String[] args) {
        SpringApplication.run(RibbonEurekaApplication.class, args);
    }

    @GetMapping
    public String hello() {
        return "ribbon invoke:" + restTemplate.getForObject(testService, String.class);
    }
}
