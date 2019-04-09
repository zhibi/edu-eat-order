package edu.eat.order.service.impl;

import edu.eat.order.domain.OrderItem;
import edu.eat.order.mapper.OrderItemMapper;
import edu.eat.order.model.OrderItemModel;
import edu.eat.order.service.OrderItemService;
import edu.eat.order.base.base.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.eat.order.base.example.Example;

import java.util.List;


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