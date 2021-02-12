package xyz.lazyrabbit.ribbon.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.util.CollectionUtils;

public class MyRule extends AbstractLoadBalancerRule {

    @Override

    public Server choose(Object o) {        ILoadBalancer lb = this.getLoadBalancer();

        if (lb == null || CollectionUtils.isEmpty(lb.getAllServers())) {
            return null;
        } else {
            return lb.getAllServers().get(0);
        }
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}
