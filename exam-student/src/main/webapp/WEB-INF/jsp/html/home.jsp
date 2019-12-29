<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<link rel="stylesheet" href="<%=path%>/css/home.css" type="text/css" />
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

<title>在线考试后台管理系统</title>
<script type="text/javascript">
var examId = "${publishexam.id}"
function homeClickEnter() {
  	window.location.href = '/html/login?id=' + examId;
}
</script>
</head>

<body>
  <div class="content-div">
    <div class="title">
      <i></i>
      <span>湖南省安全生产培训理论考试平台</span>
    </div>
    <div class="panel">
      <div class="posi-label">座位号</div>
      <div class="posi-num">${studentInfo.id}</div>
      <div class="enter-btn" onClick="homeClickEnter()">进入系统</div>
    </div>
    <div class="footer-div">
      <p>湖南省应急管理厅</p>
      <p>？？市广联科技有限公司</p>
    </div>
  </div>
</body>
</html>