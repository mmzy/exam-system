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
<link rel="stylesheet" href="<%=path%>/css/rule.css" type="text/css" />

<script type="text/javascript" src="<%=path%>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=path%>/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="<%=path%>/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=path%>/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=path%>/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="<%=path%>/js/common.js"></script>
<script type="text/javascript" src="<%=path%>/js/rule.js"></script>

<link href="<%=path%>/skin/default/skin.css" rel="stylesheet" type="text/css" id="skin" />
<title>在线考试后台管理系统</title>
</head>
<body>
  <div class="content">
    <div class="title">
      <div>考场须知</div>
      <div class="subtitle">请仔细阅读(19秒)</div>
    </div>
    <div class="panel">
      <p>一、考生进入考场禁止携带各种参考资料和通讯工具，考场内已开启视频监控。</p>
      <p>二、考生按照考官或监考人员指定座位对号入座，将准考证、身份证等有效证件放在明显位置，以备查对。</p>
      <p>
          三、考生应严格遵守考场纪律和考试程序，不得有抄袭、替考、扰乱考场秩序等违规、舞弊行为，一经发现将
          记入考场记录表，并按《湖南省安全生产培训考生违纪违规行为处理方法》等规定予以处理。
      </p>
      <p>四、对违纪已提醒考生，考官如再次发现类似行为，将对该考生进行强制收卷。</p>
      <p>五、考生必须服从考官和监考人员的安排，在考试过程中，考官有权对考生进行提醒、强制收卷。</p>
      <p>六、本场考试时间为120分钟，考生点击“确认登录”后开始计时，考试过程中如有问题，举手反馈监考人员。</p>
      <p>
          七、答题界面右上角显示本场考试剩余时间，考生完成答题后，可以点击“交卷”按钮，即使获取考试分数，
          当考试剩余时间为0时，系统将自动提交试卷并显示得分。
      </p>
      <p>八、考试结束后，考生不得在考场内逗留、交谈，不得再返回考场。</p>
    </div>
  </div>
</body>
</html>