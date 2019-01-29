package com.how2java.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.how2java.bean.Product;
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport {
    private Product product;

    public String show() {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
		
        System.out.println(request);
        System.out.println(response);
		
        product = new Product();
        product.setName("iphone7");
        return "show1";
    }
    public String add(){
        System.out.println("product.name:"+product.getName());
        return "show";
    }
    public String age() {
        System.out.println("product.name:"+product.getAge());
        return "show";
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}