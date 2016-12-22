package com.okorkut.ik.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.okorkut.ik.common.utils.IKUtils;
import com.okorkut.ik.dto.GenericValueDto;
import com.okorkut.ik.dto.UserDto;
import com.okorkut.ik.service.UserService;

/**
 * /j_security_check : invitation with this url
 */
@Configurable(dependencyCheck = true)
public class UserLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(UserLoginServlet.class);

	@Autowired
	private UserService userService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("LoginServlet doPost started...");

		String userIp = IKUtils.getClientIP(request);
		logger.debug("User Login  IP = " + userIp);

		UserDto userDto = null;

		String userEmail = request.getParameter("j_username");
		String userPasswod = request.getParameter("j_password");

		if (request.getSession().getAttribute("userDto") == null) {

			if (!StringUtils.isBlank(userEmail) && !StringUtils.isBlank(userPasswod)) {

				userEmail = URLDecoder.decode(userEmail);
				userPasswod = URLDecoder.decode(userPasswod);
				GenericValueDto genericValueDto = null;
				try {

					userDto = userService.getUserByEmailAndPassword(userEmail, userPasswod);

					if (userDto != null) {
						request.getSession().setAttribute("userDto", userDto);
						genericValueDto = new GenericValueDto(0, "", "", true);
					} else {
						genericValueDto = new GenericValueDto(0, "HataliKullaniciAdiVeyaSifres", "Kullanici adi veya şifre hatali!", false);
					}

				} catch (Exception e) {
					logger.error(e, e);
					logger.fatal("Login sirasinda hata olustu :" + e.getMessage());

				}
				if (genericValueDto.getChecked()) {
					logger.info("Redirection Page index.jsp...");
					String userKey = (String) request.getSession().getAttribute("userEposta");
					logger.info("User j_security_check :" + userKey);
					String url = "j_security_check?j_username=" + userKey + "&j_password=" + URLEncoder.encode(userPasswod);
					String redirectUrl = response.encodeRedirectURL(url);
					// response.sendRedirect(redirectUrl);

					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					PrintWriter pout = response.getWriter();
					JSONObject json = new JSONObject();
					try {
						json.put("isSuccess", true);
						pout.print(json.toString());
					} catch (JSONException e) {
						logger.error(e, e);
						e.printStackTrace();
					} finally {
						pout.close();
					}

				} else {

					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					PrintWriter pout = response.getWriter();
					JSONObject json = new JSONObject();
					try {
						json.put("isSuccess", false);
						json.put("errorCode", genericValueDto.getCode());
						json.put("errorMessage", genericValueDto.getValue());
						pout.print(json.toString());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						logger.error(e, e);
						e.printStackTrace();
					} finally {
						pout.close();
					}
				}
			} else {
				logger.info("Kullanici adi veya sifre bos");

				response.setContentType("application/json");
				response.setCharacterEncoding("utf-8");
				PrintWriter pout = response.getWriter();
				JSONObject json = new JSONObject();
				try {
					json.put("isSuccess", false);
					json.put("errorCode", "HataliKullaniciAdiVeyaSifres");
					json.put("errorMessage", "Kullanici adi veya şifre boş");
					pout.print(json.toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					logger.error(e, e);
					e.printStackTrace();
				} finally {
					pout.close();
				}
			}

			logger.info("LoginServlet doPost end...");
		} else {
			logger.info("Kullanici adi veya sifre bos. Redirection Page index.jsp...");

			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			PrintWriter pout = response.getWriter();
			JSONObject json = new JSONObject();
			try {
				json.put("isSuccess", false);
				json.put("errorCode", "HataliKullaniciAdiVeyaSifres");
				json.put("errorMessage", "Kullanici adi veya şifre boş");
				pout.print(json.toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				logger.error(e, e);
				e.printStackTrace();
			} finally {
				pout.close();
			}
		}
	}
}
