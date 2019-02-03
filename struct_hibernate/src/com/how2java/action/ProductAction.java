package com.how2java.action;

import com.opensymphony.xwork2.ActionSupport;
import com.how2java.bean.Product;

public class ProductAction extends ActionSupport{
    private Product product;
    
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    
    public String showIndex() {
        System.out.println("function show()");
        return "index";
    }
    public String submitInfo() {
        System.out.println("function submitInfo()");
        System.out.println(product.getName());
        System.out.println(product.getLowerLimit());
        System.out.println(product.getUpperLimit());
        return "index";
    }
}
