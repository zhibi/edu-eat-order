package edu.eat.order.model;

import edu.eat.order.base.base.dto.BasePageDTO;
import edu.eat.order.domain.Coupon;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author 执笔
 * @date 2019/4/10 9:51
 */
@Data
public class CouponModel extends Coupon {

  /**
   * 用户名
   */
  private String userName;
}
