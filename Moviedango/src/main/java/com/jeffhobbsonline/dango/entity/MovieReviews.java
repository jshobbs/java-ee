package com.jeffhobbsonline.dango.entity;

import java.util.Date;
import java.util.List;

/**
 * A movie review interface
 * @author jeff
 *
 */
public interface MovieReviews {
	public int getMovieReviewID();
	public Movie getMovie();
	public void setMovie(Movie movieReviewed);
	public String getMovieReviewSource();
	public void setMovieReviewSource(String reviewSource);
	public Date getMovieReviewDate();
	public void setMovieReviewDate(Date reviewDate);
	public String getMovieReview(int movieID);
	public String getMovieReview();
	public List<MovieReviews> getAllMovieReviews();
	public void setMovieReview(String movieReview);
}