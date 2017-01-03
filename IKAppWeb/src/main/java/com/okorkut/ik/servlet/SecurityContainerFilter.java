//package com.okorkut.ik.servlet;
//
//import java.io.IOException;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerRequestFilter;
//import javax.ws.rs.core.Context;
//
//import org.apache.log4j.Logger;
//
//public class SecurityContainerFilter implements ContainerRequestFilter {
//
//	@Context
//	private HttpServletRequest httpRequest;
//	private static Logger logger = Logger.getLogger(SecurityContainerFilter.class);
//
//	// @Override
//	// public ContainerRequest filter(ContainerRequest request) {
//	//
//	// if (httpRequest != null) {
//	// YetkilikisiTDto user = null;
//	// user = (YetkilikisiTDto) (httpRequest.getSession().getAttribute("yetkilikisiTDto"));
//	// if (user != null) {
//	// // if (user != null && user.getUserRoles().size() > 0) {
//	// request.setSecurityContext(new SecurityContextImpl(user));
//	// }
//	// } else {
//	// logger.error("userRoles is not found.");
//	// }
//	// return request;
//	// }
//
//	public HttpServletRequest getHttpRequest() {
//		return httpRequest;
//	}
//
//	public void setHttpRequest(HttpServletRequest httpRequest) {
//		this.httpRequest = httpRequest;
//	}
//
//	@Override
//	public void filter(ContainerRequestContext arg0) throws IOException {
//		// TODO Auto-generated method stub
//
//	}
//
//}
