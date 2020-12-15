package com.capgemini.employeepayroll.exception;

public class EmployeePayrollException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;

	public EmployeePayrollException(String message) {
		super(message);
		this.message = message;
	}
}
