package edu.eat.order.service.impl;

import edu.eat.order.base.base.service.BaseServiceImpl;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.domain.OrderItem;
import edu.eat.order.mapper.OrderItemMapper;
import edu.eat.order.model.OrderItemModel;
import edu.eat.order.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class OrderItemServiceImpl extends BaseServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public List<OrderItemModel> selectModel(MybatisCondition condition) {
        return orderItemMapper.selectModel(condition);
    }
}