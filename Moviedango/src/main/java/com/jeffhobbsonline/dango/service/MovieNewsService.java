package com.jeffhobbsonline.dango.service;

import java.util.List;

import com.jeffhobbsonline.dango.entity.MovieNews;

public interface MovieNewsService {
	public long addMovieNewsForMovie(MovieNews newsStory);
	public List<MovieNews> getMovieNewsByMovie(String movieInNews);
	public List<MovieNews> getAllMovieNews();
}