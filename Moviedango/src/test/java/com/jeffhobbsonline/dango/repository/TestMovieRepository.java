package com.jeffhobbsonline.dango.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.jeffhobbsonline.dango.entity.Movie;
import com.jeffhobbsonline.dango.entity.impl.MovieImpl;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestMovieRepository extends AbstractTransactionalJUnit4SpringContextTests{

	@Autowired
	private MovieRepository movieRepository;
	
	@Test
	//@Rollback(false)
	public void addAndGetMovie(){
		MovieImpl newMovie = new MovieImpl();
		newMovie.setMovieName("Hunger Games");
		newMovie.setMoviePlayLength(112);
		newMovie.setMovieDescription("Futuristic conflict with Catniss");
		newMovie.setMovieStudio("Lions Gate");
		newMovie.setMovieCategory("Action");
		
		int addedMovieId = movieRepository.addMovie(newMovie);
		System.out.println("movie added id " + addedMovieId);
		Assert.assertNotEquals(0, addedMovieId);		
		
		Movie found = movieRepository.getMovie(addedMovieId);
		Assert.assertEquals(found.getMovieID(), addedMovieId);
		Assert.assertEquals(found.getMovieName(), newMovie.getMovieName());
		Assert.assertEquals(found.getMoviePlayLength(), newMovie.getMoviePlayLength());
	}	
}