package com.refactorizando.example.manytomany.service;

import com.refactorizando.example.manytomany.domain.Department;
import com.refactorizando.example.manytomany.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<Department> findAll() {

        return departmentRepository.findAll();
    }

    public Department findById(Long id) {

        return departmentRepository.findById(id).orElseThrow();
    }

    public Department save (Department department) {

        return departmentRepository.save(department);
    }

    public void delete(Department department) {

        departmentRepository.delete(department);
    }
}
