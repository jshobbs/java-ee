package com.jeffhobbsonline.dango.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jeffhobbsonline.dango.entity.MovieNews;
import com.jeffhobbsonline.dango.entity.impl.MovieNewsImpl;
import com.jeffhobbsonline.dango.repository.MovieNewsRepository;

@Repository
public class MovieNewsRepositoryImpl implements MovieNewsRepository {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public long addMovieNews(MovieNews news) {
		return (long) this.sessionFactory.getCurrentSession().save(news);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MovieNews> getMovieNews(String movieName) {
		
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(MovieNewsImpl.class)
				.add(Restrictions.eq("movieInNews.movieName", movieName));		
		List<MovieNews> newsList = crit.list();
		
		return newsList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MovieNews> getAllMovieNews() {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(MovieNewsImpl.class);		
		List<MovieNews> newsList = crit.list();
		
		return newsList;
	}
}