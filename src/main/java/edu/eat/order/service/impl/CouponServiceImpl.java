package edu.eat.order.service.impl;

import com.github.pagehelper.PageInfo;
import edu.eat.order.base.base.service.BaseServiceImpl;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.domain.Coupon;
import edu.eat.order.mapper.CouponMapper;
import edu.eat.order.model.CouponModel;
import edu.eat.order.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 执笔
 * @date 2019/4/10 12:32
 */
@Service
public class CouponServiceImpl extends BaseServiceImpl<CouponMapper, Coupon> implements CouponService {

    @Autowired
    private CouponMapper couponMapper;
    @Override
    public PageInfo<CouponModel> selectModelPage(MybatisCondition example) {
        stratPage(example);
        return new PageInfo<CouponModel>(couponMapper.selectModel(example));
    }
}
