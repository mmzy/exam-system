<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="<%=path%>/lib/html5.js"></script>
<script type="text/javascript" src="<%=path%>/lib/respond.min.js"></script>
<script type="text/javascript" src="<%=path%>/lib/PIE_IE678.js"></script>
<![endif]-->
<link href="<%=path%>/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<script type="text/javascript" src="<%=path%>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=path%>/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="<%=path%>/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=path%>/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=path%>/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="<%=path%>/js/common.js"></script>

<title>学生（老师）列表</title>
</head>
<body>
<div class="pd-20">
    <form action="">
        <input type="hidden" id="curr" name="curr" />
        <div class="text-c"> 
            <input type="text" name="param" value="${params }" placeholder=" 老师姓名、教工号、手机等" style="width:250px" class="input-text" />
            <button class="btn btn-success" type="submit">查找</button>
        </div>
    </form>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover">
            <thead>
                <tr>
                    <th>教工号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>身份证号</th>
                    <th>QQ</th>
                    <th>手机</th>
                    <th>邮箱</th>
                    <th>操作<button class="btn size-M radius" onclick="showLayer('添加教师','<%=path%>/teacher/add')"> 添加</button></th>
                </tr>
            </thead>
            <tbody>
                    <c:forEach items="${pageInfo.list }" var="teacher">
                    <tr>
                        <td>${teacher.id }</td>
                        <td>${teacher.name }</td>
                        <td>
                        	<c:if test="${teacher.sex==0 }">女</c:if>
                        	<c:if test="${teacher.sex==1 }">男</c:if>
                        </td>
                        <td>${teacher.age }</td>
                        <td>${teacher.idcard }</td>
                        <td>${teacher.qq }</td>
                        <td>${teacher.phone }</td>
                        <td>${teacher.email }</td>
                        <td>
                            <button class="btn size-MINI radius" onclick="showLayer('修改教师信息','<%=path%>/teacher/update?id=${teacher.id }')">修改</button>
                        	<button class="btn size-MINI radius" onclick="showLayer('学科管理','<%=path%>/teacherSubject/update?id=${teacher.id }')">学科管理</button>
                        </td>
                    </tr>
                  </c:forEach>
            </tbody>
        </table>
            <div id="pagination" style="margin: 20px;"></div>
            <script type="text/javascript" src="<%=path%>/lib/laypage/1.2/laypage.js"></script>
            <script type="text/javascript">
                laypage({
                    cont:'pagination',
                    pages:${pageInfo.pages},
                    curr: ${pageInfo.pageNum},
                    jump:function(obj,first){
                        if(!first){
                            $("#curr").val(obj.curr);
                            $("form").submit();
                        }
                    }
                });
            </script>
    </div>
</div>
</body>
</html>