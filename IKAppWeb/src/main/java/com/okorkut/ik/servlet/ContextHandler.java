package com.okorkut.ik.servlet;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import com.okorkut.ik.common.utils.IKConstants;

public class ContextHandler implements ServletContextListener, HttpSessionListener {

	private static Logger logger = Logger.getLogger(ContextHandler.class);
	// private static final Logger logger =
	// LogManager.getLogger(ContextHandler.class.getName());

	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			logger.info("ContextHandler initiliaze...");
			logger.fatal("IK Web Applicaiton Acildi.");

			InetAddress ip = InetAddress.getLocalHost();
			IKConstants.serverIP = ip.getHostAddress();

		} catch (Exception e) {
			logger.error(e, e);
			logger.fatal("Unable to initialize IK. Error : " + e.getMessage());
		}
	}

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		String ipStr = "";
		try {
			InetAddress ip = InetAddress.getLocalHost();
			ipStr = ip.getHostAddress();
		} catch (UnknownHostException e) {
			logger.error(e);
		}
		logger.debug(event.getSession().getId() + " Session Created: IP:" + ipStr);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {

		try {
			// event.getSession().removeAttribute("userDto");
		} catch (Exception e) {
			logger.error(e, e);
		}

		logger.debug(event.getSession().getId() + " Session Destroyed. IP:" + IKConstants.serverIP);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		logger.fatal("IK Web Application Kapatildi.");
	}

}
