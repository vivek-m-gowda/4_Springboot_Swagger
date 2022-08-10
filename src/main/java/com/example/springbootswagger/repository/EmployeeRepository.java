package com.example.springbootswagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootswagger.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
