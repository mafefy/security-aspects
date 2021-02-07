package com.lunatech.security.common.error;

public class ValidationError extends AppError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7601336876788596775L;


	public ValidationError() {
		super(ErrorCode.validation.code, "Validation error");
	}


	public ValidationError(String details) {
		super(ErrorCode.validation.code, "Validation error", details);
	}
}
