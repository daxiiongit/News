package com.sunyanxiong.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunyanxiong.dao.TopicDao;
import com.sunyanxiong.entities.Topic;

public class TopicDaoImpl implements TopicDao {

	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List getAllTopics() {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Topic.class);
		
		return c.list();
	}

}
