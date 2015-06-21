package com.jeffhobbsonline.dango.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.jeffhobbsonline.dango.entity.Theater;
import com.jeffhobbsonline.dango.entity.impl.TheaterImpl;
import com.jeffhobbsonline.dango.repository.TheaterRepository;

@Repository
public class TheaterRepositoryImpl implements TheaterRepository {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public int addTheater(Theater theater) {
		// TODO Auto-generated method stub
		return (int) this.sessionFactory.getCurrentSession().save(theater);
	}

	@Override
	public Theater getTheater(int theaterId) {
		// TODO Auto-generated method stub
		return (Theater) this.sessionFactory.getCurrentSession().get(TheaterImpl.class, theaterId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Theater> getTheaters() {
		// TODO Auto-generated method stub
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TheaterImpl.class);		
		List<Theater> theaterList = crit.list();
		
		return theaterList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Theater> getTheaterByName(String theaterName) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TheaterImpl.class);
		if(!StringUtils.isEmpty(theaterName)){
			crit.add(Restrictions.like("theaterName", "%"+theaterName+"%"));
		}
				//.add(Restrictions.eq("owner.id", userId));		
		List<Theater> theaterList = crit.list();
		
		return theaterList;
	}
}