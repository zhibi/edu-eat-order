package com.school.food.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.school.food.domain.Food;
import com.school.food.domain.Order;
import com.school.food.domain.OrderItem;
import com.school.food.mapper.FoodMapper;
import com.school.food.mapper.OrderItemMapper;
import com.school.food.mapper.OrderMapper;
import com.school.food.model.OrderItemModel;
import com.school.food.model.OrderModel;
import com.school.food.service.OrderService;
import com.school.support.base.Page;
import com.school.support.example.ExampleType;
import com.school.support.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.school.support.example.Example;

import com.school.support.StringUtil;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * The class create by 执笔 on generate.
 */
@Service
@Transactional
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {

    @Autowired
    public OrderServiceImpl(OrderMapper mapper) {
        super(mapper);
        this.orderMapper = mapper;
    }

    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private FoodMapper foodMapper;

    @Override
    public void pay(Order order) {
        Example example = Example.getInstance()
                .addParam("o.user_id", order.getUserId())
                .addParam("o.status", 0);
        List<OrderItemModel> modelList = orderItemMapper.selectModel(example);

        Double total = 0d;
        StringBuilder ids = new StringBuilder();
        if (modelList.size() > 0) {
            for (OrderItem orderItem : modelList) {
                orderItem.setStatus(1);
                orderItemMapper.updateByPrimaryKeySelective(orderItem);
                total += orderItem.getPrice();
                ids.append(orderItem.getId()).append(",");
                Food food = foodMapper.selectByPrimaryKey(orderItem.getFoodId());
                food.setSort(food.getSort()+orderItem.getCount());
                foodMapper.updateByPrimaryKey(food);
            }
            order.setIds(ids.toString());
            order.setAddtime(new Date());
            order.setStatus(1);
            order.setOrderno(UUID.randomUUID().toString());
            order.setPaytime(new Date());
            order.setTotal(total);
            orderMapper.insertSelective(order);
        }
    }

    @Override
    public List<OrderModel> selectModel(Example example) {
        List<OrderModel> list = orderMapper.selectModel(example);
        for (OrderModel orderModel : list) {
            String ids = orderModel.getIds();
            if (!StringUtil.isEmpty(ids)) {
                if (ids.endsWith(",")) {
                    ids = ids.substring(0, ids.length() - 1);
                }
                Example example1 = Example.getInstance().addParam("o.id in(" + ids + ")");
                orderModel.setOrderItemModelList(orderItemMapper.selectModel(example1));
            }
        }
        return list;
    }

    @Override
    public PageInfo<OrderModel> selectModel(Example example, Page page) {
        if (null != page) {
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
        }
        return new PageInfo<>(selectModel(example), Page.NAV_SIZE);
    }

    @Override
    public OrderModel selectModelById(Long id) {
        Example example = Example.getInstance()
                .addParam("o.id");
        List<OrderModel> list = selectModel(example);
        if (list.size() > 0) return list.get(0);
        return null;
    }
}