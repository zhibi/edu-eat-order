package com.school.food.service;

import com.school.food.domain.OrderItem;
import com.school.food.model.OrderItemModel;
import com.school.support.service.BaseService;
import com.school.support.example.Example;

import java.util.List;

/**
* The class create by 执笔 on generate.
*/
public interface OrderItemService extends BaseService<OrderItem> {

    List<OrderItemModel> selectModel(Example example);

}