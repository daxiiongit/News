package com.sunyanxiong.dao;

import com.sunyanxiong.entities.Topic;

import java.util.List;

public interface TopicDao {

	// 获取所用主题
	public List getAllTopics();

	//  添加主题
	public void addTopic(Topic topic);

	// 通过编号获取主题
	public Topic getTopicById(int id);

	// 删除主题(同时会将主题下面的所有新闻信息也删除)
	public void deleteTopic(Topic topic);
	
}
