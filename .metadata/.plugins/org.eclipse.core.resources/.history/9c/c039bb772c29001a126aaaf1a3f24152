<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link href="<%=path%>/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=path%>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=path%>/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="<%=path%>/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=path%>/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=path%>/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="<%=path%>/js/common.js"></script>

<title>添加考试</title>
</head>
<body>
<div class="pd-20">
    <form onsubmit="ajaxSubmitForm(this, true)" action="<%=path %>/exam/add" class="form form-horizontal">
    
        <div class="row cl">
            <label class="form-label col-2">试题科目</label>
            <div class="formControls col-5">
                <select class="input-text" id="subjectId" name="subjectId">
                	<c:forEach items="${textList }" var="subject">
                		<option value="${subject.id }">${subject.name }</option>
                	</c:forEach>
                </select>
            </div>
            <div class="col-5"></div>
        </div>
    	
    	<div class="row cl">
            <label class="form-label col-2">  考试时长：</label>
            <div class="formControls col-5">

            	<select class="input-text" id="examlength" name="examlength">
            		<option value="0">0.5小时</option>
            		<option value="1">1.0小时</option>
            		<option value="2">1.5小时</option>
            		<option value="3" selected="selected">2.0小时</option>
            		<option value="4">2.5小时</option>
            		<option value="5">3.0小时</option>
            	</select>
 
            </div>
            <div class="col-5"></div>
        </div>
    	
     	<div class="row cl">
            <label class="form-label col-2">  考试时间：</label>
            <div class="formControls col-5">

            <input name="examtime" type="text" onclick="WdatePicker({minDate:'%y-%M-{%d+1}',dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="input-text Wdate" style="width:170px;" />
 
            </div>
            <div class="col-5"></div>
        </div>
		
		
		
        <div class="row cl">
            <label class="form-label col-2">试题模块</label>
            <div class="formControls col-5">
            <c:forEach items="${textModelList }" var="textModel" varStatus="vs">
                    <input name="listTextModel[${vs.count }].textModelId" value="${textModel.id }" type="hidden" />
                    <input id="textModel${textModel.id }" type="checkbox" name="textModelIds" value="${textModel.id }" /><label for="subject1" style="margin-right: 10px;">${textModel.texttype }</label> 
                    	&nbsp;&nbsp;&nbsp; 题量:<input name="listTextModel[${vs.count }].textCount" type="text" />
                    	&nbsp;&nbsp;&nbsp; 分值:<input name="listTextModel[${vs.count }].grade" type="text" /><br>
            </c:forEach>        	

            </div>
            <div class="col-5"></div>
        </div>
    
        <div class="row cl">
            <label class="form-label col-2">考试类型</label>
            <div class="formControls col-5">
            <input name="examtype" type="text" class="input-text" />
            </div>
            <div class="col-5"></div>
        </div>
        
        <div class="row cl">
            <div class="col-9 col-offset-2">
                <input class="btn btn-primary radius" type="submit" value="添加" />
                <input class="btn btn-default radius" type="button" value="关闭" onclick="parent.location.reload()" style="margin-left: 30px;" />
            </div>
        </div>
    </form>
</div>
</body>
</html>