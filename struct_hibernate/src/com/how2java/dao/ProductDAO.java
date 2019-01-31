package com.how2java.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.how2java.pojo.Product;

public class ProductDAO {
    /*
     * @brief Ôö
     */
    public void addProduct(Product product) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(product);
        
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
    
    /*
     * @brief É¾
     */
    public void deleteProduct(Product product) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        session.delete(product);
        
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
    
    public List<Product> queryProducts(){
        
    }
    
    
    
}


