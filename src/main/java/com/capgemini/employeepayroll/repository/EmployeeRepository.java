package com.capgemini.employeepayroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.employeepayroll.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
