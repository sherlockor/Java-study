package com.how2java.pojo;

import java.util.Set;

public class Category {
    int id = 0;
    String name;
    Set<Product> products;
	
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }
	
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
	
    public Set<Product> getProducts(){
        return this.products;
    }
    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
