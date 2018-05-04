<%-- 
    Document   : Start
    Created on : 2018-4-6, 22:56:44
    Author     : lee
--%>
<%@ page language="java" import="java.util.*,java.sql.*,java.net.*"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<script>
        var numofCorrect=0;//回答正确的题数
        var score=0;//玩家总分
        var username;//玩家名
        var correctAns;
        var canClick=true;
</script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src='<%=request.getContextPath()%>/dwr/engine.js'></script>
        <script src='<%=request.getContextPath()%>/dwr/interface/getQues.js'></script>
        <script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
        
        <script type="text/javascript" src="js/Start.js"></script>
        <link type="text/css" rel="stylesheet" href="css/Start.css" />
        <!--弹出层 开始 -->
	<link type="text/css" rel="stylesheet" href="css/zdialog.css" />
	<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="js/zdialog.js"></script>
	<!--弹出层 结束 -->
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        
        <title>头脑风暴</title>
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
        <div id="gameDiv" class="absol">
            <div id="score" class="absol">0</div>
            <div id="title" class="absol"></div>
            <div id="classes" class="absol">类别：天文</div>
            <button id="optA" class="absol button" onclick="clickA()">选项A</button>
            <button id="optB" class="absol button" onclick="clickB()">选项B</button>
            <button id="optC" class="absol button" onclick="clickC()">选项C</button>
            <button id="optD" class="absol button" onclick="clickD()">选项D</button>
            <div id="user" class="absol">内容来源于网络</div>
            <div id="beian" class="absol" >
                <a  style="position: relative;color: #999" rel="nofollow"target="_blank"  href="http://www.miitbeian.gov.cn/">苏ICP备18023434号</a>
                <img width="13" style="position: relative;width:13px;height:16px" height="16" src="http://ss.bdimg.com/static/superman/img/copy_rignt_24.png">
            </div>
        </div>
<script>
(function(){
    username = '<%= username %>';
    score = <%= score %>;
    if( username !== "null")
    {
        getQues.getOneQues(callBack);
    }
    else
    {
        $.DialogByZ.Alert({Title:"提示",Content:"登录信息失效，请重新登录！",BtnL:"确认",FunL:alertsTologin});
    }
})(); 
</script>
    </body>
</html>
