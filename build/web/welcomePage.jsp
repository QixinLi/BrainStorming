<%-- 
    Document   : welcomePage
    Created on : 2018-4-3, 16:47:41
    Author     : lee
--%>
<%@ page language="java" import="java.util.*,java.sql.*,java.net.*"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>欢迎来到头脑风暴</title>
        <link type="text/css" rel="stylesheet" href="css/welcomePage.css" />
        <script type="text/javascript" src="js/welcomPage.js"></script>
        <!--弹出层 开始 -->
	<link type="text/css" rel="stylesheet" href="css/zdialog.css" />
	<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="js/zdialog.js"></script>
	<!--弹出层 结束 -->
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    </head>
    <%
        String username="null";
        String score="null";
    %>
    <%
        Cookie cookie = null;
        Cookie[] cookies = null;
             // 获取当前域名下的cookies，是一个数组
        cookies = request.getCookies();
        if(cookies!=null)
        {
            for(int i=0;i<cookies.length;i++)
            {
                cookie = cookies[i];
                if(("name").equals(cookie.getName()))
                {
                    username=URLDecoder.decode(cookie.getValue(),"UTF-8");
                }
                if(("score").equals(cookie.getName()))
                {
                    score=URLDecoder.decode(cookie.getValue(),"UTF-8");
                }
            }
        }
    %>
    <body onload="AutoLoad()" onresize="changeWindowAuto()">
        <div id="loginDiv">
            <div id="userDetails">
                <div id="userimg">
                    <img src="images/logo.jpg">
                </div>
                <p id="username">昵称：</p>
                <p id="userscore">积分：</p>
                <a id="welcomemsg">超级蓝月，脱胎换"古"</a>
            </div>
            <div id="btPanel">
                <button id="start" class="bubbly-button">开始游戏</button>
                <button id="newQues" class="bubbly-button">我要出题</button>
                <button id="sendReport" class="bubbly-button">反馈问题</button>
            </div>
        </div>
        <script>
(function(){
    var username = '<%= username %>';
    var score = <%= score %>;
        if( username !== "null")
        {
            $("#username").text("昵称："+username);
            $("#userscore").text("积分："+score);
        }
        else
        {
            $.DialogByZ.Alert({Title:"提示",Content:"登录信息失效，请重新登录！",BtnL:"确认",FunL:alerts});
        }
})(); 
</script>
    </body>
    <script type="text/javascript" src="js/welcomePage.js"></script>
</html>
