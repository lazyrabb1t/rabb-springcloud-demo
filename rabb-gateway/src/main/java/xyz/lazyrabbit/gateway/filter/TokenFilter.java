package xyz.lazyrabbit.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
public class TokenFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("TokenFilter前置逻辑");
//        String token = exchange.getRequest().getHeaders().getFirst("token");
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        log.info("token:{}", token);
        if (StringUtils.hasText(token)) {
            return chain.filter(exchange).then(Mono.fromRunnable(() ->
            {
                log.info("TokenFilter后置逻辑");
            }));
        } else {
            log.warn("未获取到token");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
