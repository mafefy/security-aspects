package com.lunatech.security.common.error;

public class ExistError extends AppError {

	/**
	 * 
	 */
	private static final long serialVersionUID = -881747152660481308L;

	public ExistError() {
		super(ErrorCode.exist.code , "Exist error");
	}

}
