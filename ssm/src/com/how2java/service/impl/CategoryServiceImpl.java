package com.how2java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public void addCategory(String name) {
        // TODO Auto-generated method stub
        categoryMapper.addCategory(name);
    }

    @Override
    public List<Category> queryCategory(String name) {
        // TODO Auto-generated method stub
        return categoryMapper.getCategoriesByName(name);
    }

    @Override
    public List<Category> queryPage(int start, int count) {
        // TODO Auto-generated method stub
        return categoryMapper.getCategoriesPage(start, count);
    }
}
