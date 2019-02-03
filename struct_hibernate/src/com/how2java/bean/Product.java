package com.how2java.bean;

public class Product {
    private String name;
    private float lowerLimit;
    private float upperLimit;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getLowerLimit() {
        return lowerLimit;
    }
    public void setLowerLimit(float lowerLimit) {
        this.lowerLimit = lowerLimit;
    }
    public float getUpperLimit() {
        return upperLimit;
    }
    public void setUpperLimit(float upperLimit) {
        this.upperLimit = upperLimit;
    }
}
