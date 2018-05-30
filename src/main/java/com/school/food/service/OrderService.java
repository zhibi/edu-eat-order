package com.school.food.service;

import com.github.pagehelper.PageInfo;
import com.school.food.domain.Order;
import com.school.food.model.OrderModel;
import com.school.support.context.Constant;
import com.school.support.base.Page;
import com.school.support.service.BaseService;
import com.school.support.example.Example;

import java.util.List;


public interface OrderService extends BaseService<Order>,Constant {

    void pay(Order order);

    List<OrderModel> selectModel(Example example);

    PageInfo<OrderModel> selectModel(Example example, Page page);

    OrderModel selectModelById(Long id);
}