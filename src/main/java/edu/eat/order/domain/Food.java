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
 *
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

    private String descript;

    private String category;

    private Integer sort;

    private Date addtime;

    private Integer status;

    private String icon;

    private String name;

    private Double price;

    private Integer times;

    private Double oldprice;
    private Integer businessid;

    /**
     * 平均分
     */
    private Double aver;

}