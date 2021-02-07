package com.lunatech.security.common.error;

import com.lunatech.security.blocking.Violations;

public class FullError extends AppError {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3908757001691977467L;

	public FullError() {
		super(ErrorCode.full.code, "Full Error", Violations.FULL);
	}

}
