package com.jeffhobbsonline.dango.http.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.jeffhobbsonline.dango.entity.impl.MovieImpl;
import com.jeffhobbsonline.dango.entity.MovieReviews;

/**
 * Select fields we want exposed to the REST layer. Separation from business/data layer. 
 * 
 * Note "XML" annotation. The resteasy-jettison implementation converts these to JSON depending on
 * the Accept media type
 * 
 * @author jeff
 *
 */
@XmlRootElement(name = "movie_review")
public class HttpMovieReview {

	@XmlElement
	public int id;
		
	@XmlElement
	public String movieReviewSource;
		
	@XmlElement
	public Date movieReviewDate;
		
	@XmlElement
	public String movieReview;
	
	@XmlElement
	public MovieImpl movie;	
	
	//required by framework
	protected HttpMovieReview() {}

	public HttpMovieReview(MovieReviews movieReviews) {
		this.id = movieReviews.getMovieReviewID();
		this.movieReviewSource = movieReviews.getMovieReviewSource();
		this.movieReviewDate = movieReviews.getMovieReviewDate();
		this.movieReview = movieReviews.getMovieReview();
		this.movie = (MovieImpl) movieReviews.getMovie();
	}
}