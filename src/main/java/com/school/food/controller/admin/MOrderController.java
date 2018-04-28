package com.school.food.controller.admin;

import com.github.pagehelper.PageInfo;
import com.school.food.domain.Order;
import com.school.food.model.OrderModel;
import com.school.food.service.OrderService;
import com.school.support.base.AdminBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.school.support.base.Page;
import com.school.support.example.Example;
import com.school.support.example.ExampleType;


@Controller
@RequestMapping("admin/order")
public class MOrderController extends AdminBaseController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("list")
    public String list(Model model, Page page, OrderModel orderModel) {
        Example example = Example.getInstance()
                .addParam("o.orderNo", orderModel.getOrderno(), ExampleType.Operation.LIKE)
                .addOrder("o.status", ExampleType.OrderType.DESC)
                ;
        PageInfo<OrderModel> pageInfo = orderService.selectModel(example, page);
        setModelAttribute(model, pageInfo);
        return "admin/order/list";
    }

    @RequestMapping("sendGoods/{id}")
    public String sendGoods(@PathVariable Long id) {
        Order order = orderService.selectByPK(id);
        order.setStatus(3);
        orderService.updateByPKSelective(order);
        return redirect("list");
    }

    @RequestMapping("detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        OrderModel orderModel = orderService.selectModelById(id);
        model.addAttribute(orderModel);
        return "admin/order/detail";
    }
}
