package com.fitnescoder.Springboot.tutorial.repository;

import com.fitnescoder.Springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByDepartmentNameIgnoreCase(String departmentName);

    @Query("Select d from Department d where d.departmentCode=?1")
    Department findDepartmentByDeptId(String deptId);
}
