package com.jeffhobbsonline.dango.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.jeffhobbsonline.dango.entity.Movie;
import com.jeffhobbsonline.dango.entity.impl.MovieImpl;
import com.jeffhobbsonline.dango.repository.MovieRepository;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public int addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return (int) this.sessionFactory.getCurrentSession().save(movie);
	}

	@Override
	public Movie getMovie(int movieId) {
		// TODO Auto-generated method stub
		return (Movie) this.sessionFactory.getCurrentSession().get(MovieImpl.class, movieId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> getMovies() {
		// TODO Auto-generated method stub
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(MovieImpl.class);		
		List<Movie> movieList = crit.list();
		
		return movieList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> getMovieByName(String movieName) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(MovieImpl.class);
		if(!StringUtils.isEmpty(movieName)){
			crit.add(Restrictions.like("movieName", "%"+movieName+"%"));
		}
				//.add(Restrictions.eq("owner.id", userId));		
		List<Movie> movieList = crit.list();
		
		return movieList;
	}
}