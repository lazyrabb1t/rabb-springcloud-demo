package xyz.lazyrabbit.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;
import xyz.lazyrabbit.sentinel.config.SentinelConfig;

import java.util.concurrent.TimeUnit;

@Service
public class TestService {

    /**
     * blockHandler 流量控制后会进入该方法
     * fallback 熔断后进入该方法
     * 两种方法进行配置
     * 1、使用blockHandlerClass定义外部类，使用blockHandler定义的静态方法，fallback类似
     * 2、直接使用blockHandler，在本类中寻找对应方法，fallback类似
     */
    @SentinelResource(value = "doSomething", blockHandlerClass = SentinelConfig.class, blockHandler = "blockHandler",
            fallbackClass = SentinelConfig.class, fallback = "fallback")
    public String doSomething() {
        return "doSomething";
    }

//    public String blockHandler(BlockException exception) {
//        return "Exception: " + exception.getMessage();
//    }
//
//    public String fallback() {
//        return "Fallback";
//    }


    /**
     * 测试热点规则
     *
     * @param name
     * @return
     */
    @SentinelResource(value = "hello", blockHandler = "blockHandler1", fallback = "fallback1")
    public String hello(String name) {
        return "hello " + name;
    }

    public String blockHandler1(String name, BlockException exception) {
        return "Exception1: " + exception.getMessage();
    }

    public String fallback1(String name) {
        return "Fallback1 " + name;
    }

    /**
     * 用来测试异常的情况下熔断配置，可在sentinel控制台配置熔断策略
     *
     * @return
     */
    @SentinelResource(value = "doSomethingError", blockHandler = "blockHandler2", fallback = "fallback2")
    public String doSomethingError() {
        int a = 1 / 0;
        return "doSomethingError ";
    }

    public String blockHandler2(BlockException exception) {
        return "Exception2: " + exception.getRuleLimitApp().trim();
    }

    public String fallback2() {
        return "Fallback2";
    }

    /**
     * 用来测试超时的情况下熔断配置，可在sentinel控制台配置熔断策略
     * blockHandler和fallback都配置的情况下只有blockHandler生效
     *
     * @return
     */
    @SentinelResource(value = "doSomethingTimeout", blockHandler = "blockHandler3", fallback = "fallback3")
    public String doSomethingTimeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return "doSomethingTimeout ";
    }

    public String blockHandler3(BlockException exception) throws InterruptedException {
        return "Exception3: " + exception.getRuleLimitApp().trim();
    }

    public String fallback3() throws InterruptedException {
        return "Fallback3";
    }

}
