package com.refactorizando.example.manytomany.repository;

import com.refactorizando.example.manytomany.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
