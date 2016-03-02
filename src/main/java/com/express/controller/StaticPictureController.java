package com.express.controller;

import java.sql.Timestamp;
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

import com.express.bean.StaticPicture;
import com.express.service.StaticPictureService;
import com.express.util.CodeGenerator;
import com.express.util.CommonConst;
import com.express.util.DateUtils;


@Controller
@RequestMapping(value="/staticpicture")
public class StaticPictureController extends BaseController{

	@Autowired
	private StaticPictureService staticPictureService;
	
	private static final Logger logger = Logger.getLogger(StaticPictureController.class);
	
	@RequestMapping("/save.do")
	public void addPic(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String description = new String(request.getParameter("description").getBytes("ISO-8859-1"),"UTF-8");
			String path = CommonConst.ST_FILE_PATH;													//文件主图路径
			String id = CodeGenerator.createUUID();
			Map<String,String> map = new HashMap<String,String>();
			map.put("id", id);
			map.put("path", path);
			List<StaticPicture> list = uploadStaticPictures(request,response, map);											//上传主图
			StaticPicture file = new StaticPicture();
			file.setId(id);
			file.setDescription(description);
			Timestamp time = Timestamp.valueOf(DateUtils.getCurrDateTimeStr());
			file.setCrtime(time);
			if(list.size() != 0){
				StaticPicture f = list.get(0);
				file.setPicturesrc(f.getPicturesrc());
			}
			staticPictureService.addStaticPicture(file);
			outputJsonResponse(response, true, "uploadSuccess");
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}
	
	@RequestMapping("/update.do")
	public void updatePic(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String id = request.getParameter("id");	
			String picturesrc = request.getParameter("picturesrc");
			String description = new String(request.getParameter("description").getBytes("ISO-8859-1"),"UTF-8");
			String path = CommonConst.ST_FILE_PATH;													
			Map<String,String> map = new HashMap<String,String>();
			map.put("id", id);
			map.put("path", path);
			List<StaticPicture> list = uploadStaticPictures(request,response, map);											//上传主图
			StaticPicture file = new StaticPicture();
			file.setId(id);
			file.setDescription(description);
			file.setPicturesrc(picturesrc);
			Timestamp time = Timestamp.valueOf(DateUtils.getCurrDateTimeStr());
			file.setCrtime(time);
			if(list.size() != 0){
				StaticPicture f = list.get(0);
				file.setPicturesrc(f.getPicturesrc());
			}
			staticPictureService.updateStaticPicture(file);
			outputJsonResponse(response, true, "uploadSuccess");
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}
	
	@RequestMapping("/list.do")
	public ModelAndView newsList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			List<StaticPicture> list = staticPictureService.getPicturetList();
			Map map = new HashMap();
			map.put("fileList", list);
			return new ModelAndView("staticpicture/fileList").addAllObjects(map);
		}catch (RuntimeException e) {
			outputJsonResponse(response, false, e.getMessage());
			logger.error("获取文件列表信息出错！" +  ",errMsg=" + e.getMessage());
			return null;
		}
	}
	
	@RequestMapping("/edit.do")
	public ModelAndView blacklistEdit(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String id = request.getParameter("id");													
			StaticPicture pic = staticPictureService.getById(id);
			return new ModelAndView("staticpicture/fileEdit").addObject("pic",pic);
		}catch (RuntimeException e) {
			logger.error("根据id获取图片信息出错！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	
	@RequestMapping("/fileAdd.do")
	public ModelAndView addFile(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			ModelAndView view = new ModelAndView("staticpicture/fileAdd");
			return view;
		}catch (RuntimeException e) { 
			logger.error("获取添加图片信息列表出错！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	
	@RequestMapping("/delPic.do")
	public void delFile(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String id = request.getParameter("id");	
			staticPictureService.deleteStaticPicture(id);
			outputJsonResponse(response, true, "uploadSuccess");
		}catch (RuntimeException e) {
			logger.error("删除图片出错！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}

}
