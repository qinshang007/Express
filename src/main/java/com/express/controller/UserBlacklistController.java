package com.express.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.express.bean.UserBlacklist;
import com.express.service.UserBlacklistService;
import com.express.util.CodeGenerator;
import com.express.util.DateUtils;

@Controller
@RequestMapping(value="/userblacklist")
public class UserBlacklistController extends BaseController{
	
	@Autowired
	private UserBlacklistService userBlacklistService;
	
	private static final Logger logger = Logger.getLogger(UserBlacklistController.class);  

	/**
	 * 保存用户黑名单
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save.do")
	public void addblacklist(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			String compname = new String(request.getParameter("compname").getBytes("ISO-8859-1"),"UTF-8");
			UserBlacklist userBlacklist = new UserBlacklist();
			userBlacklist.setCompname(compname);
			userBlacklist.setName(name);
			userBlacklist.setUserid(CodeGenerator.createUUID());
			Timestamp crtime = Timestamp.valueOf(DateUtils.getCurrDateTimeStr());
			userBlacklist.setCrtime(crtime);
			userBlacklistService.addBlackList(userBlacklist);
			outputJsonResponse(response, true, "uploadSuccess");
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}
	
	/**
	 * 修改黑名单
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/update.do")
	public void updateBlacklist(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String userid = request.getParameter("userid");																//获取文章id
			String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			String compname = new String(request.getParameter("compname").getBytes("ISO-8859-1"),"UTF-8");
			UserBlacklist userBlacklist = new UserBlacklist();
			userBlacklist.setCompname(compname);
			userBlacklist.setName(name);
			userBlacklist.setUserid(userid);
			Timestamp crtime = Timestamp.valueOf(DateUtils.getCurrDateTimeStr());
			userBlacklist.setCrtime(crtime);
			userBlacklistService.updateBlackList(userBlacklist);
			outputJsonResponse(response, true, "uploadSuccess");
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}
	
	/**
	 * 黑名单详情
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view.do")
	public ModelAndView blacklistView(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String userid = request.getParameter("userid");	
			UserBlacklist user = userBlacklistService.getByUserid(userid);
			return new ModelAndView("userblacklist/userView").addObject("user",user);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("根据userid获取黑名单用户信息出错！" +  ",errMsg=" + e.getMessage());
			return null;
		}
	}

	
	/**
	 * 返回员工黑名单列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list.do")
	public ModelAndView blackList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			List<UserBlacklist> blacklists = new ArrayList<>();
			blacklists = userBlacklistService.getBlackList();
			return new ModelAndView("userblacklist/userList").addObject("blacklists",blacklists);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	
	/**
	 * 编辑黑名单
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit.do")
	public ModelAndView blacklistEdit(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String userid = request.getParameter("userid");													
			UserBlacklist user = userBlacklistService.getByUserid(userid);
			return new ModelAndView("userblacklist/userEdit").addObject("user",user);
		}catch (RuntimeException e) {
			logger.error("根据userid获取编辑黑名单员工信息出错！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	
	/**
	 * 添加员工黑名单
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userAdd.do")
	public ModelAndView addCompany(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{			
			ModelAndView view = new ModelAndView("userblacklist/userAdd");
			return view;
		}catch (RuntimeException e) {
			logger.error("获取添加员工黑名单信息出错！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	
	/**
	 * 删除会员
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delUser.do")
	public void delUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String userid = request.getParameter("userid");	
			userBlacklistService.deleteBlacklist(userid);
			outputJsonResponse(response, true, "uploadSuccess");
		}catch (RuntimeException e) {
			logger.error("删除黑名单用户出错！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}
	
}
