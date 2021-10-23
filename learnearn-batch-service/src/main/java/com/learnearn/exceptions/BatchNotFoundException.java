package com.learnearn.exceptions;

/**
 * @author MohanapriyaV
 *
 */
public class BatchNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BatchNotFoundException() {
		super();
	}

	public BatchNotFoundException(String message) {
		super(message);
	}

}
