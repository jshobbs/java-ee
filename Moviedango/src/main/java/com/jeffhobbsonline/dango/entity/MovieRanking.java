package com.jeffhobbsonline.dango.entity;

import java.util.Date;
import java.util.List;

/**
 * A movie ranking interface
 * @author jeff
 *
 */
public interface MovieRanking {
	public Movie getMovie();
	public void setMovie(Movie movie);
	public int getMovieRankingID();
	public int getRank(int movie);
	public List<MovieRanking> getTopTenRank();
	public void setRank(int rank);
	public Date getRankingWeek(int movieRankingID);
	public void setRankingWeek(Date rankingWeek);
	public int getTotalGrossSales(int movieRankingID);
	public void setTotalGrossSales(int totalGrossSales);
}