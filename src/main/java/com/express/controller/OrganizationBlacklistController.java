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

import com.express.bean.OrganizationBlacklist;
import com.express.service.OrganizationBlacklistService;
import com.express.util.CodeGenerator;
import com.express.util.DateUtils;


@Controller
@RequestMapping(value="/organizationblacklist")
public class OrganizationBlacklistController extends BaseController{
	
	@Autowired
	private OrganizationBlacklistService organizationBlacklistService;
	
	private static final Logger logger = Logger.getLogger(OrganizationBlacklistController.class); 
	
	/**
	 * 保存用户黑名单
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save.do")
	public void addblacklist(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String organizationname = new String(request.getParameter("organizationname").getBytes("ISO-8859-1"),"UTF-8");
			OrganizationBlacklist organizationBlacklist = new OrganizationBlacklist();
			organizationBlacklist.setOrganizationname(organizationname);
			organizationBlacklist.setOrganizationid(CodeGenerator.createUUID());
			Timestamp crtime = Timestamp.valueOf(DateUtils.getCurrDateTimeStr());
			organizationBlacklist.setCrtime(crtime);
			organizationBlacklistService.addBlackList(organizationBlacklist);
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
			String organizationid = request.getParameter("organizationid");															
			String organizationname = new String(request.getParameter("organizationname").getBytes("ISO-8859-1"),"UTF-8");
			OrganizationBlacklist organizationBlacklist = new OrganizationBlacklist();
			organizationBlacklist.setOrganizationname(organizationname);
			organizationBlacklist.setOrganizationid(organizationid);
			Timestamp crtime = Timestamp.valueOf(DateUtils.getCurrDateTimeStr());
			organizationBlacklist.setCrtime(crtime);
			organizationBlacklistService.updateBlackList(organizationBlacklist);
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
			String organizationid = request.getParameter("organizationid");		
			OrganizationBlacklist user = organizationBlacklistService.getByOrganizationId(organizationid);
			return new ModelAndView("organizationblacklist/userView").addObject("user",user);
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
			List<OrganizationBlacklist> blacklists = new ArrayList<>();
			blacklists = organizationBlacklistService.getBlackList();
			return new ModelAndView("organizationblacklist/userList").addObject("blacklists",blacklists);
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
			String organizationid = request.getParameter("organizationid");													
			OrganizationBlacklist user = organizationBlacklistService.getByOrganizationId(organizationid);
			return new ModelAndView("organizationblacklist/userEdit").addObject("user",user);
		}catch (RuntimeException e) {
			logger.error("根据organizationid获取编辑黑名单员工信息出错！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	
	/**
	 * 添加快递公司黑名单
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/organizationAdd.do")
	public ModelAndView addCompany(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{			
			ModelAndView view = new ModelAndView("organizationblacklist/userAdd");
			return view;
		}catch (RuntimeException e) {
			logger.error("获取添加快递公司黑名单信息出错！" +  ",errMsg=" + e.getMessage());
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
			String organizationid = request.getParameter("organizationid");	
			organizationBlacklistService.deleteBlacklist(organizationid);
			outputJsonResponse(response, true, "uploadSuccess");
		}catch (RuntimeException e) {
			logger.error("删除黑名单用户出错！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}

}
