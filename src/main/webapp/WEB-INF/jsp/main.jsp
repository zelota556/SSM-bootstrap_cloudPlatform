<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/7
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.*,com.zelot.ModelDo.User" %>
<html>
<head>
    <meta charset="utf-8">
    <!-- 响应式设置viewport -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 图标 -->
    <link rel="icon" href="${pageContext.request.contextPath}/img/icon.png">
    <!-- 标题 -->
    <title>物联网管理系统</title>
    <!-- Bootstrap CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <!-- 样式 CSS-->
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
</head>

<body>
<!-- 头部导航栏 -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <!-- 屏幕变窄出现一个下拉菜单 -->
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <!-- 按钮图标 -->
                <span class="sr-only"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <!-- /按钮图标 -->
            </button>
            <!-- /屏幕变窄出现一个下拉菜单 -->
            <a href="jsp/main.jsp" class="navbar-left">
                <img src="${pageContext.request.contextPath}/img/icon.png" width="50px">
                <a class="navbar-brand" href="html/main.html">物联网管理系统</a>
            </a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#">
                        <% User user = (User) request.getSession().getAttribute("userSession");%>
                        <button type="button" class="btn btn-info">欢迎!<%=user.getUserName()%></button>
                    </a>
                </li>
                <li>
                    <a>
                    <button type="button"  class="btn btn-default" onclick="exit()" >登出</button>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- /头部导航栏 -->

<!-- 主体 -->
<div class="container-fluid">
    <div class="row">
        <!-- 左侧导航栏 -->
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="main"><span class="glyphicon glyphicon-home"></span>&emsp;首页</a> </li>
            </ul>
            <ul class="nav nav-sidebar">
                <li class="active"><a><span class="glyphicon glyphicon-th-list"></span>&emsp;用户管理</a></li>
                <li><a href="user" target="mainframe">&emsp;&emsp;用户列表</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li class="active"><a> <span class="glyphicon glyphicon-th-list"></span>&emsp;设备管理</a></li>
                <li><a href="device" target="mainframe">&emsp;&emsp;设备列表</a></li>
            </ul>
        </div>
        <!-- /左侧导航栏 -->

        <!-- 主体内容 -->

        <%
            String realPath = "http://" + request.getServerName() + ":" + request.getServerPort()
                    + request.getContextPath()+request.getServletPath().substring(0,request.getServletPath().lastIndexOf("/")+1);
        %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <iframe src= ${realpath}"welcome" id="mainframe" name="mainframe" frameborder="0" width="100%" height="850">

            </iframe>
        </div>
        <!-- /主体内容 -->

    </div>
</div>
<!-- /主体 -->
<!-- 页脚 -->
<div class="navbar-fixed-bottom footer">@物联网管理系统</div>
<!-- /页脚 -->
</body>

<script type="text/javascript">
    function exit() {
        $.ajax({
            type:'post',
            url:'user/logout',
            data:"",
            dataType:'json',
        })

    }
</script>
</html>
