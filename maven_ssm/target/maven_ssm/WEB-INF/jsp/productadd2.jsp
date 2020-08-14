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
<!-- 上传图片是需要指定属性 enctype="multipart/form-data" -->
<form id="itemForm" action="${pageContext.request.contextPath }/additem.action" method="post"
      enctype="multipart/form-data">
    添加商品信息：
    <table width="100%" border=1>
        <tr>
            <td>商品名称&nbsp;&nbsp;<input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>商品价格&nbsp;&nbsp;<input type="text" name="price"/></td>
        </tr>

        <tr>
            <td>商品生产日期&nbsp;&nbsp;
                <div class="layui-input-inline">
                    <input type="text" name="createtime" class="layui-input" id="test5"
                           placeholder="yyyy-MM-dd HH:mm:ss">
                </div>
            </td>
        </tr>
        <tr>
            <td>商品图片&nbsp;&nbsp;
                <input type="file" name="pictureFile"/>
            </td>
        </tr>
        <tr>
            <td>商品简介&nbsp;&nbsp;
                <textarea rows="3" cols="30" name="detail"></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value=" 提 交 "/>&nbsp;
                <input type="reset" value=" 清 空 "/>
            </td>
        </tr>
    </table>

    <script src="${pageContext.request.contextPath }/layui/layui.js" charset="utf-8"></script>
    <script>
        layui.use('laydate', function () {
            var laydate = layui.laydate;

            //日期时间选择器
            laydate.render({
                elem: '#test5'
                , type: 'datetime'
            });

        });
    </script>
</form>
</body>

</html>