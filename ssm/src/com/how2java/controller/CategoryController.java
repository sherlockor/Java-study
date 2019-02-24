package com.how2java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;

@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    
    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
    
    @RequestMapping("addCategory")
    public String addCategory(String name) {
        categoryService.addCategory(name);
        return "index";
    }
    @RequestMapping("query")
    public String query() {
        return "query";
    }
    @RequestMapping("queryCategory")
    public String queryCategory(String name) {
        List<Category> categories = categoryService.queryCategory(name);
        for (Category category : categories) {
            System.out.println(category);
        }
        return "query";
    }
    
    @RequestMapping("queryCategoryPage")
    public String queryCategoryPage(int start, int count) {
        System.out.println("queryCategoryPage:" + start + "," + count);
        List<Category> categories = categoryService.queryPage(start, count);
        for (Category category : categories) {
            System.out.println(category);
        }
        return "query";
    }
}
