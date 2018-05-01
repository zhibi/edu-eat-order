package com.school.food.controller;


import com.github.pagehelper.PageInfo;
import com.school.food.domain.Food;
import com.school.food.model.FoodModel;
import com.school.food.service.FoodService;
import com.school.food.service.OrderItemService;
import com.school.support.StringUtil;
import com.school.support.base.BaseController;
import com.school.support.base.Page;
import com.school.support.example.Example;
import com.school.support.example.ExampleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 执笔 on 2017/3/5.
 */
@RequestMapping("food")
@Controller
public class FoodController extends BaseController {

    @Autowired
    private FoodService foodService;
    @Autowired
    private OrderItemService orderItemService;


    @RequestMapping("list")
    public String list(Food food, Model model, Page page, String collect) {
        Example example = Example.getInstance()
                .addOrder("f.sort", ExampleType.OrderType.DESC)
                .addParam("f.category", food.getCategory())
                .addParam("f.name", food.getName(), ExampleType.Operation.LIKE)
                .addParam("f.status", "1");
        if (!StringUtil.isEmpty(collect)) {
            example.addParam("c.id  is not null");
        }
        PageInfo<FoodModel> pageInfo = foodService.selectModel(example, page);
        setModelAttribute(model, pageInfo);
        return "food/list";
    }

    @RequestMapping("del/{id}")
    public String del(@PathVariable Integer id) {
        orderItemService.deleteByPK(id);
        return refresh();
    }

}
