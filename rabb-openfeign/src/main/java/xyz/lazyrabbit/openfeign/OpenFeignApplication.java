package xyz.lazyrabbit.openfeign;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import xyz.lazyrabbit.common.pojo.dto.User;
import xyz.lazyrabbit.common.pojo.vo.Response;
import xyz.lazyrabbit.common.util.ResponseUtils;
import xyz.lazyrabbit.openfeign.service.OpenFeignService;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
@EnableFeignClients
@RestController
public class OpenFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignApplication.class, args);
    }

    @Autowired
    OpenFeignService openFeignService;

    @GetMapping("/create")
    public Response create() {
        User user = new User(1, "lazyrabbit-" + LocalDateTime.now().toString());
        return openFeignService.create(user);
    }

    @GetMapping("/get")
    public Response get() {
        return openFeignService.get(2);
    }

    @GetMapping("/update")
    public Response update() {
        return openFeignService.update(3);
    }

    @GetMapping("/delete")
    public Response delete() {
        return openFeignService.delete(4);
    }

    /**
     * 负载均衡策略
     *
     * @return
     */
//    @Bean
    public IRule loadBalancerRule() {
        return new RandomRule();
    }

}
