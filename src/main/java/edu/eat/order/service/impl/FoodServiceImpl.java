package edu.eat.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.eat.order.domain.Food;
import edu.eat.order.mapper.FoodMapper;
import edu.eat.order.model.FoodModel;
import edu.eat.order.service.FoodService;
import edu.eat.order.base.base.Page;
import edu.eat.order.base.base.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.eat.order.base.example.Example;


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