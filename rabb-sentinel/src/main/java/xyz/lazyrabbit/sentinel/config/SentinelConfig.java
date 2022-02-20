package xyz.lazyrabbit.sentinel.config;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class SentinelConfig {

    public static String blockHandler(BlockException exception) {
        return "Exception: " + exception.getMessage();
    }

    public static String fallback() {
        return "Fallback";
    }

}
