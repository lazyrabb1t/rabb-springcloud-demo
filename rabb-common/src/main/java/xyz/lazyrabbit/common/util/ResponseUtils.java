package xyz.lazyrabbit.common.util;

import xyz.lazyrabbit.common.constant.ResponseEnum;
import xyz.lazyrabbit.common.pojo.vo.Response;

public class ResponseUtils {

    public static Response build(ResponseEnum responseEnum) {
        return new Response().setCode(responseEnum.getCode()).setMsg(responseEnum.getMsg());
    }

    public static Response success(Object data) {
        return build(ResponseEnum.SUCCESS).setData(data);
    }

    public static Response success() {
        return success(null);
    }

    public static Response failure() {
        return build(ResponseEnum.FAILURE);
    }

    public static Response failure(String msg) {
        return build(ResponseEnum.FAILURE).setMsg(msg);
    }
}
