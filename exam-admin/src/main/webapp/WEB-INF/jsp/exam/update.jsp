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

<title>修改学习卡</title>
</head>
<body>
<div class="pd-20">
    <form onsubmit="ajaxSubmitForm(this, true)" action="<%=path %>/exam/update" class="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-2">试题科目</label>
            <div class="formControls col-5">
                <select class="input-text" id="subjectId" name="subjectId">
                	<c:forEach items="${textList }" var="subject">
                		<option value="${subject.id }" 
                		<c:if test="${publishExam.subjectId == subject.id }">  selected = "selected" </c:if>
                		>
                		 ${subject.name }           		
                		</option>
                		
                	</c:forEach>
                </select>
                <input type="hidden" id="id" name="id" value="${publishExam.id }" />
            </div>
            <div class="col-5"></div>
        </div>
        
        <div class="row cl">
            <label class="form-label col-2">  考试时长：</label>
            <div class="formControls col-5">

            	<select class="input-text" id="examlength" name="examlength">
            		
            		<option value="0"
            			<c:if test="${publishExam.examlength == 0 }">selected="selected"</c:if>
            		>0.5小时</option>
            		<option value="1"
            			<c:if test="${publishExam.examlength == 1 }">selected="selected"</c:if>
            		>1.0小时</option>
            		<option value="2"
            			<c:if test="${publishExam.examlength == 2 }">selected="selected"</c:if>
            		>1.5小时</option>
            		<option value="3"
            			<c:if test="${publishExam.examlength == 3 }">selected="selected"</c:if>
            		>2.0小时</option>
            		<option value="4"
            			<c:if test="${publishExam.examlength == 4 }">selected="selected"</c:if>
            		>2.5小时</option>
            		<option value="5"
            			<c:if test="${publishExam.examlength == 5 }">selected="selected"</c:if>
            		>3.0小时</option>
            	</select>
 
            </div>
            <div class="col-5"></div>
        </div>
    
    	<div class="row cl">
            <label class="form-label col-2">  考试时间：</label>
            <div class="formControls col-5">

            <input name="examtime" type="text"  onclick="WdatePicker({minDate:'%y-%M-{%d+1}',dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="input-text Wdate" style="width:170px;" value="${date }" />
 
            </div>
            <div class="col-5"></div>
        </div>
        
        

        <div class="row cl">
            <label class="form-label col-2">试题模块</label>
            <div class="formControls col-5">
            <c:forEach items="${textModelList }" var="textModel" varStatus="vs">
                
							<input name="listTextModel[${vs.count }].textModelId" value="${textModel.id }" type="hidden" />
			                    <input id="textModel${textModel.id }" type="checkbox" name="textModelIds" value="${textModel.id }"
			                    	<c:forEach items="${updateList }" var="textModel2" >
										<c:if test="${textModel2.textModelId == textModel.id }"> 
											checked="checked" 
										</c:if>
									</c:forEach> 
			                     /><label for="subject1" style="margin-right: 10px;">${textModel.texttype }</label> 
			                    	&nbsp;&nbsp;&nbsp; 题量:<input name="listTextModel[${vs.count }].textCount" type="text" 
				                    	
				                    	<c:forEach items="${updateList }" var="textModel2" >
											<c:if test="${textModel2.textModelId == textModel.id }"> 
												value="${textModel2.textCount }" 
											</c:if>
										</c:forEach> 
			                    	
			                    	/>
			                    	&nbsp;&nbsp;&nbsp; 分值:<input name="listTextModel[${vs.count }].grade" type="text"
			                    		<c:forEach items="${updateList }" var="textModel2" >
											<c:if test="${textModel2.textModelId == textModel.id }"> 
												value="${textModel2.grade }" 
											</c:if>
										</c:forEach> 
			                    	
			                    	 /><br>
            </c:forEach>        	

            </div>
            <div class="col-5"></div>
        </div>
    
        <div class="row cl">
            <label class="form-label col-2">考试类型</label>
            <div class="formControls col-5">
            <input name="examtype" type="text" value="${publishExam.examtype }" class="input-text" />
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