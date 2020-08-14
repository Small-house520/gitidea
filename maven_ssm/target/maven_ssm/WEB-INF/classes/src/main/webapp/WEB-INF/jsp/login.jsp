<%--
  Created by IntelliJ IDEA.
  User: 小房子
  Date: 2020/8/12
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>用户登录</legend>
</fieldset>
<form action="${pageContext.request.contextPath}/login.action">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-inline">
            <input type="text" required name="username" lay-verify="title" autocomplete="off"
                   placeholder="用户名" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="password" required name="password" lay-verify="title" autocomplete="off"
                   placeholder="密码" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">登 录</button>
            <button type="reset" class="layui-btn layui-btn-primary">清 空</button>
        </div>
    </div>
</form>
</body>
</html>
