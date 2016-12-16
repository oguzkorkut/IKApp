package com.okorkut.ik.resource;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * This class is used for backend of Menu.js
 *
 */
@Path("/")
@Component
@XmlAccessorType(XmlAccessType.FIELD)
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class MenuResource {

	private static final Logger logger = Logger.getLogger(MenuResource.class);
	// private static final Logger logger =
	// LogManager.getLogger(MenuResource.class.getName());

	@GET
	@Path("/getstrs")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getStr(@Context final HttpServletRequest request) {

		logger.info("test");

		final List<String> strs = new ArrayList<String>();

		strs.add("dssd");
		strs.add("dssdfdd");
		strs.add("dssewgvdfd");
		strs.add("dsswd");

		logger.fatal("sds");

		return Response.ok(strs).build();
	}
}
