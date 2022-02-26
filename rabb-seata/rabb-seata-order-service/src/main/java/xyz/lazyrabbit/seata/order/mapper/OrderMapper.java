package xyz.lazyrabbit.seata.order.mapper;

import xyz.lazyrabbit.seata.order.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author rabb
 * @since 2022-02-26
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
