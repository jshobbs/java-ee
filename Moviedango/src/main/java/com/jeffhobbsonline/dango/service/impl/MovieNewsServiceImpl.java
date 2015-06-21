package com.jeffhobbsonline.dango.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeffhobbsonline.dango.entity.MovieNews;
import com.jeffhobbsonline.dango.repository.MovieNewsRepository;
import com.jeffhobbsonline.dango.service.MovieNewsService;

@Service
@Transactional
public class MovieNewsServiceImpl implements MovieNewsService {
	
	@Autowired
	private MovieNewsRepository movieNewsRepository;

	@Override
	public long addMovieNewsForMovie(MovieNews newsStory) {
		return movieNewsRepository.addMovieNews(newsStory);
	}
	
	@Override
	public List<MovieNews> getMovieNewsByMovie(String movieName) {
		return movieNewsRepository.getMovieNews(movieName);
	}

	@Override
	public List<MovieNews> getAllMovieNews() {
		return movieNewsRepository.getAllMovieNews();
	}
}