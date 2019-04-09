package edu.eat.order.mapper;

import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.model.OrderModel;
import edu.eat.order.domain.Order;
import tk.mybatis.mapper.common.Mapper;
import edu.eat.order.base.example.Example;

import java.util.List;


/**
 *
 *
 * @author 执笔
 * @date 2019/4/9 18:17
 */
public interface OrderMapper extends Mapper<Order>{

    /**
     * 通过条件查找
     * @param condition
     * @return
     */
    List<OrderModel> selectModel(MybatisCondition condition);
}
