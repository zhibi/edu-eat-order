package edu.eat.order.service;

import com.github.pagehelper.PageInfo;
import edu.eat.order.base.base.service.BaseService;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.domain.Coupon;
import edu.eat.order.model.CouponModel;

/**
 * @author 执笔
 * @date 2019/4/10 12:32
 */
public interface CouponService extends BaseService<Coupon> {
    /**
     * 通过条件分页查找
     * @param example
     * @return
     */
    PageInfo<CouponModel> selectModelPage(MybatisCondition example);
}
