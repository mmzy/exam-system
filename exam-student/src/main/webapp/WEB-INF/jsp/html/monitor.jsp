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
<link rel="stylesheet" href="<%=path%>/css/monitor.css" type="text/css" />

<script type="text/javascript" src="<%=path%>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=path%>/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="<%=path%>/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=path%>/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=path%>/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="<%=path%>/js/common.js"></script>
<script type="text/javascript" src="<%=path%>/js/monitor.js"></script>

<link href="<%=path%>/skin/default/skin.css" rel="stylesheet" type="text/css" id="skin" />
<title>在线考试后台管理系统</title>
</head>
<body>
  <div class="content">
    <div class="left">
      <div class="left-title">考试平台</div>
      <div class="test-grid">
        <table class="exam-table">
            <thead>
              <tr><td>姓名</td><td>准考证</td><td>状态</td></tr>
            </thead>
            <tbody id="exam-body">
            </tbody>
        </table>
      </div>
    </div>
    <div class="top">
      <span class="top-title">长沙煤矿安全技术培训中心</span>
      <span class="top-name">刘琛</span>
      <span class="top-role">[考官]</span>
      <i class="logout-icon" onClick="Monitor.doLogout()"></i>
      <span class="logout" onClick="Monitor.doLogout()">退出</span>
    </div>
    <div class="main" id="main">
    </div>
  </div>
</body>
</html>