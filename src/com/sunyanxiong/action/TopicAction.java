package com.sunyanxiong.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sunyanxiong.entities.Topic;
import com.sunyanxiong.service.TopicService;
import org.apache.struts2.interceptor.RequestAware;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/3 0003.
 */
public class TopicAction extends ActionSupport implements RequestAware{

    TopicService topicService;

    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }

    // 封装topic对象
    Topic topic;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    // 构建requestMap
    Map<String,Object> request;

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    public String addtopic(){
        topicService.addTopic(topic);
        return "admin";
    }

    // 编辑主题
    public String topiclist(){
        List topicList = topicService.getAllTopics();
        request.put("topicList",topicList);
        return "topic_list";
    }

    // 删除主题
    public String deletetopic(){
        topicService.deleteTopic(topic.getId());
        return "topiclist";
    }

}
