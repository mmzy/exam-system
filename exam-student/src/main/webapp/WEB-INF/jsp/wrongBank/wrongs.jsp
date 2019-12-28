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
	<link href="<%=path %>/css/css2.css" rel="stylesheet" type="text/css"/>
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
  
  <body>
    <table align="center" width="1003" height="485" border="0" cellpadding="0" cellspacing="0" class="centerbg">
    	<tr>
    		<td width="149" height="485">&nbsp;</td>
    		<td width="741" valign="top" class="rightbian">
    		<form action="">
    			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="10">
    				<tr>
    					<td><div align="center" class="STYLE3">考试时间：${examTimeLength/60 } 分钟</div></td>
    					<td><div align="center" class="STYLE3">考生：${studentInfo.name }</div></td>
    					<td><div align="center" class="STYLE3">总分：${sum }分</div></td>
    					
    				</tr>
    				<tr>
    					<td>&nbsp;<input type="hidden" name="id" value="${publishexam.id }" /></td>
    					<td><div id="tTime"></div><div id="examTimes" style="display:none">${examTime }</div></td>
    					<td><div id="tTime"></div><div id="examTimes1"></div></td>
    				</tr>
    				
    			<c:forEach  items="${textModelList }" var="textmodel">
	    				<tr>
	    					<td colspan="3" bgcolor="#999999" class="STYLE4">${textmodel.texttype }</td>
	    				</tr>
	    				
	    				<!--题目开始-->
    				<c:forEach  items="${textList }" var="texts" varStatus="vs">
    					<c:if test="${texts.texId == textmodel.id }">
		    				<tr>
		    					<input type="hidden" name="examList[${vs.count }].textId" value="${texts.id }" />
		    					<td colspan="3"><strong>第<span class="STYLE5">${vs.count }</span>题&nbsp;${texts.title }</strong></td>
		    				</tr>
		    				
		    				<c:if test="${texts.texId == 2 }">
			    				<tr>
			    					<td height="32" colspan="3" bgcolor="#CCCCCC">判断题答案：
			    					×<input type="radio" name="examList[${vs.count }].answer" value="×" />
			    					√<input type="radio" name="examList[${vs.count }].answer" value="√" />
			    					</td>
			    				</tr>
		    				</c:if>
		    				<c:if test="${texts.texId == 1 }">
			    				<tr>
			    					<td colspan="3"><strong>A.</strong>${texts.type1 }</td>
			    				</tr>
			    				<tr>
			    					<td colspan="3"><strong>B.</strong>${texts.type2 }</td>
			    				</tr>
			    				<tr>
			    					<td colspan="3"><strong>C.</strong>${texts.type3 }</td>
			    				</tr>
			    				<tr>
			    					<td colspan="3"><strong>D.</strong>${texts.type4 }</td>
			    				</tr>
			    				
			    				<tr>
			    					<td height="32" colspan="3" bgcolor="#CCCCCC">选择题答案：
			    					A<input type="radio" name="examList[${vs.count }].answer" value="A" />
			    					B<input type="radio" name="examList[${vs.count }].answer" value="B" />
			    					C<input type="radio" name="examList[${vs.count }].answer" value="C" />
			    					D<input type="radio" name="examList[${vs.count }].answer" value="D" />
			    					</td>
			    				</tr>
		    				</c:if>
		    				<c:if test="${texts.texId != 1 and texts.texId != 2 }">
		    				   <c:choose  >
		    				   <c:when test="${texts.texId == 7}">
			    				<tr>				
			    						<td colspan="3"><textarea rows="5" cols="270" name="examList[${vs.count }].answer"></textarea></td>
			    				</tr>
			    				</c:when>
			    				<c:otherwise>
			    					<tr>				
			    						<td colspan="3"><textarea rows="5" cols="70" name="examList[${vs.count }].answer"></textarea></td>
			    				</tr>
			    				</c:otherwise> 
			    				</c:choose>
		    				</c:if>
		    				
		    			</c:if>
   					</c:forEach>		
    			</c:forEach>	  				
    				
    				<!--题目结束-->
    				<!-- <tr>
    					<td colspan="3">
    						<div align="center">
    							<input type="submit" value="提交答卷" name="submit">
    						</div>
    					</td>
    				</tr> -->
    				
    			</table>
    		
    		</form>
    		</td>
    		<td width="113">&nbsp;</td>
    	</tr>
    
    </table>
  </body>
</html>