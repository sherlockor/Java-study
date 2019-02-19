package com.how2java.pojo;

import java.util.List;

public class Order {
    private int id;
    private String code;
    private List<OrderMapper> orderMappers;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public List<OrderMapper> getOrderMappers() {
        return orderMappers;
    }
    public void setOrderMappers(List<OrderMapper> orderMappers) {
        this.orderMappers = orderMappers;
    }
}
