package edu.eat.order.mapper;

import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.domain.Coupon;
import edu.eat.order.model.CouponModel;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 执笔
 * @date 2019/4/10 10:52
 */
public interface CouponMapper extends Mapper<Coupon> {
    /**
     * 通过条件查找
     * @param example
     * @return
     */
    List<CouponModel> selectModel(MybatisCondition example);
}
