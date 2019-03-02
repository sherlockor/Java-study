package indi.sherlock.gms.mapper;

import java.util.List;

import indi.sherlock.gms.bean.Department;

public interface DepartmentMapper {
    
    public int addDepartment(Department department);
    
    public void deleteDepartmentByname(String name);
    
    public void deleteDepartmentById(int id);
    
    public List<Department> getDepartmentsByName(String name);
    
    public Department getDepartmentById(int id);
    
    public void updateDepartmentById(Department department);
}
