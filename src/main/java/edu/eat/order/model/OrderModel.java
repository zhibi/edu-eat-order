package edu.eat.order.model;

import edu.eat.order.domain.Order;

import java.util.List;


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
