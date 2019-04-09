package edu.eat.order.domain;

import edu.eat.order.base.base.dto.BasePageDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Data
@Table(name="order_item")
public class OrderItem extends BasePageDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "food_id")
    private Integer foodId;

    private Double price;

    private Integer count;

    @Column(name = "user_id")
    private Integer userId;

    private String status;

    private Date addtime;

    private Integer score;
}