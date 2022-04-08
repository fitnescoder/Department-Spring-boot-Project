package com.dailycodebuffer.Springboot.tutorial.service;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.exception.DepartmentNotFoundException;

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
