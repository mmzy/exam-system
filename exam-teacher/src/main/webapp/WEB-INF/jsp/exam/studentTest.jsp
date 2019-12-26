<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
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
  
    <title>开始考试</title>
	<link href="<%=path %>/exam/css/css2.css" rel="stylesheet" type="text/css"/>
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <style type="text/css">
    <!--
	.STYLE3 {font-size: 18px; }
	.STYLE4 {font-size: 18px; font-weight: bold; }
	.STYLE5 {color: #FF0000}
-->
    </style>

  </head>
  
  <body onload="sT()">
    <table align="center" width="1003" height="485" border="0" cellpadding="0" cellspacing="0" class="centerbg">
    	<tr>
    		<td width="149" height="485">&nbsp;</td>
    		<td width="741" valign="top" class="rightbian">
    		<form onsubmit="" action="" method="post">
    			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="10">
    				<tr>
    					<td colspan="3">
    						<input type="hidden" name="studentid" value="${examhis.studentid }">
    						<input type="hidden" name="publishexamid" value="${examhis.publishexamid }">
    					</td>
    				</tr>
    				<c:forEach  items="${textModelList }" var="textmodel">
	    				<c:forEach  items="${TextModel }" var="model">
		    				<c:if test="${model.textModelId == textmodel.id }">
			    				<tr>
			    					<td colspan="3" bgcolor="#999999" class="STYLE4">${textmodel.texttype }(每道题${model.grade }分)</td>
			    				</tr>			
			    				<!--题目开始-->
			    				<c:forEach  items="${ExamhisAnswer }" var="exam" varStatus="vs">
			    					<c:if test="${exam.text.texId == textmodel.id }">
					    				<tr>
					    					<input type="hidden" name="examhisAnswerList[${vs.count }].textId" value="${exam.textId }" />
					    					<td colspan="3"><strong style="font-size:16px;">第<span class="STYLE5" >${vs.count }</span>题&nbsp;${exam.text.title }</strong></td>
					    				</tr>
					    				<c:if test="${exam.text.texId == 2 }">
						    				<tr>
						    					<td height="32" colspan="3" bgcolor="#CCCCCC">选择题答案：
						    					×<input type="radio" name="examhisAnswerList[${vs.count }].answer" value="×" 
						    						<c:if test="${exam.answer eq 'A' }">checked="checked"</c:if>
						    					 />
						    					√<input type="radio" name="examhisAnswerList[${vs.count }].answer" value="√"
						    						<c:if test="${exam.answer eq 'B' }">checked="checked"</c:if>
						    					 />
						    					</td>
						    				</tr>
					    				</c:if>
					    				
					    				<c:if test="${exam.text.texId == 1 }">
						    				<tr>
						    					<td colspan="3"><strong>A.</strong>${exam.text.type1 }</td>
						    				</tr>
						    				<tr>
						    					<td colspan="3"><strong>B.</strong>${exam.text.type2 }</td>
						    				</tr>
						    				<tr>
						    					<td colspan="3"><strong>C.</strong>${exam.text.type3 }</td>
						    				</tr>
						    				<tr>
						    					<td colspan="3"><strong>D.</strong>${exam.text.type4 }</td>
						    				</tr>
						    				
						    				<tr>
						    					<td height="32" colspan="3" bgcolor="#CCCCCC">选择题答案：
						    					A<input type="radio" name="examhisAnswerList[${vs.count }].answer" value="A" 
						    						<c:if test="${exam.answer eq 'A' }">checked="checked"</c:if>
						    					 />
						    					B<input type="radio" name="examhisAnswerList[${vs.count }].answer" value="B" 
						    						<c:if test="${exam.answer eq 'B' }">checked="checked"</c:if>
						    					/>
						    					C<input type="radio" name="examhisAnswerList[${vs.count }].answer" value="C" 
						    						<c:if test="${exam.answer eq 'C' }">checked="checked"</c:if>
						    					/>
						    					D<input type="radio" name="examhisAnswerList[${vs.count }].answer" value="D" 
						    						<c:if test="${exam.answer eq 'D' }">checked="checked"</c:if>
						    					/>
						    					</td>
						    				</tr>
					    				</c:if>
					    				
					    				<c:if test="${exam.text.texId != 1 and exam.text.texId != 2 }">
						    				<tr>				
						    						<td colspan="3"><textarea rows="5" cols="70" name="examhisAnswerList[${vs.count }].answer">${exam.answer }</textarea></td>
						    				</tr>
						    				
					    				</c:if>
					    				<tr>
					    						<td colspan="3">
					    							<span style="color:red;font-size:16px;">正确答案：${exam.text.answer }</span>
					    							&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:red;font-size:16px;">打分：</span>				    		
					    								<input type="text" style="width:25px;" name="examhisAnswerList[${vs.count }].grade" value="${exam.grade }">
					    						</td>
					    				</tr>
					    			</c:if>
					    		
			    				</c:forEach>
			    			</c:if>
	   					</c:forEach>						
    				</c:forEach>
    				<!--题目结束-->
    				<tr>
    					<td colspan="3">
    						<div align="center">
    						</div>
    					</td>
    				</tr>
    				
    			</table>
    		
    		</form>
    		</td>
    		<td width="113">&nbsp;</td>
    	</tr>
    
    </table>
  </body>
</html>