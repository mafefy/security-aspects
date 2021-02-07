package com.lunatech.security.common.error;

public class NotCompleteError extends AppError {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8489331145665659798L;

	public NotCompleteError() {
		super(ErrorCode.notComplete.code, "Not complete Error");
	}

}
