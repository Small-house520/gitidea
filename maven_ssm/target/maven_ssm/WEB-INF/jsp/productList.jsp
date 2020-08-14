<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询商品列表</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.0.js"></script>
</head>
<body>
<%--<form action="${pageContext.request.contextPath }/queryitem.action" method="post">
    查询条件：
    <table>
        <tr>
            <td>商品名称：<input type="text" name="name">&nbsp;&nbsp;<input type="submit" value=" 查 询 "/></td>
        </tr>
    </table>
</form>--%>
<div align="center">
    <span style="font-size: 20px; margin-top: 20px;">商品列表</span>
    <table align="center" class="layui-table"
           lay-data="{width: 1000, height:400, url:'${pageContext.request.contextPath }/productPage', page:true, id:'idTest'}"
           lay-filter="demo">
        <thead>
        <tr>
            <th lay-data="{type:'checkbox', name:'ids', width:50, fixed: 'left'}"></th>
            <th lay-data="{field:'name', width:140, fixed: true}">商品名称</th>
            <th lay-data="{field:'price', width:135, sort: true}">商品价格</th>
            <th lay-data="{field:'createtime', width:200, sort: true}">生产日期</th>
            <th lay-data="{field:'detail', width:280}">商品描述</th>
            <th lay-data="{fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}"></th>
        </tr>
        </thead>
    </table>
</div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="add">添加</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<table class="layui-hide" id="test"></table>

<script src="${pageContext.request.contextPath }/layui/layui.js" charset="utf-8"></script>

<script>
    layui.use('table', function () {
        var table = layui.table;
        //监听表格复选框选择
        table.on('checkbox(demo)', function (obj) {
            console.log(obj)
        });
        //监听工具条
        table.on('tool(demo)', function (obj) {
            var data = obj.data;
            if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    // obj.del();
                    // layer.close(index);
                    window.location.href = "${pageContext.request.contextPath }/deleteitem.action?ids=" + data.id;
                });
            } else if (obj.event === 'edit') {
                // window.location.href = "${pageContext.request.contextPath }/itemEdit.action?id=" + data.id;
                window.location.href = "${pageContext.request.contextPath }/itemEdit.action/" + data.id;
                // layer.alert('编辑行：<br>' + JSON.stringify(data))
            } else if (obj.event === 'add') {
                window.location.href = "${pageContext.request.contextPath }/itemAdd.action";
            }
        });

        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>

</body>
</html>