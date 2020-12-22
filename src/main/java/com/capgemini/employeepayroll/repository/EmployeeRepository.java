package com.capgemini.employeepayroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.employeepayroll.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	@Query(value = "select * from employee_payroll_data, employee_department where employee_payroll_data.id = employee_department.id and department = :department", nativeQuery = true)
	List<Employee> findEmployeeByDepartment(String department);

}
