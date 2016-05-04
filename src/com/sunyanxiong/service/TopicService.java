package com.sunyanxiong.service;

import com.sunyanxiong.entities.Topic;

import java.util.List;

public interface TopicService {

	// 获取所有主题
	public List getAllTopics();

	// 添加主题
	public void addTopic(Topic topic);

	// 通过编号获取主题
	public Topic getTopicById(int id);

	// 删除主题（通过主题编号）
	public void deleteTopic(int id);
	
}
