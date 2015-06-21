package com.jeffhobbsonline.dango.entity;

import java.util.List;

/**
 * A movie interface
 * @author jeff
 *
 */
public interface Movie {
	public int getMovieID();
	public int getMovieID(String movieName);
	public String getMovieName();
	public String getMovieName(int movieID);
	public void setMovieName(String movieName);
	public int getMoviePlayLength();
	public int getMoviePlayLength(int movieID);
	public void setMoviePlayLength(int playLength);
	public String getMovieDescription(int movieID);
	public String getMovieDescription();
	public void setMovieDescription(String movieDescription);
	public String getMovieStudio(int movieID);
	public String getMovieStudio();
	public void setMovieStudio(String movieStudio);
	public String getMovieCategory(int movieID);
	public String getMovieCategory();
	public void setMovieCategory(String movieCategory);
	
	public List<ShowTime> getShowTimes();
	public void addShowTime(ShowTime movieShowTimes);
	public List<MovieNews> getMovieNews();
	public void addMovieNews(MovieNews movieNews);
	public List<MovieRanking> getMovieRanking();
	public void addMovieRanking(MovieRanking movieRanking);
	public List<MovieReviews> getMovieReview();
	public void addMovieReview(MovieReviews movieReview);
}