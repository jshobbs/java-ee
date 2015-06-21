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

import com.jeffhobbsonline.dango.entity.Movie;
import com.jeffhobbsonline.dango.entity.impl.MovieImpl;
import com.jeffhobbsonline.dango.http.entity.HttpMovie;
import com.jeffhobbsonline.dango.service.MovieListingService;
import com.jeffhobbsonline.dango.service.exception.DangoException;

@Path("/movies")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class MovieResource {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MovieListingService movieService;
	
	@POST
	@Path("/")
	public Response createMovie(HttpMovie newMovie){
		Movie movieToCreate = convert(newMovie);
		Movie addedMovie = movieService.addMovie(movieToCreate);
		return Response.status(Status.CREATED).header("Location", "/movies/"+addedMovie.getMovieID()).entity(new HttpMovie(addedMovie)).build();
	}	

	@GET
	@Path("/{movieId}")	
	public HttpMovie getMovieById(@PathParam("movieId") int movieId){
		logger.info("getting movie by id:"+movieId);
		Movie movie = movieService.getMovie(movieId);	
		return new HttpMovie(movie);
	}
	
	@GET
	@Path("/")
	@Wrapped(element="movies")
	public List<HttpMovie> getMovieSearch(@QueryParam("movieName") String movieName, @QueryParam("studio") String studio) throws DangoException{
		List<Movie> found = movieService.getMovieByName(movieName);
		List<HttpMovie> returnList = new ArrayList<>(found.size());
		for(Movie movie:found){
			returnList.add(new HttpMovie(movie));
		}
		return returnList;
	}
	
	/**
	 * Not pushing this into business layer. Could be a util as well
	 * @param newMovie
	 * @return movie
	 */
	private Movie convert(HttpMovie newMovie) {
		MovieImpl movie = new MovieImpl();
		movie.setMovieName(newMovie.movieName);
		movie.setMoviePlayLength(newMovie.playLength);
		movie.setMovieDescription(newMovie.description);
		movie.setMovieStudio(newMovie.studio);
		movie.setMovieCategory(newMovie.category);
		return movie;
	}	
}