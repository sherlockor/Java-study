package com.how2java.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;
import com.how2java.service.ProductService;

public class TestSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		
        Category c = (Category) context.getBean("c");

        System.out.println(c.getName());
        System.out.println(c.getId());

        Product product = (Product) context.getBean("p");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getCategory().getName());
		 
		
		ProductService productService = (ProductService)context.getBean("s");
		productService.doSomeService();
	}
}
