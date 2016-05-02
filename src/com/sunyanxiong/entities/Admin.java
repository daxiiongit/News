package com.sunyanxiong.entities;

import java.io.Serializable;

// 管理员实体类
public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;

	public Admin() {
		super();
	}

	public Admin(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
