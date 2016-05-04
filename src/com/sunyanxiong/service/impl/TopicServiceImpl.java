package com.sunyanxiong.service.impl;

import java.util.List;

import com.sunyanxiong.dao.TopicDao;
import com.sunyanxiong.entities.Topic;
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

	// 添加主题
	@Override
	public void addTopic(Topic topic) {
		topicDao.addTopic(topic);
	}

	// 通过编号获取主题
	@Override
	public Topic getTopicById(int id) {
		return topicDao.getTopicById(id);
	}


	// 删除主题
	@Override
	public void deleteTopic(int id) {
		Topic topic = topicDao.getTopicById(id);
		topicDao.deleteTopic(topic);

	}

}
