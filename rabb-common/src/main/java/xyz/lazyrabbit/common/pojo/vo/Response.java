package xyz.lazyrabbit.common.pojo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Response<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

}
