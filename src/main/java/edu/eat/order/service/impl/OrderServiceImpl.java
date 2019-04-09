package edu.eat.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.eat.order.base.StringUtil;
import edu.eat.order.base.base.service.BaseServiceImpl;
import edu.eat.order.base.example.Example;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.domain.Order;
import edu.eat.order.domain.OrderItem;
import edu.eat.order.mapper.FoodMapper;
import edu.eat.order.mapper.OrderItemMapper;
import edu.eat.order.mapper.OrderMapper;
import edu.eat.order.model.OrderItemModel;
import edu.eat.order.model.OrderModel;
import edu.eat.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 执笔
 * @date 2019/4/9 18:15
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
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
               /* Food food = foodMapper.selectByPrimaryKey(orderItem.getFoodId());
                food.setSort(food.getSort()+orderItem.getCount());
                foodMapper.updateByPrimaryKey(food);*/
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
    public List<OrderModel> selectModel(MybatisCondition condition) {
        List<OrderModel> list = orderMapper.selectModel(condition);
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