package com.lunatech.security.common.error;

public class BusyError extends AppError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1998893481172626496L;

	public BusyError() {
		super(ErrorCode.busy.code, "Busy error");
	}
	
	public BusyError(String details) {
		super(ErrorCode.busy.code, details);
	}

}
