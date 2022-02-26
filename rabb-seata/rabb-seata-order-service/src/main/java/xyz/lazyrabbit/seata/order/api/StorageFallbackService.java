package xyz.lazyrabbit.seata.order.api;

import org.springframework.stereotype.Component;
import xyz.lazyrabbit.common.pojo.dto.User;
import xyz.lazyrabbit.common.pojo.vo.Response;
import xyz.lazyrabbit.common.util.ResponseUtils;

@Component
public class StorageFallbackService implements StorageService {
    @Override
    public Response manage(Integer id, Integer count) {
        return ResponseUtils.failure("fallback");
    }
}
