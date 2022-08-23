package com.refactorizando.example.manytomany.controller;

import com.refactorizando.example.manytomany.domain.Department;
import com.refactorizando.example.manytomany.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {


    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<Department>> getDepartments() {

        var departments = departmentService.findAll();

        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable Long id) {

        var department = departmentService.findById(id);

        return new ResponseEntity<>(department, HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {

        var departmentSaved = departmentService.save(department);

        return new ResponseEntity<>(departmentSaved, HttpStatus.OK);

    }

    @DeleteMapping()
    public ResponseEntity<Department> deleteDepartment(@RequestBody Department department) {

        departmentService.delete(department);

        return new ResponseEntity<>(department, HttpStatus.OK);

    }

}