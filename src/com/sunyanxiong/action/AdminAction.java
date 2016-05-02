package com.sunyanxiong.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sunyanxiong.entities.Admin;
import com.sunyanxiong.service.AdminService;

public class AdminAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	// 定义用于保存表单的两个属性
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// 声明sessionMap,这是使用是想SessionAware的方式
	Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> session) {

		this.session = session;
		
	}
	
	// 声明 AdminService
	AdminService adminService;
	
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	// 处理登录请求
	public String validateLogin(){
		
		Admin condition = new Admin();
		condition.setUsername(username);
		condition.setPassword(password);
		List list = adminService.login(condition);
		
		if(list.size() > 0){
			// 将管理员对象存入session中
			session.put("admin", list.get(0));
		}
		
	//	System.out.println("username:" + list.get(0));
		
		return "index";
	}

}
