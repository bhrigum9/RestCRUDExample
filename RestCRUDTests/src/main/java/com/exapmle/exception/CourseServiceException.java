package com.exapmle.exception;

import org.springframework.stereotype.Component;

/**
 * @author bhrigu
 *
 */
@Component
public class CourseServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CourseServiceException() {
		super();
	}

	public CourseServiceException(final String message) {
		super(message);
	}

}
