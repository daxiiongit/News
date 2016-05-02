package com.sunyanxiong.entities;

import java.io.Serializable;
import java.util.Date;

// 新闻信息实体类
public class Newsinfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String title;
	private String author;
	private Date createtime;
	private String content;
	private String summary;

	public Newsinfo() {
		super();
	}

	public Newsinfo(int id, String title, String author, Date createtime, String content, String summary, Topic topic) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.createtime = createtime;
		this.content = content;
		this.summary = summary;
		this.topic = topic;
	}

	// 双向向多对一
	private Topic topic;

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public String getContent() {
		return content;
	}

	public String getSummary() {
		return summary;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
