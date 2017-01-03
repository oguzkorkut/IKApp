package com.okorkut.ik.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.okorkut.ik.dto.GenericValueDto;
import com.okorkut.ik.dto.PositionDto;
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

	// private static Logger logger =
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

	@GET
	@Path("/isLogged")
	// @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	// @Consumes({"application/xml","application/json"})
	public Response isLogged(@Context HttpServletRequest request) {
		logger.info("isLogged called");

		GenericValueDto dto = null;
		// request.getSession().removeAttribute("userDto");
		if (request.getSession().getAttribute("userDto") != null) {
			dto = new GenericValueDto(0, "", "", true);
		} else {
			dto = new GenericValueDto(0, "", "", false);
		}

		return Response.ok(dto).build();
	}

	@GET
	@Path("/getApplications")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ "application/xml", "application/json" })
	public Response getApplications(@Context HttpServletRequest request) {
		logger.info("getApplications called");

		GenericValueDto dto = null;
		request.getSession().removeAttribute("userDto");
		if (request.getSession().getAttribute("userDto") != null) {
			dto = new GenericValueDto(0, "", "", true);
		} else {
			logger.error("Yetkisiz kullanıcı istegi");
			dto = new GenericValueDto(0, "", "", false);
			return Response.status(Response.Status.UNAUTHORIZED).entity(dto).build();
		}

		return Response.ok(dto).build();
	}

	@GET
	@Path("/getPositions")
	// @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	// @Consumes({ "application/xml", "application/json" })
	public Response getPositions(@Context HttpServletRequest request) {
		logger.info("getPositions called");

		List<PositionDto> positionDtos;
		try {
			positionDtos = userService.getPositions();
		} catch (Exception e) {
			GenericValueDto dto = new GenericValueDto(0, "ERROR", "Pozisyonlarin cekilmesi sirasinda bir hata olustu. Hata:" + e, false);
			logger.error(e, e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(dto).build();
		}
		// GenericEntity<Lis> entity = new GenericEntity<AppConf>(appConf,
		// AppConf.class) {
		// };
		return Response.ok(positionDtos).build();
	}

	@POST
	@Path("/addPosition")
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPosition(@Context HttpServletRequest request, PositionDto positionDto) {
		logger.info("addPosition called");

		GenericValueDto valueDto = null;

		try {
			if (positionDto != null) {

				PositionDto dto = userService.addPosition(positionDto);

				return Response.ok(dto).build();
			} else {
				String error = "Pozisyon objesi null olamaz.";
				logger.info(error);
				valueDto = new GenericValueDto(0, "ERROR", error, false);
				throw new Exception(error);
			}

		} catch (Exception e) {
			String error = "Pozisyon ekleme islemi sirasinda bir hata olustu. Hata:" + e;
			logger.error(error);
			logger.fatal(error);

			valueDto = new GenericValueDto(0, "ERROR", error, false);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(valueDto).build();
		}

	}

	@PUT
	@Path("/updatePosition")
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePosition(@Context HttpServletRequest request, PositionDto positionDto) {
		logger.info("updatePosition called");

		GenericValueDto valueDto = null;

		try {
			if (positionDto != null) {

				boolean c = userService.updatePosition(positionDto);
				if (c) {
					valueDto = new GenericValueDto(0, "SUCCESS", "", true);
					return Response.ok(valueDto).build();
				}
				valueDto = new GenericValueDto(0, "ERROR", "Pozisyon guncellenemedi. Lutfen tekrar deneyin.", false);
				return Response.ok(valueDto).build();

			} else {
				String error = "Pozisyon objesi null olamaz.";
				logger.info(error);
				valueDto = new GenericValueDto(0, "ERROR", error, false);
				throw new Exception(error);
			}

		} catch (Exception e) {
			String error = "Pozisyon ekleme islemi sirasinda bir hata olustu. Hata:" + e;
			logger.error(error);
			logger.fatal(error);

			valueDto = new GenericValueDto(0, "ERROR", error, false);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(valueDto).build();
		}

	}

	@DELETE
	@Path("/deletePosition/{id}")
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePosition(@Context HttpServletRequest request, @PathParam("id") Integer id) {
		logger.info("updatePosition called");

		GenericValueDto valueDto = null;

		try {
			boolean c = userService.deletePosition(id);
			if (c) {
				valueDto = new GenericValueDto(0, "SUCCESS", "", true);
				return Response.ok(valueDto).build();
			}
			valueDto = new GenericValueDto(0, "ERROR", "Pozisyon silinemedi. Lutfen tekrar deneyin.", false);
			return Response.ok(valueDto).build();

		} catch (Exception e) {
			String error = "Pozisyon silme islemi sirasinda bir hata olustu. Hata:" + e;
			logger.error(error);
			logger.fatal(error);

			valueDto = new GenericValueDto(0, "ERROR", error, false);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(valueDto).build();
		}

	}

	@POST
	@Path("/applyPositionByPositionId/{positionId}")
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response applyPositionByPositionId(@Context HttpServletRequest request, @PathParam("positionId") Integer id) {
		logger.info("applyPositionByPositionId called . ID:" + id);

		GenericValueDto dto = null;

		try {

			if (request.getSession().getAttribute("userDto") != null) {

				UserDto userDto = (UserDto) request.getSession().getAttribute("userDto");

				userService.applyPositionByPositionId(userDto.getId(), id);
				dto = new GenericValueDto(0, "SUCCESS", "Başvuru alındı", true);

				return Response.ok(dto).build();
			} else {
				throw new Exception("UserDto bos oldugundan islem devam ettirilemeiyor.");
			}

		} catch (Exception e) {
			String error = "Pozisyona basvuru sirasinda bir hata olustu. Hata:" + e;
			logger.error(error);
			logger.fatal(error);

			dto = new GenericValueDto(0, "ERROR", error, false);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(dto).build();
		}

	}

	@GET
	@Path("/getPositionsByUserId")
	public Response getPositionsById(@Context HttpServletRequest request, @QueryParam("userId") Integer userId) {
		logger.info("getPositionsByUserId called. User Id:" + userId);

		List<PositionDto> positionDtos;
		try {
			positionDtos = userService.getPositionsByUserId(userId);
		} catch (Exception e) {
			GenericValueDto dto = new GenericValueDto(0, "ERROR", "Pozisyonlarin cekilmesi sirasinda bir hata olustu. Hata:" + e, false);
			logger.error(e, e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(dto).build();
		}
		return Response.ok(positionDtos).build();
	}

	@GET
	@Path("/getUserDetailById")
	public Response getUserDetailById(@Context HttpServletRequest request, @QueryParam("userId") Integer userId) {
		logger.info("getUserDetailById called. User Id:" + userId);

		UserDto userDto;
		try {
			userDto = userService.getUserProfileById(userId);
		} catch (Exception e) {
			GenericValueDto dto = new GenericValueDto(0, "ERROR", "Kullanici profilinin cekilmesi sirasinda bir hata olustu. Hata:" + e, false);
			logger.error(e, e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(dto).build();
		}
		return Response.ok(userDto).build();
	}

}
