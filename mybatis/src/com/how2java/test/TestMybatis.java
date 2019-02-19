package com.how2java.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import com.how2java.pojo.Category;
import com.how2java.pojo.Order;
import com.how2java.pojo.OrderMapper;
import com.how2java.pojo.Product;

public class TestMybatis {
    String resource = "config.xml";
    //@Test
    public void testCategory() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(); 
        
        List<Category> categories = sqlSession.selectList("listCategory");
        for(Category category : categories) {
            System.out.println(category.getName());
        }
        sqlSession.close();
    }
    //@Test
    public void testProduct() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(); 
        
        List<Product> products = sqlSession.selectList("listProduct");
        for(Product product : products) {
            System.out.println(product.getName() + "  " + product.getPrice());
        }
        sqlSession.close();
    }
    //@Test
    public void testAddCategory() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        
        Category category = new Category();
        category.setName("new category");
        sqlSession.insert("addCategory", category);
        
        sqlSession.commit();
        sqlSession.close();
    }
    //@Test
    public void testDeleteCategory() throws IOException {
        InputStream inputInputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputInputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        Category category = new Category();
        category.setName("new category111");
        sqlSession.delete("deleteCategory", category);
        
        sqlSession.commit();
        sqlSession.close();
    }
    //@Test
    public void testSelectCategory() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        Category category = new Category();
        category.setId(2);
        //List<Category> categories = sqlSession.selectList("getCategory", category);
        List<Category> categories = sqlSession.selectList("getCategory");
        
        for (Category category2 : categories) {
            System.out.println("select:" + category2.getName());
        }
        sqlSession.close();
    }
    //@Test
    public void testUpdateCategory() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        Category category = new Category();
        category.setId(2);
        category.setName("update category 2");
        
        sqlSession.update("updateCategory", category);
        
        sqlSession.commit();
        sqlSession.close();
    }
    //@Test
    public void testVagueSelectCategory() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("id", 0);
        paramsMap.put("name", "c");
        List<Category> categories = sqlSession.selectList("selectByIdAndName", paramsMap);
        
        for (Category category2 : categories) {
            System.out.println("select by id and name:" + category2.getName());
        }
        sqlSession.close();
    }
    //@Test
    public void  testOne2Many() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        List<Category> categories = sqlSession.selectList("one2ManyListCategory");
        for (Category category : categories) {
            System.out.println(category);
            List<Product> products = category.getProducts();
            for (Product product : products) {
                System.out.println(product);
            }
            System.out.println("----------------------------");
        }
        sqlSession.commit();
        sqlSession.close();
    }
    //@Test
    public void testMany2One() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        List<Product> products = sqlSession.selectList("listProduct2");
        for (Product product : products) {
            Category category = product.getCategory();
            System.out.println(product);
            System.out.println(category);
            System.out.println("---------------------------------");
        }
        
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    //查询所有有product的订单
    public void queryOrderByProduct() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        List<Order> orders = sqlSession.selectList("listOrder");
        
        for (Order order : orders) {
            System.out.println("Order id:" + order.getId());
            List<OrderMapper> orderMappers = order.getOrderMappers();
            for (OrderMapper orderMapper : orderMappers) {
                System.out.println("product id:" + orderMapper.getProduct().getId());
            }
            System.out.println("-------------------------------------");
        }
        
        sqlSession.commit();
        sqlSession.close();
    }
}

























