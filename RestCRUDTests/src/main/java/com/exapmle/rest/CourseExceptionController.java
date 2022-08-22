package com.exapmle.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CourseExceptionController {

	@ExceptionHandler(value = CourseCRUDExceptions.class)
	public ResponseEntity<Object> exception(CourseCRUDExceptions exception) {
		return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	}
}
