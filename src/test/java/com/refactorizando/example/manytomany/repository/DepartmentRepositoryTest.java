package com.refactorizando.example.manytomany.repository;

import com.refactorizando.example.manytomany.domain.Department;
import com.refactorizando.example.manytomany.domain.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void when_save_new_department_with_multiples_employees_then_department_is_saved_correctly() {

        Department department = new Department();
        department.setName("IT");
        department.setCode("oP");

        var employee = new Employee();
        employee.setName("Noel");

        department.getEmployees().add(employee);

        departmentRepository.save(department);
    }


    @Test
    @Sql("classpath:createDepartment.sql")
    public void when_remove_employee_from_department_then_employee_is_removed_correctly() {

        var departmentList = departmentRepository.findAll();

        var department = departmentList.stream().findFirst().orElseThrow();
        var employee = department.getEmployees().stream().findFirst().orElseThrow();

        department.removeEmployee(employee);
        departmentRepository.save(department);

    }
}
