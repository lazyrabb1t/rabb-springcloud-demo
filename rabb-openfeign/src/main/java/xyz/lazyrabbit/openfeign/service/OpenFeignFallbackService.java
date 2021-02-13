package xyz.lazyrabbit.openfeign.service;

import org.springframework.stereotype.Component;
import xyz.lazyrabbit.common.pojo.dto.User;
import xyz.lazyrabbit.common.pojo.vo.Response;
import xyz.lazyrabbit.common.util.ResponseUtils;

@Component
public class OpenFeignFallbackService implements OpenFeignService {

    @Override
    public Response create(User user) {
        return ResponseUtils.failure("fallback");
    }

    @Override
    public Response get(Integer id) {
        return ResponseUtils.failure("fallback");
    }

    @Override
    public Response update(Integer id) {
        return ResponseUtils.failure("fallback");
    }

    @Override
    public Response delete(Integer id) {
        return ResponseUtils.failure("fallback");
    }
}
