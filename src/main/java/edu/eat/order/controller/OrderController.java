package edu.eat.order.controller;

import edu.eat.order.base.annocation.RequestLogin;
import edu.eat.order.base.base.controller.BaseController;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.domain.Business;
import edu.eat.order.domain.Order;
import edu.eat.order.mapper.BusinessMapper;
import edu.eat.order.mapper.OrderMapper;
import edu.eat.order.model.OrderModel;
import edu.eat.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;


@RequestMapping("order")
@Controller
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private BusinessMapper businessMapper;
    @Autowired
    private OrderMapper orderMapper;


    /**
     * 发布预约页面
     *
     * @param businessId
     * @param model
     * @return
     */
    @RequestLogin
    @GetMapping("send/{businessId}")
    public String send(@PathVariable Integer businessId, Model model) {
        Business business = businessMapper.selectByPrimaryKey(businessId);
        model.addAttribute(business);
        return "business/order-send";
    }

    /**
     * 发布评论
     *
     * @param order
     * @return
     */
    @Transactional
    @PostMapping("send")
    @RequestLogin
    public String send(Order order) {
        order.setAddTime(new Date());
        order.setUserId(sessionUser().getId());
        orderMapper.insertSelective(order);
        Business business = businessMapper.selectByPrimaryKey(order.getBusinessId());
        business.setCommendNum(business.getOrderNum() + 1);
        businessMapper.updateByPrimaryKeySelective(business);
        return redirect("预约成功","order/myOrder");
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
