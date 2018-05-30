package com.school.food.service;

import com.school.food.domain.OrderItem;
import com.school.food.model.OrderItemModel;
import com.school.support.service.BaseService;
import com.school.support.example.Example;

import java.util.List;


public interface OrderItemService extends BaseService<OrderItem> {

    List<OrderItemModel> selectModel(Example example);

}