package indi.sherlock.gms.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import indi.sherlock.gms.bean.Department;
import indi.sherlock.gms.mapper.DepartmentMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestDepartment {
    @Autowired
    private DepartmentMapper departmentMapper;
    
    //@Test
    public void addDepartment() {
        Department department = new Department();
        department.setName("test add department21");
        //department.setDescription("1111");
        try {
            int result = departmentMapper.addDepartment(department);
            System.out.println(result);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getLocalizedMessage());
        }
        
    }
    //@Test
    public void deleteDepartmentByName() {
        departmentMapper.deleteDepartmentByname("test add department2");
    }
    //@Test
    public void testDeleteDepartmentById() {
        departmentMapper.deleteDepartmentById(4);
    }
    //@Test
    public void testGetDepartmentByName() {
        List<Department> depatDepartments = departmentMapper.getDepartmentsByName("test");
        
        for (Department department : depatDepartments) {
            System.out.println(department);
        }
    }
    //@Test
    public void testGetDepartmentLikeName() {
        List<Department> depatDepartments = departmentMapper.getDepartmentsLikeName("add");
        
        for (Department department : depatDepartments) {
            System.out.println(department);
            System.out.println("-----------------------------");
        }
    }
    //@Test
    public void testGetPartmentById() {
        int id = 17;
        Department department = departmentMapper.getDepartmentById(id);
        if (department != null) {
            System.out.println(department);
        } else {
            System.out.println(String.format("Cannot get department by id:[%d]", id));
        }
        
    }
    //@Test
    public void testUpdateDepartmentById() {
        int id = 15;
        Department department = departmentMapper.getDepartmentById(id);
        if (department == null) {
            System.out.println(String.format("Cannot get department by id:[%d]", id));
        } else {
            department.setName("update 111");
            department.setDescription("update desc 222");
            departmentMapper.updateDepartmentById(department);
        }
    }
}
