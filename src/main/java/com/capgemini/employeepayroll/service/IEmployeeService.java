package com.capgemini.employeepayroll.service;

import java.util.List;

import javax.validation.Valid;

import com.capgemini.employeepayroll.dto.EmployeePayrollDTO;
import com.capgemini.employeepayroll.entity.Employee;

public interface IEmployeeService {
	
	Employee saveEmployee(EmployeePayrollDTO empPayrollDTO);

	List<Employee> getEmployees();

	Employee getEmployeeById(Long empId);
	
	List<Employee> getEmployeesByDepartment(String department);

	void deleteEmployee(Long empId);

	Employee updateEmployee(Long empId,EmployeePayrollDTO empPayrollDTO);

}
