package xyz.lazyrabbit.zookeeper.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lazyrabbit.zookeeper.consumer.config.ZookeeperConfig;

@RestController
@Slf4j
public class ConfigController {

    @Autowired
    ZookeeperConfig zookeeperConfig;

    @GetMapping("url2")
    public String url2() {
        return zookeeperConfig.getUrl();
    }
}
