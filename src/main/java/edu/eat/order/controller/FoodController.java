package edu.eat.order.controller;


import com.github.pagehelper.PageInfo;
import edu.eat.order.base.utils.StringUtils;
import edu.eat.order.base.base.controller.BaseController;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.domain.Food;
import edu.eat.order.mapper.OrderItemMapper;
import edu.eat.order.model.FoodModel;
import edu.eat.order.service.FoodService;
import edu.eat.order.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("food")
@Controller
public class FoodController extends BaseController {

    @Autowired
    private FoodService foodService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private OrderItemMapper orderItemMapper;


    @RequestMapping("list")
    public String list(Food food, Model model, MybatisCondition condition, String collect) {
        condition
                .order("f.sort", false)
                .eq("f.category", food.getCategory())
                .like("f.name", food.getName())
                .eq("f.status", "1");
        if (!StringUtils.isEmpty(collect)) {
            condition.condition("c.id  is not null");
        }
        PageInfo<FoodModel> pageInfo = foodService.selectModelPage(condition);
        setModelAttribute(model, pageInfo);
        return "food/list";
    }

    @RequestMapping("del/{id}")
    public String del(@PathVariable Integer id) {
        orderItemMapper.deleteByPrimaryKey(id);
        return refresh();
    }

}
