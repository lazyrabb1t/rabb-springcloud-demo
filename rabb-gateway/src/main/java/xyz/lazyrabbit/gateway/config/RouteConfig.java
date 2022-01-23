package xyz.lazyrabbit.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RouteConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route", r -> r.path("/blog")
                        .filters(filter -> filter.addRequestHeader("name", "rabb"))
                        .uri("https://blog.lazyrabbit.xyz"))
                .build();
    }
}
