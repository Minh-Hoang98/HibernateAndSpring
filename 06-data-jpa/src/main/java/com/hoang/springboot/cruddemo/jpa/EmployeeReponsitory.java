package com.hoang.springboot.cruddemo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoang.springboot.cruddemo.entity.Employee;

@Repository
public interface EmployeeReponsitory extends JpaRepository<Employee, Integer> {

}
