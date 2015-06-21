package com.jeffhobbsonline.dango.repository;

import java.util.List;

import com.jeffhobbsonline.dango.entity.MovieReviews;

public interface MovieReviewRepository {
	public int addMovieReview(MovieReviews movieReview);
	public MovieReviews getMovieReview(int movieReviewID);
	public List<MovieReviews> getMovieReviews(String movieReview);
	public List<MovieReviews> getAllMovieReviews();
	public List<MovieReviews> getMovieReviewsByMovie(String movieReviewed);
}