package com.sunyanxiong.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sunyanxiong.entities.Admin;
import com.sunyanxiong.entities.Newsinfo;
import com.sunyanxiong.entities.Pager;
import com.sunyanxiong.entities.Topic;
import com.sunyanxiong.service.NewsinfoService;
import com.sunyanxiong.service.TopicService;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class NewsinfoAction extends ActionSupport implements RequestAware, SessionAware {

	private static final long serialVersionUID = 1L;
	
	/* 
	 * 	封装 newsinfo 表单对象
	 */
	Newsinfo newsinfo;
	
	public Newsinfo getNewsinfo() {
		return newsinfo;
	}
	
	public void setNewsinfo(Newsinfo newsinfo) {
		this.newsinfo = newsinfo;
	}

	// 主题业务接口
	TopicService topicService;
	
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}
	
	// 新闻业务逻辑接口
	NewsinfoService newsinfoService;
	
	public void setNewsinfoService(NewsinfoService newsinfoService) {
		this.newsinfoService = newsinfoService;
	}
	
	// 分页实体类
	private Pager pager;
	
	public Pager getPager() {
		return pager;
	}
	
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
	// 创建sessionMap 对象
	Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	
	// 创建requestMap对象。
	Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	/*
	 * 	根据条件和页码获取新闻列表，在转到新闻浏览首页:index.jsp
	 */
	
	public String index() throws Exception{
		
		int curPage = 1;
		if(pager != null){    // 判断分页对象是否为空
			curPage = pager.getCurPage();
		}
		
		List newsinfoList = null;
		if(newsinfo == null){
			// 如果没有指定查询条件，获取指定页码的新闻列表(每页10页)
			newsinfoList = newsinfoService.getAllNewsinfoByPage(curPage, 10);
			// 获取所有新闻总数，用来初始化分页类Pager对象
			pager = newsinfoService.getPagerOfAllNewsinfo(10);
		}else{
			// 如果指定查询条件,根据条件获取指定页码的新闻列表
			newsinfoList = newsinfoService.getNewsinfoByConditionAndPage(newsinfo, curPage, 10);
			// 在根据条件获取所属新闻总数，用来初始化分页类Pager对象
			pager = newsinfoService.getPagerOfNewsinfo(newsinfo, 10);
		}
		
		// 设置Pager 对象中的待显示页码
		pager.setCurPage(curPage);
		// 将待显示的当前页新闻列表存入request 范围
		request.put("newsinfoList", newsinfoList);
		// 获取所有主题
		List topicList = topicService.getAllTopics();
		// 将主题列表存入request 范围
		request.put("topicList", topicList);
		
		// 转到新闻浏览首页index.jsp
		return "index";
	}
	
	// 从国内新闻和国际中心中各去取5条记录，在转到index_sidebar.jsp页面
	public String indexsidebar(){
		// 获取5条国内新闻
		Newsinfo condition = new Newsinfo();
		Topic topic = new Topic();
		topic.setId(1);
		condition.setTopic(topic);
		List domesticNewsList = newsinfoService.getNewsinfoByConditionAndPage(condition, 1, 5);
		
		// 获取5条国际新闻
		topic.setId(2);
		condition.setTopic(topic);
		List internationalNewsList = newsinfoService.getNewsinfoByConditionAndPage(condition, 1, 5);
		
		// 将获取的数据存储到request中
		request.put("domesticNewsList", domesticNewsList);
		request.put("internationalNewsList", internationalNewsList);
		
		return "index_sidebar";
	}
	
	// 封装表单传递的新闻标号
	int id;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	// 浏览新闻内容
	public String newsread(){
		// 根据新闻编号获取新闻
		Newsinfo newsinfo = newsinfoService.getNewsinfoById(id);
		// 将新闻存入request范围
		request.put("newsinfo", newsinfo);
		// 获取5条国内新闻
		Newsinfo condition = new Newsinfo();
		Topic topic = new Topic();
		topic.setId(1);
		condition.setTopic(topic);
		List domesticNewsList = newsinfoService.getNewsinfoByConditionAndPage(condition, 1, 5);
		
		// 获取5条国际新闻
		topic.setId(2);
		condition.setTopic(topic);
		List internationalNewsList = newsinfoService.getNewsinfoByConditionAndPage(condition, 1, 5);
		
		// 将新闻保存到request 中
		request.put("domesticNewsList", domesticNewsList);
		request.put("internationalNewsList", internationalNewsList);
		
		// 获取所有主题，并存入request中
		List topicList = topicService.getAllTopics();
		request.put("topicList", topicList);
		
		// 转到新闻浏览页
		return "news_read";
	}
	
	// 获取指定页新闻列表，再转到新闻管理首页
	public String admin(){
		List newsinfoList = null;
		int curPage = 1;
		if(pager != null){
			curPage = pager.getCurPage();
		}
		
		if(newsinfo == null){
			// 没有指定查询条件，获取指定页码新闻列表
			newsinfoList = newsinfoService.getAllNewsinfoByPage(curPage, 10);
			// 再获取所有新闻总数，用来初始化Pager分页类
			pager = newsinfoService.getPagerOfAllNewsinfo(10);
		}else{
			// 指定查询条件，根据查询条件来获取新闻列表
			newsinfoList = newsinfoService.getNewsinfoByConditionAndPage(newsinfo, curPage, 10);
			// 根据条件获取所属新闻总数，初始化Pager 分页类
			pager = newsinfoService.getPagerOfNewsinfo(newsinfo, 10);
		}
		
		// 设置Pager 对象中待显示页页码
		pager.setCurPage(curPage);
		// 将待显示的当前页新闻列表存入request对象
		request.put("newsinfoList", newsinfoList);
		// 获取所有主题
		List topicList = topicService.getAllTopics();
		// 将主题存入request中
		request.put("topicList", topicList);
		
		return "admin";
	}
	
	// 获取主题列表，再转到新闻添加页面
	public String toNewsAdd(){
		List topicList = topicService.getAllTopics();
		request.put("topicList", topicList);
		
		//System.out.println("topicList:" +topicList.get(0));
		
		return "news_add";
	}
	
	// 执行新闻添加
	public String doNewsAdd(){
		// 从session 中获取管理员对象
		Admin admin = (Admin)session.get("admin");
		newsinfo.setAuthor(admin.getUsername());
		newsinfo.setCreatetime(new Date());
		
	//	System.out.println("newsinfo:" + newsinfo.getId());
		
		newsinfoService.addNews(newsinfo);
		return "admin";
	}

	// 删除新闻
	public String deleteNews(){
		newsinfoService.deleteNews(id);
		return "admin";
	}

}
