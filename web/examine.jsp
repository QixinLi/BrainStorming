<%-- 
    Document   : examine
    Created on : 2018-4-19, 21:46:34
    Author     : C
--%>

<%@page import="java.net.URLDecoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src='<%=request.getContextPath()%>/dwr/engine.js'></script>
        <script src='<%=request.getContextPath()%>/dwr/interface/examineQ.js'></script>
        <script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
        <!--调用DWR-->
        <script type="text/javascript" src="js/examine.js"></script>
        <link type="text/css" rel="stylesheet" href="css/Start.css" />
        <!--弹出层 开始 -->
	<link type="text/css" rel="stylesheet" href="css/zdialog.css" />
	<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="js/zdialog.js"></script>
	<!--弹出层 结束 -->
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        
        <title>审核页面</title>
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
                    //读取cookie
                    username=URLDecoder.decode(cookie.getValue(),"UTF-8");
                }
                if(("score").equals(cookie.getName()))
                {
                    score=URLDecoder.decode(cookie.getValue(),"UTF-8");
                }
            }
        }
    %>
        <title>JSP Page</title>
    </head>
        <!--静态网页框架-->
    <body onload="AutoLoad()" onresize="changeWindowAuto()">
        <div id="gameDiv" class="absol">
            <button id="score" class="absol" onclick="save()">
                保存修改
            </button>
            <button id="examine_img_bt_p" onclick="click_pass()">
                <img id="examine_img_div" class="examine_img_class" style="width: 60px;height: 60px" src="images/pass.png">
            </button>
            <button id="examine_img_bt_up" onclick="click_unpass()">
                <img id="examine_img_div" class="examine_img_class" style="width: 60px;height: 60px" src="images/unpass.png">
            </button>
            
            <div id="title" class="absol"></div>
            <div id="classes" class="absol">类别：天文</div>
            <button id="optA" class="absol button" >选项A</button>
            <button id="optB" class="absol button" >选项B</button>
            <button id="optC" class="absol button" >选项C</button>
            <button id="optD" class="absol button" >选项D</button>
            <div id="user" class="absol">内容来源于网络</div>
        </div>
<script>
<!-- 向服务器请求数据-->
(function(){
    username = '<%= username %>';
    score = <%= score %>;

    if( username !== "null")
    {
        examineQ.LoadOneQues(callBack);
    }
    else
    {
        $.DialogByZ.Alert({Title:"提示",Content:"登录信息失效，请重新登录！",BtnL:"确认",FunL:alertsTologin});
    }
})(); 
</script>
    </body>
</html>

