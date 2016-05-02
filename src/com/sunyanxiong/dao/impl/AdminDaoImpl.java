package com.sunyanxiong.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.sunyanxiong.dao.AdminDao;
import com.sunyanxiong.entities.Admin;

public class AdminDaoImpl implements AdminDao {

	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List search(Admin condition) {
		List list = null;
		Session session = sessionFactory.getCurrentSession();
		
		// 创建Criteria对象
		Criteria c = session.createCriteria(Admin.class);
		
		// 使用Example 工具类创建实类对象,构造查询条件
		Example example = Example.create(condition);
		
		// 为Criteria 对象指定查询对象
		c.add(example);
		
		// 执行查询条件，并获取结果
		list = c.list();
		
		// 返回结果
		return list;
	}

}
