package indi.sherlock.gms.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import indi.sherlock.gms.bean.Department;
import indi.sherlock.gms.bean.User;
import indi.sherlock.gms.bean.UserBaseInfo;
import indi.sherlock.gms.mapper.DepartmentMapper;
import indi.sherlock.gms.mapper.UserBaseInfoMapper;
import indi.sherlock.gms.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestUser {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper;
    
    
    @Test
    public void testAddUser() {
        User user = new User();
        user.setName("test user name2222");
        user.setPassword("12345");
        userMapper.addUser(user);
        
        System.out.println(user.getId());
        
        Department department = departmentMapper.getDepartmentById(6);
        
        UserBaseInfo userBaseInfo = new UserBaseInfo();
        userBaseInfo.setRealName("real name");
        userBaseInfo.setDepartment(department);
        userBaseInfo.setGender(1);
        userBaseInfo.setUser(user);
        userBaseInfoMapper.addUserBaseInfo(userBaseInfo);
    }

}
