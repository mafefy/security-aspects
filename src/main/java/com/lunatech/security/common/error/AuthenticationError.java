package com.lunatech.security.common.error;

import com.lunatech.security.blocking.Violations;

public class AuthenticationError extends AppError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1600350634369726239L;

	public AuthenticationError() {
		super(ErrorCode.authenticationError.code, "Authenticationt error", Violations.LOGIN);
	}

}
