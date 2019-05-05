package edu.eat.order.controller;

import edu.eat.order.base.annocation.RequestLogin;
import edu.eat.order.base.base.controller.BaseAdminController;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.domain.Business;
import edu.eat.order.domain.Food;
import edu.eat.order.domain.Start;
import edu.eat.order.mapper.BusinessMapper;
import edu.eat.order.mapper.FoodMapper;
import edu.eat.order.mapper.StartMapper;
import edu.eat.order.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    private BusinessMapper  businessMapper;
    @Autowired
    private FoodMapper      foodMapper;
    @Autowired
    private StartMapper     startMapper;

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
        if (sessionUser() != null) {
            Start start = startMapper.selectOne(new Start().setUserId(sessionUser().getId()).setBusinessId(id));
            model.addAttribute("start", start);
        }
        return "business/detail";
    }

    /**
     * 点赞操作
     */
    @GetMapping("start/{id}")
    @RequestLogin
    public String start(@PathVariable Integer id) {
        Start    start1   = new Start().setUserId(sessionUser().getId()).setBusinessId(id);
        Start    start    = startMapper.selectOne(start1);
        Business business = businessMapper.selectByPrimaryKey(id);
        if (start == null) {
            business.setStartNum(business.getStartNum() + 1);
            startMapper.insertSelective(start1);
        } else {
            business.setStartNum(business.getStartNum() - 1);
            startMapper.delete(start);
        }
        businessMapper.updateByPrimaryKeySelective(business);
        return refresh();
    }
}
