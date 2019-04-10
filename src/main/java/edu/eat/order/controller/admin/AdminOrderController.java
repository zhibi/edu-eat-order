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

    /**
     * 预约列表
     *
     * @param model
     * @param orderModel
     * @return
     */
    @RequestMapping("list")
    public String list(Model model, OrderModel orderModel) {
        MybatisCondition example = new MybatisCondition()
                .like("o.order_No", orderModel.getOrderNo())
                .like("u.name", orderModel.getUserName())
                .like("b.name", orderModel.getBusinessName())
                .order("o.status", false)
                .order("o.add_time", false)
                .page(orderModel);
        PageInfo<OrderModel> pageInfo = orderService.selectModelPage(example);
        setModelAttribute(model, pageInfo);
        return "admin/order/list";
    }

    /**
     * 修改订单状态
     *
     * @param order
     * @return
     */
    @RequestMapping("update")
    public String update(Order order) {
        orderMapper.updateByPrimaryKeySelective(order);
        return refresh();
    }

}
