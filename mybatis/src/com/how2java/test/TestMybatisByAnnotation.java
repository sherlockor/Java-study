package com.how2java.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.how2java.mapper.CategoryMapper;
import com.how2java.mapper.OrderMapper;
import com.how2java.mapper.ProductMapper;
import com.how2java.pojo.Category;
import com.how2java.pojo.Order;
import com.how2java.pojo.OrderItem;
import com.how2java.pojo.Product;

public class TestMybatisByAnnotation {
    private String resource = "config.xml";
    private SqlSession sqlSession;
    private CategoryMapper categoryMapper;
    private ProductMapper productMapper;
    private OrderMapper orderMapper;
    
    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        productMapper = sqlSession.getMapper(ProductMapper.class);
        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }
    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }
    //@Test
    public void testAddCategory() throws IOException {
        Category category = new Category();
        category.setName("annotation category");
        int number = categoryMapper.addCategory(category);
        System.out.println(number);
    }
    //@Test
    public void testDeleteCategory() {
        categoryMapper.deleteCategoryById(14);
    }
    //@Test
    public void testGetCategoryById() {
        Category category = categoryMapper.getCategoryById(15);
        System.out.println(category.getName());
    }
    //@Test
    public void testUpdateCategory() {
        Category category = categoryMapper.getCategoryById(15);
        if (category == null) {
            System.out.println("Cannot get category class");
            return;
        }
        category.setName("update annotation");
        categoryMapper.updateCategory(category);
    }
    //@Test
    public void testGetCategoriesByName() {
        List<Category> categories = categoryMapper.getCategoriesByName("category");
        for (Category category : categories) {
            System.out.println(category.getId() + "," + category.getName());
            List<Product> products = category.getProducts();
            for (Product product : products) {
                System.out.println(product.getName());
            }
            System.out.println("--------------------------");
        }
    }
    //@Test
    public void testGetProducts() {
        List<Product> products = productMapper.getProducts();
        for (Product product : products) {
            System.out.println(product.getId() + "," + product.getName());
            Category category = product.getCategory();
            if (category != null) {
                System.out.println(category.getId() + "," + category.getName());
            }
            System.out.println("--------------------------");
        }
    }
    @Test
    public void testMany2Many() {
        List<Order> orders = orderMapper.getOrders();
        for (Order order : orders) {
            System.out.println(order.getId());
            List<OrderItem> orderItems = order.getOrderItems();
            for (OrderItem orderItem : orderItems) {
                Product product = orderItem.getProduct();
                System.out.println(product.getId() + ":" + product.getName());
            }
            System.out.println("--------------------------------------");
        }
    }
}









