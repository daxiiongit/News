package com.sunyanxiong.service.impl;

import java.util.List;

import com.sunyanxiong.dao.NewsinfoDao;
import com.sunyanxiong.entities.Newsinfo;
import com.sunyanxiong.entities.Pager;
import com.sunyanxiong.service.NewsinfoService;

public class NewsinfoServiceImpl implements NewsinfoService {

	NewsinfoDao newsinfoDao;
	
	public void setNewsinfoDao(NewsinfoDao newsinfoDao) {
		this.newsinfoDao = newsinfoDao;
	}
	
	// 获取指定页码新闻列表
	@Override
	public List getAllNewsinfoByPage(int page, int pageSize) {
		return newsinfoDao.getAllNewsinfoByPage(page, pageSize);
	}

	// 获取获取所有新闻的数量，用于初始化分页类Pager对象，并设置perPageRows 和 rowCount 属性
	@Override
	public Pager getPagerOfAllNewsinfo(int pageSize) {
		
		int count = newsinfoDao.getCountOfAllNewsinfo();   // 获取所有新闻数量
		Pager pager = new Pager();
		pager.setPerPageRows(pageSize);    // 设置每页显示的记录数 
		pager.setRowCount(count);    // 设置总记录数
		
		return pager;   // 返回pager对象
	}

	// 根据主题编号，新闻标题等条件和指定页码获取新闻列表
	@Override
	public List getNewsinfoByConditionAndPage(Newsinfo condition, int page, int pageSize) {
		
		return newsinfoDao.getNewsinfoByConditionAndPage(condition, page, pageSize);
	}

	// 根据主题编号，新闻标题等条件获取新闻数量，用来初始化分页类对象，并设置perPageRows 和 rowCount 属性
	@Override
	public Pager getPagerOfNewsinfo(Newsinfo condition, int pageSize) {
		
		int count = newsinfoDao.getCountOfNewsinfo(condition);   // 根据情况来获取新闻 数量
		Pager pager = new Pager();
		pager.setPerPageRows(pageSize);
		pager.setRowCount(count);
		
		return pager;
	}

	// 根据新闻编号获取新闻信息
	@Override
	public Newsinfo getNewsinfoById(int id) {
		return newsinfoDao.getNewsinfoById(id);
	}

	// 添加新闻
	@Override
	public void addNews(Newsinfo newsinfo) {
		newsinfoDao.addNews(newsinfo);
	}

	// 删除新闻
	@Override
	public void deleteNews(int id) {
		Newsinfo newsinfo = newsinfoDao.getNewsinfoById(id);
		newsinfoDao.deleteNewsinfo(newsinfo);
	}

}
