package xyz.lazyrabbit.seata.storage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author rabb
 * @since 2022-02-26
 */
@Getter
@Setter
@TableName("t_sku")
public class Sku implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品名称
     */
    @TableField("sku_name")
    private String skuName;

    /**
     * 库存
     */
    @TableField("count")
    private Integer count;

//    /**
//     * 创建时间
//     */
//    @TableField(value = "create_time", exist = false)
//    @JsonIgnore
//    private LocalDateTime createTime;
//
//    /**
//     * 更新时间
//     */
//    @TableField(value = "update_time", exist = false)
//    @JsonIgnore
//    private LocalDateTime updateTime;


}
