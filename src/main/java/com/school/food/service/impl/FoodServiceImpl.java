package com.school.food.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.school.food.domain.Food;
import com.school.food.mapper.FoodMapper;
import com.school.food.model.FoodModel;
import com.school.food.service.FoodService;
import com.school.support.base.Page;
import com.school.support.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.school.support.example.Example;

/**
* The class create by 执笔 on generate.
*/
@Service
@Transactional
public class FoodServiceImpl extends BaseServiceImpl<Food> implements FoodService {

    @Autowired
    public FoodServiceImpl(FoodMapper mapper) {
        super(mapper);
        this.foodMapper = mapper;
    }
    private FoodMapper foodMapper;

    @Override
    public PageInfo<FoodModel> selectModel(Example example, Page page) {
        if(null != page){
            PageHelper.startPage(page.getPageNum(),page.getPageSize());
        }
        return new PageInfo<>(foodMapper.selectModel(example),Page.NAV_SIZE);
    }

}