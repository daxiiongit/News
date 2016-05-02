package com.sunyanxiong.service.impl;

import java.util.List;

import com.sunyanxiong.dao.AdminDao;
import com.sunyanxiong.entities.Admin;
import com.sunyanxiong.service.AdminService;

public class AdminServiceImpl implements AdminService {

//	private AdminDao adminDao;
	AdminDao adminDao;
	
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	@Override
	public List login(Admin condition) {
		return adminDao.search(condition);
	}

}
