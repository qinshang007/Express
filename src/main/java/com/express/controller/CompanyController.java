package com.express.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.express.bean.Company;
import com.express.service.CompanyService;
import com.express.util.CodeGenerator;
import com.express.util.DateUtils;


@Controller
@RequestMapping(value="/company")
public class CompanyController extends BaseController{
	
	@Autowired
	private CompanyService compService;
	

	private static final Logger logger = Logger.getLogger(CompanyController.class);  
	
	/**
	 * 保存公司
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save.do")
	public void addNews(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String compname = new String(request.getParameter("compname").getBytes("ISO-8859-1"),"UTF-8");		
			String address = new String(request.getParameter("address").getBytes("ISO-8859-1"),"UTF-8");		
			String pcompid = request.getParameter("pcompid");
			String tel = request.getParameter("tel");
			String principal = new String(request.getParameter("principal").getBytes("ISO-8859-1"),"UTF-8");
			int level = Integer.parseInt(request.getParameter("level"));
			Company company = new Company();
			company.setCompid(CodeGenerator.createUUID());
			company.setCompname(compname);
			company.setAddress(address);
			company.setLevel(level);
			if (pcompid.equals("null")) {
				company.setPcompid(null);
			}else {
				company.setPcompid(pcompid);
			}
			Timestamp crtime = Timestamp.valueOf(DateUtils.getCurrDateTimeStr());	
			company.setCrtime(crtime);
			company.setPrincipal(principal);	
			company.setTel(tel);
			compService.addCompany(company);
			outputJsonResponse(response, true, "uploadSuccess");
		}catch (RuntimeException e) {
			logger.error("添加公司失败！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}
	
	/**
	 * 返回公司列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list.do")
	public ModelAndView compList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			List<Company> companyList = new ArrayList<Company>();
			companyList = compService.getCompanyList();
			return new ModelAndView("company/companyList").addObject("companyList",companyList);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	
	/**
	 * 修改公司
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/update.do")
	public void updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String compid = request.getParameter("compid");
			String compname = new String(request.getParameter("compname").getBytes("ISO-8859-1"),"UTF-8");		
			String address = new String(request.getParameter("address").getBytes("ISO-8859-1"),"UTF-8");				
			String tel = request.getParameter("tel");
			String principal = new String(request.getParameter("principal").getBytes("ISO-8859-1"),"UTF-8");		
			String pcompid = request.getParameter("pcompid");
			int level = Integer.parseInt(request.getParameter("level"));
			Company company = new Company();
			company.setCompid(compid);
			company.setCompname(compname);
			company.setAddress(address);
			company.setLevel(level);
			if (pcompid.equals("null")) {
				company.setPcompid(null);
			}else {
				company.setPcompid(pcompid);
			}
			Timestamp crtime = Timestamp.valueOf(DateUtils.getCurrDateTimeStr());	
			company.setCrtime(crtime);
			company.setPrincipal(principal);		
			company.setTel(tel);
			compService.updateCompany(company);
			outputJsonResponse(response, true, "uploadSuccess");
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}
	
	/**
	 * 公司详情
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/companyView.do")
	public ModelAndView userView(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String compid = request.getParameter("compid");													
			Company company = compService.getByCompanyId(compid);
			String level = new String();
			if (company.getLevel() == 1) {
				level = "会员单位";
			}else if (company.getLevel() == 2) {
				level = "理事";
			}else if (company.getLevel() == 3) {
				level = "管理员";
			}
			String pcompname = new String();
			if (company.getPcompid() != null) {
				Company pCompany = compService.getByCompanyId(company.getPcompid());
				pcompname = pCompany.getCompname();
			}
			Map map = new HashMap();
			map.put("pcompname", pcompname);
			map.put("company", company);
			map.put("level", level);
			return new ModelAndView("company/companyView").addAllObjects(map);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("根据compid获取公司信息出错！" +  ",errMsg=" + e.getMessage());
			return null;
		}
	}
	
	/**
	 * 编辑公司信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/companyEdit.do")
	public ModelAndView userEdit(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String compid = request.getParameter("compid");														
			Company company = compService.getByCompanyId(compid);
			List<Company> compList =  new ArrayList<Company>();
			if (company.getPcompid() != null) {
				Company nullCom = new Company();
				nullCom.setCompid("null");
				nullCom.setCompname("无");
				compList.add(nullCom);
			}
			compList.addAll(compService.getMainCompanyList());
			String pcompname = "无";//主公司名称
			if (company.getPcompid() != null) {
				Company pCompany = compService.getByCompanyId(company.getPcompid());
				pcompname = pCompany.getCompname();
				
			}
			for(int i=0;i<compList.size();i++){
				if(compList.get(i).getCompid().equals(company.getPcompid())){
					compList.remove(i);
					break;
				}
			}
			String level = company.getLevel()+"";
			Map map = new HashMap();
			map.put("compList", compList);
			map.put("company", company);
			map.put("level", level);
			map.put("compid", compid);
			map.put("compname", pcompname);
			return new ModelAndView("company/companyEdit").addAllObjects(map);
		}catch (RuntimeException e) {
			logger.error("根据compid获取编辑公司信息出错！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	
	
	/**
	 * 添加公司
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/companyAdd.do")
	public ModelAndView addCompany(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			List<Company> compList = compService.getMainCompanyList();
			ModelAndView view = new ModelAndView("company/companyAdd").addObject("compList",compList);
			return view;
		}catch (RuntimeException e) {
			logger.error("获取主公司信息列表出错！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	
	
	/**
	 * 添加会员
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delComp.do")
	public void delUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String compid = request.getParameter("compid");	
			compService.deleteComp(compid);
			outputJsonResponse(response, true, "uploadSuccess");
		}catch (RuntimeException e) {
			logger.error("删除公司出错！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}

}
