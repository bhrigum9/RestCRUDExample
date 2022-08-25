package com.exapmle.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.exapmle.model.ErrorMessage;

/**
 * @author bhrigu
 *
 */
@ControllerAdvice
public class CourseExceptionControlAdvice {

	@ExceptionHandler(CourseServiceException.class)
	public ResponseEntity<ErrorMessage> courseExceptionEntity(CourseServiceException courseServiceException,
			WebRequest request) {
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(),
				courseServiceException.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(CourseDaoException.class)
	public ResponseEntity<ErrorMessage> courseExceptionEntity(CourseDaoException courseDaoException,
			WebRequest request) {
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(),
				courseDaoException.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> globalExceptionEntity(Exception exception, WebRequest request) {
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(),
				exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
