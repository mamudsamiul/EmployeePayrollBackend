package com.capgemini.employeepayroll.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.persistence.JoinColumn; 

import com.capgemini.employeepayroll.dto.EmployeePayrollDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_payroll_data")
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "salary")
	private double salary;

	private String gender;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	private String note;
	private String profilePic;
	
	@ElementCollection
	@CollectionTable(name="employee_department", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "department")
	private List<String> departments;
	

	public Employee(EmployeePayrollDTO empPayrollDTO) {
		this.name = empPayrollDTO.name;
		this.salary = empPayrollDTO.salary;
		this.gender = empPayrollDTO.gender;
		this.startDate = empPayrollDTO.startDate;
		this.note = empPayrollDTO.note;
		this.profilePic = empPayrollDTO.profilePic;
		this.departments = empPayrollDTO.department;

	}
}
