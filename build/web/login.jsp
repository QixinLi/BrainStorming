<%-- 
    Document   : index
    Created on : 2018-3-31, 13:58:45
    Author     : lee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登录</title>
        <link type="text/css" rel="stylesheet"  href="css/login.css" />
        <script type="text/javascript" src="js/login.js"></script>
        <!--弹出层 开始 -->
        <link type="text/css" rel="stylesheet"  href="css/reset.css" />
	<link type="text/css" rel="stylesheet" href="css/zdialog.css" />
	<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="js/zdialog.js"></script>
	<!--弹出层 结束 -->
        <meta name="viewport"
    	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="content-type" content="text/html charset=utf-8"> 
    </head>
<%
String iscorrect="1";
String username="null";
%>
<%    
    String flag = request.getParameter("errNo");    
    if(flag!=null)
        iscorrect="0";
%> 
    
    <body onload="AutoLoad()" onresize="changeWindowAuto()">
        <form action ="login" method="post"> 
            <div id="loginDiv" class="absol">
                
                <div id="logo" class="absol">
                    <img src="images/logo.jpg">
		</div>
                
                <div id="usernameimg" class="absol" >
                    <img src="images/mobileicon.png">
		</div>
		<div id="passwordimg" class="absol">
                    <img src="images/keyicon.png">
		</div>
                
                <input type="text" id="tel" name="tel"  class="absol" maxlength=11 placeholder="账号">
                <input type="password" id="pwd" name="pwd" class="absol" placeholder="密码">
                <input type="submit" id="signin" class="absol" value="登录">

                <div id="signup" class="absol">还没有账号？ <span style="color:#ffffff" onclick="clickSignUpBt()">马上注册</span> </div>
            </div>
        </form>
        
<script>
(function(){
    var username = '<%= username %>';
	if(<%= iscorrect %> == "0")
	{
            $.DialogByZ.Alert({Title:"提示",Content:"账号密码有误！",BtnL:"确认",FunL:alerts});
	}
})(); 
</script>
    </body>
    
</html>
