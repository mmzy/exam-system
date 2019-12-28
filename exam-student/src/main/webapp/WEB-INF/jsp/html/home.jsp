<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=path%>/css/home.css" type="text/css" />

<script type="text/javascript" src="<%=path%>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=path%>/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="<%=path%>/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=path%>/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=path%>/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="<%=path%>/js/common.js"></script>
<script type="text/javascript" src="<%=path%>/js/home.js"></script>

<link href="<%=path%>/skin/default/skin.css" rel="stylesheet" type="text/css" id="skin" />
<title>在线考试后台管理系统</title>
</head>
<body>
  <div class="content-div">
    <div class="title">
      <i></i>
      <span>湖南省安全生产培训理论考试平台</span>
    </div>
    <div class="panel">
      <div class="posi-label">座位号</div>
      <div class="posi-num">001</div>
      <div class="enter-btn" onClick="Home.clickEnter()">进入系统</div>
    </div>
    <div class="footer-div">
      <p>湖南省应急管理厅</p>
      <p>？？市广联科技有限公司</p>
    </div>
  </div>
</body>
</html>