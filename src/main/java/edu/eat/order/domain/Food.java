package edu.eat.order.domain;

import edu.eat.order.base.base.dto.BasePageDTO;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 * @author 执笔
 * @date 2019/4/9 18:29
 */
@Data
@Table(name = "food")
public class Food extends BasePageDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;

    /**
     * 描述
     */
    private String description;

    /**
     * 分类
     */
    private String category;

    private Integer sort;

    private Date addtime;

    /**
     * 图片
     */
    private String icon;

    /**
     * 名字
     */
    private String name;

    /**
     * 价格
     */
    private Double price;

    /**
     * 原价
     */
    private Double oldPrice;
    private Integer businessId;
}