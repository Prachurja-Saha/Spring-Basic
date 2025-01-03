package com.practice.springbasic.concept.jdbcjpaorm.implementation;

import com.practice.springbasic.concept.jdbcjpaorm.implementation.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    List<Employee> findByName(String name);
}
