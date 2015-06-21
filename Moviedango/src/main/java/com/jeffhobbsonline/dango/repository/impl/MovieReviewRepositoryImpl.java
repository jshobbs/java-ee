package com.jeffhobbsonline.dango.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.jeffhobbsonline.dango.entity.MovieReviews;
import com.jeffhobbsonline.dango.entity.impl.MovieReviewsImpl;
import com.jeffhobbsonline.dango.repository.MovieReviewRepository;

@Repository
public class MovieReviewRepositoryImpl implements MovieReviewRepository {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public int addMovieReview(MovieReviews movieReview) {
		// TODO Auto-generated method stub
		return (int) this.sessionFactory.getCurrentSession().save(movieReview);
	}
	
	@Override
	public MovieReviews getMovieReview(int movieReviewID) {
		// TODO Auto-generated method stub
		return (MovieReviews) this.sessionFactory.getCurrentSession().get(MovieReviewsImpl.class, movieReviewID);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MovieReviews> getMovieReviews(String movieReview) {
		// TODO Auto-generated method stub
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(MovieReviewsImpl.class);
		if(!StringUtils.isEmpty(movieReview)){
			crit.add(Restrictions.like("movieReview", "%"+movieReview+"%"));
		}
				
		List<MovieReviews> movieReviewList = crit.list();
		
		return movieReviewList;		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MovieReviews> getMovieReviewsByMovie(String movieReviewed) {
		// TODO Auto-generated method stub
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(MovieReviewsImpl.class);
		if(!StringUtils.isEmpty(movieReviewed)){
			crit.add(Restrictions.like("movieReviewed", "%"+movieReviewed+"%"));
		}
				
		List<MovieReviews> movieReviewList = crit.list();
		
		return movieReviewList;		
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MovieReviews> getAllMovieReviews() {
		// TODO Auto-generated method stub
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(MovieReviewsImpl.class);		
		List<MovieReviews> movieReviewList = crit.list();
		
		return movieReviewList;
	}
}