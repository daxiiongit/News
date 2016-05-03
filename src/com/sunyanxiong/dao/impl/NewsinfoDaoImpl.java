package com.sunyanxiong.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.sunyanxiong.dao.NewsinfoDao;
import com.sunyanxiong.entities.Newsinfo;

public class NewsinfoDaoImpl implements NewsinfoDao {

    // 获取sessionFactory
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	// 根据指定页面获取新闻列表
	@Override
	public List getAllNewsinfoByPage(int page, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Newsinfo.class);
		
		c.setFirstResult(pageSize * (page - 1));
		c.setMaxResults(pageSize);
		c.addOrder(Order.desc("createtime"));
		
		return c.list();
	}

	// 获取所用新闻数量
	@Override
	public Integer getCountOfAllNewsinfo() {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Newsinfo.class);
		return c.list().size();
	}

	// 根据主题编号，新闻标题等条件和指定页码获取新闻列表
	@Override
	public List getNewsinfoByConditionAndPage(Newsinfo condition, int page, int pageSize) {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Newsinfo.class);
		
		// 判断条件对象不为空
		if(condition != null){
			// 主题不为空
			if((condition.getTopic() != null) && (condition.getTopic().getId() != null)){
				c.add(Restrictions.eq("topic.id", condition.getTopic().getId()));
			}
			// 标题不为空
			if((condition.getTitle() != null) && !("".equals(condition.getTitle()))){
				c.add(Restrictions.like("title", condition.getTitle(),MatchMode.ANYWHERE));
			}
		}
		c.setFirstResult(pageSize*(page - 1));
		c.setMaxResults(pageSize);
		c.addOrder(Order.desc("createtime"));
		
		return c.list();
	}

	// 根据主题，新闻标题等条件获取所属新闻的数量
	@Override
	public Integer getCountOfNewsinfo(Newsinfo condition) {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Newsinfo.class);
		
		if(condition != null){     // 查询条件不为空
			// 主题不为空,condition.getTopic().getId()!= null,在Topic类中定义id必须为Integer类型
			if((condition.getTopic()!= null) && (condition.getTopic().getId()!= null)){
				c.add(Restrictions.eq("topic.id", condition.getTopic().getId()));
			}
			// 标题不为空
			if((condition.getTitle() != null) && !("".equals(condition.getTitle()))){
				c.add(Restrictions.like("title", condition.getTitle(),MatchMode.ANYWHERE));
			}
		}
		
		return c.list().size();
	}

	// 根据新闻编号获取新闻信息
	@Override
	public Newsinfo getNewsinfoById(int id) {
		Session session  = sessionFactory.getCurrentSession();
		Newsinfo newsinfo = (Newsinfo)session.get(Newsinfo.class, id);
		return newsinfo;
	}

	// 添加新闻
	@Override
	public void addNews(Newsinfo newsinfo) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(newsinfo);
	}

	// 删除新闻
	@Override
	public void deleteNewsinfo(Newsinfo newsinfo) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(newsinfo);
	}

}
