package xyz.lazyrabbit.seata.storage.service;

import xyz.lazyrabbit.seata.storage.entity.Sku;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author rabb
 * @since 2022-02-26
 */
public interface SkuService extends IService<Sku> {

    /**
     * 管理商品库存
     *
     * @param skuId
     * @param count
     */
    void manage(Integer skuId, Integer count);
}
