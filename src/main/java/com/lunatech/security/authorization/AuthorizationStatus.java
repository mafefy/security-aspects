package com.lunatech.security.authorization;

import lombok.Data;

@Data
public class AuthorizationStatus {

	private Boolean authorized;
	private Boolean expired;
	private Long userId;
	private String role;
	private String name; 
	private Boolean suspended;
	private Boolean sourceSystemAllowed;

	public AuthorizationStatus() {
		userId = null;
		authorized = false;
		sourceSystemAllowed = false;
		expired = false;
		name = null;
		suspended = false;
	}

}
