<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p><security:authentication property="principal.username"></security:authentication></p>
				<%--<p><security:authentication property="principal.image_head"></security:authentication></p>--%>
				<%--<img src="#{pageContext.request.contextPath}/img/visa.png">--%>
				<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a
				href="${pageContext.request.contextPath}/pages/main.jsp"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>

			<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
					<span>系统管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>


			</a>
				<ul class="treeview-menu">

					<li id="system-setting">
						<%--<security:authorize access="hasRole(管理员)"></security:authorize>--%>
						<a
						href="${pageContext.request.contextPath}/user/findall.do?page=1&size=10"> <i
							class="fa fa-circle-o"></i> 用户管理
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/comment/findall.do"> <i
							class="fa fa-circle-o"></i> 评论管理
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/post/findall.do"> <i
							class="fa fa-circle-o"></i> 帖子管理
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/role/findall.do"> <i
							class="fa fa-circle-o"></i> 角色管理
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/type/findall.do"> <i
							class="fa fa-circle-o"></i> 类型管理
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/proclamation/findall.do"> <i
							class="fa fa-circle-o"></i> 公告管理
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/tag/findall.do"> <i
							class="fa fa-circle-o"></i> 标签管理
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/follower_fan/findall.do"> <i
							class="fa fa-circle-o"></i> 关注-粉丝管理
					</a></li>

					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/permission/findAll.do">
							<i class="fa fa-circle-o"></i> 资源权限管理
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/sysLog/findAll.do"> <i
							class="fa fa-circle-o"></i> 访问日志
					</a></li>
				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>基础数据</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/product/findAll.do">
							<i class="fa fa-circle-o"></i> 产品管理
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/orders/findAll.do?page=1&pageSize=3"> <i
							class="fa fa-circle-o"></i> 订单管理
					</a></li>

				</ul></li>

		</ul>
	</section>
	<!-- /.sidebar -->
</aside>