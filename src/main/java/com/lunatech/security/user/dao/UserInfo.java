package com.lunatech.security.user.dao;


import lombok.Data;

@Data
public class UserInfo{

	private Long id;
	private String name;
	private Boolean suspended;
	private String role;
}
