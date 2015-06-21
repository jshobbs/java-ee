package com.jeffhobbsonline.dango.repository;

import java.util.List;

import com.jeffhobbsonline.dango.entity.Theater;

public interface TheaterRepository {

	int addTheater(Theater theater);
	
	Theater getTheater(int theaterId);
	
	public List<Theater> getTheaters();
	
	public List<Theater> getTheaterByName(String theaterName);
}