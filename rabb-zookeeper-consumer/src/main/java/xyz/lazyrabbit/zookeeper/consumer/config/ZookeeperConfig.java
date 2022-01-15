package xyz.lazyrabbit.zookeeper.consumer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 支持动态刷新配置
 */
@Component
@ConfigurationProperties(prefix = "rabb")
public class ZookeeperConfig {
    public String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
