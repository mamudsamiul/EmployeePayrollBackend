package com.capgemini.employeepayroll.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "payroll")
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@NotEmpty(message = "First name cant be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Incorrect Name")
    private String name;
	@NotEmpty(message = "Profile Photo cant be empty")
    private String profile;
	@NotEmpty(message = "Gender cant be empty")
    private String gender;
	@NotEmpty(message = "Department cant be empty")
    private String department;
	@NotEmpty(message = "Salary cant be empty")
    private double salary;
	@NotEmpty(message = "Start date cant be empty")
    private String startDate;
    private String notes;
}
