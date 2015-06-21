package com.jeffhobbsonline.dango.service;

import java.util.List;

import com.jeffhobbsonline.dango.entity.MovieReviews;

public interface MovieReviewService {
	public MovieReviews getMovieReview(int movieReviewID);
	public List<MovieReviews> getMovieReviews();
	public MovieReviews addMovieReview(MovieReviews movieReview);
	public List<MovieReviews> getMovieReviews(String movieName);
}