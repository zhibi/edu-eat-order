package edu.eat.order.controller;

import edu.eat.order.base.base.controller.BaseController;
import edu.eat.order.base.exception.MessageException;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.base.response.JsonResponse;
import edu.eat.order.domain.Food;
import edu.eat.order.domain.Order;
import edu.eat.order.mapper.FoodMapper;
import edu.eat.order.model.OrderModel;
import edu.eat.order.service.FoodService;
import edu.eat.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@RequestMapping("order")
@Controller
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private FoodService foodService;
    @Autowired
    private FoodMapper foodMapper;


    @RequestMapping("myCar")
    public String myCar(Model model) {
        MybatisCondition example = new MybatisCondition()
                .order("o.addtime", false)
                .eq("o.user_id", sessionUser().getId())
                .eq("o.status", 0);
        double money = 0;
        model.addAttribute("money", money);
        return "pay";
    }

    @RequestMapping("delItem/{id}")
    public String delItem(@PathVariable Integer id) {
        return refresh();
    }

    @RequestMapping("pay")
    public String pay(Order order) {
        order.setUserId(sessionUser().getId());
        orderService.pay(order);
        return "redirect:myOrder";
    }

    /**
     * 我的订单
     *
     * @param model
     * @return
     */
    @RequestMapping("myOrder")
    public String myOrder(Model model) {
        MybatisCondition example = new MybatisCondition()
                .order("o.addtime", false)
                .eq("o.user_id", sessionUser().getId())
                .order("o.status");
        List<OrderModel> modelList = orderService.selectModel(example);
        model.addAttribute("modelList", modelList);
        return "order";
    }


}
