package com.school.food.service;

import com.github.pagehelper.PageInfo;
import com.school.food.domain.Food;
import com.school.food.model.FoodModel;
import com.school.support.base.Page;
import com.school.support.service.BaseService;
import com.school.support.example.Example;

/**
* The class create by 执笔 on generate.
*/
public interface FoodService extends BaseService<Food> {

    PageInfo<FoodModel> selectModel(Example example, Page page);

}