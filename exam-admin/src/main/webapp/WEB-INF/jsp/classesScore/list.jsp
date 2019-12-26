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
    <form action="<%=path%>/classesScore/list">
        <input type="hidden" id="curr" name="curr" />
        <div class="text-c"> 
            <input type="text" name="name" value="${name }" placeholder="请输入班级名称" style="width:250px" class="input-text" />
            <button class="btn btn-success" type="submit">查找</button>
        </div>
    </form>
    <div class="mt-20">
        <c:if test="${scoreInfo != null }">
        <table class="table table-border table-bordered table-bg table-hover">
            <thead>
                <tr>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>所在班级</th>
                    
                    <c:forEach items="${subjectList }" var="examhis">
                    	<th>${examhis.subjectname }</th>
                    </c:forEach>
                    
                </tr>
            </thead>
            <tbody>
            	<c:forEach items="${studentInfo.list }" var="student">
                    <tr>
                        <td>${student.id }</td>
                        <td>${student.name }</td>
                        <td>${student.classesname }</td>
                        
                        <c:forEach items="${scoreInfo.list }" var="examhis">
                        	<c:if test="${student.id == examhis.studentid }">
                        		<td>${examhis.score }</td>
                        	</c:if>
						</c:forEach>
						
                    </tr>
                </c:forEach>
            </tbody>
        </table>
         <div id="pagination" style="margin: 20px;"></div>
            <script type="text/javascript" src="<%=path%>/lib/laypage/1.2/laypage.js"></script>
            <script type="text/javascript">
                laypage({
                    cont:'pagination',
                    pages:${studentInfo.pages},
                    curr: ${studentInfo.pageNum},
                    jump:function(obj,first){
                        if(!first){
                            $("#curr").val(obj.curr);
                            $("form").submit();
                        }
                    }
                });
            </script>
        </c:if>
        <c:if test="${scoreInfo == null }">
        	所要查询的班级无考试记录
        </c:if>
           
    </div>
</div>
</body>
</html>