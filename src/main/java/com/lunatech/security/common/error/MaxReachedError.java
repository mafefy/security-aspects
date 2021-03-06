package com.lunatech.security.common.error;

import com.lunatech.security.blocking.Violations;

public class MaxReachedError extends AppError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5583568522773373082L;

	public MaxReachedError() {
		super(ErrorCode.maxReached.code, "Reached maximum limit error", Violations.MAX_REACHED);
	}
	
	public MaxReachedError(String details) {
		super(ErrorCode.maxReached.code, "Reached maximum limit error", details,Violations.MAX_REACHED);
	}

}
