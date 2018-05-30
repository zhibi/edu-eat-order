package com.school.food.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;



@Table(name="order_item")
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "food_id")
    private Integer foodId;

    private Double price;

    private Integer count;

    @Column(name = "user_id")
    private Integer userId;

    private Integer status;//0 未支付  1 已支付

    private Date addtime;

    private Integer score;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFoodId(){
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Double getPrice(){
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount(){
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getUserId(){
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}