package com.how2java.action;

import com.opensymphony.xwork2.ActionSupport;


import com.how2java.pojo.Product;

import java.util.List;

import com.how2java.dao.ProductDAO;

public class ProductAction extends ActionSupport{
    private Product product;
    private ProductDAO productDAO = new ProductDAO();
    
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
    public String insert() {
        System.out.println("function insert()");
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        productDAO.addProduct(product);
        return "pass";
    }
    public String query() {
        System.out.println("function submitInfo()");
        System.out.println(product.getName());
        System.out.println(product.getLowerLimit());
        System.out.println(product.getUpperLimit());
        List<Product> listPList = productDAO.queryProducts(product.getName(), product.getLowerLimit(), product.getUpperLimit());
        for (Product product : listPList) {
            System.out.println(product.getName());
        }
        
        return "index";
    }
}
