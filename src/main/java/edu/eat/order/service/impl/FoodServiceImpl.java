package edu.eat.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.eat.order.base.base.service.BaseServiceImpl;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.domain.Food;
import edu.eat.order.mapper.FoodMapper;
import edu.eat.order.model.FoodModel;
import edu.eat.order.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FoodServiceImpl extends BaseServiceImpl<FoodMapper, Food> implements FoodService {

    @Autowired
    private FoodMapper foodMapper;

    @Override
    public PageInfo<FoodModel> selectModelPage(MybatisCondition example) {
        PageHelper.startPage(example.getPageNum(), example.getPageSize());
        return new PageInfo<>(foodMapper.selectModel(example));
    }

}