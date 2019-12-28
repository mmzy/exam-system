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
<link rel="stylesheet" href="<%=path%>/css/test.css" type="text/css" />

<script type="text/javascript" src="<%=path%>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=path%>/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="<%=path%>/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=path%>/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=path%>/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="<%=path%>/js/common.js"></script>
<script type="text/javascript" src="<%=path%>/js/test.js"></script>

<link href="<%=path%>/skin/default/skin.css" rel="stylesheet" type="text/css" id="skin" />
<title>在线考试后台管理系统</title>
</head>
<body>
  <div class="top">
            <i class="top-icon"></i>
            <span class="top-title">湖南省安全生产培训考试系统</span>
        </div>
        <div class="middle">
            <i class="mpic"></i>
            <div class="minfo">
                <div class="minfo-name">媛媛</div>
                <div class="minfo-examid">
                    <span>准考证号：</span>
                    <span>123445</span>
                </div>
                <div class="minfo-cardid">
                    <span>身份证号：</span>
                    <span>123445299222222222</span>
                </div>
                <div class="minfo-type">
                    <span>人员类别：</span>
                    <span>主要负责人</span>
                </div>
                <div class="minfo-project">
                    <span>考试科目：</span>
                    <span>危险化学品生产单位</span>
                </div>
            </div>
            <div class="mtime">
                <div class="remain-time">
                    <span>14</span>
                    <span class="remain-time-colon">:</span>
                    <span>20</span>
                </div>
                <div class="remain-time-label">
                    <span>时</span>
                    <span>分</span>
                </div>
                <div id="ok" onclick="Test.submit()">交卷</div>
            </div>
        </div>
        <div class="bottom">
            <div class="bottom-left">
                <div class="single">
                    <div class="ques-title">单选题</div>
                    <div class="ques-index" id="single-index"></div>
                </div>
                <div class="judge">
                    <div class="ques-title">判断题</div>
                    <div class="ques-index" id="judge-index"></div>
                </div>
            </div>
            <div class="bottom-right">
                <div class="br-top">
                    <span class="br-top-title" id="quesType">单选题</span>
                    <span>（共</span>
                    <span id="quesNum">0</span>
                    <span>题，本题</span>
                    <span id="quesScore">1</span>
                    <span>分）</span>
                    <input type="checkbox" name="mark" id="mark" />
                    <label for="mark">标记</label>
                    <i class="br-icon"></i>
                </div>
                <div class="br-main">
                    <span class="br-main-index">1</span>
                    <div class="br-main-ques-container">
                        <p class="br-main-ques" id="question">
                            问题描述：可视对讲福克斯荆防颗粒时代峻
                            峰考虑是否健康数据福克斯的积分开发圣诞节快乐
                            开始觉得分开了第三方律师代理费克雷登斯放得开飞机上的可乐放
                        </p>
                    </div>
                    <div class="br-main-asw-title">答案区</div>
                    <div class="br-main-asw-content" id=answer></div>
                </div>
                <div class="br-bottom">
                    <div class="btn">上一题</div>
                    <div class="btn">下一题</div>
                    <div class="btn">显示标记</div>
                </div>
            </div>
        </div>
</body>
</html>