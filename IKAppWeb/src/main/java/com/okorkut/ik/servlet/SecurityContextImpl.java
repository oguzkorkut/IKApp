//package com.okorkut.ik.servlet;
//
//import java.security.Principal;
//
//import javax.ws.rs.core.SecurityContext;
//
//import org.apache.log4j.Logger;
//
//import com.okorkut.ik.dto.UserDto;
//
//public class SecurityContextImpl implements SecurityContext {
//	private static Logger logger = Logger.getLogger(SecurityContextImpl.class);
//	private final UserDto user;
//
//	public SecurityContextImpl(UserDto user) {
//		this.user = user;
//	}
//
//	@Override
//	public boolean isUserInRole(String role) {
//		logger.info("User Role Control started...");
//		boolean allow = user.getRoleDtos().contains(role);
//		logger.info("User Role Control end...");
//		return allow;
//	}
//
//	@Override
//	public String getAuthenticationScheme() {
//		return SecurityContext.BASIC_AUTH;
//	}
//
//	@Override
//	public Principal getUserPrincipal() {
//		return (Principal) user;
//	}
//
//	@Override
//	public boolean isSecure() {
//		return false;
//	}
//
//}
