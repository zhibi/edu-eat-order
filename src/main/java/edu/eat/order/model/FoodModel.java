package edu.eat.order.model;

import edu.eat.order.domain.Food;


public class FoodModel extends Food {

    private String  businessName;
    private Integer comment;

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
}