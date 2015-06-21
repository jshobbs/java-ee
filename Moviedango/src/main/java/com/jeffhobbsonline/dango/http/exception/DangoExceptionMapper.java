package com.jeffhobbsonline.dango.http.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ExceptionMapper;

import org.springframework.stereotype.Component;

import com.jeffhobbsonline.dango.service.exception.DangoException;

/**
 * Return HTTP 409 with response body 
 * 
 * @author jeff
 *
 */
@Provider
@Component
public class DangoExceptionMapper implements ExceptionMapper<DangoException>{

	@Override
	public Response toResponse(DangoException ex) {
		return Response.status(Status.CONFLICT).entity(new HttpError(ex)).build();
	}
}