<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/12/16
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="author" content="Kodinger">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>E-mail verification</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/my-login.css">
</head>
<body class="my-login-page">
<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-md-center h-100">
            <div class="card-wrapper">
                <div class="brand">
                    <img src="<%=basePath%>/image/logo.jpg" alt="bootstrap 4 login page">
                </div>
                <div class="card fat">
                    <div class="card-body">
                        <h4 class="card-title">Register</h4>
                        <form method="POST" class="my-login-validation" novalidate="" action="/user/emailVerify.action">

                            <input type="hidden" id="nickName" name="nickName"
                                   value="<%=request.getParameter("nickName")%>">
                            <input type="hidden" id="password" name="password"
                                   value="<%=request.getParameter("password")%>">
                            <input type="hidden" id="name" name="name" value="<%=request.getParameter("name")%>">
                            <input type="hidden" id="email" name="email" value="<%=request.getParameter("email")%>">
                            <input type="hidden" id="phone" name="phone" value="<%=request.getParameter("phone")%>">
                            <input type="hidden" id="detail" name="detail" value="<%=request.getParameter("detail")%>">

                            <div class="form-group">
                                <label for="emailVerify">Email Verify Code</label>
                                <input id="emailVerify" type="text" class="form-control" name="emailVerify"
                                       required
                                       data-eye>
                                <div class="invalid-feedback">
                                    Password is required
                                </div>
                            </div>

                            <div class="form-group m-0">
                                <button type="submit" class="btn btn-primary btn-block">
                                    Register
                                </button>
                            </div>
                            <div class="mt-4 text-center">
                                Already have an account? <a href="<%=basePath%>login/index.jsp">Login</a>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="footer">
                    Copyright &copy; 2017 &mdash; Your Company
                </div>
            </div>
        </div>
    </div>
</section>

<%--
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
--%>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="<%=basePath%>js/my-login.js"></script>
</body>
</html>
