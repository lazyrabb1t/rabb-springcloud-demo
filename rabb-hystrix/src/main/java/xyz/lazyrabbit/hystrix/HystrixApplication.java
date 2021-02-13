package xyz.lazyrabbit.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringCloudApplication
@RestController
@Slf4j
public class HystrixApplication {

    @Autowired
    RestTemplate restTemplate;
    @Value("${rabb.service.test}")
    private String testService;

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping
    @HystrixCommand(fallbackMethod = "defaultHello")
    public String hello() {
        // 正常调用情况
        return "hystrix invoke:" + restTemplate.getForObject(testService + "/hystrix", String.class);
    }

    @GetMapping("timeout")
    @HystrixCommand(fallbackMethod = "defaultHello", commandProperties = {
            // 设置超时时间
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
    })
    public String timeout() {
        // 提供者超时情况
        return "hystrix invoke:" + restTemplate.getForObject(testService + "/hystrix/timeout", String.class);
    }

    @GetMapping("consumer/error")
    @HystrixCommand(fallbackMethod = "defaultHello")
    public String consumerError() {
        // 消费者异常情况
        int i = 10 / 0;
        return "hystrix invoke:" + restTemplate.getForObject(testService + "/hystrix", String.class);
    }

    @GetMapping("breaker")
    @HystrixCommand(fallbackMethod = "defaultHello", commandProperties = {
            // 开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 失败率
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String breaker() {
        log.info("invoke breaker !");
        // 提供者异常情况
        return "hystrix invoke:" + restTemplate.getForObject(testService + "/hystrix/exception", String.class);
    }

    @GetMapping("provider/error")
    @HystrixCommand(fallbackMethod = "defaultHello")
    public String providerError() {
        // 提供者异常情况
        return "hystrix invoke:" + restTemplate.getForObject(testService + "/hystrix/exception", String.class);
    }

    /**
     * 默认回调方法
     *
     * @param throwable
     * @return
     */
    public String defaultHello(Throwable throwable) {
        return throwable == null ? "something wrong!" : "exception:" + throwable.getMessage();
    }


    @GetMapping("cache")
    public String cache(String name) {
        hystrixCache(name);
        hystrixCache(name);
        hystrixCache(name);
        return hystrixCache(name);
    }

    @CacheResult(cacheKeyMethod = "getCacheKey")
    @HystrixCommand(fallbackMethod = "defaultHello", commandKey = "cacheKey")
    public String hystrixCache(String name) {
        log.info("hystrixCache");
        return "hystrix invoke:" + restTemplate.getForObject(testService + "/hystrix", String.class) + " name:" + name;
    }

    /**
     * 为缓存生成key的方法
     */
    public String getCacheKey(String name) {
        return "hystrix-cache-" + name == null ? "" : name.trim();
    }
}
