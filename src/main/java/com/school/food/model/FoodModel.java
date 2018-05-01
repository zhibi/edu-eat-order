package com.school.food.model;

import com.school.food.domain.Food;

/**
 * Created by 执笔 on 2017/3/19.
 */
public class FoodModel extends Food {

    private String  businessName;

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
}
