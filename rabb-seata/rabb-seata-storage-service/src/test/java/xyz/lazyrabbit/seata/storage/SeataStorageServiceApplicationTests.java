package xyz.lazyrabbit.seata.storage;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.lazyrabbit.seata.storage.entity.Sku;
import xyz.lazyrabbit.seata.storage.service.SkuService;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Slf4j
class SeataStorageServiceApplicationTests {

    @Autowired
    SkuService skuService;

    @Test
    void contextLoads() {
        Sku sku = new Sku();
        sku.setSkuName("奥迪");
        sku.setCount(999);
        sku.setCreateTime(LocalDateTime.now());
        sku.setUpdateTime(LocalDateTime.now());
        skuService.saveOrUpdate(sku);
        List<Sku> list = skuService.list();
        log.info("list:{}", list);
    }

}
