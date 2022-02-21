package xyz.lazyrabbit.gateway.alibaba.config;

import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiDefinition;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiPathPredicateItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiPredicateItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.GatewayApiDefinitionManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import xyz.lazyrabbit.common.util.ResponseUtils;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class SentinelConfig {

    @PostConstruct
    public void doInit() {
        // 代码方式添加api分组以及规则
        initCustomizedApis();
        initGatewayRules();
        // 自定义异常处理
        initBlockHandler();
    }

    /**
     * 自定义限流异常处理器
     */
    private void initBlockHandler() {
        BlockRequestHandler blockRequestHandler = new BlockRequestHandler() {
            @Override
            public Mono<ServerResponse> handleRequest(ServerWebExchange serverWebExchange, Throwable throwable) {
                return ServerResponse.status(HttpStatus.TOO_MANY_REQUESTS)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(ResponseUtils.failure("限流")));
            }
        };

        // 加载自定义限流异常处理器
        GatewayCallbackManager.setBlockHandler(blockRequestHandler);
    }

    /**
     * API分组，对不组可以进行不同限流规则
     */
    private void initCustomizedApis() {
        Set<ApiDefinition> definitions = new HashSet<>();
        ApiDefinition api1 = new ApiDefinition("some_customized_api")
                .setPredicateItems(new HashSet<ApiPredicateItem>() {{
                    add(new ApiPathPredicateItem().setPattern("/rabb-nacos-provider/openfeign/user/**"));
                }});
        ApiDefinition api2 = new ApiDefinition("another_customized_api")
                .setPredicateItems(new HashSet<ApiPredicateItem>() {{
                    add(new ApiPathPredicateItem().setPattern("/rabb-nacos-provider/openfeign/test/**"));
                }});
        definitions.add(api1);
        definitions.add(api2);
        GatewayApiDefinitionManager.loadApiDefinitions(definitions);
    }

    /**
     * 配置限流规则
     */
    private void initGatewayRules() {
//        Set<GatewayFlowRule> rules = new HashSet<>();
//        rules.add(new GatewayFlowRule("appPush-service")
//                .setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_RATE_LIMITER)//0 直接拒绝 ,1 Warm Up, 2 匀速排队
//                .setGrade(RuleConstant.FLOW_GRADE_QPS)//0 基于线程数,1 基于QPS
//                .setMaxQueueingTimeoutMs(5000)//和排队数量、单个任务处理时间成正比。可以设置大点防止丢弃请求。
//                .setCount(10)//qps限制为10
//                .setIntervalSec(1)//时间窗口为1s
//        );
//        GatewayRuleManager.loadRules(rules);
    }
}
