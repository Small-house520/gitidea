<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改商品信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all">
</head>
<body>
<!-- 上传图片是需要指定属性 enctype="multipart/form-data" -->
<!-- <form id="itemForm" action="" method="post" enctype="multipart/form-data"> -->
<form id="itemForm" action="${pageContext.request.contextPath }/updateitem.action" method="post"
      enctype="multipart/form-data">
    <input type="hidden" name="id" value="${item.id }"/> 修改商品信息：
    <table width="100%" border=1 cellpadding="0" cellspacing="0">
        <tr>
            <td>商品名称</td>
            <td><input type="text" name="name" value="${item.name }"/></td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td><input type="text" name="price" value="${item.price }"/></td>
        </tr>

        <tr>
            <td>商品生产日期</td>
            <td>
                <div class="layui-input-inline">
                    <input type="text" name="createtime" required id="date1"
                           value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                           autocomplete="off" class="layui-input">
                </div>
            </td>
        </tr>
        <tr>
            <td>商品图片</td>
            <td>
                <c:if test="${item.pic !=null}">
                    <img src="${pageContext.request.contextPath}/images/${item.pic}" width=100 height=100/>
                    <br/>
                </c:if>
                <input type="file" name="pictureFile"/>
            </td>
        </tr>
        <tr>
            <td>商品简介</td>
            <td>
                <textarea rows="3" cols="30" name="detail">${item.detail }</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value=" 提 交 "/>&nbsp;
                <input type="reset" value=" 重 置 "/>
            </td>
        </tr>
    </table>

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