package com.jeffhobbsonline.dango.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.jeffhobbsonline.dango.entity.Movie;
import com.jeffhobbsonline.dango.service.MovieListingService;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestMovieListingService extends AbstractJUnit4SpringContextTests   {	
	@Autowired
	private MovieListingService movieService;

	String movieName;
	
	@Test
	public void getMovie(){
		movieName  = movieService.getMovieName(1);
		Assert.assertEquals("Correct", "Frozen", movieName);
	}

	@Test
	public void getWrongMovie(){
		
		Assert.assertNotEquals("Incorrect", "Fast And Furious", movieService.getMovieName(5));
	}
	
	@Test
	public void getAllMovies(){
		List<Movie> allMovies = movieService.getAllMovies();
		Assert.assertNotNull("Not Null", allMovies);
	}
	
	@Test
	public void getAllMoviesSize(){
		List<Movie> allMovies = movieService.getAllMovies();
		Assert.assertEquals("Not Empty", 6, allMovies.size());
	}
	
	@Test
	public void getMovieByName(){
		List<Movie> searchedMovie = movieService.getMovieByName("Frozen");
		boolean isFound = false;
		if (searchedMovie.size() == 1){
			Movie foundMovie = searchedMovie.get(0);
			isFound = foundMovie.getMovieName().equals("Frozen");
		}
		
		Assert.assertTrue(isFound);
	}
}