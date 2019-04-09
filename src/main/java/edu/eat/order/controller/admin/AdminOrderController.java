package edu.eat.order.controller.admin;

import com.github.pagehelper.PageInfo;
import edu.eat.order.base.base.controller.BaseAdminController;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.domain.Order;
import edu.eat.order.mapper.OrderMapper;
import edu.eat.order.model.OrderModel;
import edu.eat.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 执笔
 * @date 2019/4/9 18:09
 */
@Controller
@RequestMapping("admin/order")
public class AdminOrderController extends BaseAdminController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping("list")
    public String list(Model model, OrderModel orderModel) {
        MybatisCondition example = new MybatisCondition()
                .like("o.orderNo", orderModel.getOrderno())
                .order("o.status", false)
                .page(orderModel);
        PageInfo<OrderModel> pageInfo = orderService.selectModelPage(example);
        setModelAttribute(model, pageInfo);
        return "admin/order/list";
    }

    @RequestMapping("sendGoods/{id}")
    public String sendGoods(@PathVariable Long id) {
        Order order = orderMapper.selectByPrimaryKey(id);
        order.setStatus(3);
        orderMapper.updateByPrimaryKeySelective(order);
        return redirect("list");
    }

    @RequestMapping("detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        OrderModel orderModel = orderService.selectModelById(id);
        model.addAttribute(orderModel);
        return "admin/order/detail";
    }
}
