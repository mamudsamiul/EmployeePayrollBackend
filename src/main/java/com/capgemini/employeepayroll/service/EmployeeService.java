package com.capgemini.employeepayroll.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.employeepayroll.dto.EmployeePayrollDTO;
import com.capgemini.employeepayroll.entity.Employee;
import com.capgemini.employeepayroll.exception.EmployeePayrollException;
import com.capgemini.employeepayroll.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService{
	@Autowired
	private EmployeeRepository employeePayrollRepository;

	@Override
	public Employee saveEmployee(EmployeePayrollDTO empPayrollDTO) {
		Employee empData = new Employee(empPayrollDTO);
		employeePayrollRepository.save(empData);
		return empData;
	}

	@Override
	public List<Employee> getEmployees() {
		return employeePayrollRepository.findAll().stream().collect(Collectors.toList());
	}

	@Override
	public Employee getEmployeeById(Long empId) {
		Employee empPayrollData = employeePayrollRepository.findById(empId).orElseThrow(() -> new EmployeePayrollException("Not Found"));
		return empPayrollData;
	}

	@Override
	public List<Employee> getEmployeesByDepartment(String department) {
		return employeePayrollRepository.findEmployeeByDepartment(department);
	}

	@Override
	public void deleteEmployee(Long empId) {
		Employee empData = this.getEmployeeById(empId);
		employeePayrollRepository.deleteById(empData.getId());
		
	}

	@Override
	public Employee updateEmployee(Long empId, EmployeePayrollDTO empPayrollDTO) {
		Employee empData = this.getEmployeeById(empId);
		empData.setName(empPayrollDTO.name);
		empData.setSalary(empPayrollDTO.salary);
		empData.setGender(empPayrollDTO.gender);
		empData.setStartDate(empPayrollDTO.startDate);
		empData.setNote(empPayrollDTO.note);
		empData.setProfilePic(empPayrollDTO.profilePic);
		empData.setDepartments(empPayrollDTO.department);
		employeePayrollRepository.save(empData);
		return empData;
	}

}
