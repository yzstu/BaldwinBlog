<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/12/13
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>留言板</title>
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
                    <li><a href="<%=basePath%>edit.jsp">我要写</a></li>
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
                <h1>留言板</h1>
                <p>
                    沟通交流，拉近你我！
                </p>
            </section>
            <div class="textarea-wrap message" id="textarea-wrap">
                <form class="layui-form blog-editor" action="">
                    <div class="layui-form-item">
                        <textarea name="editorContent" lay-verify="content" id="remarkEditor" placeholder="请输入内容"
                                  class="layui-textarea layui-hide"></textarea>
                    </div>
                    <div class="layui-form-item">
                        <button class="layui-btn" lay-submit="formLeaveMessage" lay-filter="formLeaveMessage">提交留言
                        </button>
                    </div>
                </form>
            </div>
        </div>
        <div class="f-cb"></div>
        <div class="mt20">
            <ul class="message-list" id="message-list">
                <li class="zoomIn article">
                    <div class="comment-parent">
                        <a name="remark-1"></a>
                        <img src="https://thirdqq.qlogo.cn/qqapp/101465933/7627F745B95BFAC18C6C481FE72B4EB1/100"/>
                        <div class="info">
                            <span class="username">Baldwin</span>
                        </div>
                        <div class="comment-content">
                            剑气纵横三万里
                        </div>
                        <p class="info info-footer">
                            <i class="fa fa-map-marker" aria-hidden="true"></i>
                            <span>四川</span>
                            <span class="comment-time">2018-01-01</span>
                            <a href="javascript:;" class="btn-reply" data-targetid="1" data-targetname="燕十三">回复</a>
                        </p>
                    </div>
                    <hr/>
                    <div class="comment-child">
                        <a name="reply-1"></a>
                        <img src="https://thirdqq.qlogo.cn/qqapp/101465933/7627F745B95BFAC18C6C481FE72B4EB1/100">
                        <div class="info">
                            <span class="username">燕十四</span>
                            <span style="padding-right:0;margin-left:-5px;">回复</span>
                            <span class="username">燕十三</span>
                            <span>一剑光寒十九洲</span>
                        </div>
                        <p class="info">
                            <i class="fa fa-map-marker" aria-hidden="true"></i>
                            <span>四川</span>
                            <span class="comment-time">2018-01-01</span>
                            <a href="javascript:;" class="btn-reply" data-targetid="2" data-targetname="燕十四">回复</a>
                        </p>
                    </div>
                    <div class="replycontainer layui-hide">
                        <form class="layui-form" action="">
                            <input type="hidden" name="remarkId" value="1">
                            <input type="hidden" name="targetUserId" value="0">
                            <div class="layui-form-item">
                                <textarea name="replyContent" lay-verify="replyContent" placeholder="请输入回复内容"
                                          class="layui-textarea" style="min-height:80px;"></textarea>
                            </div>
                            <div class="layui-form-item">
                                <button class="layui-btn layui-btn-xs" lay-submit="formReply" lay-filter="formReply">
                                    提交
                                </button>
                            </div>
                        </form>
                    </div>
                </li>
                <li class="zoomIn article">
                    <div class="comment-parent">
                        <a name="remark-1"></a>
                        <img src="https://thirdqq.qlogo.cn/qqapp/101465933/7627F745B95BFAC18C6C481FE72B4EB1/100"
                             alt="{{name}}"/>
                        <div class="info">
                            <span class="username">燕十三</span>
                        </div>
                        <div class="comment-content">
                            剑气纵横三万里
                        </div>
                        <p class="info info-footer">
                            <i class="fa fa-map-marker" aria-hidden="true"></i>
                            <span>四川</span>
                            <span class="comment-time">2018-01-01</span>
                            <a href="javascript:;" class="btn-reply" data-targetid="1" data-targetname="燕十三">回复</a>
                        </p>
                    </div>
                    <div class="replycontainer layui-hide">
                        <form class="layui-form" action="">
                            <input type="hidden" name="remarkId" value="1">
                            <input type="hidden" name="targetUserId" value="0">
                            <div class="layui-form-item">
                                <textarea name="replyContent" lay-verify="replyContent" placeholder="请输入回复内容"
                                          class="layui-textarea" style="min-height:80px;"></textarea>
                            </div>
                            <div class="layui-form-item">
                                <button class="layui-btn layui-btn-xs" lay-submit="formReply" lay-filter="formReply">
                                    提交
                                </button>
                            </div>
                        </form>
                    </div>
                </li>
                <li class="zoomIn article">
                    <div class="comment-parent">
                        <a name="remark-1"></a>
                        <img src="https://thirdqq.qlogo.cn/qqapp/101465933/7627F745B95BFAC18C6C481FE72B4EB1/100"/>
                        <div class="info">
                            <span class="username">燕十三</span>
                        </div>
                        <div class="comment-content">
                            剑气纵横三万里
                        </div>
                        <p class="info info-footer">
                            <i class="fa fa-map-marker" aria-hidden="true"></i>
                            <span>四川</span>
                            <span class="comment-time">2018-01-01</span>
                            <a href="javascript:;" class="btn-reply" data-targetid="1" data-targetname="燕十三">回复</a>
                        </p>
                    </div>
                    <hr/>
                    <div class="replycontainer layui-hide">
                        <form class="layui-form" action="">
                            <input type="hidden" name="remarkId" value="1">
                            <input type="hidden" name="targetUserId" value="0">
                            <div class="layui-form-item">
                                <textarea name="replyContent" lay-verify="replyContent" placeholder="请输入回复内容"
                                          class="layui-textarea" style="min-height:80px;"></textarea>
                            </div>
                            <div class="layui-form-item">
                                <button class="layui-btn layui-btn-xs" lay-submit="formReply" lay-filter="formReply">
                                    提交
                                </button>
                            </div>
                        </form>
                    </div>
                </li>
            </ul>
        </div>
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
