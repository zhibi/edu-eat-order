package edu.eat.order.service;

import edu.eat.order.base.base.service.BaseService;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.domain.OrderItem;
import edu.eat.order.model.OrderItemModel;

import java.util.List;


public interface OrderItemService extends BaseService<OrderItem> {

    /**
     * 通过条件查找
     *
     * @param condition
     * @return
     */
    List<OrderItemModel> selectModel(MybatisCondition condition);

}