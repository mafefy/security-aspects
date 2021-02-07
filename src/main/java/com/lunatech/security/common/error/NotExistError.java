package com.lunatech.security.common.error;

public class NotExistError extends AppError {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6805846198999439846L;

	public NotExistError() {
		super(ErrorCode.notExist.code, "Not exist error");
	}

}
