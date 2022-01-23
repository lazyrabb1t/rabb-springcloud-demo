package xyz.lazyrabbit.gateway.config;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.lazyrabbit.gateway.filter.TokenFilter;

@Configuration
public class FilterConfig {
    @Bean
    public GlobalFilter tokenFilter() {
        return new TokenFilter();
    }
}
