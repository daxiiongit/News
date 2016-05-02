package com.sunyanxiong.service;

import java.util.List;

import com.sunyanxiong.entities.Admin;

public interface AdminService {

	// 此方法是用于 调用 AdminDao 的业务逻辑方法  
	public List login(Admin condition);
	
}
