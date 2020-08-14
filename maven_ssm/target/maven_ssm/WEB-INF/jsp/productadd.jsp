<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加商品信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>添加商品信息</legend>
</fieldset>
<form class="layui-form layui-form-pane" id="itemForm" action="${pageContext.request.contextPath }/additem.action"
      method="post" enctype="multipart/form-data">
    <div class="layui-form-item">
        <label class="layui-form-label">商品名称</label>
        <div class="layui-input-inline">
            <input type="text" name="name" required autocomplete="off" placeholder="请输入商品名称" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品价格</label>
        <div class="layui-input-inline">
            <input type="text" name="price" required placeholder="￥" autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">商品生产日期</label>
            <div class="layui-input-block">
                <input type="text" name="createtime" required id="date1" placeholder="yyyy-MM-dd HH:mm:ss"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">商品图片</label>
        <div class="layui-upload">
            <input type="file" name="pictureFile"/>
        </div>
    </div>

    <div class="layui-form-item layui-form-text" style="width: 600px; ">
        <label class="layui-form-label">商品简介</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容" class="layui-textarea" name="detail"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <button type="submit" class="layui-btn">提 交</button>
    </div>
</form>

<script src="${pageContext.request.contextPath }/layui/layui.js" charset="utf-8"></script>

<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var laydate = layui.laydate;

        //日期时间选择器
        laydate.render({
            elem: '#date1'
            , type: 'datetime'
        });

    });
</script>
</body>
</html>