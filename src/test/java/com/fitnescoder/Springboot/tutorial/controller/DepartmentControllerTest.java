package com.fitnescoder.Springboot.tutorial.controller;

import com.fitnescoder.Springboot.tutorial.entity.Department;
import com.fitnescoder.Springboot.tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;


    private Department department;

    @BeforeEach
    void setUp() {
     department=Department.builder()
     .departmentName("Mech")
     .departmentCode("001")
     .departmentAddress("USA")
     .build();

    }

    @Test
    void saveDepartment() throws Exception {
        Department InDepartment =Department.builder()
                .departmentName("Mech")
                .departmentCode("001")
                .departmentAddress("USA")
                .departmentId(1L)
                .build();

        Mockito.when(departmentService.saveDepartment(InDepartment)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
                "    \"departmentName\": \"Mech\",\n" +
                "    \"departmentAddress\": \"USA\",\n" +
                "    \"departmentCode\":\"001\"\n" +
                "}")).andExpect(status().isOk());
    }

    @Test
    void getByIdDepartment() throws Exception {

        Mockito.when(departmentService.getByIdDepartment(1L)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));


    }
}