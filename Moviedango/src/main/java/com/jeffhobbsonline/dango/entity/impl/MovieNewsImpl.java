package com.jeffhobbsonline.dango.entity.impl;

import com.jeffhobbsonline.dango.entity.MovieNews;
import com.jeffhobbsonline.dango.entity.Movie;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="movie_news")
public class MovieNewsImpl implements MovieNews {
	@Id
	@Column(name="idmovie_news")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int movieNewsID;
	
	@ManyToOne(targetEntity=MovieImpl.class)
	@JoinColumn(name="movie_idmovie")	
	private Movie movieInNews;
	
	@Column(name="movie_news_date")
	private Date movieNewsDate;
	
	@Column(name="movie_news_title")
	private String movieNewsTitle;
	
	@Column(name="movie_news_source")
	private String movieNewsSource;
	
	@Column(name="movie_news_story")
	private String movieNewsStory;
	
	@Override
	public int getMovieNewsID() {
		// TODO Auto-generated method stub
		return movieNewsID;
	}

	@Override
	public Movie getMovie() {
		return movieInNews;
	}
	
	@Override
	public void setMovie(Movie movie) {
		this.movieInNews = movie;
	}

	@Override
	public Date getNewsDate(int movieNewsID) {
		// TODO Auto-generated method stub
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		Date date = new Date();
//		String dateTime = dateFormat.format(date);
//		try {
//			movieNewsDate = dateFormat.parse(dateTime);
//		} catch (ParseException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return movieNewsDate;
	}
	
	@Override
	public void setNewsDate(Date newsDate) {
		// TODO Auto-generated method stub
		this.movieNewsDate = newsDate;
	}

	@Override
	public String getNewsTitle(int movieNewsID) {
		// TODO Auto-generated method stub
		return movieNewsTitle;
	}
	
	@Override
	public void setNewsTitle(String newsTitle) {
		// TODO Auto-generated method stub
		this.movieNewsTitle = newsTitle;
	}

	@Override
	public String getNewsSource(int movieNewsID) {
		// TODO Auto-generated method stub
		return movieNewsSource;
	}
	
	@Override
	public void setNewsSource(String newsSource) {
		// TODO Auto-generated method stub
		this.movieNewsSource = newsSource;
	}

//	@Override
//	public String getNewsStoryByMovie(int movieNewsID) {
		// TODO Auto-generated method stub
//		return movieNewsStory;
//	}
	
	@Override
	public List<MovieNews> getAllNewsStory() {
		// TODO Auto-generated method stub
		List<MovieNews> myList = new ArrayList<>();
		return myList;
	}
	
//	@Override
//	public boolean setNewsStory(MovieNews newsStory) {
		// TODO Auto-generated method stub
//		return this.movieNewsStory.add(newsStory);
//	}	
	
	@Override
	public String toString() {
		return "MovieNewsImpl [movieNewsID=" + movieNewsID + ", movie=" + movieInNews
				+ ", movieNewsDate=" + movieNewsDate + ", movieNewsTitle="
				+ movieNewsTitle + ", movieNewsSource=" + movieNewsSource
				+ ", movieNewsStory=" + movieNewsStory + "]";
	}
}