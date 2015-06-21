package com.jeffhobbsonline.dango.http;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jeffhobbsonline.dango.entity.Theater;
import com.jeffhobbsonline.dango.entity.impl.TheaterImpl;
import com.jeffhobbsonline.dango.http.entity.HttpTheater;
import com.jeffhobbsonline.dango.service.MovieListingService;
import com.jeffhobbsonline.dango.service.exception.DangoException;

@Path("/theaters")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class TheaterResource {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MovieListingService movieService;
	
	@POST
	@Path("/")
	public Response createTheater(HttpTheater newTheater){
		Theater theaterToCreate = convert(newTheater);
		Theater addedTheater = movieService.addTheater(theaterToCreate);
		return Response.status(Status.CREATED).header("Location", "/theaters/"+addedTheater.getTheaterID()).entity(new HttpTheater(addedTheater)).build();
	}	

	@GET
	@Path("/{theaterId}")	
	public HttpTheater getTheaterById(@PathParam("theaterId") int theaterId){
		logger.info("getting theater by id:"+theaterId);
		Theater theater = movieService.getTheater(theaterId);
		return new HttpTheater(theater);
	}
	
	@GET
	@Path("/")
	@Wrapped(element="theaters")
	public List<HttpTheater> getTheaterSearch(@QueryParam("theaterName") String theaterName) throws DangoException{
		List<Theater> found = movieService.getTheaterByName(theaterName);
		List<HttpTheater> returnList = new ArrayList<>(found.size());
		for(Theater theater:found){
			returnList.add(new HttpTheater(theater));
		}
		return returnList;
	}
	
	/**
	 * Not pushing this into business layer. Could be a util as well
	 * @param newMovie
	 * @return movie
	 */
	private Theater convert(HttpTheater newTheater) {
		TheaterImpl theater = new TheaterImpl();
		theater.setTheaterName(newTheater.theaterName);
		theater.setTheaterAddress(newTheater.theaterAddress);
		theater.setTheaterPhone(newTheater.theaterPhone);
		theater.setNumberOfTheaters(newTheater.numberOfScreens);
		return theater;
	}	
}