package com.jeffhobbsonline.dango.entity.impl;

import java.util.ArrayList;
import java.util.List;

import com.jeffhobbsonline.dango.entity.ShowTime;
import com.jeffhobbsonline.dango.entity.Theater;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="theater")
public class TheaterImpl implements Theater {
	@Id
	@Column(name="idtheater")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int theaterID;
	
	@Column(name="theater_name")
	private String theaterName;
	
	@Column(name="theater_address")
	private String theaterAddress;
	
	@Column(name="theater_phone")
	private String theaterPhone;
	
	@Column(name="number_of_screens")
	private int numberOfTheaters;

	@OneToMany(mappedBy = "showTimeMovie", targetEntity=ShowTimeImpl.class, cascade=CascadeType.ALL)	
    private List<ShowTime> moviesListed;
	
	@Override
	public int getTheaterID() {
		// TODO Auto-generated method stub
		return theaterID;
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
	public String getTheaterName(int theaterID) {
		// TODO Auto-generated method stub
		return theaterName;
	}
	
	@Override
	public String getTheaterName() {
		return theaterName;
	}

	@Override
	public String getTheaterAddress(int theaterID) {
		// TODO Auto-generated method stub
		return theaterAddress;
	}
	
	@Override
	public String getTheaterAddress() {
		// TODO Auto-generated method stub
		return theaterAddress;
	}

	@Override
	public String getTheaterPhone(int theaterID) {
		// TODO Auto-generated method stub
		return theaterPhone;
	}
	
	@Override
	public String getTheaterPhone() {
		// TODO Auto-generated method stub
		return theaterPhone;
	}

	@Override
	public int getNumberOfTheaters(int theaterID) {
		// TODO Auto-generated method stub
		return numberOfTheaters;
	}
	
	@Override
	public int getNumberOfTheaters() {
		// TODO Auto-generated method stub
		return numberOfTheaters;
	}

	@Override
	public void setTheaterName(String theaterName) {
		// TODO Auto-generated method stub
		this.theaterName = theaterName;
	}

	@Override
	public void setTheaterAddress(String theaterAddress) {
		// TODO Auto-generated method stub
		this.theaterAddress = theaterAddress;
	}

	@Override
	public void setTheaterPhone(String theaterPhone) {
		// TODO Auto-generated method stub
		this.theaterPhone = theaterPhone;
	}

	@Override
	public void setNumberOfTheaters(int numberOfTheaters) {
		// TODO Auto-generated method stub
		this.numberOfTheaters = numberOfTheaters;
	}
	
	@Override
	public String toString() {
		return "TheaterImpl [theaterID=" + theaterID + ", theaterName="
				+ theaterName + ", theaterAddress=" + theaterAddress
				+ ", theaterPhone=" + theaterPhone + ", numberOfTheaters="
				+ numberOfTheaters + "]";
	}
}