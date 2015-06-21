package com.jeffhobbsonline.dango.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.jeffhobbsonline.dango.entity.Movie;
import com.jeffhobbsonline.dango.entity.ShowTime;
import com.jeffhobbsonline.dango.entity.impl.MovieImpl;
import com.jeffhobbsonline.dango.entity.impl.ShowTimeImpl;
import com.jeffhobbsonline.dango.repository.ShowTimeRepository;

@Repository
public class ShowTimeRepositoryImpl implements ShowTimeRepository {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public int addShowTime(ShowTime showTime) {
		return (int) this.sessionFactory.getCurrentSession().save(showTime);
	}

	@Override
	public ShowTime getShowTime(int showTimeId) {
		return (ShowTime) this.sessionFactory.getCurrentSession().get(ShowTimeImpl.class, showTimeId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ShowTime> getShowTimes() {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(ShowTimeImpl.class);		
		List<ShowTime> showTimeList = crit.list();
		
		return showTimeList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ShowTime> getShowTimes(int movieId, int theaterId) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(ShowTimeImpl.class);		
		
		if(movieId != 0){
			crit.add(Restrictions.eq("showTimeMovie.movieID", movieId));
		}
		
		if(theaterId != 0){
			crit.add(Restrictions.eq("theater.theaterID", theaterId));
		}
		
				//.add(Restrictions.eq("showTimeMovie.movieID", movieId));			
		
		List<ShowTime> showTimeList = crit.list();
		
		return showTimeList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ShowTime> getMoviesByTheater(int theaterID) {
		
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(ShowTime.class)
				.add(Restrictions.eq("theater.theaterID", theaterID));

		List<ShowTime> movieList = crit.list();
		
		return movieList;
	}
}