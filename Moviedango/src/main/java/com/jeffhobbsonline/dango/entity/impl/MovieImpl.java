package com.jeffhobbsonline.dango.entity.impl;

import java.util.ArrayList;
import java.util.List;

import com.jeffhobbsonline.dango.entity.Movie;
import com.jeffhobbsonline.dango.entity.MovieNews;
import com.jeffhobbsonline.dango.entity.MovieRanking;
import com.jeffhobbsonline.dango.entity.MovieReviews;
import com.jeffhobbsonline.dango.entity.ShowTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class MovieImpl implements Movie {
	@Id
	@Column(name="idmovie")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int movieID;
	
	@Column(name="movie_name")
	private String movieName;
	
	@Column(name="movie_play_length")
	private int moviePlayLength;
	
	@Column(name="movie_description")
	private String movieDescription;
	
	@Column(name="movie_studio")
	private String movieStudio;
	
	@Column(name="movie_category")
	private String movieCategory;
	
	@OneToMany(mappedBy = "showTimeMovie", targetEntity=ShowTimeImpl.class, cascade=CascadeType.ALL)	
    private List<ShowTime> moviesListed;
	
	@OneToMany(mappedBy = "movieInNews", targetEntity=MovieNewsImpl.class, cascade=CascadeType.ALL)	
    private List<MovieNews> moviesNews;
	
	@OneToMany(mappedBy = "movieRanked", targetEntity=MovieRankingImpl.class, cascade=CascadeType.ALL)	
    private List<MovieRanking> moviesRanked;
	
	@OneToMany(mappedBy = "movieReviewed", targetEntity=MovieReviewsImpl.class, cascade=CascadeType.ALL)	
    private List<MovieReviews> moviesReviewed;
	
	@Override
	public String getMovieName() {
		return movieName;
	}
	
	@Override
	public String getMovieName(int movieID) {
		return movieName;
	}
	
	@Override
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	@Override
	public int getMovieID() {
		return movieID;
	}
	
	@Override
	public int getMovieID(String movieName) {
		// TODO Auto-generated method stub
		return movieID;
	}

	@Override
	public int getMoviePlayLength() {
		return moviePlayLength;
	}
	
	@Override
	public int getMoviePlayLength(int movieID) {
		// TODO Auto-generated method stub
		return moviePlayLength;
	}
	
	@Override
	public void setMoviePlayLength(int moviePlayLength) {
		// TODO Auto-generated method stub
		this.moviePlayLength = moviePlayLength;
	}

	@Override
	public String getMovieDescription(int movieID) {
		// TODO Auto-generated method stub
		return movieDescription;
	}
	
	@Override
	public String getMovieDescription() {
		// TODO Auto-generated method stub
		return movieDescription;
	}
	
	@Override
	public void setMovieDescription(String movieDescription) {
		// TODO Auto-generated method stub
		this.movieDescription = movieDescription;
	}

	@Override
	public String getMovieStudio(int movieID) {
		// TODO Auto-generated method stub
		return movieStudio;
	}
	
	@Override
	public String getMovieStudio() {
		// TODO Auto-generated method stub
		return movieStudio;
	}
	
	@Override
	public void setMovieStudio(String movieStudio) {
		// TODO Auto-generated method stub
		this.movieStudio = movieStudio;
	}

	@Override
	public String getMovieCategory(int movieID) {
		// TODO Auto-generated method stub
		return movieCategory;
	}
	
	@Override
	public String getMovieCategory() {
		// TODO Auto-generated method stub
		return movieCategory;
	}

	@Override
	public void setMovieCategory(String movieCategory) {
		this.movieCategory = movieCategory;
	}
	
	@Override
	public List<ShowTime> getShowTimes() {
		// TODO Auto-generated method stub
		return moviesListed;
	}

	@Override
	public void addShowTime(ShowTime movieShowTimes) {
		// TODO Auto-generated method stub
		if(this.moviesListed == null) {
			this.moviesListed = new ArrayList<ShowTime>();
		}
		this.moviesListed.add(movieShowTimes);
	}
	
	@Override
	public List<MovieNews> getMovieNews() {
		// TODO Auto-generated method stub
		return this.moviesNews;
	}

	@Override
	public void addMovieNews(MovieNews movieNews) {
		// TODO Auto-generated method stub
		if(this.moviesNews == null) {
			this.moviesNews = new ArrayList<MovieNews>();
		}
		this.moviesNews.add(movieNews);
	}
	
	@Override
	public List<MovieRanking> getMovieRanking() {
		// TODO Auto-generated method stub
		return this.moviesRanked;
	}

	@Override
	public void addMovieRanking(MovieRanking movieRanking) {
		// TODO Auto-generated method stub
		if(this.moviesRanked == null) {
			this.moviesRanked = new ArrayList<MovieRanking>();
		}
		this.moviesRanked.add(movieRanking);
	}
	
	@Override
	public List<MovieReviews> getMovieReview() {
		return this.moviesReviewed;
	}

	@Override
	public void addMovieReview(MovieReviews movieReview) {
		if(this.moviesReviewed == null) {
			this.moviesReviewed = new ArrayList<MovieReviews>();
		}
		this.moviesReviewed.add(movieReview);
	}

	@Override
	public String toString() {
		return "MovieImpl [id=" + movieID + ", movieName=" + movieName + ", moviePlayLength=" + moviePlayLength
				+ ", movieDescription=" + movieDescription + ", movieStudio=" + movieStudio 
				+ ", movieCategory=" + movieCategory + "]";
	}
}