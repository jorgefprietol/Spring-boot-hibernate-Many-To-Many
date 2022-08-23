package com.refactorizando.example.manytomany.repository;

import com.refactorizando.example.manytomany.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
