package com.school.food.model;

import com.school.food.domain.Order;

import java.util.List;

/**
 * Created by 执笔 on 2017/3/28.
 */
public class OrderModel extends Order {

    private String username;
    private List<OrderItemModel> orderItemModelList;

    public List<OrderItemModel> getOrderItemModelList() {
        return orderItemModelList;
    }

    public void setOrderItemModelList(List<OrderItemModel> orderItemModelList) {
        this.orderItemModelList = orderItemModelList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
