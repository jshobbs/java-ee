package com.jeffhobbsonline.dango.repository;

import java.util.List;

import com.jeffhobbsonline.dango.entity.Movie;

public interface MovieRepository {

	public int addMovie(Movie movie);
	
	public Movie getMovie(int movieId);
	
	public List<Movie> getMovies();
	
	public List<Movie> getMovieByName(String movieName);
}