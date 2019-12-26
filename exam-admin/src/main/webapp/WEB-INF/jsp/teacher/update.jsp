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

<title>修改老师</title>
</head>
<body>
<div class="pd-20">
    <form onsubmit="ajaxSubmitForm(this, true)" action="<%=path %>/teacher/update" class="form form-horizontal">
        <input type="hidden"  name="id" value="${teacher.id }"/>
        
        <div class="row cl">
            <label class="form-label col-2">姓名</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" name="name" value="${teacher.name }"/>
            </div>
            <div class="col-5"></div>
        </div>

        <div class="row cl">
            <label class="form-label col-2">性别</label>
            <div class="col-10">
                <input id="male" name="sex" type="radio" value="1" checked="checked" /><label for="male">男</label>&nbsp;&nbsp;&nbsp;&nbsp;
                <input id="female" name="sex" type="radio" value="0" /><label for="female">女</label>
            </div>
        </div>
        
        <div class="row cl">
            <label class="form-label col-2">年龄</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" name="age" value="${teacher.age }"/>
            </div>
            <div class="col-5"></div>
        </div>
        
         <div class="row cl">
            <label class="form-label col-2">身份证号</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" name="idcard" value="${teacher.idcard }"/>
            </div>
            <div class="col-5"></div>
        </div>
        
         
        <div class="row cl">
            <label class="form-label col-2">QQ</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" name="qq"  value="${teacher.qq }"/>
            </div>
            <div class="col-5"></div>
        </div>
        
         <div class="row cl">
            <label class="form-label col-2">手机</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" name="phone" value="${teacher.phone }"/>
            </div>
            <div class="col-5"></div>
        </div>
       
        
        <div class="row cl">
            <label class="form-label col-2">邮箱</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" name="email" value="${teacher.email }"/>
            </div>
            <div class="col-5"></div>
        </div> 
        
        <div class="row cl">
            <div class="col-9 col-offset-2">
                <input class="btn btn-primary radius" type="submit" value="修改" />
                <input class="btn btn-default radius" type="button" value="关闭" onclick="parent.location.reload()" style="margin-left: 30px;" />
            </div>
        </div>
    </form>
</div>
</body>
</html>