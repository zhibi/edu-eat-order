package edu.eat.order.service;

import com.github.pagehelper.PageInfo;
import edu.eat.order.base.base.service.BaseService;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.domain.Food;
import edu.eat.order.model.FoodModel;

/**
 * 
 * @author 执笔
 * @date 2019/4/9 18:30
 */
public interface FoodService extends BaseService<Food> {

    /**
     * 通过条件分页查找
     * @param example
     * @return
     */
    PageInfo<FoodModel> selectModelPage(MybatisCondition example);

}