package com.how2java.service.impl;

import java.util.List;

import com.how2java.dao.ProductDAO;
import com.how2java.pojo.Product;
import com.how2java.service.ProductService;

public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO;
    
    @Override
    public List<Product> list() {
        // TODO Auto-generated method stub
        List<Product> products = productDAO.list();
        if (products.isEmpty()) {
            for(int i = 0; i < 5; i++) {
                Product product = new Product();
                product.setName("procut " + i);
                productDAO.add(product);
                products.add(product);
            }
        }
        return products;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
}
