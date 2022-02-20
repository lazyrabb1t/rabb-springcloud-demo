package xyz.lazyrabbit.sentinel.service;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OpenFeignFallbackFactoryService implements FallbackFactory<OpenFeignService> {
    @Override
    public OpenFeignService create(Throwable throwable) {
        log.error("服务降级：异常信息：{}", throwable.getMessage(), throwable);
        return new OpenFeignFallbackService();
    }
}
