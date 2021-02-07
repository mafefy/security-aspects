package com.lunatech.security.common.error;

public class FailureError extends AppError {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6668921380010574237L;

	public FailureError() {
		super(ErrorCode.failure.code, "Failure Error");
	}
	
	public FailureError(String details) {
		super(ErrorCode.failure.code, "Failure Error", details);
	}

}
