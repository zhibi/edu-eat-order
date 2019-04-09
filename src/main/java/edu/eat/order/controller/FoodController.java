package edu.eat.order.controller;


import com.github.pagehelper.PageInfo;
import edu.eat.order.domain.Food;
import edu.eat.order.model.FoodModel;
import edu.eat.order.service.FoodService;
import edu.eat.order.service.OrderItemService;
import edu.eat.order.base.StringUtil;
import edu.eat.order.base.base.controller.BaseController;
import edu.eat.order.base.base.Page;
import edu.eat.order.base.example.Example;
import edu.eat.order.base.example.ExampleType;
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
