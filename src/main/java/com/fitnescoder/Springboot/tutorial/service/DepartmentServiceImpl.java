package com.fitnescoder.Springboot.tutorial.service;

import com.fitnescoder.Springboot.tutorial.entity.Department;
import com.fitnescoder.Springboot.tutorial.exception.DepartmentNotFoundException;
import com.fitnescoder.Springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements  DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getByIdDepartment(Long id) throws DepartmentNotFoundException {
        Optional<Department> department= departmentRepository.findById(id);

        if(!department.isPresent()) {
            throw new DepartmentNotFoundException("Department Not Available for id :"+id);
        }

        return department.get();
    }

    @Override
    public void deleteById(Long id) {
       departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department depDb=departmentRepository.findById(id).get();

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDb.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDb.setDepartmentCode(department.getDepartmentCode());
        }


        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            depDb.setDepartmentName(department.getDepartmentName());
        }
        return departmentRepository.save(depDb);
    }

    @Override
    public Department getDepartmentByName(String deptName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(deptName);
    }

    @Override
    public Department getDepartmentByDeptId(String id) {
        return departmentRepository.findDepartmentByDeptId(id);
    }
}
