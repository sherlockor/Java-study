package com.how2java.pojo;

public class Product {
	private int id;
	private String name;
	private float price;
	private float lowerLimit;
	private float upperLimit;
	
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
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getLowerLimit() {
	    return lowerLimit;
	}
	public void setLowerLimit(float lowerLimit) {
	    this.lowerLimit = lowerLimit;
	}
	public float getUpperLimit() {
	    return upperLimit;
	}
	public void setUpperLimit(float upperLimit) {
	    this.upperLimit = upperLimit;
	}
}
