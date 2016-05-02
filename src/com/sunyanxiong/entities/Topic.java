package com.sunyanxiong.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

// 主题实体类(-)
public class Topic implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;

	public Topic() {
		super();
	}

	public Topic(Integer id, String name, Set newsinfos) {
		super();
		this.id = id;
		this.name = name;
		this.newsinfos = newsinfos;
	}

	// 主题里面的新闻信息
	private Set newsinfos = new HashSet(0);

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set getNewsinfos() {
		return newsinfos;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNewsinfos(Set newsinfos) {
		this.newsinfos = newsinfos;
	}

}
