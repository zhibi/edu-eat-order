package com.school.food.mapper;

import com.school.food.model.OrderItemModel;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import com.school.food.domain.OrderItem;
import com.school.support.example.Example;

import java.util.List;

/**
* Created by 执笔 on generate.
*/
public interface OrderItemMapper extends Mapper<OrderItem>{

    List<OrderItemModel> selectModel(@Param("example") Example example);
}
