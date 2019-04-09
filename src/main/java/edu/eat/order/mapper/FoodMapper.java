package edu.eat.order.mapper;

import edu.eat.order.model.FoodModel;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import edu.eat.order.domain.Food;
import edu.eat.order.base.example.Example;

import java.util.List;

/**
* Created by 执笔 on generate.
*/
public interface FoodMapper extends Mapper<Food>{

    List<FoodModel> selectModel(@Param("example") Example example);
}
