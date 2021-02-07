package com.lunatech.security.authorization;

import java.util.Date;
import java.util.List;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lunatech.security.user.dao.UserInfo;

public class AuthorizationService {

	private static String jwtSecret;
	private static Long expireInterval;
	private static List<String> allowedSystems;

	/**
	 * 
	 * @param secrect jwt encryption / hashing key
	 * @param interval token interval time out
	 * @param allowedSystems  system that can connect to this system
	 */
	public static void configure(String secrect, Long interval, List<String> allowedSystems) {
		AuthorizationService.expireInterval = interval;
		AuthorizationService.jwtSecret = secrect;
		AuthorizationService.allowedSystems = allowedSystems;
	}

	private Date getTokenExpire() {
		Date now = new Date();
		now.setTime(now.getTime() + expireInterval);
		return now;
	}

	public String generateToken(UserInfo user, String sourceSystem) {
		String token = null;
		try {
			Algorithm algorithm = Algorithm.HMAC512(jwtSecret);
			token = JWT.create().withIssuer(issuer).withExpiresAt(getTokenExpire()).withClaim(id, user.getId())
					.withClaim(role, user.getRole()).withClaim(name, user.getName())
					.withClaim(sourceSystemKey, sourceSystem).withClaim(suspended, user.getSuspended()).sign(algorithm);
		} catch (JWTCreationException exception) {
			System.err.println("JWT  system generation errror");
		}

		return token;
	}

	private static String issuer = "authentication-service";
	private static String id = "id";
	private static String role = "role";
	private static String name = "name";
	private static String suspended = "suspended";
	private static String sourceSystemKey = "source system";

	public AuthorizationStatus getStatus(String token) {
		AuthorizationStatus status = new AuthorizationStatus();
		if (token == null) {
			status.setAuthorized(false);
			status.setExpired(false);
			return status;
		}
		try {
			Algorithm algorithm = Algorithm.HMAC512(jwtSecret);
			JWTVerifier verifier = JWT.require(algorithm).withIssuer(issuer).build(); // Reusable verifier instance
			DecodedJWT jwt = verifier.verify(token);
			
			
			String incomingSourceSystem= jwt.getClaim( sourceSystemKey).asString();
			if ( isAllowed(incomingSourceSystem) ) {
				status.setSourceSystemAllowed( true );			
				status.setAuthorized(true);
				status.setUserId(jwt.getClaim(id).asLong());
				status.setName(jwt.getClaim(name).asString());
				status.setRole(jwt.getClaim(role).asString());
				status.setSuspended(jwt.getClaim(suspended).asBoolean());				
			} else {
				status.setAuthorized(false);
				status.setSourceSystemAllowed(false);
			}
		} catch (TokenExpiredException exe) {
			status.setExpired(true);
			status.setAuthorized(false);
		} catch (JWTVerificationException exe) {
			status.setAuthorized(false);
		}
		return status;
	}
	
	public boolean isAllowed(String incomingSourceSystem) {
		if ( allowedSystems == null ) {
			return true;
		}  else {
			return allowedSystems.size() > 0 ? allowedSystems.contains( incomingSourceSystem ) :true;  
		}
	}
}
