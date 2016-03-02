package com.express.controller;

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

import com.express.bean.Advertisement;
import com.express.bean.StaticPicture;
import com.express.service.AdvertisementService;
import com.express.util.CodeGenerator;
import com.express.util.CommonConst;
import com.express.util.DateUtils;

@Controller
@RequestMapping(value="/advertisement")
public class AdvertisementController extends BaseController{

	@Autowired
	private AdvertisementService addService;
	
	private static final Logger logger = Logger.getLogger(AdvertisementController.class);
	
	/**
	 * 保存广告
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save.do")
	public void saveAdvertisement(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String path = CommonConst.ADD_FILE_PATH;													//文件主图路径
			String id = CodeGenerator.createUUID();
			Map<String,String> map = new HashMap<String,String>();
			map.put("id", id);
			map.put("path", path);
			List<StaticPicture> list = uploadStaticPictures(request,response, map);	
			Advertisement add = new Advertisement();
			String link = new String(request.getParameter("link").getBytes("ISO-8859-1"),"UTF-8");
			add.setLink(link);
			if(list.size() != 0){
				StaticPicture f = list.get(0);
				add.setPic(f.getPicturesrc());
			}
			if(addService.addAdvertisement(add))
				outputJsonResponse(response, true, "uploadSuccess");
			else
				outputJsonResponse(response, true, "uploadFailure");
		}catch (RuntimeException e) {
			logger.error("添加广告失败！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}

	/**
	 * 更改广告
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/update.do")
	public void updateAdvertisement(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String path = CommonConst.ADD_FILE_PATH;													//文件主图路径
			String id = CodeGenerator.createUUID();
			Map<String,String> map = new HashMap<String,String>();
			map.put("id", id);
			map.put("path", path);
			List<StaticPicture> list = uploadStaticPictures(request,response, map);	
			Advertisement add = new Advertisement();
			String link = new String(request.getParameter("link").getBytes("ISO-8859-1"),"UTF-8");
			String pic = new String(request.getParameter("pic").getBytes("ISO-8859-1"),"UTF-8");
			String picid = new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
			add.setLink(link);
			add.setPic(pic);
			add.setId(Integer.valueOf(picid));
			add.setCrtime(DateUtils.getCurrDateTimeStr());
			if(list.size() != 0){
				StaticPicture f = list.get(0);
				add.setPic(f.getPicturesrc());
			}
			if(addService.updateAdvertisement(add))
				outputJsonResponse(response, true, "uploadSuccess");
			else
				outputJsonResponse(response, true, "uploadFailure");
		}catch (RuntimeException e) {
			logger.error("更新广告失败！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}

	/**
	 * 返回广告列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list.do")
	public ModelAndView addList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			List<Advertisement> addList = new ArrayList<Advertisement>();
			addList = addService.getAdvertisementList();
			return new ModelAndView("advertisement/advertisementList").addObject("advertisementList",addList);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}

	/**
	 * 添加广告
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add.do")
	public ModelAndView addAdvertisement(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			return new ModelAndView("advertisement/advertisementAdd");
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("添加广告页面出错！" +  ",errMsg=" + e.getMessage());
			return null;
		}
	}

	
	/**
	 * 广告详情
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view.do")
	public ModelAndView addView(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String id = request.getParameter("id");													
			Advertisement add = addService.getAdvertisementById(Integer.valueOf(id));
			return new ModelAndView("advertisement/advertisementView").addObject("add", add);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("根据id获广告信息出错！" +  ",errMsg=" + e.getMessage());
			return null;
		}
	}

	/**
	 * 删除广告
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delAdvertisement.do")
	public void delAdvertisement(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String id = request.getParameter("id");	
			addService.deleteAdvertisement(Integer.valueOf(id));
			outputJsonResponse(response, true, "uploadSuccess");
		}catch (RuntimeException e) {
			logger.error("删除广告出错！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}

	
}
