package xyz.lazyrabbit.ribbon.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RibbonConfig {

    /**
     * 使用@LoadBalanced开启ribbon负载均衡功能
     *
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 负载均衡策略
     *
     * @return
     */
    @Bean
    public IRule loadBalancerRule() {
        return new MyRule();
    }
}