package com.how2java.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestSpringMybatis {
    @Autowired
    private CategoryMapper categoryMapper;
    
    @Test
    public void testAdd() {
        categoryMapper.addCategory("spring_mybatis test");
    }
    
    @Test
    public void testQuery() {
        List<Category> categories = categoryMapper.getCategoriesByName("spring");
        for (Category category : categories) {
            System.out.println(category);
        }
    }
}
