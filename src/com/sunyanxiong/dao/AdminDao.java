package com.sunyanxiong.dao;

import java.util.List;

import com.sunyanxiong.entities.Admin;

public interface AdminDao {

	// 查询管理员
	public List search(Admin condition);	
}
