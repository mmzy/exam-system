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
    
<!-- <script type="text/javascript">
 var ksTime; //定义考试时间以分钟计算
 ksTime = ${ksTime};//对考试时间赋值
 if(readCookie("ss")==""){
  setCookie("ss",${examTime},ksTime/60);
 }
 function sT(){
  var tti = new Date();
  var lt  = parseInt((tti-new Date(readCookie("ss")))/1000)
  if((ksTime*60-lt)<0){
   setCookie("ss",new Date(),0);
   alert("考试时间到!\n即将提交试卷!");
   document.forms[0].submit();
  }else{
  	lm = Math.floor(lt / 60);
	ls = lt % 60;
	allY = ksTime*60-lt;
	ym = Math.floor(allY / 60);
	ys = allY % 60;
   document.getElementById("tTime").innerHTML = "考试已经开始了" + lm + "分" + ls + "秒" + ",剩余"  + ym + "分" + ys + "秒";
   var ttt = setTimeout("sT()",1000);
  }
 }
 function readCookie(name) { 
  var cookieValue = ""; 
  var search = name + "="; 
  if(document.cookie.length > 0) { 
   offset = document.cookie.indexOf(search); 
   if (offset != -1) { 
    offset += search.length; 
    end = document.cookie.indexOf(";", offset); 
    if (end == -1) 
     end = document.cookie.length; 
    cookieValue = document.cookie.substring(offset, end) 
   } 
  } 
  return cookieValue; 
 }  
 function setCookie(name, value, hours) { 
  var expire = ""; 
  if(hours != null) { 
   expire = new Date((new Date()).getTime() + hours * 3600000); 
   expire = "; expires=" + expire.toGMTString(); 
  } 
  document.cookie = name + "=" + value + expire; 
 }
 </script> -->
  </head>
  <script type="text/javascript">
    function startTime(){  
    	//定义考试剩余时间，时间为毫秒数
        //examTime = "${examTime}";//对考试剩余时间赋值
    	//var exam = parseInt("${examTime}");
    	var examTime = parseInt(examTimes.innerHTML);  
	    var examTimeLength;//考试时长
	    examTimeLength = "${examTimeLength}"; 
	    if ((examTime)<0){
	    	alert("考试时间到!\n即将提交试卷!");
	    	document.forms[0].submit();
	    }else{
	    	//var lm = Math.floor((examTimeLength - examTime) / 60000);
	    	var lh = Math.floor(((examTimeLength - examTime) / 3600) % 60)
	    	var lm = Math.floor(((examTimeLength - examTime) / 60) % 60);
	    	var ls = (examTimeLength - examTime) % 60;
	    	var yh = Math.floor((examTime / 3600) % 60);
	    	var ym = Math.floor((examTime / 60) % 60);
	    	var ys = examTime % 60;
	       document.getElementById("tTime").innerHTML = "考试已经开始了" + lh + "时" + lm + "分" + ls + "秒" + ",剩余" + yh + "时"  + ym + "分" + ys + "秒";
	    }
	    examTime--;
	    examTimes.innerHTML=examTime;
	    setTimeout(startTime,1000);
    }
    
    var timer=null;
    //当页面加载后，启动周期性定时器，每过1秒执行startTime
    window.onload=function(){
    	startTime();
    }
    
    
    </script>
  <body>
    <table align="center" width="1003" height="485" border="0" cellpadding="0" cellspacing="0" class="centerbg">
    	<tr>
    		<td width="149" height="485">&nbsp;</td>
    		<td width="741" valign="top" class="rightbian">
    		<form onsubmit="ajaxSubmitForm(this, true)" action="<%=path %>/exam/examEnd" method="post">
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
    				<tr>
    					<td colspan="3">
    						<div align="center">
    							<input type="submit" value="提交答卷" name="submit">
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
