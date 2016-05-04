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

	// 添加主题
	@Override
	public void addTopic(Topic topic) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(topic);
	}

	// 通过编号获取主题
	@Override
	public Topic getTopicById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Topic topic = (Topic) session.get(Topic.class,id);

		return topic;
	}

	// 删除主题（同时将该主题下面的所有新闻删除）
	@Override
	public void deleteTopic(Topic topic) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(topic);
	}

}
