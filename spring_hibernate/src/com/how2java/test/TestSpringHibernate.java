package com.how2java.test;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.how2java.dao.CategoryDao;
import com.how2java.pojo.Category;

public class TestSpringHibernate {
    //@Test
    public void testDao() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Category category = (Category)applicationContext.getBean("category");
        System.out.println(category.getName());
    }
    //@Test
    public void testOP() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CategoryDao categoryDao = (CategoryDao) applicationContext.getBean("categoryDao");
        Category category2 = new Category();
        category2.setName("category test 2");
        //≤Â»Î
        categoryDao.save(category2);
        //ªÒ»°
        Category category = (Category)categoryDao.get(Category.class, 2);
        System.out.println(category.getName());
        
        category.setName("category update");
        categoryDao.update(category);
        
        categoryDao.delete(category);
    }
    //@Test
    public void forInsert() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CategoryDao categoryDao = (CategoryDao) applicationContext.getBean("categoryDao");
        for(int index = 0; index < 20; index++) {
            String name = "category test" + index;
            Category category = new Category();
            category.setName(name);
            
            categoryDao.save(category);
        }
    }
    //@Test
    public void testPaging() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CategoryDao categoryDao = (CategoryDao) applicationContext.getBean("categoryDao");
        
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Category.class);
        int start = 23;
        int count = 5;
        List<Category> categories = categoryDao.findByCriteria(detachedCriteria, start, count);
        for (Category category : categories) {
            System.out.println(category.getName());
        }
    }
    @Test
    public void testCount() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CategoryDao categoryDao = (CategoryDao) applicationContext.getBean("categoryDao");
        
        List<Long> counts = categoryDao.find("select count(*) from Category c");
        long count = counts.get(0);
        System.out.println(count);
    }
}
