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

import com.express.bean.MercBlacklist;
import com.express.service.MercBlacklistService;
import com.express.util.CodeGenerator;
import com.express.util.DateUtils;

@Controller
@RequestMapping(value="/mercblacklist")
public class MercBlacklistController extends BaseController{
	
	@Autowired
	private MercBlacklistService mercBlacklistService;
	
	private static final Logger logger = Logger.getLogger(MercBlacklistController.class); 
	
	/**
	 * 保存用户黑名单
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save.do")
	public void addblacklist(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String mercname = new String(request.getParameter("mercname").getBytes("ISO-8859-1"),"UTF-8");
			MercBlacklist mercBlacklist = new MercBlacklist();
			mercBlacklist.setMercname(mercname);
			mercBlacklist.setMercid(CodeGenerator.createUUID());
			Timestamp crtime = Timestamp.valueOf(DateUtils.getCurrDateTimeStr());
			mercBlacklist.setCrtime(crtime);
			mercBlacklistService.addBlackList(mercBlacklist);
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
			String mercid = request.getParameter("mercid");															
			String mercname = new String(request.getParameter("mercname").getBytes("ISO-8859-1"),"UTF-8");
			MercBlacklist mercBlacklist = new MercBlacklist();
			mercBlacklist.setMercname(mercname);
			mercBlacklist.setMercid(mercid);
			Timestamp crtime = Timestamp.valueOf(DateUtils.getCurrDateTimeStr());
			mercBlacklist.setCrtime(crtime);
			mercBlacklistService.updateBlackList(mercBlacklist);
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
			String mercid = request.getParameter("mercid");		
			MercBlacklist user = mercBlacklistService.getByMercId(mercid);
			return new ModelAndView("mercblacklist/userView").addObject("user",user);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("根据mercid获取黑名单用户信息出错！" +  ",errMsg=" + e.getMessage());
			return null;
		}
	}

	
	/**
	 * 返回电商黑名单列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list.do")
	public ModelAndView blackList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			List<MercBlacklist> blacklists = new ArrayList<>();
			blacklists = mercBlacklistService.getBlackList();
			return new ModelAndView("mercblacklist/userList").addObject("blacklists",blacklists);
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
			String mercid = request.getParameter("mercid");													
			MercBlacklist user = mercBlacklistService.getByMercId(mercid);
			return new ModelAndView("mercblacklist/userEdit").addObject("user",user);
		}catch (RuntimeException e) {
			logger.error("根据userid获取编辑黑名单员工信息出错！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	
	/**
	 * 添加电商黑名单
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/mercAdd.do")
	public ModelAndView addCompany(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{			
			ModelAndView view = new ModelAndView("mercblacklist/userAdd");
			return view;
		}catch (RuntimeException e) {
			logger.error("获取添加电商黑名单信息出错！" +  ",errMsg=" + e.getMessage());
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
			String mercid = request.getParameter("mercid");	
			mercBlacklistService.deleteBlacklist(mercid);
			outputJsonResponse(response, true, "uploadSuccess");
		}catch (RuntimeException e) {
			logger.error("删除黑名单用户出错！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}
	

}
