package edu.eat.order.mapper;

import edu.eat.order.model.OrderItemModel;
import edu.eat.order.domain.OrderItem;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import edu.eat.order.base.example.Example;

import java.util.List;


public interface OrderItemMapper extends Mapper<OrderItem>{

    List<OrderItemModel> selectModel(@Param("example") Example example);
}
