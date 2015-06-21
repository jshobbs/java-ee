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

import com.jeffhobbsonline.dango.entity.MovieReviews;
import com.jeffhobbsonline.dango.entity.impl.MovieReviewsImpl;
import com.jeffhobbsonline.dango.http.entity.HttpMovieReview;
import com.jeffhobbsonline.dango.service.MovieReviewService;
import com.jeffhobbsonline.dango.service.exception.DangoException;

@Path("/reviews")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class MovieReviewResource {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MovieReviewService movieReviewService;
	
	@POST
	@Path("/")
	public Response createMovieReview(HttpMovieReview newMovieReview){
		MovieReviews movieReviewToCreate = convert(newMovieReview);
		MovieReviews addedMovieReview = movieReviewService.addMovieReview(movieReviewToCreate);
		return Response.status(Status.CREATED).header("Location", "/movie_review/"+addedMovieReview.getMovieReviewID()).entity(new HttpMovieReview(addedMovieReview)).build();
	}	

	@GET
	@Path("/{movieReviewId}")	
	public HttpMovieReview getMovieReviewById(@PathParam("movieReviewId") int movieReviewId){
		logger.info("getting movie review by id:"+movieReviewId);
		MovieReviews movieReview = movieReviewService.getMovieReview(movieReviewId);
		return new HttpMovieReview(movieReview);
	}
	
	@GET
	@Path("/")
	@Wrapped(element="reviews")
	public List<HttpMovieReview> getMovieReviewSearch(@QueryParam("movieReviewed") String movieReviewed) throws DangoException{
		List<MovieReviews> found = movieReviewService.getMovieReviews(movieReviewed);
		List<HttpMovieReview> returnList = new ArrayList<>(found.size());
		for(MovieReviews review:found){
			returnList.add(new HttpMovieReview(review));
		}
		return returnList;
	}
	
	/**
	 * Not pushing this into business layer. Could be a util as well
	 * @param newMovie
	 * @return movie_review
	 */
	private MovieReviews convert(HttpMovieReview newMovieReview) {
		MovieReviewsImpl movieReview = new MovieReviewsImpl();
		movieReview.setMovieReviewSource(newMovieReview.movieReviewSource);
		movieReview.setMovieReviewDate(newMovieReview.movieReviewDate);
		movieReview.setMovieReview(newMovieReview.movieReview);
		movieReview.setMovie(newMovieReview.movie);
		return movieReview;
	}	
}