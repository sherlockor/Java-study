package indi.sherlock.gms.bean;

import java.util.List;

public class Project {
    private int id;
    private String name;
    private String description;
    private List<User> listUsers;
    
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<User> getListUsers() {
        return listUsers;
    }
    public void setListUsers(List<User> listUsers) {
        this.listUsers = listUsers;
    }
}
