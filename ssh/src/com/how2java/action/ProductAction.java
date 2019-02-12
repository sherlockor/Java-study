package com.how2java.action;

import java.util.List;

import com.how2java.pojo.Product;
import com.how2java.service.ProductService;

public class ProductAction {
    private ProductService productService;
    List<Product> products;
    
    public String list() {
        System.out.println("function list()");
        System.out.println(this);
        products = productService.list();
        return "pass";
    }
    
    public ProductService getProductService() {
        return productService;
    }
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    public List<Product> getProducts(){
        return products;
    }
    public void setProducts(List<Product>products) {
        this.products = products;
    }
}
