package edu.eat.order.domain;

import edu.eat.order.base.base.dto.BasePageDTO;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * @author 执笔
 * @date 2019/4/9 18:11
 */
@Table(name = "orders")
@Data
public class Order extends BasePageDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    private String orderNo;

    /**
     * 添加时间
     */
    private Date addTime;

    private Double total;

    /**
     * 状态 预约  已支付 预约完成  取消
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

    private Integer userId;

    /**
     * 预约商家
     */
    private Integer businessId;

    private Date payTime;

    /**
     * 预约时间
     */
    private String orderTime;

    /**
     * 预约人数
     */
    private Integer num;

    private String phone;

    /**
     * 优惠券Id
     */
    private Integer couponId;


    /**
     * 点的菜
     */
    private String foods;
}