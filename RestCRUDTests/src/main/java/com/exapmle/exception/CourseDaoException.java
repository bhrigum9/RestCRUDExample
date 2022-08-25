package com.exapmle.exception;

import java.sql.SQLException;

/**
 * @author bhrigu
 *
 */
public class CourseDaoException extends SQLException {

	private static final long serialVersionUID = 1L;

	public CourseDaoException() {
		super();
	}

	public CourseDaoException(String message) {
		super(message);
	}
}
