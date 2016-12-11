package com.okorkut.ik.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.okorkut.ik.common.utils.IKUtils;



/**
 * Servlet Filter implementation class test
 */
public class LogoutFilter implements Filter {

	private static Logger logger = Logger.getLogger(LogoutFilter.class);

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// logger.info("login.html Page requested...");

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		// httpServletResponse.sendRedirect("giris.jsp");

		logger.info("initialized LogoutFilter... IP :" + IKUtils.getClientIP(httpServletRequest));
		// pass the request along the filter chain
		chain.doFilter(httpServletRequest, httpServletResponse);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig Config) throws ServletException {
		logger.info("initialized LogoutFilter...");
	}


}
