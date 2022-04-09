package com.fitnescoder.Springboot.tutorial.service;

import com.fitnescoder.Springboot.tutorial.entity.Department;
import com.fitnescoder.Springboot.tutorial.exception.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getAllDepartments();

    Department getByIdDepartment(Long id) throws DepartmentNotFoundException;

    void deleteById(Long id);

    Department updateDepartment(Long id, Department department);

    Department getDepartmentByName(String deptName);

    Department getDepartmentByDeptId(String id);
}
