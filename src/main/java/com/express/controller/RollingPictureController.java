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

import com.express.bean.RollingPicture;
import com.express.service.RollingPictureService;
import com.express.util.CodeGenerator;
import com.express.util.CommonConst;
import com.express.util.DateUtils;

@Controller
@RequestMapping(value="/rollingpicture")
public class RollingPictureController extends BaseController{
	
	@Autowired
	private RollingPictureService rollingPictureService;
	
	private static final Logger logger = Logger.getLogger(RollingPictureController.class);
	
	@RequestMapping("/save.do")
	public void addPic(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String title = new String(request.getParameter("title").getBytes("ISO-8859-1"),"UTF-8");
			String path = CommonConst.RO_FILE_PATH;													//文件主图路径
			String sequence = request.getParameter("sequence");
			String link = request.getParameter("link");
			String id = CodeGenerator.createUUID();
			Map<String,String> map = new HashMap<String,String>();
			map.put("id", id);
			map.put("path", path);
			List<RollingPicture> list = upload(request,response, map);											//上传主图
			RollingPicture file = new RollingPicture();
			file.setId(id);
			file.setSequence(Integer.valueOf(sequence));
			file.setTitle(title);
			file.setLink(link);
			Timestamp time = Timestamp.valueOf(DateUtils.getCurrDateTimeStr());
			file.setCrtime(time);
			if(list.size() != 0){
				RollingPicture f = list.get(0);
				file.setFilesrc(f.getFilesrc());
			}
			rollingPictureService.addRollingPicture(file);
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
			String title = new String(request.getParameter("title").getBytes("ISO-8859-1"),"UTF-8");
			String path = CommonConst.RO_FILE_PATH;													//文件主图路径
			String sequence = request.getParameter("sequence");
			String link = request.getParameter("link");
			String filesrc = request.getParameter("filesrc");
			Map<String,String> map = new HashMap<String,String>();
			map.put("id", id);
			map.put("path", path);
			List<RollingPicture> list = upload(request,response, map);											//上传主图
			RollingPicture file = new RollingPicture();
			file.setId(id);
			file.setSequence(Integer.valueOf(sequence));
			file.setTitle(title);
			file.setLink(link);
			file.setFilesrc(filesrc);
			Timestamp time = Timestamp.valueOf(DateUtils.getCurrDateTimeStr());
			file.setCrtime(time);
			if(list.size() != 0){
				RollingPicture f = list.get(0);
				file.setFilesrc(f.getFilesrc());
			}
			rollingPictureService.updateRollingPicture(file);
			outputJsonResponse(response, true, "uploadSuccess");
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}
	
	@RequestMapping("/list.do")
	public ModelAndView newsList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			List<RollingPicture> list = rollingPictureService.getListBySequence();
			Map map = new HashMap();
			map.put("fileList", list);
			return new ModelAndView("rollingpicture/fileList").addAllObjects(map);
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
			RollingPicture pic = rollingPictureService.getById(id);
			return new ModelAndView("rollingpicture/fileEdit").addObject("pic",pic);
		}catch (RuntimeException e) {
			logger.error("根据id获取滚动新闻信息出错！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	
	@RequestMapping("/fileAdd.do")
	public ModelAndView addFile(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			ModelAndView view = new ModelAndView("rollingpicture/fileAdd");
			return view;
		}catch (RuntimeException e) { 
			
			logger.error("获取添加滚动新闻信息列表出错！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	
	@RequestMapping("/delFile.do")
	public void delFile(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String id = request.getParameter("id");	
			rollingPictureService.deleteRollingPicture(id);
			outputJsonResponse(response, true, "uploadSuccess");
		}catch (RuntimeException e) {
			logger.error("删除滚动新闻出错！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}

}
