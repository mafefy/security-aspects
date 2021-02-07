package com.lunatech.security.common.dao;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lunatech.security.authorization.AuthorizationStatus;
import com.lunatech.security.common.model.Request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode( callSuper = true)
public class AuthenticatedRequest extends Request{

	/*
	 * you can use headers too
	 */
	private String token;
	
	// will be injected by authentication aspect
	@JsonIgnore
	private AuthorizationStatus status;
}
