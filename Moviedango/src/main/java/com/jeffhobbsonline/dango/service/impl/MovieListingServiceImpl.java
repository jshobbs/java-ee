package com.jeffhobbsonline.dango.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeffhobbsonline.dango.entity.Movie;
import com.jeffhobbsonline.dango.entity.ShowTime;
import com.jeffhobbsonline.dango.entity.Theater;
import com.jeffhobbsonline.dango.repository.MovieRepository;
import com.jeffhobbsonline.dango.repository.ShowTimeRepository;
import com.jeffhobbsonline.dango.repository.TheaterRepository;
import com.jeffhobbsonline.dango.service.MovieListingService;

@Service
@Transactional
public class MovieListingServiceImpl implements MovieListingService {
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private TheaterRepository theaterRepository;
	
	@Autowired
	private ShowTimeRepository showTimeRepository;
	
	@Override
	public Movie addMovie(Movie movie) {
		int id = movieRepository.addMovie(movie);
		
		return movieRepository.getMovie(id);
	}
	
	@Override
	public Movie getMovie(int movieID) {
		return movieRepository.getMovie(movieID);
	}
	
	@Override
	public String getMovieName(int movieID) {
		Movie movieItem = movieRepository.getMovie(movieID);
		System.out.println(movieItem);
		return movieItem.getMovieName();
	}

	@Override
	public List<ShowTime> getTheaterShowTimes(int theaterID, int movieID,
			String showTime) {
		return null;  // Should I even do this? Not required...
	}

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movies = movieRepository.getMovies();
		
		return movies;
	}

	@Override
	public List<Movie> getMovieByName(String movieName) {
		List<Movie> movies = movieRepository.getMovieByName(movieName);
		
		return movies;
	}

	@Override
	public List<Movie> getMovieByTheater(int theaterID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShowTime> getShowTimes() {
		List<ShowTime> showTimes = showTimeRepository.getShowTimes();
		
		return showTimes;
	}
	
	@Override
	public List<ShowTime> getShowTimes(int movieID, int theaterID) {
		List<ShowTime> showTimes = showTimeRepository.getShowTimes(movieID, theaterID);
		
		return showTimes;
	}
	
	@Override
	public Theater getTheater(int theaterID) {
		return theaterRepository.getTheater(theaterID);
	}
	
	@Override
	public Theater addTheater(Theater theater) {
		int id = theaterRepository.addTheater(theater);
		
		return theaterRepository.getTheater(id);
	}
	
	@Override
	public ShowTime addShowTime(ShowTime showTime) {
		int id = showTimeRepository.addShowTime(showTime);
		
		return showTimeRepository.getShowTime(id);
	}
	
	@Override
	public ShowTime getShowTime(int showTimeID) {
		return showTimeRepository.getShowTime(showTimeID);
	}

	@Override
	public List<Theater> getAllTheaters() {
		List<Theater> theaters = theaterRepository.getTheaters();
		
		return theaters;
	}

	@Override
	public List<Theater> getTheaterByName(String theaterName) {
		List<Theater> theaters = theaterRepository.getTheaterByName(theaterName);
		
		return theaters;
	}

	@Override
	public List<Theater> getTheaterByMovie(int movieID) {
		// TODO Auto-generated method stub
		return null;
	}
}