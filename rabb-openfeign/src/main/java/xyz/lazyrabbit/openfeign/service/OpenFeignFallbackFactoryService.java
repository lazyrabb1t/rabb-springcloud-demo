package xyz.lazyrabbit.openfeign.service;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import xyz.lazyrabbit.common.pojo.dto.User;
import xyz.lazyrabbit.common.pojo.vo.Response;
import xyz.lazyrabbit.common.util.ResponseUtils;

@Component
@Slf4j
public class OpenFeignFallbackFactoryService implements FallbackFactory<OpenFeignService> {
    @Override
    public OpenFeignService create(Throwable throwable) {
        log.error("服务降级：异常信息：{}", throwable.getMessage(), throwable);
        return new OpenFeignFallbackService();
    }
}
