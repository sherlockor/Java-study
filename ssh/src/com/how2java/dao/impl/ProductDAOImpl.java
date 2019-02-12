package com.how2java.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.how2java.dao.ProductDAO;
import com.how2java.pojo.Product;

public class ProductDAOImpl extends HibernateTemplate implements ProductDAO {
    @Override
    public List<Product> list() {
        // TODO Auto-generated method stub
        return find("from Product");
    }

    @Override
    public void add(Product product) {
        // TODO Auto-generated method stub
        save(product);
    }
}
