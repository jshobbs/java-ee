package com.jeffhobbsonline.dango.entity;

import java.util.Date;

/**
 * A movie show time interface
 * @author jeff
 *
 */
public interface ShowTime {
	public int getShowTimeID();
	public Movie getMovie();
	public int getMovieID();
	public void setMovie(Movie movie);
	public Theater getTheater();
	public int getTheaterID();
	public void setTheater(Theater theater);
	public Date getShowTime(int showTimeID);
	public Date getShowTime();
	public void setShowTime(Date showTime);
}