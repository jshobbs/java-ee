package com.jeffhobbsonline.dango.service;

import java.util.List;

import com.jeffhobbsonline.dango.entity.Movie;
import com.jeffhobbsonline.dango.entity.ShowTime;
import com.jeffhobbsonline.dango.entity.Theater;

public interface MovieListingService {
	public Movie addMovie(Movie movie);
	public Movie getMovie(int movieID);
	public String getMovieName(int movieID);
	public List<ShowTime> getTheaterShowTimes(int theaterID, int movieID, String showTime);
	public List<Movie> getAllMovies();
	public List<Movie> getMovieByName(String movieName);
	public List<Movie> getMovieByTheater(int theaterID);
	public ShowTime addShowTime(ShowTime showTime);
	public ShowTime getShowTime(int showTimeID);
	public List<ShowTime> getShowTimes();
	public List<ShowTime> getShowTimes(int theaterID, int movieID);
	public Theater getTheater(int theaterID);
	public Theater addTheater(Theater theater);
	public List<Theater> getAllTheaters();
	public List<Theater> getTheaterByName(String theaterName);
	public List<Theater> getTheaterByMovie(int movieID);
}