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
        <script type="text/javascript" src="js/GameOver.js"></script>
        <link type="text/css" rel="stylesheet"  href="css/GameOver.css" />
        
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
<script type="text/javascript" id="bdshare_js" data="type=tools&mini=1" ></script> 
<script type="text/javascript" id="bdshell_js"></script> 
    <body onload="AutoLoad()" onresize="changeWindowAuto()">
        <div id="mainPanel" class="absol">
            
            <div id="shareImg" class="absol">
                <img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523093534326&di=f0e34f0b961a5d0652abdedfcbf2ec3c&imgtype=0&src=http%3A%2F%2Fimage.woshipm.com%2Fwp-files%2F2016%2F03%2F6512bd43d9caa6e02c990b0a82652dca.png">
            </div>
            
            <div id="shareMsg" class="absol"></div>
            
            <button id="shareBt" class="absol" onclick="clickBack()">返回主页</button>
            
            <div class="bdsharebuttonbox absol" data-tag="share_1">
                <a class="bds_mshare" data-cmd="mshare"></a>
                <a class="bds_sqq" data-cmd="sqq" href="#"></a>
                <a class="bds_qzone" data-cmd="qzone"></a>
                <a class="bds_weixin" data-cmd="weixin"></a>
                <a class="bds_more" data-cmd="more">更多</a>
            </div>
            <div id="beian" class="absol" >
                <a  style="position: relative;color: #999" rel="nofollow"target="_blank"  href="http://www.miitbeian.gov.cn/">苏ICP备18023434号</a>
                <img width="13" style="position: relative;width:13px;height:16px" height="16" src="http://ss.bdimg.com/static/superman/img/copy_rignt_24.png">
            </div>
        </div>
        
        

<script>
    $("#shareMsg").text(shareMsg);
    
    var bddesc="我这次在头脑风暴连续答对"+score+"题。你也来试试吧！";
	window._bd_share_config = {
		common : {
			bdText : '头脑风暴，等你来战',	
			bdDesc : bddesc,	
			bdUrl : 'http://47.96.162.8:8080/AnswerSheet/', 	
			bdPic : 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523093534326&di=f0e34f0b961a5d0652abdedfcbf2ec3c&imgtype=0&src=http%3A%2F%2Fimage.woshipm.com%2Fwp-files%2F2016%2F03%2F6512bd43d9caa6e02c990b0a82652dca.png'
		},
		share : [{
			"bdSize" : 32
		}],
		slide : [{	   
			bdImg : 0,
			bdPos : "right",
			bdTop : 100
		}],
		image : [{
			viewType : 'list',
			viewPos : 'top',
			viewColor : 'black',
			viewSize : '16',
			viewList : ['sqq','qzone','tsina','weixin']
		}]
	}
	with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?cdnversion='+~(-new Date()/36e5)];
</script>
    </body>
</html>
