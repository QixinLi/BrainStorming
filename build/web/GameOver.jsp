<%-- 
    Document   : GameOver
    Created on : 2018-4-7, 0:30:07
    Author     : lee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>游戏结束</title>
        <link type="text/css" rel="stylesheet"  href="css/GameOver.css" />
        <script type="text/javascript" src="js/GameOver.js"></script>
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
String score;
%>
<%    
    score = request.getParameter("score");    
%> 
<script>
    var score=<%=score%>;
    var shareMsg;
    if(score>=3&&score<=10)
    {
        shareMsg="啊呦，不错哦~本局连续答对"+score+"道题。";
    }
    else if(score>10)
    {
        shareMsg="哇哦！居然连续答对"+score+"道题，你的头脑是开挂了吧！";
    }
    else if(score>0&&score<3)
    {
        shareMsg="这次只答对"+score+"道题。不过不要气馁，下次一定会更棒！";
    }
    else{
        shareMsg="一道题也没有答对~革命尚未成功，同志仍需努力~";
    }
</script>
    <body onload="AutoLoad()" onresize="changeWindowAuto()">
        <div id="mainPanel" class="absol">
            
            <div id="shareImg" class="absol">
                <img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523093534326&di=f0e34f0b961a5d0652abdedfcbf2ec3c&imgtype=0&src=http%3A%2F%2Fimage.woshipm.com%2Fwp-files%2F2016%2F03%2F6512bd43d9caa6e02c990b0a82652dca.png">
            </div>
            
            <div id="shareMsg" class="absol"></div>
            
            <button id="shareBt" class="absol" onclick="clickBack()">返回主页</button>
            
            <div id="bdshare" class="bdshare_t bds_tools get-codes-bdshare absol">
            <a href="#" class="bds_more" data-cmd="more">分享到：</a>
            <a href="#" class="bds_sqq" data-cmd="sqq" title="分享到QQ好友">QQ</a>
            <a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间">QQ空间</a>
            <a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博">新浪微博</a>
            
            </div>
        </div>
        
        
<script type="text/javascript" id="bdshare_js" data="type=tools&mini=1" ></script> 
<script type="text/javascript" id="bdshell_js"></script> 
<script>
    $("#shareMsg").text(shareMsg);
    var shareString="我在头脑风暴一局斩获"+score+"分，你也来试试吧！";
    var bds_config = {
            "bdText": shareString,
            "bdDesc": "头脑风暴，谁敢来战！",
            "bdMini": "2",
            "bdMiniList": false,
            "bdPic": "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523093534326&di=f0e34f0b961a5d0652abdedfcbf2ec3c&imgtype=0&src=http%3A%2F%2Fimage.woshipm.com%2Fwp-files%2F2016%2F03%2F6512bd43d9caa6e02c990b0a82652dca.png",
            "url": "http://47.96.162.8:8080/AnswerSheet/",
            "bdStyle": "0",
            "bdSize": "24"
    };
    document.getElementById('bdshell_js').src = "http://share.baidu.com/static/js/shell_v2.js?cdnversion=" + Math.ceil(new Date()/3600000);
</script>
    </body>
</html>
