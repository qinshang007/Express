<%@ page pageEncoding="utf-8"%>

		<!-- BEGIN SIDEBAR -->
		<div class="page-sidebar nav-collapse collapse">
		<!-- BEGIN SIDEBAR MENU -->        
			<ul class="page-sidebar-menu">
				<li>
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
					<div class="sidebar-toggler hidden-phone"></div>
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
				</li>
				<li class="start">
					<a href="/Express/news/newsAdd.do"><i class="icon-home"></i> 
						<span class="title">添加文章</span>
					</a>
				</li>
				<li class="">
					<a href="javascript:;">
					<i class="icon-plus-sign"></i> 
					<span class="title">关于协会</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li >
							<a href="/Express/news/list.do?newstype=1&subtype=1">协会简介</a>
						</li>
						<li >
							<a href="/Express/news/list.do?newstype=1&subtype=2">协会章程</a>
						</li>
						<li >
							<a href="/Express/news/list.do?newstype=1&subtype=3">协会制度</a>
						</li>
						<li >
							<a href="/Express/news/list.do?newstype=1&subtype=4">协会成员</a>
						</li>
					</ul>
				</li>
				<li class="">
					<a href="javascript:;">
					<i class="icon-plus-sign"></i> 
					<span class="title">政策法规</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li >
							<a href="/Express/news/list.do?newstype=2&subtype=1">行业法律法规</a>
						</li>
						<li >
							<a href="/Express/news/list.do?newstype=2&subtype=2">部门规章</a>
						</li>
						<li >
							<a href="/Express/news/list.do?newstype=2&subtype=3">规范性文件</a>
						</li>
						<li >
							<a href="/Express/news/list.do?newstype=2&subtype=4">地方性法规</a>
						</li>
						<li >
							<a href="/Express/news/list.do?newstype=2&subtype=5">行业其它要求</a>
						</li>
					</ul>
				</li>
				<li class="">
					<a href="javascript:;">
					<i class="icon-plus-sign"></i> 
					<span class="title">行业统计</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li >
							<a href="/Express/news/list.do?newstype=3&subtype=1">统计报告</a>
						</li>
						<li >
							<a href="/Express/news/list.do?newstype=3&subtype=2">申诉通告</a>
						</li>
					</ul>
				</li>
				<li class="">
					<a href="/Express/news/list.do?newstype=4&subtype=0">
					<i class="icon-plus-sign"></i> 
					<span class="title">会员风采</span>
					</a>
				</li>
				<li class="">
					<a href="/Express/news/list.do?newstype=5&subtype=0">
					<i class="icon-plus-sign"></i> 
					<span class="title">重要公告</span>
					</a>
				</li>
				<li class="">
					<a href="/Express/news/list.do?newstype=6&subtype=0">
					<i class="icon-plus-sign"></i> 
					<span class="title">行业资讯</span>
					</a>
				</li>
				<li class="">
					<a href="/Express/news/list.do?newstype=8&subtype=0">
					<i class="icon-plus-sign"></i> 
					<span class="title">协会动态</span>
					</a>
				</li>
				<li class="">
					<a href="javascript:;">
					<i class="icon-sitemap"></i> 
					<span class="title">会员管理</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li >
							<a href="/Express/user/userAdd.do">添加会员</a>
						</li>
						<li >
							<a href="/Express/user/list.do">会员列表</a>
						</li>
						<li >
							<a href="/Express/company/companyAdd.do">添加公司</a>
						</li>
						<li >
							<a href="/Express/company/list.do">公司列表</a>
						</li>
						
					</ul>
				</li>
				<li class="">
					<a href="javascript:;">
					<i class="icon-sitemap"></i> 
					<span class="title">黑名单管理</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li >
							<a href="/Express/userblacklist/userAdd.do">添加员工黑名单</a>
						</li>
						<li >
							<a href="/Express/userblacklist/list.do">员工黑名单列表</a>
						</li>
						<li >
							<a href="/Express/mercblacklist/mercAdd.do">添加电商黑名单</a>
						</li>
						<li >
							<a href="/Express/mercblacklist/list.do">电商黑名单列表</a>
						</li>
						<li >
							<a href="/Express/organizationblacklist/organizationAdd.do">添加快递公司黑名单</a>
						</li>
						<li >
							<a href="/Express/organizationblacklist/list.do">快递公司黑名单列表</a>
						</li>
					</ul>
				</li>
				<li class="">
					<a href="javascript:;">
					<i class="icon-sitemap"></i> 
					<span class="title">滚动新闻管理</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li >
							<a href="/Express/rollingpicture/fileAdd.do">添加滚动新闻</a>
						</li>
						<li >
							<a href="/Express/rollingpicture/list.do">滚动新闻列表</a>
						</li>
					</ul>
				</li>
				<li class="">
					<a href="javascript:;">
					<i class="icon-sitemap"></i> 
					<span class="title">图片管理</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li >
							<a href="/Express/staticpicture/fileAdd.do">添加滚动图片</a>
						</li>
						<li >
							<a href="/Express/staticpicture/list.do">滚动图片列表</a>
						</li>
					</ul>
				</li>
				<li class="">
					<a href="javascript:;">
					<i class="icon-sitemap"></i> 
					<span class="title">下载中心管理</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li >
							<a href="/Express/downloadzone/fileAdd.do">添加下载文件</a>
						</li>
						<li >
							<a href="/Express/downloadzone/list.do">下载中心列表</a>
						</li>
					</ul>
				</li>
				<li class="">
					<a href="javascript:;">
					<i class="icon-sitemap"></i> 
					<span class="title">广告管理</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li >
							<a href="/Express/advertisement/add.do">添加广告</a>
						</li>
						<li >
							<a href="/Express/advertisement/list.do">广告列表</a>
						</li>
					</ul>
				</li>
			</ul>
		<!-- END SIDEBAR MENU -->
		</div>
		<!-- END SIDEBAR -->
