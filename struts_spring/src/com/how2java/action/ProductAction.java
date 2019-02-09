package com.how2java.action;
  
public class ProductAction {
    private String name;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String show() {
        System.out.println("function show()");
        return "show";
    }
    
    public String submit() {
        System.out.println("function submit()");
        System.out.println(name);
        return "pass";
    }
  
}