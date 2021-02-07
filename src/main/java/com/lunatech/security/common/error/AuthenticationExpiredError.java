package com.lunatech.security.common.error;

public class AuthenticationExpiredError extends AppError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5903827574238990123L;

	public AuthenticationExpiredError() {
		super(ErrorCode.authenticationExpired.code, "Authentication token expired error");
	}

}
