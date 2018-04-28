package com.school.food.service;

import com.school.food.domain.FoodImg;
import com.school.support.service.BaseService;

import java.util.List;

/**
* The class create by 执笔 on generate.
*/
public interface FoodImgService extends BaseService<FoodImg> {

    List<FoodImg> selectByFood(Integer id);
}