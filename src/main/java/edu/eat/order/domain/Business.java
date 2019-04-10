package edu.eat.order.domain;

import edu.eat.order.base.base.dto.BasePageDTO;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 执笔
 * @date 2019/4/10 13:41
 */
@Data
@Table(name = "business")
public class Business extends BasePageDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 名字
     */
    private String name;

    /**
     * 分类
     */
    private String category;
    /**
     * 电话
     */
    private String phone;
    private String address;

    /**
     * 横坐标
     */
    private Double pointX;
    /**
     * 竖坐标
     */
    private Double pointY;

    /**
     * 商家介绍
     */
    private String content;

    /**
     * 评论数量
     */
    private Integer commendNum;

    /**
     * 预约次数
     */
    private Integer orderNum;

    /**
     * 点赞数量
     */
    private Integer startNum;
}