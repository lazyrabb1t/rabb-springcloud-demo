package xyz.lazyrabbit.seata.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单名称
     */
    @TableField("order_name")
    private String orderName;

    /**
     * 商品ID
     */
    @TableField("sku_id")
    private Integer skuId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;


}
