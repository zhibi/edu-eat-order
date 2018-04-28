package com.school.food.service;

import com.github.pagehelper.PageInfo;
import com.school.food.domain.Order;
import com.school.food.model.OrderModel;
import com.school.support.context.Constant;
import com.school.support.base.Page;
import com.school.support.service.BaseService;
import com.school.support.example.Example;

import java.util.List;

/**
* The class create by 执笔 on generate.
*/
public interface OrderService extends BaseService<Order>,Constant {

    void pay(Order order);

    List<OrderModel> selectModel(Example example);

    PageInfo<OrderModel> selectModel(Example example, Page page);

    OrderModel selectModelById(Long id);
}