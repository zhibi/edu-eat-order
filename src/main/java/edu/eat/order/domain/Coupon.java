package edu.eat.order.domain;

import edu.eat.order.base.base.dto.BasePageDTO;
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
public class Coupon extends BasePageDTO {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     *
     */
    private Integer userId;

    /**
     * 金额
     */
    private Double money;

    /**
     * 种类
     */
    private String species;

    private Date addTime;

    /**
     * 待使用  已使用
     */
    private String status;
}
