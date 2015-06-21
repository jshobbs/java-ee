package com.jeffhobbsonline.dango.entity;

import java.util.Date;
import java.util.List;

/**
 * A movie news interface
 * @author jeff
 *
 */
public interface MovieNews {
	public int getMovieNewsID();
	public Movie getMovie();
	public void setMovie(Movie movie);
	public Date getNewsDate(int movieNewsID);
	public void setNewsDate(Date newsDate);
	public String getNewsTitle(int movieNewsID);
	public void setNewsTitle(String newsTitle);
	public String getNewsSource(int movieNewsID);
	public void setNewsSource(String newsSource);
//	public List<MovieNews> getNewsStoryByMovie(int movieNewsID);
	public List<MovieNews> getAllNewsStory();
//	public boolean setNewsStory(MovieNews newsStory);
}