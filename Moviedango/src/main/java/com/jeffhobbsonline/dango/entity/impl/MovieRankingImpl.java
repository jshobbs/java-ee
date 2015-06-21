package com.jeffhobbsonline.dango.entity.impl;

import com.jeffhobbsonline.dango.entity.Movie;
import com.jeffhobbsonline.dango.entity.MovieRanking;

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
@Table(name="movie_ranking")
public class MovieRankingImpl implements MovieRanking {
	@Id
	@Column(name="idmovie_ranking")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int movieRankingID;
	
	@ManyToOne(targetEntity=MovieImpl.class)
	@JoinColumn(name="movie_idmovie")	
	private Movie movieRanked;
	
	@Column(name="movie_rank")
	private int movieRank;
	
	@Column(name="movie_rank_week")
	private Date movieRankingWeek;
	
	@Column(name="total_gross_sales")
	private int totalGrossSales;
	
	@Override
	public int getMovieRankingID() {
		// TODO Auto-generated method stub
		return movieRankingID;
	}

	@Override
	public Movie getMovie() {
		return movieRanked;
	}
	
	@Override
	public void setMovie(Movie movie) {
		this.movieRanked = movie;
	}
	
	@Override
	public int getRank(int movieRankingID) {
		// TODO Auto-generated method stub
		return movieRank;
	}
	
	@Override
	public List<MovieRanking> getTopTenRank() {
		// TODO Auto-generated method stub
		List<MovieRanking> movieRank = new ArrayList<>();
		return movieRank;
	}

	@Override
	public Date getRankingWeek(int movieRankingID) {
		// TODO Auto-generated method stub
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		Date date = new Date();
//		return dateFormat.format(date);
		return movieRankingWeek;
	}

	@Override
	public int getTotalGrossSales(int movieRankingID) {
		// TODO Auto-generated method stub
		return totalGrossSales;
	}

	@Override
	public void setRank(int rank) {
		// TODO Auto-generated method stub
		this.movieRank = rank;
	}

	@Override
	public void setRankingWeek(Date rankingWeek) {
		// TODO Auto-generated method stub
		this.movieRankingWeek = rankingWeek;
	}

	@Override
	public void setTotalGrossSales(int totalGrossSales) {
		// TODO Auto-generated method stub
		this.totalGrossSales = totalGrossSales;
	}

	@Override
	public String toString() {
		return "MovieRankingImpl [movieRankingID=" + movieRankingID
				+ ", movie=" + movieRanked + ", movieRank=" + movieRank
				+ ", movieRankingWeek=" + movieRankingWeek
				+ ", totalGrossSales=" + totalGrossSales + "]";
	}
}