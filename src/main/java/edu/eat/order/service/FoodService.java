package edu.eat.order.service;

import com.github.pagehelper.PageInfo;
import edu.eat.order.domain.Food;
import edu.eat.order.model.FoodModel;
import edu.eat.order.base.base.Page;
import edu.eat.order.base.base.service.BaseService;
import edu.eat.order.base.example.Example;


public interface FoodService extends BaseService<Food> {

    PageInfo<FoodModel> selectModel(Example example, Page page);

}