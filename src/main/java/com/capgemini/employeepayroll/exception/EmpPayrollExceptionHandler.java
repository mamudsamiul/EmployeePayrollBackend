package com.capgemini.employeepayroll.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.employeepayroll.dto.ResponseDTO;

@ControllerAdvice
public class EmpPayrollExceptionHandler {
	
	private static final String message = "Exception while processing REST Request";

	@ExceptionHandler(EmployeePayrollException.class)
	public final ResponseEntity<ResponseDTO> employeeNotFoundException(EmployeePayrollException e) {
		ResponseDTO status = new ResponseDTO(message, e.getMessage());
		return new ResponseEntity<ResponseDTO>(status, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleValidationExceptions(MethodArgumentNotValidException exception){
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errMsg = errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());
		ResponseDTO response = new ResponseDTO(message,errMsg);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ResponseDTO> anonymousException(Exception e) {
		ResponseDTO status = new ResponseDTO(message, e.getMessage());
		return new ResponseEntity<ResponseDTO>(status, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception){
		ResponseDTO respDTO = new ResponseDTO(message, "Should have date in format dd MM yyyy");
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.BAD_REQUEST);
	}

}
