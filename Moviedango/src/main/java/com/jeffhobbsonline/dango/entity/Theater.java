package com.jeffhobbsonline.dango.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * A movie theater interface
 * @author jeff
 *
 */
public interface Theater {
	public int getTheaterID();
	public String getTheaterName(int theaterID);
	public String getTheaterName();
	public void setTheaterName(String theaterName);
	public String getTheaterAddress(int theaterID);
	public String getTheaterAddress();
	public void setTheaterAddress(String theaterAddress);
	public String getTheaterPhone(int theaterID);
	public String getTheaterPhone();
	public void setTheaterPhone(String theaterPhone);
	public int getNumberOfTheaters(int theaterID);
	public int getNumberOfTheaters();
	public void setNumberOfTheaters(int numberOfTheaters);
	public List<ShowTime> getShowTimes();
	public void addShowTime(ShowTime movieShowTimes);
}