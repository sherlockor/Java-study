package com.how2java.pojo;

import org.springframework.stereotype.Component;

@Component("c")
public class Category {
	private int id = 12123;
	private String name = "catgory 9876";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
