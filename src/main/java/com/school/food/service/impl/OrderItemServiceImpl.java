package com.school.food.service.impl;

import com.school.food.domain.OrderItem;
import com.school.food.mapper.OrderItemMapper;
import com.school.food.model.OrderItemModel;
import com.school.food.service.OrderItemService;
import com.school.support.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.school.support.example.Example;

import java.util.List;

/**
* The class create by 执笔 on generate.
*/
@Service
@Transactional
public class OrderItemServiceImpl extends BaseServiceImpl<OrderItem> implements OrderItemService {

    @Autowired
    public OrderItemServiceImpl(OrderItemMapper mapper) {
        super(mapper);
        this.orderItemMapper = mapper;
    }
    private OrderItemMapper orderItemMapper;

    @Override
    public List<OrderItemModel> selectModel(Example example) {
        return orderItemMapper.selectModel(example);
    }
}