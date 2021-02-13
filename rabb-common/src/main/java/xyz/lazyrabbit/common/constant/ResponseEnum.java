package xyz.lazyrabbit.common.constant;

public enum ResponseEnum {
    SUCCESS(0, "成功"),
    FAILURE(-1, "失败");

    private Integer code;
    private String msg;

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
