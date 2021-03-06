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

<title>添加班级成员</title>
</head>
<body>
<div class="pd-20">
    <div class="text-c">
        <form action="">
            <input type="hidden" id="curr" name="curr" />
            <input type="hidden" id="id" name="id" value="${id }">
            <input type="text" name="param" value="" placeholder=" 学生姓名、班级、邮箱、手机等" style="width:250px" class="input-text" />
            <button class="btn btn-success radius" type="submit">查找</button>
            <input class="btn btn-default radius" type="button" value="关闭" onclick="parent.location.reload()" style="margin-left: 30px;" />
        </form> 
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover">
            <thead>
                <tr>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>身份证号</th>
                    <th>QQ</th>
                    <th>手机</th>
                    <th>邮箱</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach items="${pageInfo.list }" var="student">
                    <tr>
                        <td>${student.id }</td>
                        <td>${student.name }</td>
                        <td>
                        	<c:if test="${student.sex==0 }">女</c:if>
                        	<c:if test="${student.sex==1 }">男</c:if>
                        </td>
                        <td>${student.age }</td>
                        <td>${student.idcard }</td>
                        <td>${student.qq }</td>
                        <td>${student.phone }</td>
                        <td>${student.email }</td>
                        <td>
                            <button class="btn size-MINI radius" onclick="ajaxSubmit('<%=path%>/classesStudent/add', 'id=${student.id }&classesId=${id }')">添加到班级</button>
                        </td>
                    </tr>
                  </c:forEach>
                    
            </tbody>
        </table>
        
            <div id="pagination" style="margin: 10px;"></div>
            <script type="text/javascript" src="<%=path%>/lib/laypage/1.2/laypage.js"></script>
            <script type="text/javascript">
                laypage({
                    cont: 'pagination',
                    pages:${pageInfo.pages},
                    curr: ${pageInfo.pageNum},
                    jump:function(obj,first){
                        if(!first){ //一定要加此判断，否则初始时会无限刷新
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