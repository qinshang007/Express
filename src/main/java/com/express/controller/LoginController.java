package com.express.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.express.service.UserService;

@Controller
@RequestMapping(value="/admin")
public class LoginController extends BaseController{
	@Autowired
	private UserService userService;
	
	private static final Logger logger = Logger.getLogger(LoginController.class); 
	
	/**
	 * 会员登录
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/login.do")
	public void login(HttpServletRequest request, HttpServletResponse response){
		try {
			HttpSession hs = request.getSession();
			String username = request.getParameter("username");												//获取会员名称
			String password = request.getParameter("password");	
			String message = "";
			String userid = userService.getUserIdbyLogin(username, password);
			if(userid != null){
				int level = userService.getLevelByUserid(userid);
				if (level == 3) {
					hs.setAttribute("username",username);
					hs.setAttribute("userid", userid);
					message = "loginSuccess";
					outputJsonResponse(response, true, message);
				}else {
					message = "permissionDenied";
					outputJsonResponse(response, false, message);
				}
			}else{
				message = "loginFailed";
				outputJsonResponse(response, false, message);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("会员登录信息出错！" +  ",errMsg=" + e.getMessage());
		}

	}
	
	@RequestMapping("/loginPage.do")
	public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response){
		try {
			return new ModelAndView("login");
		} catch (Exception e) {
			outputJsonResponse(response, false, e.getMessage());
			logger.error("获取login页面出错！" +  ",errMsg=" + e.getMessage());
			return null;
		}
	}

	

	
}
