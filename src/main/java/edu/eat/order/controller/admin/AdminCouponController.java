package edu.eat.order.controller.admin;

import com.github.pagehelper.PageInfo;
import edu.eat.order.base.base.controller.BaseAdminController;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.domain.Coupon;
import edu.eat.order.mapper.CouponMapper;
import edu.eat.order.model.CouponModel;
import edu.eat.order.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author 执笔
 * @date 2019/4/10 10:53
 */
@Controller
@RequestMapping("admin/coupon")
public class AdminCouponController extends BaseAdminController {

    @Autowired
    private CouponService couponService;
    @Autowired
    private CouponMapper couponMapper;

    /**
     * 代金券列表
     *
     * @param model
     * @param couponModel
     * @return
     */
    @RequestMapping("list")
    public String list(Model model, CouponModel couponModel) {
        MybatisCondition example = new MybatisCondition()
                .like("u.name", couponModel.getUserName())
                .page(couponModel)
                .order("c.id", false);
        PageInfo<CouponModel> pageInfo = couponService.selectModelPage(example);
        setModelAttribute(model, pageInfo);
        return "admin/coupon/list";
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        couponMapper.deleteByPrimaryKey(id);
        return prompt("删除成功");
    }

    /**
     * 添加
     *
     * @return
     */
    @GetMapping("add/{userId}")
    public String add(@PathVariable Integer userId, Model model) {
        model.addAttribute("userId", userId);
        return "admin/coupon/add";
    }

    /**
     * 添加
     *
     * @return
     */
    @PostMapping("add")
    public String add(Coupon coupon) {
        coupon.setAddTime(new Date());
        coupon.setStatus("待使用");
        couponMapper.insertSelective(coupon);
        return prompt("添加成功", "/admin/coupon/list");
    }
}
