package com.how2java.mapper;

import java.util.List;

import com.how2java.pojo.Category;

public interface CategoryMapper {
    public int addCategory(String name);
    
    public List<Category> getCategoriesByName(String name);
    
    public List<Category> getCategoriesPage(int start, int count);
}
