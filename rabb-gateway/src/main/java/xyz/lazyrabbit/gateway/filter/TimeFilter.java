package xyz.lazyrabbit.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
public class TimeFilter implements GatewayFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("TimeFilter前置逻辑");
        String path = exchange.getRequest().getURI().getPath();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        return chain.filter(exchange).then(Mono.fromRunnable(() ->
        {
            stopWatch.stop();
            long lastTaskTimeMillis = stopWatch.getLastTaskTimeMillis();
            log.info("请求地址：{}，耗时{}ms", path, lastTaskTimeMillis);
            log.info("TimeFilter后置逻辑");
        }));

    }

    @Override
    public int getOrder() {
        return 0;
    }
}
