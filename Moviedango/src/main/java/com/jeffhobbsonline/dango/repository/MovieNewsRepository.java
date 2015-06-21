package com.jeffhobbsonline.dango.repository;

import java.util.List;

import com.jeffhobbsonline.dango.entity.MovieNews;

public interface MovieNewsRepository {

	public long addMovieNews(MovieNews news);
	
	public List<MovieNews> getMovieNews(String movieName);
	
	public List<MovieNews> getAllMovieNews();
}