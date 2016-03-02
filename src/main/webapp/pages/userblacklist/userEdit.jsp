<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>编辑用户</title>
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
	<link rel="stylesheet" type="text/css" href="/Express/media/css/bootstrap-fileupload.css" />
	<link href="/Express/media/css/bootstrap-modal.css" rel="stylesheet" type="text/css"/>
	<!-- END PAGE LEVEL STYLES -->
	<link rel="shortcut icon" href="/Express/media/image/favicon.ico" />	
	
</head>
<body class="page-header-fixed">
	<!-- BEGIN HEADER -->
	<%@ include file="/pages/includes/top_banner.jsp"%>
	<!-- END HEADER -->
	<!-- BEGIN CONTAINER -->
	<div class="page-container row-fluid">
	<%@ include file="/pages/includes/left_navigation.jsp"%>
		<!-- BEGIN PAGE -->  
		<div class="page-content">
			<!-- BEGIN PAGE CONTAINER-->
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12">
						<h3 class="page-title">
							编辑黑名单员工
						</h3>
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="/Express/pages/news/newsAdd.jsp">主页</a> 
								<span class="icon-angle-right"></span>
							</li>
							<li>
								<a >黑名单管理</a>
								<span class="icon-angle-right"></span>
							</li>
							<li><a >${user.name}</a></li>
						</ul>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN SAMPLE FORM PORTLET-->   
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption"><i class="icon-reorder"></i>${user.name}</div>
							</div>
						<div class="portlet-body form">
							<!-- BEGIN FORM-->
							<form id="userForm" action="/Express/userblacklist/update.do" class="form-horizontal" method="post" enctype="multipart/form-data" target="hidden_frame">
								<input name="userid" type="hidden" value="${user.userid }">
								<div class="control-group">
									<label class="control-label">员工姓名</label>
									<div class="controls">
										<input id="name" type="text" class="span6 m-wrap" name="name" value="${user.name}"/>
										<span class="help-inline">必填</span>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">员工公司</label>
									<div class="controls">
										<input id="compname" type="text" class="span6 m-wrap" name="compname" value="${user.compname}" />
										<span class="help-inline">必填</span>
									</div>
								</div>
							</form>
							<div class="form-actions">
								<button type="submit" class="btn blue" onclick="save();">提交</button>
								<button type="button" class="btn">取消</button>                            
							</div>
						</div>
						</div>
						<!-- END EXTRAS PORTLET-->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- END CONTAINER -->
	<!-- BEGIN FOOTER -->
	<div class="footer">
		<div class="footer-inner">
			2013 &copy; Metronic by keenthemes.
		</div>
		<div class="footer-tools">
			<span class="go-top">
			<i class="icon-angle-up"></i>
			</span>
		</div>
	</div>
	<iframe name='hidden_frame' id="hidden_frame" style="display:none" ></iframe>  
	<!-- END FOOTER -->
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN CORE PLUGINS -->
	<script src="/Express/media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
	<script src="/Express/media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script src="/Express/media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      
	<script src="/Express/media/js/bootstrap.min.js" type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script type="text/javascript" src="/Express/media/js/bootstrap-fileupload.js"></script>
	<script type="text/javascript" src="/Express/media/js/jsonRespUtils.js"></script>
	<script type="text/javascript" src="/Express/media/js/validate.js"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="/Express/media/js/app.js"></script>
	<!-- END PAGE LEVEL SCRIPTS -->
	<script>
		jQuery(document).ready(function() {       
		   // initiate layout and plugins
		   App.init();
		});
		
		function submitById(id){			
			//Callback handler for form submit event
			$("#"+id).submit(function(e)
			{
				  	e.preventDefault();
				  	var formObj = $(this);
				    var formURL = formObj.attr("action");
				    var formData = new FormData(this);
				    $.ajax({
				        url: formURL,
				    type: 'POST',
				        data:  formData,
				    mimeType:"multipart/form-data",
				    contentType: false,
				    cache: false,
				    processData:false,
				    success: function(transport)
				    {
				    	 var jresp = new JsonRespUtils(transport);
				    	 if (jresp.isSuccessfully()){
				    		 var res = jresp.getMessage();
				    		alert("更改成功！");
				    	 }
				    	 location.reload();
				    },
				     error: function(transport) 
				     {
				    	alert("保存失败！");
				     }          
				    });
				}); 
				$("#"+id).submit();
			}

		function save(){
			submitById('userForm');
			return false;
		}
		
	</script>
	<script type="text/javascript">  var _gaq = _gaq || [];  _gaq.push(['_setAccount', 'UA-37564768-1']);  _gaq.push(['_setDomainName', 'keenthemes.com']);  _gaq.push(['_setAllowLinker', true]);  _gaq.push(['_trackPageview']);  (function() {    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;    ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);  })();</script></body>
	<!-- END BODY -->
</body>
</html>