package com.dailycodebuffer.Springboot.tutorial.controller;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.exception.DepartmentNotFoundException;
import com.dailycodebuffer.Springboot.tutorial.service.DepartmentService;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside save Department PostMapping");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department getByIdDepartment(@PathVariable Long id) throws DepartmentNotFoundException {
        LOGGER.info("Get Department By ID");
        return departmentService.getByIdDepartment(id);
    }

    @DeleteMapping("/departments/{id}")
    public void deleteById(@PathVariable Long id) {
        departmentService.deleteById(id);
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        return departmentService.updateDepartment(id,department);
    }

    @GetMapping("/departments/deptByName/{deptName}")
    public Department getDepartmentByName(@PathVariable String deptName) {
        return departmentService.getDepartmentByName(deptName);
    }

    @GetMapping("/departments/deptId/{id}")
    public Department getDepartmentByDeptId(@PathVariable String id) {
        return departmentService.getDepartmentByDeptId(id);
    }
}
