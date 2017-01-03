package com.okorkut.ik.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.okorkut.ik.common.utils.IKUtils;


/**
 * Servlet implementation class LogoutServlet
 */
public class UserLogoutServlet extends HttpServlet {
	private static Logger logger = Logger.getLogger(UserLogoutServlet.class);

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLogoutServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			logger.info("LogoutServlet doPost started...");
			String userIp = IKUtils.getClientIP(request);
			logger.debug("User Logout IP = " + userIp);
			request.getSession().removeAttribute("userDto");
			request.getSession().invalidate();

			response.addHeader("Pragma", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
			response.addHeader("Cache-Control", "no-store");
			response.addHeader("Cache-Control", "must-revalidate");
			response.addHeader("Expires", "Mon, 8 Aug 2000 10:00:00 GMT");

			response.sendRedirect("login");
		} catch (Exception e) {
			logger.error(e, e);
		}

	}


}
