package com.jeffhobbsonline.dango.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeffhobbsonline.dango.entity.MovieRanking;
import com.jeffhobbsonline.dango.repository.MovieRepository;
import com.jeffhobbsonline.dango.service.MovieRankingService;

@Service
@Transactional
public class MovieRankingServiceImpl implements MovieRankingService {
	@Autowired
	private MovieRepository ranking;

	List<MovieRanking> rankList = new ArrayList<MovieRanking>();
	
	@Override
	public List<MovieRanking> getTopTenMovies() {
		// TODO Auto-generated method stub
		//rankList.addAll(ranking.getTopTenRank());
		return rankList;
	}

	@Override
	public List<MovieRanking> addTopTenMovies(MovieRanking topTen) {
		return rankList;
	}
}
