package com.okorkut.ik.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.okorkut.ik.common.utils.AppConf;


//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MainResource {
	private static final Logger logger = Logger.getLogger(MainResource.class);
//	private static final Logger logger = LogManager.getLogger(MainResource.class.getName());

	public MainResource() {
	}

	@GET
	@Path("/version")
//	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	@Consumes({"application/xml","application/json"})
	public Response getThresholdList() {
		
		logger.info("version called");
		
		AppConf appConf = new AppConf();
		
		logger.info(appConf.toString());

//		GenericEntity<AppConf> entity = new GenericEntity<AppConf>(appConf, AppConf.class) {
//		};
		return Response.ok(appConf).build();
	}
}
