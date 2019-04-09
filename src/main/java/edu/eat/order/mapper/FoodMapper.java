package edu.eat.order.mapper;

import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.domain.Food;
import edu.eat.order.model.FoodModel;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by 执笔 on generate.
 */
public interface FoodMapper extends Mapper<Food> {

    List<FoodModel> selectModel(MybatisCondition example);
}
