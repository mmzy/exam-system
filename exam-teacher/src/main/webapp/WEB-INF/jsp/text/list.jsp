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

<title>试题列表</title>
</head>
<body>
<div class="pd-20">
	<form action="<%=path%>/text/list">
		<input type="hidden" id="curr" name="curr">
	</form>
    <table class="table table-border table-bordered table-bg table-hover">
        <thead>
            <tr>
            	<th>试题编号</th>
            	<th>所属学科</th>
            	<th>所属章节</th>
            	<th>所属模块</th>
            	<th>试题题目</th>
                <th>试题难度</th>
                
                
                <th>操作 <button class="btn size-M radius" onclick="showLayer('添加试题','<%=path%>/text/add')"> 添加</button></th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${pageInfo.list }" var="text" varStatus="vs">
	        	<tr>
	                <td>${vs.count }</td>
	            	<td>${text.subjectname }</td>
	            	<td>${text.chaptername }</td>
	            	<td>${text.modelname }</td>
	            	<td>${text.title }</td>
	                <td>
	                	<c:if test="${text.diffculty==1 }">简单</c:if>
	                	<c:if test="${text.diffculty==2 }">一般</c:if>
	                	<c:if test="${text.diffculty==3 }">困难</c:if>
	                </td>
            
                
	                <td>
	                	<button class="btn size-MINI radius" onclick="showLayer('查看试题详情','<%=path%>/text/text?id=${text.id }')">查看</button>
	                    <button class="btn size-MINI radius" onclick="showLayer('修改试题信息','<%=path%>/text/update?id=${text.id }')">修改</button>
	                    <button class="btn size-MINI radius" onclick="ajaxDelete('<%=path%>/text/delete', 'id=${text.id}')">删除</button>
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
</body>
</html>