package com.how2java.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import com.how2java.pojo.Product;

public class ProductDAO {
    //@Test
    public void testAddProduct() {
        Product product = new Product();
        product.setName("unit test");
        product.setPrice(12345);
        ProductDAO productDAO = new ProductDAO();
        productDAO.addProduct(product);
    }
    //@Test
    public void testDeleteProduct() {
        ProductDAO productDAO = new ProductDAO();
        productDAO.deleteProduct(4);
    }
    //@Test
    public void testQueryProduct() {
        ProductDAO productDAO = new ProductDAO();
        List<Product> listProducts = productDAO.queryProducts("test", 0, 99999);
        if (listProducts.isEmpty()) {
            System.out.println("No result");
            return;
        }
        
        for (Product product : listProducts) {
            String result = String.format("id:%d name:%s price:%f", 
                    product.getId(), product.getName(), product.getPrice());
            System.out.println(result);
        }
    }
    //@Test
    public void testUpdateProduct() {
        ProductDAO productDAO = new ProductDAO();
        Product product = new Product();
        product.setName("update test");
        product.setPrice(91969);
        
        if(productDAO.updateProducts(5, product)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
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
    public void deleteProduct(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Product product = (Product)session.get(Product.class, id);
        
        session.delete(product);
        
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
    
    /*
     * @brief ²é
     */
    public List<Product> queryProducts(String name, float priceLowerLimit, float priceUpperLimit){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        String hqlString = "from Product product where product.name like ? "
                + "and product.price >= ? "
                + "and product.price <= ?";
        Query query = session.createQuery(hqlString);
        query.setParameter(0, "%" + name + "%");
        query.setParameter(1, priceLowerLimit);
        query.setParameter(2, priceUpperLimit);
        
        List<Product> liseProducts = query.list();
        
        System.out.println(query.getQueryString());
        
        session.close();
        sessionFactory.close();
        return liseProducts;
    }
    
    /*
     * @brief ¸Ä
     */
    public boolean updateProducts(int id, Product product) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Product oldProduct = (Product) session.get(Product.class, id);
        if (oldProduct == null) {
            return false;
        }
        
        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        
        session.update(oldProduct);
        
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return true;
    }
}


