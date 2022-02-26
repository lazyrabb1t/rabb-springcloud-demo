package xyz.lazyrabbit.seata.storage.service.impl;

import xyz.lazyrabbit.seata.storage.entity.Sku;
import xyz.lazyrabbit.seata.storage.mapper.SkuMapper;
import xyz.lazyrabbit.seata.storage.service.SkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author rabb
 * @since 2022-02-26
 */
@Service
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements SkuService {

    @Override
    public void manage(Integer skuId, Integer count) {
        Sku sku = this.getById(skuId);
        sku.setCount(sku.getCount() - count);
        this.saveOrUpdate(sku);
    }
}
