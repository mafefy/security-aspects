package com.lunatech.security.common.error;

public class SuspendedError extends AppError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1687891817535735006L;

	public SuspendedError() {
		super(ErrorCode.suspended.code, "Suspended Error");
	}

}
