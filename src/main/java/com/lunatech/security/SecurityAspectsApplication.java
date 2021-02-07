package com.lunatech.security;

/*
import java.util.Arrays;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.lunatech.security.authorization.AuthorizationService;
import com.lunatech.security.authorization.AuthorizationStatus;
import com.lunatech.security.authorization.UserRole;
import com.lunatech.security.user.dao.UserInfo;

@SpringBootApplication
@EnableScheduling
public class SecurityAspectsApplication {

	public static void main(String[] args) {
		AuthorizationService service = new AuthorizationService();
		AuthorizationService.configure("fancy man is happy",200000000L, Arrays.asList("a", "happy 2"));
		
		//mock login process
		UserInfo info = new UserInfo();
		info.setId(34L);
		info.setName("ahmed user");
		info.setRole( UserRole.ROOT.role);
		info.setSuspended(false);
		
		String token= service.generateToken(info, "happy" );
		//AuthorizationService.configure("fancy man is happy",200000000L,  Arrays.asList("hello", "eshta", "happy system "));
		AuthorizationStatus status=	service.getStatus(token);
		System.out.println(status);
		//SpringApplication.run(SecurityAspectsApplication.class, args);
	}

}
*/



public class SecurityAspectsApplication {

}


