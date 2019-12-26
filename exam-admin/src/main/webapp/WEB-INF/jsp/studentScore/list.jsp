<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<title>学生成绩列表</title>
</head>
<body>
<div class="pd-20">
    <form action="/studentScore/list">
        <div class="text-c"> 
            <input type="text" name="id" value="${id }" placeholder="按学号查询学生成绩" style="width:250px" class="input-text" />
            <button class="btn btn-success" type="submit">查找</button>
        </div>
    </form>
    <div class="mt-20">
        <c:if test="${list != null }">
	        <table class="table table-border table-bordered table-bg table-hover">
	            <thead>
	                <tr>
	                    <th>学号</th>
	                    <th>姓名</th>
	                    <th>所在班级</th>
	                    
	                    <c:forEach items="${list }" var="examhis">
	                    	<th>${examhis.subjectname }</th>
	            		</c:forEach>
	
	                </tr>
	            </thead>
	            <tbody>
	                    <tr>
	                        <td>${student.studentid }</td>
	                        <td>${student.studentname }</td>
	                        <td>${student.classesname }</td>
	                    	<c:forEach items="${list }" var="examhise">
			                        <td>${examhise.score }</td>
	                       </c:forEach>
	                    </tr>        
	                      
	                  
	            </tbody>
	        </table>
        </c:if>
        <c:if test="${list == null }">
        	所要查询的学生无考试记录
        </c:if>
    </div>
</div>
</body>
</html>