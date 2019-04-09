package edu.eat.order.service;

import edu.eat.order.domain.OrderItem;
import edu.eat.order.model.OrderItemModel;
import edu.eat.order.base.base.service.BaseService;
import edu.eat.order.base.example.Example;

import java.util.List;


public interface OrderItemService extends BaseService<OrderItem> {

    List<OrderItemModel> selectModel(Example example);

}