<%-- 
    Document   : signup
    Created on : 2018-3-9, 21:16:54
    Author     : lee
--%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%@ page contentType="text/html;charset=utf-8"%> 
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<base href="<%=basePath%>">  
	<title>注册</title>
	<link rel="stylesheet" href="css/register.css">
	<script type="text/javascript" src="js/register.js"></script>
	<link type="text/css" rel="stylesheet"  href="css/reset.css" />
	<!--弹出层 开始 -->
	<link type="text/css" rel="stylesheet" href="css/zdialog.css" />
	<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="js/zdialog.js"></script>
	<!--弹出层 结束 -->
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	
	<script>  
        function addCheck(){  
            var telreg = /^1[34578]\d{9}$/;
            var username=document.getElementById("username").value;  
            var password=document.getElementById("password").value;  
            var repassword=document.getElementById("repassword").value;
            var name=document.getElementById("name").value;
            if(username==""){  
            	$.DialogByZ.Alert({Title:"提示",Content:"账号不能为空！",BtnL:"确认",FunL:alerts});
                document.getElementById("username").focus();    
                return false;  
            }
            if(password==""){  
            	$.DialogByZ.Alert({Title:"提示",Content:"密码不能为空！",BtnL:"确认",FunL:alerts});
                document.getElementById("password").focus();  
                return false;  
            } 
            if(password != repassword){  
            	$.DialogByZ.Alert({Title:"提示",Content:"两次输入密码不一致！",BtnL:"确认",FunL:alerts});
                document.getElementById("repassword").focus();  
                return false;  
            }  
            if(name==""){
            	$.DialogByZ.Alert({Title:"提示",Content:"不给自己起一个响亮而又霸气的名字？",BtnL:"确认",FunL:alerts});
                document.getElementById("name").focus();  
                return false;  
            }
        }  
        function validate(){  
            var flag = addCheck();  
            if(flag == false)  
                return false;  
            return true;  
        }
    </script> 
    
</head>
<%
String getReturn="null";
%>
<%    
    String flag = request.getParameter("return");    
    if(flag!=null)
    {
        getReturn=flag;
    }
%> 
<body onresize="changeWindowAuto()" onload="AutoLoad()">
    <div id="login" class="absol">
			<div id="logo" class="absol">
				<img src="images/logo.png">
			</div>
			
			<form action = "register" method = "post" onsubmit = "return validate()"> 
			
				<input type="text" id="username" name="username" placeholder="账号" class="absol" maxlength=11>
				<input type="password" id="password" name="password" placeholder="密码" class="absol" >
				<input type="password" id="repassword" name="repassword" placeholder="确认密码" class="absol" >
				<input type="text" id="name" name="name" placeholder="昵称" class="absol" >
				<input type="submit" id="signup" class="absol" value="注册">
				
			</form>
			<div id="signin" class="absol">已有账号？ <span style="color:#ffffff" onclick="clickSignInBt()">马上登录</span> </div>
                <div id="beian" class="absol" >
                    <a  style="position: relative;color: #999" rel="nofollow"target="_blank"  href="http://www.miitbeian.gov.cn/">苏ICP备18023434号</a>
                    <img width="13" style="position: relative;width:13px;height:16px" height="16" src="http://ss.bdimg.com/static/superman/img/copy_rignt_24.png">
                </div>
    </div>

<script>
(function(){
    var username = '<%=getReturn %>';
    if(username!=="null")
    {
        if(username==="0")
	{
            $.DialogByZ.Alert({Title:"提示",Content:"注册成功，正在跳转到登录页面！",BtnL:"确认",FunL:alerts_tologin});
	}
        else if(username==="1")
        {
            $.DialogByZ.Alert({Title:"提示",Content:"该用户名已经存在，请重新输入！",BtnL:"确认",FunL:alerts});
        }
        else if(username==="2")
        {
            $.DialogByZ.Alert({Title:"提示",Content:"注册失败！",BtnL:"确认",FunL:alerts});
        }
    }
})(); 
</script>
</body>
</html>