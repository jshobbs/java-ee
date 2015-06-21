package com.jeffhobbsonline.dango.repository;

import java.util.List;

import com.jeffhobbsonline.dango.entity.ShowTime;

public interface ShowTimeRepository {
	public int addShowTime(ShowTime showTime);
	public ShowTime getShowTime(int showTimeId);
	public List<ShowTime> getShowTimes();
	public List<ShowTime> getShowTimes(int movieId, int theaterId);
	public List<ShowTime> getMoviesByTheater(int theaterID);
}