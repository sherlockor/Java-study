package indi.sherlock.gms.bean;

import java.util.List;

public class User {
    private int id;
    private String name;
    private String password;
    private UserBaseInfo userBaseInfo;
    private UserContectInfo userContectInfo;
    private List<Project> listProjects;
    
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public UserBaseInfo getUserBaseInfo() {
        return userBaseInfo;
    }
    public void setUserBaseInfo(UserBaseInfo userBaseInfo) {
        this.userBaseInfo = userBaseInfo;
    }
    public UserContectInfo getUserContectInfo() {
        return userContectInfo;
    }public void setUserContectInfo(UserContectInfo userContectInfo) {
        this.userContectInfo = userContectInfo;
    }
    public List<Project> getListProjects() {
        return listProjects;
    }
    public void setListProjects(List<Project> listProjects) {
        this.listProjects = listProjects;
    }
}
