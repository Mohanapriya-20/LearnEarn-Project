package com.learnearn.exceptions;

/**
 * @author MohanapriyaV
 *
 */
public class CourseNotFoundException extends RuntimeException {

	public CourseNotFoundException() {
		super();
	}

	public CourseNotFoundException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;

}
