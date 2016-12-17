package com.okorkut.ik.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.okorkut.ik.dto.GenericValueDto;
import com.okorkut.ik.dto.UserDto;
import com.okorkut.ik.service.UserService;

//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

//import org.apache.logging.log4j.Logger;

@Path("/")
// @Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
	private static final Logger logger = Logger.getLogger(UserResource.class);

	@Autowired
	private UserService userService;

	// private static final Logger logger =
	// LogManager.getLogger(MainResource.class.getName());

	// @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	// @Consumes({"application/xml","application/json"})

	// @Produces({ "application/xml", "application/json" })
	// @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	// @Consumes({ "application/xml", "application/json", "application/json",
	// "application/x-www-form-urlencoded" })
	@POST
	// @Path("/save")
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(@Context HttpServletRequest request, UserDto userDto) {
		logger.info("save called");

		GenericValueDto valueDto = null;

		try {
			if (userDto != null) {

				userService.save(userDto);

				valueDto = new GenericValueDto(0, "SUCCESS", "Kayıt başarılı bir şekilde alındı.", true);
			} else {
				String error = "Müşteri objesi null olduğundan işlem devam ettirilemiyor.";
				logger.info(error);
				valueDto = new GenericValueDto(0, "ERROR", error, false);
			}

		} catch (Exception e) {
			String error = "Müşteri kaydı sırasında bir hata oluştu. Hata:" + e;
			logger.error(error);
			logger.fatal(error);

			valueDto = new GenericValueDto(0, "ERROR", error, false);
		}

		// GenericEntity<AppConf> entity = new GenericEntity<AppConf>(appConf,
		// AppConf.class) {
		// };
		return Response.ok(valueDto).build();
	}
}
