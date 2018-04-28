package com.school.food.model;

import com.school.food.domain.OrderItem;

/**
 * Created by 执笔 on 2017/3/24.
 */
public class OrderItemModel extends OrderItem {

    private String foodName;
    private String foodIcon;
    private Double foodPrice;


    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodIcon() {
        return foodIcon;
    }

    public void setFoodIcon(String foodIcon) {
        this.foodIcon = foodIcon;
    }
}
