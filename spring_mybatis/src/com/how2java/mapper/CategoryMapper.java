package com.how2java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.how2java.pojo.Category;

public interface CategoryMapper {
    @Insert("insert into category_ (name) values (#{name})")
    public int addCategory(String name);
    
    @Select("select * from category_ where name like concat('%', #{name}, '%')")
    public List<Category> getCategoriesByName(String name);
    
    public void updateCategory(Category category);
}
