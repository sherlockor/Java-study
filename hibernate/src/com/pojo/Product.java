package com.pojo;

/**
 * @brief	用于映射数据库中的表product_
 * @author 	sherlock
 *
 */
public class Product {
	int id;
	String name;
	float price;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	public float getPrice() {
		return price;
	}
}
