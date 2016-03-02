<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
	<meta charset="utf-8" />
	<title>杭州快递行业协会后台</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	<link href="/Express/media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="/Express/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
	<link href="/Express/media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	<link href="/Express/media/css/style-metro.css" rel="stylesheet" type="text/css"/>
	<link href="/Express/media/css/style.css" rel="stylesheet" type="text/css"/>
	<link href="/Express/media/css/style-responsive.css" rel="stylesheet" type="text/css"/>
	<link href="/Express/media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>
	<link href="/Express/media/css/uniform.default.css" rel="stylesheet" type="text/css"/>
	<!-- END GLOBAL MANDATORY STYLES -->
	<!-- BEGIN PAGE LEVEL STYLES -->
	<link href="/Express/media/css/login.css" rel="stylesheet" type="text/css"/>
	<!-- END PAGE LEVEL STYLES -->
	<link rel="/Express/shortcut icon" href="/Express/media/image/favicon.ico" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="login">
	<!-- BEGIN LOGO -->
	<div class="logo">
		<img src="/Express/media/image/logo-big.png" alt="" /> 
	</div>
	<!-- END LOGO -->
	<!-- BEGIN LOGIN -->
	<div class="content">
		<!-- BEGIN LOGIN FORM -->
		<form class="form-vertical login-form" action="/Express/admin/login.do">
			<h3 class="form-title">杭州快递协会后台登录</h3>
			<div class="alert alert-error hide">
				<button class="close" data-dismiss="alert"></button>
				<span>输入用户名和密码.</span>
			</div>
			<div class="control-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9">账号</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-user"></i>
						<input id="username" class="m-wrap placeholder-no-fix" type="text" placeholder="Username" name="username"/>
					</div> 
				</div>
			</div>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">密码</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i>
						<input id="password" class="m-wrap placeholder-no-fix" type="password" placeholder="Password" name="password"/>
					</div>
				</div>
			</div>
		</form>
		<div class="form-actions">
			<label class="checkbox"><input type="checkbox" name="remember" value="1" />记住我</label>
			<button id="lgbtn" type="submit" class="btn green pull-right">登录 <i class="m-icon-swapright m-icon-white"></i></button>            
		</div>
		<!-- END LOGIN FORM -->        
	</div>
	<!-- END LOGIN -->
	<!-- BEGIN COPYRIGHT -->
	<div class="copyright">
		2013 &copy; Metronic. Admin Dashboard Template.
	</div>
	<!-- END COPYRIGHT -->
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN CORE PLUGINS -->
	<script src="/Express/media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
	<script src="/Express/media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script src="/Express/media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      
	<script src="/Express/media/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="/Express/media/js/jquery.slimscroll.min.js" type="text/javascript"></script>
	<script src="/Express/media/js/jquery.blockui.min.js" type="text/javascript"></script>  
	<script src="/Express/media/js/jquery.cookie.min.js" type="text/javascript"></script>
	<script src="/Express/media/js/jquery.uniform.min.js" type="text/javascript" ></script>
	<script src="/Express/media/js/jsonRespUtils.js" type="text/javascript" ></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script src="/Express/media/js/app.js" type="text/javascript"></script>
	<script src="/Express/media/js/login.js" type="text/javascript"></script>      
	<!-- END PAGE LEVEL SCRIPTS --> 
	<script>

	jQuery(document).ready(function() {     
		  App.init();
	});

	$("#lgbtn").click(function () {
		var username = encodeURI($("#username").val());
		var password = encodeURI($("#password").val());
		 var url="/Express/admin/login.do";
         $.post(url,{username:username,password:password},function(data){
        	 var jresp = new JsonRespUtils(data);
        	 if (jresp.isSuccessfully()){
        		var returnUri = '/Express<%=session.getAttribute("returnUri")%>';
        		if(returnUri == "/Expressnull"){
        			 window.location.href= "/Express/pages/news/newsAdd.jsp";
        		}else{
        			 window.location.href= returnUri;
        		}
              }else{
            	  var res = jresp.getMessage();
            	  if(res=="loginFailed"){
		    			 alert("用户名密码错误！");
		    		}else if(res=="permissionDenied"){
		    			alert("权限不足！");
		    		}
	    			 location.reload();
              }
         });
	})
	
	
	</script>

</body>
<!-- END BODY -->
</html>