package com.sunyanxiong.service;

import java.util.List;

import com.sunyanxiong.entities.Newsinfo;
import com.sunyanxiong.entities.Pager;

public interface NewsinfoService {

	// 获取指定页码新闻
	public List getAllNewsinfoByPage(int page, int pageSize);

	// 获取所有新闻数量，用来初始化分页类Pager对象，并设置perPageRows 和 rowCount属性
	public Pager getPagerOfAllNewsinfo(int pageSize);

	// 根据主题编号，新闻标题等条件和指定页码获取新闻列表
	public List getNewsinfoByConditionAndPage(Newsinfo condition, int page, int pageSize);

	// 根据主题，新闻标题等条件获取新闻数量，用来初始化分页类Pager 对象，并设置 perPageRows 和 rowCount 属性
	public Pager getPagerOfNewsinfo(Newsinfo condition, int pageSize);

	// 根据新闻编号获取新闻信息
	public Newsinfo getNewsinfoById(int id);

	// 添加新闻
	public void addNews(Newsinfo newsinfo);

}
