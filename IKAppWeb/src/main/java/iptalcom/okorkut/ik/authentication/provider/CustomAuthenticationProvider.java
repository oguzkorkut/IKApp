package iptalcom.okorkut.ik.authentication.provider;
//package com.okorkut.ik.authentication.provider;
//
//import java.util.Collection;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.stereotype.Component;
//
//import com.okorkut.ik.dto.UserDto;
//import com.okorkut.ik.service.UserService;
//@Component
//public class CustomAuthenticationProvider implements AuthenticationProvider{
//
//	private static final Logger logger = Logger.getLogger(CustomAuthenticationProvider.class);
//	
//	@Autowired
//	private UserService userService;
//	
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		  String email = authentication.getName();
//	      String password = (String) authentication.getCredentials();
//	 
//	        UserDto user = null;
//	        Collection<? extends GrantedAuthority> authorities = null;
//			try {
//				user = userService.getUserByEmailAndPassword(email, password);
//				
//				 if (user == null) {
//					 logger.debug("Kullanıcı adı veya Şifre Hatalı.");
//			            throw new BadCredentialsException("Kullanıcı adı veya Şifre Hatalı.");
//			      }
//			 
////			        if (!password.equals(user.getPassword())) {
////			            throw new BadCredentialsException("Wrong password.");
////			        }
//			 
//			     authorities = user.getRoles();
//			} catch (Exception e) {
//				logger.error(e,e);
//				throw new BadCredentialsException("Kullanıcı adı veya Şifre Hatalı.");
//			}
//	 
//	       
//	 
//	        return new UsernamePasswordAuthenticationToken(user, password, authorities);
//	}
//
//	public boolean supports(Class<?> arg0) {
//		return true;
//	}
//
//}
