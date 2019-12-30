<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/12/30
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width"/>
    <meta name="author" content="www.yzstu.cn"/>
    <meta name="robots" content="all"/>
    <title>编辑博客</title>
    <link rel="stylesheet" href="<%=basePath%>font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=basePath%>layui/css/layui.css"/>
    <link rel="stylesheet" href="<%=basePath%>css/master.css"/>
    <link rel="stylesheet" href="<%=basePath%>css/gloable.css"/>
    <link rel="stylesheet" href="<%=basePath%>css/nprogress.css"/>
    <link rel="stylesheet" href="<%=basePath%>css/message.css"/>
</head>
<body>
<div class="header">
</div>
<header class="gird-header">
    <div class="header-fixed">
        <div class="header-inner">
            <a href="javascript:void(0)" class="header-logo" id="logo">Mr.Yss</a>
            <nav class="nav" id="nav">
                <ul>
                    <li><a href="<%=basePath%>index.jsp">首页</a></li>
                    <li><a href="<%=basePath%>article.jsp">博客</a></li>
                    <li><a href="<%=basePath%>article.jsp">我要写</a></li>
                    <li><a href="<%=basePath%>message.jsp">留言</a></li>
                    <li><a href="<%=basePath%>link.jsp">友链</a></li>
                </ul>
            </nav>
            <a href="#" class="blog-user">
                <i class="fa fa-qq"></i>
            </a>
            <a class="phone-menu">
                <i></i>
                <i></i>
                <i></i>
            </a>
        </div>
    </div>
</header>
<div class="doc-container" id="doc-container">
    <div class="container-fixed">
        <div class="container-inner">
            <section class="msg-remark">
                <h1>编辑博客</h1>
                <p>
                    用代码改变世界
                </p>
            </section>
            <div class="textarea-wrap message" id="textarea-wrap">
                <form class="layui-form blog-editor" action="">
                    <div class="layui-form-item">
                        <%--<textarea name="editorContent" lay-verify="content" id="remarkEditor" placeholder="请输入内容"
                                  class="layui-textarea layui-hide"></textarea>--%>
                        <%@include file="support/ueditor.jsp" %>
                    </div>
                    <div class="layui-form-item">
                        <button class="layui-btn" lay-submit="formLeaveMessage" lay-filter="formLeaveMessage">提交博客
                        </button>
                    </div>
                </form>
            </div>
        </div>
        <div class="f-cb"></div>
        <div class="mt20"></div>
    </div>
</div>
<footer class="grid-footer">
    <div class="footer-fixed">
        <div class="copyright">
            <div class="info">
                <div class="contact">
                    <a href="javascript:void(0)" class="github" target="_blank"><i class="fa fa-github"></i></a>
                    <a href="#" class="qq" target="_blank"><i class="fa fa-qq"></i></a>
                    <a href="#" class="email" target="_blank"><i class="fa fa-envelope"></i></a>
                    <a href="javascript:void(0)" class="weixin"><i class="fa fa-weixin"></i></a>
                </div>
                <p class="mt05">
                    Copyright &copy; 2018-2018 www.yzstu.cn All Rights Reserved V.1.0.0 豫ICP备19018621号-1
                </p>
            </div>
        </div>
    </div>
</footer>
<script src="<%=basePath%>layui/layui.js"></script>
<script src="<%=basePath%>js/yss/gloable.js"></script>
<script src="<%=basePath%>js/plugins/nprogress.js"></script>
<script>NProgress.start();</script>
<script src="<%=basePath%>js/pagemessage.js"></script>
<script>NProgress.start();</script>
<script>
    window.onload = function () {
        NProgress.done();
    };
</script>
</body>
</html>
