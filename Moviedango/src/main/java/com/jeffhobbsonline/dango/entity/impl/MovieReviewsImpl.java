package com.jeffhobbsonline.dango.entity.impl;

import com.jeffhobbsonline.dango.entity.Movie;
import com.jeffhobbsonline.dango.entity.MovieReviews;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="movie_review")
public class MovieReviewsImpl implements MovieReviews {
	@Id
	@Column(name="idmovie_review")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int movieReviewID;
	
	@ManyToOne(targetEntity=MovieImpl.class)
	@JoinColumn(name="movie_idmovie")	
	private Movie movieReviewed;
	
	@Column(name="movie_review_source")
	private String reviewSource;
	
	@Column(name="movie_review_date")
	private Date reviewDate;
	
	@Column(name="movie_review")
	private String movieReview;
	
	@Override
	public int getMovieReviewID() {
		// TODO Auto-generated method stub
		return movieReviewID;
	}
	
	@Override
	public Movie getMovie() {
		// TODO Auto-generated method stub
		return movieReviewed;
	}
	
	@Override
	public void setMovie(Movie movieReviewed) {
		// TODO Auto-generated method stub
		this.movieReviewed = movieReviewed;
	}

	@Override
	public String getMovieReviewSource() {
		// TODO Auto-generated method stub
		return reviewSource;
	}
	
	@Override
	public void setMovieReviewSource(String movieReviewSource) {
		// TODO Auto-generated method stub
		this.reviewSource = movieReviewSource;
	}

	@Override
	public Date getMovieReviewDate() {
		// TODO Auto-generated method stub
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//Date date = new Date();
		//return dateFormat.format(date);
		return reviewDate;
	}

	@Override
	public void setMovieReviewDate(Date reviewDate) {
		// TODO Auto-generated method stub
		this.reviewDate = reviewDate;
	}
	
	@Override
	public String getMovieReview(int movieID) {
		// TODO Auto-generated method stub
		return movieReview;
	}
	
	@Override
	public String getMovieReview() {
		// TODO Auto-generated method stub
		return movieReview;
	}
	
	@Override
	public List<MovieReviews> getAllMovieReviews() {
		List<MovieReviews> reviewList = new ArrayList<>();
		return reviewList;
	}
	
	@Override
	public void setMovieReview(String movieReview) {
		// TODO Auto-generated method stub
		this.movieReview = movieReview;
	}

	@Override
	public String toString() {
		return "MovieReviewsImpl [movieReviewID=" + movieReviewID
				+ ", movieReviewed=" + movieReviewed + ", reviewSource="
				+ reviewSource + ", reviewDate=" + reviewDate
				+ ", movieReview=" + movieReview + "]";
	}
}