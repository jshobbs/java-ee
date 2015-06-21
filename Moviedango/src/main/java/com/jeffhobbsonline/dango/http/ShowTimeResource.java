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

import com.jeffhobbsonline.dango.entity.ShowTime;
import com.jeffhobbsonline.dango.entity.impl.ShowTimeImpl;
import com.jeffhobbsonline.dango.http.entity.HttpShowTime;
import com.jeffhobbsonline.dango.service.MovieListingService;
import com.jeffhobbsonline.dango.service.exception.DangoException;

@Path("/showtimes")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class ShowTimeResource {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MovieListingService movieService;
	
	@POST
	@Path("/")
	public Response createShowTime(HttpShowTime newShowTime){
		ShowTime showTimeToCreate = convert(newShowTime);
		ShowTime addedShowTime = movieService.addShowTime(showTimeToCreate);
		return Response.status(Status.CREATED).header("Location", "/showtimes/"+addedShowTime.getShowTimeID()).entity(new HttpShowTime(addedShowTime)).build();
	}	

	@GET
	@Path("/{showTimeId}")	
	public HttpShowTime getShowTimeById(@PathParam("showTimeId") int showTimeId){
		logger.info("getting showtime by id:"+showTimeId);
		ShowTime showTime = movieService.getShowTime(showTimeId);	
		return new HttpShowTime(showTime);
	}
	
	@GET
	@Path("/")
	@Wrapped(element="showtimes")
	public List<HttpShowTime> getReviewSearch(@QueryParam("movieId") int movieId, @QueryParam("theaterId") int theaterId) throws DangoException{
		List<ShowTime> found = movieService.getShowTimes(movieId, theaterId);
		List<HttpShowTime> returnList = new ArrayList<>(found.size());
		for(ShowTime showtime:found){
			returnList.add(new HttpShowTime(showtime));
		}
		return returnList;
	}
	
	/**
	 * Not pushing this into business layer. Could be a util as well
	 * @param newShowTime
	 * @return showtime
	 */
	private ShowTime convert(HttpShowTime newShowTime) {
		ShowTimeImpl showtime = new ShowTimeImpl();
		showtime.setShowTime(newShowTime.showTime);
		showtime.setTheater(newShowTime.theater);
		showtime.setMovie(newShowTime.movie);
		return showtime;
	}	
}