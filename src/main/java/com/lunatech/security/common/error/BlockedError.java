package com.lunatech.security.common.error;

public class BlockedError extends AppError {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7174545663145022632L;

	public BlockedError() {
		super(ErrorCode.blocked.code, "Blocked Error");
	}

}
