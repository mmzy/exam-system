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
<link rel="stylesheet" href="<%=path%>/css/login.css" type="text/css" />

<script type="text/javascript" src="<%=path%>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=path%>/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="<%=path%>/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=path%>/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=path%>/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="<%=path%>/js/common.js"></script>

<title>在线考试后台管理系统</title>
</head>
<script type="text/javascript">
var examId = "${publishexam.id}"
function loginClickEnter() {
	window.location.href = '/html/rule?id=' + examId;
}
</script>
<body>
  <div class="content">
    <div class="title">
      <i></i>
      <span>湖南省安全生产培训理论考试平台</span>
    </div>
    <div class="sit-number">
        <span>座位号：</span>
        <span>${studentInfo.id}</span>
    </div>
    <div class="panel">
      <div class="avtar"></div>
      <div class="examinee-info">
          <table>
              <tbody>
                  <tr><td class="labelname">考生姓名：</td><td>${studentInfo.name}</td></tr>
                  <tr><td class="labelname">准考证号：</td><td>${studentInfo.id}</td></tr>
                  <tr><td class="labelname">身份证号：</td><td>${studentInfo.idcard}</td></tr>
                  <tr><td class="labelname">人员类别：</td><td>${studentInfo.classesname}</td></tr>
                  <tr><td class="labelname">考试科目：</td><td>${publishexam.subjectName}</td></tr>
              </tbody>
          </table>
          <div class="enter-btn" onClick="loginClickEnter()">确认登录</div>
      </div>
    </div>
    <div class="footer">
      <p>湖南省应急管理厅</p>
    </div>
  </div>
</body>
</html>