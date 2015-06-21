package com.jeffhobbsonline.dango.entity.impl;

import com.jeffhobbsonline.dango.entity.Movie;
import com.jeffhobbsonline.dango.entity.ShowTime;
import com.jeffhobbsonline.dango.entity.Theater;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="show_time")
public class ShowTimeImpl implements ShowTime {
	@Id
	@Column(name="idshow_time")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int showTimeID;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity=MovieImpl.class)
	@JoinColumn(name="movie_idmovie")	
	private Movie showTimeMovie;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity=TheaterImpl.class)
	@JoinColumn(name="theater_idtheater")	
	private Theater theater;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="show_time")
	private Date showTime;

	@Override
	public int getShowTimeID() {
		// TODO Auto-generated method stub
		return showTimeID;
	}

	@Override
	public Movie getMovie() {
		return showTimeMovie;
	}
	
	@Override
	public void setMovie(Movie movie) {
		this.showTimeMovie = movie;
	}
	
	@Override
	public int getMovieID() {
		return showTimeMovie.getMovieID();
	}
	
	@Override
	public Theater getTheater() {
		return theater;
	}
	
	@Override
	public int getTheaterID() {
		return theater.getTheaterID();
	}
	
	@Override
	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	
	@Override
	public Date getShowTime(int showTimeID) {
		// TODO Auto-generated method stub
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		Date date = new Date();
//		return dateFormat.format(date);
		return showTime;
	}
	
	@Override
	public Date getShowTime() {
		return showTime;
	}

	@Override
	public void setShowTime(Date showTime) {
		// TODO Auto-generated method stub
		this.showTime = showTime;
	}

	@Override
	public String toString() {
		return "ShowTimeImpl [showTimeID=" + showTimeID + ", showTimeMovie="
				+ showTimeMovie + ", theater=" + theater + ", showTime="
				+ showTime + "]";
	}
}