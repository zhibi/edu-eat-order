package com.school.food.domain;

import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
 
import java.util.*;


/**
* The class create by 执笔 on generate.
* The class generate create by food_img
*/
@Table(name="food_img")
public class FoodImg implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String path;

    private String title;

    private String name;

    private Date addtime;

    @Column(name = "food_id")
    private Integer foodId;


    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath(){
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAddtime(){
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Integer getFoodId(){
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }


}