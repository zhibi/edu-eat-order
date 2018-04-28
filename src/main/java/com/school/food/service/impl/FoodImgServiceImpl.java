package com.school.food.service.impl;

import com.school.food.domain.FoodImg;
import com.school.food.mapper.FoodImgMapper;
import com.school.food.service.FoodImgService;
import com.school.support.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* The class create by 执笔 on generate.
*/
@Service
@Transactional
public class FoodImgServiceImpl extends BaseServiceImpl<FoodImg> implements FoodImgService {

    @Autowired
    public FoodImgServiceImpl(FoodImgMapper mapper) {
        super(mapper);
        this.foodImgMapper = mapper;
    }
    private FoodImgMapper foodImgMapper;

    @Override
    public List<FoodImg> selectByFood(Integer id) {
        FoodImg foodImg = new FoodImg();
        foodImg.setFoodId(id);
        return foodImgMapper.select(foodImg);
    }
}