package com.jeffhobbsonline.dango.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import com.jeffhobbsonline.dango.entity.MovieReviews;
import com.jeffhobbsonline.dango.repository.MovieReviewRepository;
import com.jeffhobbsonline.dango.service.MovieReviewService;


@Service
@Transactional
public class MovieReviewServiceImpl implements MovieReviewService {
	@Autowired
	private MovieReviewRepository movieReviewRepository;
	
	List<MovieReviews> reviewList = new ArrayList<MovieReviews>();

	@Override
	public MovieReviews addMovieReview(MovieReviews movieReview) {
		int id = movieReviewRepository.addMovieReview(movieReview);
		
		return movieReviewRepository.getMovieReview(id);
	}
	
	@Override
	public MovieReviews getMovieReview(int movieReviewID) {
		// TODO Auto-generated method stub
		return movieReviewRepository.getMovieReview(movieReviewID);
	}

	@Override
	public List<MovieReviews> getMovieReviews() {
		// TODO Auto-generated method stub
		List<MovieReviews> reviewList = movieReviewRepository.getAllMovieReviews();
		return reviewList;
	}
	
	@Override
	public List<MovieReviews> getMovieReviews(String movieName) {
		// TODO Auto-generated method stub
		List<MovieReviews> reviewList = movieReviewRepository.getMovieReviewsByMovie(movieName);
		return reviewList;
	}
}