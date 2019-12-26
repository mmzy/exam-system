<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script>
    //定义函数myClose关闭当前窗口
    function myClose(){
        //将id为time的元素的内容转为整数，保存在变量n中
        var n=parseInt(time.innerHTML);
        n--;//将n-1
        //如果n==0,关闭页面
        //否则, 将n+秒钟后自动关闭，再保存回time的内容中
        if(n>0){
            time.innerHTML=n+"秒钟后自动关闭该网页";
            timer=setTimeout(myClose,1000);
        }else{
        	parent.location.reload();
        }
    }
    var timer=null;
    //当页面加载后，启动周期性定时器，每过1秒执行myClose
    window.onload=function(){
        timer=setTimeout(myClose,1000);
    }
</script>
  <body>
  	<span style="font-size:20px">${message },</span><span id="time"  style="font-size:20px">5秒钟后自动关闭该网页</span><br>
  </body>
</html>
