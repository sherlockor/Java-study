package com.how2java.pojo;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("p")
public class Product {
	private int id = 999;
	private String name = "produce test";
	private float price = 888.88f;
	//@Autowired
	@Resource(name="c")
	private Category category;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id  = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public Category getCategory() {
		return category;
	}
	//@Autowired
	public void setCategory(Category category) {
		this.category = category;
	}
}
