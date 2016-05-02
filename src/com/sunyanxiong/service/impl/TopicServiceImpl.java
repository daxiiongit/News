package com.sunyanxiong.service.impl;

import java.util.List;

import com.sunyanxiong.dao.TopicDao;
import com.sunyanxiong.service.TopicService;

public class TopicServiceImpl implements TopicService{

	TopicDao topicDao;
	
	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}
	
	// 获取所有主题
	@Override
	public List getAllTopics() {
		return topicDao.getAllTopics();
	}

}
