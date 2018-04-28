package com.school.food.mapper;

import com.school.food.model.OrderModel;
import tk.mybatis.mapper.common.Mapper;
import com.school.food.domain.Order;
import com.school.support.example.Example;

import java.util.List;

/**
* Created by 执笔 on generate.
*/
public interface OrderMapper extends Mapper<Order>{

    List<OrderModel> selectModel(Example example);
}
