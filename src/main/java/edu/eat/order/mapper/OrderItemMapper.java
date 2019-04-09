package edu.eat.order.mapper;

import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.domain.OrderItem;
import edu.eat.order.model.OrderItemModel;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface OrderItemMapper extends Mapper<OrderItem> {

    List<OrderItemModel> selectModel(MybatisCondition condition);
}
