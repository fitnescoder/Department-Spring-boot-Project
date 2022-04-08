package com.dailycodebuffer.Springboot.tutorial.service;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {


    }

    @Test
    public void getDepartmentByNameOfDepartment() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentCode("IT-06")
                .build();

        String departmentName="IT";

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase(departmentName)).thenReturn(department);

        Department found=departmentService.getDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());

    }
}