package com.how2java.service;

import java.util.List;

import com.how2java.pojo.Category;

public interface CategoryService {
    public void addCategory(String name);
    
    public List<Category> queryCategory(String name);
    
    public List<Category> queryPage(int start, int count);
}
