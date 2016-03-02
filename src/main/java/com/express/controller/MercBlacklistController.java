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
	 * �����û�������
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
	 * �޸ĺ�����
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
	 * ����������
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
			logger.error("����mercid��ȡ�������û���Ϣ����" +  ",errMsg=" + e.getMessage());
			return null;
		}
	}

	
	/**
	 * ���ص��̺������б�
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
	 * �༭������
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
			logger.error("����userid��ȡ�༭������Ա����Ϣ����" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	
	/**
	 * ��ӵ��̺�����
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
			logger.error("��ȡ��ӵ��̺�������Ϣ����" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	
	/**
	 * ɾ����Ա
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
			logger.error("ɾ���������û�����" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}
	

}
