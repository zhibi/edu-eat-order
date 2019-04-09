package edu.eat.order.service;

import com.github.pagehelper.PageInfo;
import edu.eat.order.base.base.service.BaseService;
import edu.eat.order.base.context.Constant;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.domain.Order;
import edu.eat.order.model.OrderModel;

import java.util.List;

/**
 * @author 执笔
 * @date 2019/4/9 18:15
 */
public interface OrderService extends BaseService<Order>, Constant {

    void pay(Order order);

    /**
     * 通过条件查找
     *
     * @param example
     * @return
     */
    List<OrderModel> selectModel(MybatisCondition example);

    /**
     * 通过条件分页查找
     *
     * @param example
     * @return
     */
    PageInfo<OrderModel> selectModelPage(MybatisCondition example);

    OrderModel selectModelById(Long id);
}