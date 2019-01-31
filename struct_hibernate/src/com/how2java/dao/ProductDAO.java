package com.how2java.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.how2java.pojo.Product;

public class ProductDAO {
    public static void main(String[] args) {
        System.out.println("start");
        
        Product product = new Product();
        product.setName("unit test");
        product.setPrice(12345);
        
        ProductDAO productDAO = new ProductDAO();
        productDAO.addProduct(product);
        
        System.out.println("end");
    }
    
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
    
//    public List<Product> queryProducts(){
//        
//    }
    
    
    
}


