package edu.eat.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.eat.order.base.base.service.BaseServiceImpl;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.domain.Order;
import edu.eat.order.mapper.OrderMapper;
import edu.eat.order.model.OrderModel;
import edu.eat.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 执笔
 * @date 2019/4/9 18:15
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void pay(Order order) {
        MybatisCondition example = new MybatisCondition()
                .eq("o.user_id", order.getUserId())
                .eq("o.status", 0);
        Double total = 0d;
    }

    @Override
    public List<OrderModel> selectModel(MybatisCondition condition) {
        return orderMapper.selectModel(condition);
    }

    @Override
    public PageInfo<OrderModel> selectModelPage(MybatisCondition condition) {
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        return new PageInfo<>(selectModel(condition));
    }

    @Override
    public OrderModel selectModelById(Long id) {
        MybatisCondition example = new MybatisCondition()
                .eq("o.id", id);
        List<OrderModel> list = selectModel(example);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}