<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<script type="text/javascript">
		$(function(){
			//科目的下拉框change事件
			$("#subjectid").change(function(){
				var subjectid = $("#subjectid").val();
				$.ajax({
					type:"POST",
					url:"<%=path%>/text/showChapter",
					data:{
						id:subjectid
					},
					dataType:"json",
					success:function(data){
						$("#chapterid").empty();
						$.each(data,function(index,item){
							$("#chapterid").append("<option value='"+item.id+"'>"+item.name+"&nbsp;&nbsp;&nbsp;"+item.title+"</option>");
						})
					}
				})
			}
					
			)
			
		})
	</script>
	
	<!-- 当是选择题时出现选择题ABCD框，否则不显示 -->
	<script type="text/javascript">
		//初始情况
		$(function(){
			var model = $("#texId option:selected").text();
			if (model != "选择题"){
				$("#type1,#type2,#type3,#type4").hide();
			}
			
			//当试题模块内容改变
			$("#texId").change(function(){
				var model = $("#texId option:selected").text();
				if (model != "选择题"){
					$("#type1,#type2,#type3,#type4").hide();
				}else{
					$("#type1,#type2,#type3,#type4").show();
				}
			})
			
		})
	</script>
	
<title>添加试题</title>
</head>
<body>
<div class="pd-20">
    <form action="" class="form form-horizontal">   
        <div class="row cl">
            <label class="form-label col-2">试题科目</label>
            <div class="formControls col-5">
                <select class="input-text" id="subjectid" name="subjectid">
                	<c:forEach items="${textList }" var="subject">
                		<option value="${subject.id }"
                			<c:if test="${subject.id == text.subjectid }">
                				selected = 'selected'
                			</c:if>
                		>${subject.name }</option>
                	</c:forEach>
                </select>
            </div>
            <div class="col-5"></div>
        </div>
        
        <div class="row cl">
            <label class="form-label col-2">试题章节</label>
            <div class="formControls col-5">
                <select class="input-text" id="chapterid" name="chapterid">
                	<c:forEach items="${chapterList }" var="chapter">
                		<option value="${chapter.id }"
                			<c:if test="${chapter.id == text.chapterid }">
                				selected = 'selected'
                			</c:if>
                		>${chapter.name } &nbsp;&nbsp;&nbsp; ${chapter.title }</option>
                	</c:forEach>
                </select>
            </div>
            <div class="col-5"></div>
        </div>
    
        <div class="row cl">
            <label class="form-label col-2">试题模块</label>
            <div class="formControls col-5">
            	<select class="input-text" id="texId" name="texId">
                	<c:forEach items="${textModelList }" var="textModel">
                		<option value="${textModel.id }"
                			<c:if test="${text.texId == textModel.id }">
                				selected = 'selected'
                			</c:if>
                		>${textModel.texttype }</option>
                	</c:forEach>
                </select>
            </div>
            <div class="col-5"></div>
        </div>
        
        <div class="row cl">
            <label class="form-label col-2">试题难度</label>
            <div class="formControls col-5">
            	<select class="input-text" id="diffculty" name="diffculty">
                	<option value="1"
                		<c:if test="${text.diffculty == 1 }">
                				selected = 'selected'
                		</c:if>
                	>简单</option>
                	<option value="2"
                		<c:if test="${text.diffculty == 2 }">
                				selected = 'selected'
                		</c:if>
                	>一般</option>
                	<option value="3"
                		<c:if test="${text.diffculty == 3 }">
                				selected = 'selected'
                		</c:if>
                	>困难</option>
                </select>
            </div>
            <div class="col-5"></div>
        </div>
        
        <div class="row cl">
            <label class="form-label col-2">题目</label>
            <div class="formControls col-5">
            <textarea name="title" id="title" class="textarea">${text.title }</textarea>
            </div>
            <div class="col-5"></div>
        </div>
        
        <!-- 选择题显示下面四个文本框 -->
	        <div class="row cl" id="type1">
	            <label class="form-label col-2">A选项</label>
	            <div class="formControls col-5">
	            	<input type="text" class="input-text" name="type1" value="${text.type1 }" />
	            </div>
	            <div class="col-5"></div> 
	        </div>
	        
	        <div class="row cl" id="type2">
	            <label class="form-label col-2">B选项</label>
	            <div class="formControls col-5">
	            	<input type="text" class="input-text" name="type2" value="${text.type2 }" />
	            </div>
	            <div class="col-5"></div> 
	        </div>
	        
	        <div class="row cl" id="type3">
	            <label class="form-label col-2">C选项</label>
	            <div class="formControls col-5">
	            	<input type="text" class="input-text" name="type3" value="${text.type3 }"  />
	            </div>
	            <div class="col-5"></div> 
	        </div>
	        
	        <div class="row cl" id="type4">
	            <label class="form-label col-2">D选项</label>
	            <div class="formControls col-5">
	            	<input type="text" class="input-text" name="type4" value="${text.type4 }" />
	            </div>
	            <div class="col-5"></div> 
	        </div>
        
        <div class="row cl">
            <label class="form-label col-2">答案</label>
            <div class="formControls col-5">
            <textarea name="answer" class="textarea">${text.answer }</textarea>
            </div>
            <div class="col-5"></div>
        </div>
        
    </form>
</div>
</body>
</html>