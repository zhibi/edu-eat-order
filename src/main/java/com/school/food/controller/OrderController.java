package com.school.food.controller;

import com.school.food.domain.Food;
import com.school.food.domain.Order;
import com.school.food.domain.OrderItem;
import com.school.food.model.OrderItemModel;
import com.school.food.model.OrderModel;
import com.school.food.service.FoodService;
import com.school.food.service.OrderItemService;
import com.school.food.service.OrderService;
import com.school.support.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import com.school.support.annocation.request.LoginInfo;
import com.school.support.exception.MessageException;
import com.school.support.example.Example;
import com.school.support.example.ExampleType;

import com.school.support.response.Response;

import java.util.Date;
import java.util.List;


@RequestMapping("order")
@Controller
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private FoodService foodService;

    @RequestMapping("saveItem")
    @ResponseBody
    public Response<String> saveItem(Integer footId) throws Exception {
        Food food = foodService.selectByPK(footId);
        if (null == food || food.getStatus() == 0) {
            throw new MessageException("该餐品不存在或者已下架");
        }
        OrderItem orderItem = new OrderItem();
        orderItem.setUserId(sessionUser().getId());
        orderItem.setFoodId(footId);
        orderItem.setStatus(0);
        orderItem.setScore(0);
        OrderItem temp = orderItemService.selectOne(orderItem);
        if (null != temp) {
            temp.setCount(temp.getCount() + 1);
            temp.setPrice(temp.getPrice() + 1 * food.getPrice());
            temp.setAddtime(new Date());
            orderItemService.updateByPKSelective(temp);
        } else {
            orderItem.setFoodId(footId);
            orderItem.setCount(1);
            orderItem.setPrice(food.getPrice());
            orderItem.setAddtime(new Date());
            orderItemService.insert(orderItem);
        }
        return Response.ok("");
    }

    @RequestMapping("myCar")
    public String myCar(Model model){
        Example example = Example.getInstance()
                .addOrder("o.addtime", ExampleType.OrderType.DESC)
                .addParam("o.user_id", sessionUser().getId())
                .addParam("o.status", 0);
        List<OrderItemModel> modelList = orderItemService.selectModel(example);
        model.addAttribute("modelList",modelList);
        double money = 0;
        for(OrderItemModel itemModel : modelList) {
            money += itemModel.getPrice();
        }
        model.addAttribute("money",money);
        return "pay";
    }

    @RequestMapping("delItem/{id}")
    public String delItem(@PathVariable Integer id){
        orderItemService.deleteByPK(id);
        return refresh();
    }

    @RequestMapping("pay")
    public String pay(Order order){
        order.setUserId(sessionUser().getId());
        orderService.pay(order);
        return "redirect:myOrder";
    }

    /**
     * 我的订单
     * @param model
     * @return
     */
    @RequestMapping("myOrder")
    public String myOrder(Model model){
        Example example = Example.getInstance()
                .addOrder("o.addtime", ExampleType.OrderType.DESC)
                .addParam("o.user_id", sessionUser().getId())
                .addOrder("o.status");
        List<OrderModel> modelList = orderService.selectModel(example);


        model.addAttribute("modelList",modelList);
        return "order";
    }

    /**
     * 为食物打分
     * @return
     */
    @RequestMapping("score")
    public String score(Integer orderItemId,Integer score){
        OrderItem orderItem = orderItemService.selectByPK(orderItemId);
        orderItem.setScore(score);
        orderItemService.updateByPK(orderItem);
        Food food = foodService.selectByPK(orderItem.getFoodId());
        food.setTimes(food.getTimes()+1);//评论次数
        food.setSort(food.getSort() + score);
        food.setAver((double) (food.getSort()/food.getTimes()));
        foodService.updateByPKSelective(food);
        return refresh();
    }

}
