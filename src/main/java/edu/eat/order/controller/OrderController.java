package edu.eat.order.controller;

import edu.eat.order.base.base.controller.BaseController;
import edu.eat.order.base.exception.MessageException;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.base.response.JsonResponse;
import edu.eat.order.domain.Food;
import edu.eat.order.domain.Order;
import edu.eat.order.domain.OrderItem;
import edu.eat.order.mapper.FoodMapper;
import edu.eat.order.mapper.OrderItemMapper;
import edu.eat.order.model.OrderItemModel;
import edu.eat.order.model.OrderModel;
import edu.eat.order.service.FoodService;
import edu.eat.order.service.OrderItemService;
import edu.eat.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Autowired
    private FoodMapper foodMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;

    @RequestMapping("saveItem")
    @ResponseBody
    public JsonResponse<String> saveItem(Integer footId) throws Exception {
        Food food = foodMapper.selectByPrimaryKey(footId);
        if (null == food || food.getStatus() == 0) {
            throw new MessageException("该餐品不存在或者已下架");
        }
        OrderItem orderItem = new OrderItem();
        orderItem.setUserId(sessionUser().getId());
        orderItem.setFoodId(footId);
        orderItem.setStatus("0");
        orderItem.setScore(0);
        OrderItem temp = orderItemMapper.selectOne(orderItem);
        if (null != temp) {
            temp.setCount(temp.getCount() + 1);
            temp.setPrice(temp.getPrice() + 1 * food.getPrice());
            temp.setAddtime(new Date());
            orderItemMapper.updateByPrimaryKeySelective(temp);
        } else {
            orderItem.setFoodId(footId);
            orderItem.setCount(1);
            orderItem.setPrice(food.getPrice());
            orderItem.setAddtime(new Date());
            orderItemMapper.insert(orderItem);
        }
        return JsonResponse.ok("");
    }

    @RequestMapping("myCar")
    public String myCar(Model model) {
        MybatisCondition example = new MybatisCondition()
                .order("o.addtime", false)
                .eq("o.user_id", sessionUser().getId())
                .eq("o.status", 0);
        List<OrderItemModel> modelList = orderItemService.selectModel(example);
        model.addAttribute("modelList", modelList);
        double money = 0;
        for (OrderItemModel itemModel : modelList) {
            money += itemModel.getPrice();
        }
        model.addAttribute("money", money);
        return "pay";
    }

    @RequestMapping("delItem/{id}")
    public String delItem(@PathVariable Integer id) {
        orderItemMapper.deleteByPrimaryKey(id);
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

    /**
     * 为食物打分
     *
     * @return
     */
    @RequestMapping("score")
    public String score(Integer orderItemId, Integer score) {
        OrderItem orderItem = orderItemMapper.selectByPrimaryKey(orderItemId);
        orderItem.setScore(score);
        orderItemMapper.updateByPrimaryKeySelective(orderItem);
        Food food = foodMapper.selectByPrimaryKey(orderItem.getFoodId());
        food.setTimes(food.getTimes() + 1);//评论次数
        food.setSort(food.getSort() + score);
        food.setAver((double) (food.getSort() / food.getTimes()));
        foodMapper.updateByPrimaryKeySelective(food);
        return refresh();
    }

}
