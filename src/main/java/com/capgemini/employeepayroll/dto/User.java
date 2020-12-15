package com.capgemini.employeepayroll.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.capgemini.employeepayroll.entity.Employee;

import lombok.Data;

@Data
public class User {
	
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
        
	    public User(){

	    }

	    public User(Employee employee){
	        this.id = employee.getId();
	        this.name = employee.getName();
	        this.profile = employee.getProfile();
	        this.gender = employee.getGender();
	        this.department = employee.getDepartment();
	        this.salary = employee.getSalary();
	        this.startDate = employee.getStartDate();
	        this.notes = employee.getNotes();
	    }

}
