package com.how2java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.how2java.pojo.Category;

public interface CategoryMapper {
    @Insert("insert into category_ (name) values (#{name})")
    public int addCategory(Category category);
    
    @Delete("delete from category_ where id=#{id}")
    public void deleteCategoryById(int id);
    
    @Select("select * from category_ where id=#{id}")
    public Category getCategoryById(int id);
    
    @Update("update category_ set name=#{name} where id=#{id}")
    public int updateCategory(Category category);
    
    @Select("select * from category_ where name like concat('%',#{name},'%')")
    @Results({
        @Result(property="id", column="id"),
        @Result(property="products", javaType=List.class, column="id",many=@Many(
                select="com.how2java.mapper.ProductMapper.getProductsByCategoryId"))
    })
    public List<Category> getCategoriesByName(String name);
}


