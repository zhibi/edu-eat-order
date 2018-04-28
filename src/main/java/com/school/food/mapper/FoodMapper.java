package com.school.food.mapper;

import com.school.food.model.FoodModel;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import com.school.food.domain.Food;
import com.school.support.example.Example;

import java.util.List;

/**
* Created by 执笔 on generate.
*/
public interface FoodMapper extends Mapper<Food>{

    List<FoodModel> selectModel(@Param("example") Example example);
}
