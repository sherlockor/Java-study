package indi.sherlock.gms.bean;

import java.util.List;

public class User {
    private int id;
    private UserBaseInfo userBaseInfo;
    private UserContectInfo userContectInfo;
    private List<Project> listProjects;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
