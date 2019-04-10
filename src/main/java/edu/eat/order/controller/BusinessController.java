package edu.eat.order.controller;

import edu.eat.order.base.base.controller.BaseAdminController;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.domain.Business;
import edu.eat.order.domain.Food;
import edu.eat.order.mapper.BusinessMapper;
import edu.eat.order.mapper.FoodMapper;
import edu.eat.order.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 执笔
 * @date 2019/4/10 17:15
 */
@Controller
@RequestMapping("business")
public class BusinessController extends BaseAdminController {

    @Autowired
    private BusinessService businessService;
    @Autowired
    private BusinessMapper businessMapper;
    @Autowired
    private FoodMapper foodMapper;

    /**
     * 详情
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Business business = businessMapper.selectByPrimaryKey(id);
        MybatisCondition example = new MybatisCondition()
                .order("sort", false)
                .eq("business_id", id);
        List<Food> foodList = foodMapper.selectByExample(example);
        model.addAttribute("business", business);
        model.addAttribute("foodList", foodList);
        return "business/detail";
    }
}
