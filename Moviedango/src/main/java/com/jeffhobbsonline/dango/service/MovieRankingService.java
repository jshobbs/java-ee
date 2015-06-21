package com.jeffhobbsonline.dango.service;

import java.util.List;

import com.jeffhobbsonline.dango.entity.MovieRanking;

public interface MovieRankingService {
	List<MovieRanking> getTopTenMovies();
	List<MovieRanking> addTopTenMovies(MovieRanking topTen);
}
