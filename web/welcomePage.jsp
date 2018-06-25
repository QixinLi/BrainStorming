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
        
        <script src='<%=request.getContextPath()%>/dwr/engine.js'></script>
        <script src='<%=request.getContextPath()%>/dwr/interface/getUserImg.js'></script>
        <script src='<%=request.getContextPath()%>/dwr/interface/getUserMsg.js'></script>
        <script src='<%=request.getContextPath()%>/dwr/interface/friend.js'></script>
        <script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
        
        <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
        <script type="text/javascript" src='js/jquery-ui.min.js'></script>
        <link type="text/css" rel="stylesheet" href="css/welcomePage.css"/>
        <!--弹出层 开始 -->
	<link type="text/css" rel="stylesheet" href="css/zdialog.css" />
	<script type="text/javascript" src="js/zdialog.js"></script>
	<!--弹出层 结束 -->
        <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
        <link type="text/css" rel="stylesheet" href="css/mailmsg.css" />
	
        
        <script type="text/javascript" src="js/welcomePage.js"></script>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    </head>
    <%
        String tel="null";
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
                if(("tel").equals(cookie.getName()))
                {
                    tel=URLDecoder.decode(cookie.getValue(),"UTF-8");
                }
            }
        }
    %>
    <body onload="AutoLoad()" onresize="changeWindowAuto()">
        <div id="loginDiv">
            
            <div id="loginBg"></div>
            <div id="userDetails">
                <div id="mail" onclick="showMailandGetMsg()">
                    <img id="mailimg" src="images/mail.png">
                </div>
                <div id="friend" onclick="showFriend()">
                    <img src="images/friend.png">
                </div>
                <label id="userimg">
                    <img  id="touxiang" src="images/logo.png">
                    <input type="hidden" id="img" name="uploadImg"/>  
                    <input type="file" id="uploadImg" onchange="selectImg(this);" accept="image/*"/>  
                </label>
                <p id="username" onclick="gotoAdminPage()">昵称：</p>
                <p id="userscore" class="muserscore">积分：</p>
                <a id="welcomemsg">头脑风暴，脑力沙龙</a>
            </div>
            <div id="btPanel">
                <button id="start" class="bubbly-button">开始游戏</button>
                <button id="newQues" class="bubbly-button">我要出题</button>
                <button id="sendReport" class="bubbly-button">反馈问题</button>
                <button id="getHb" class="bubbly-button">红包拿来</button>
            </div>
            <div id="beian" style="position: absolute" >
                <a  style="position: relative;color: #999" rel="nofollow"target="_blank"  href="http://www.miitbeian.gov.cn/">苏ICP备18023434号</a>
                <img width="13" style="position: relative;width:13px;height:16px" height="16" src="http://ss.bdimg.com/static/superman/img/copy_rignt_24.png">
            </div>
            <button id="logout" onclick="window.location='login.jsp'">注销</button>
        </div>
        
        <div id="mailMsg" class="chat">
            <header>
                <h2 class='title'>我的消息</h2>
            </header>
            <div class='body' id="mymsg">

            </div>
            <footer>
                <a onclick="readAllMsg()">全部已读</a><a onclick="showMailMsg()">关闭</a>
            </footer>
        </div>
        
        <div id="myFriend" class="chat">
            <header>
                <h2 class='title'>好友列表</h2>
            </header>
            <img class="loadingimg" src="images/loading.gif">
            <div class='body' id="mybuddy">
            </div>
            <footer>
                <a onclick="addFriend()">添加好友</a><a onclick="showFriend()">关闭</a>
            </footer>
        </div>
        
        <div id="addFriend" class="chat">
            <header>
                <h2 class='title'>账号查找</h2>
            </header>
            <input id="userTel" type="text" />
            <button id="searchTel" onclick="searchTel()">查找</button>
            <img class="loadingimg" src="images/loading.gif">
            <div class='body' id="getUserByTel">
            </div>
            <footer>
                <a onclick="showADDFriend()">关闭</a>
            </footer>
        </div>
        
        <div id="chatwithfriend" class="chat">
            <header>
                <h2 class='title'>TNFB聊天</h2>
            </header>
            <div class="friendid">站内信——To：</div>
            <textarea rows="3" cols="20" id="usertextmsg"></textarea>
            <button id="sendmsg" onclick="sendMsg()">发送</button>
            <footer>
                <a onclick="showChatFriend()">关闭</a>
            </footer>
        </div>
        
        <script type="text/javascript" src="js/mailmsg.js"></script>
        <script>
            var username = '<%= username %>';
            var tel = '<%= tel %>';
            var score = <%= score %>;
(function(){
    $("#mailMsg").hide();
    $("#myFriend").hide();
    $("#addFriend").hide();
    $("#chatwithfriend").hide();
    $(".loadingimg").hide();
    if( username !== "null" && tel !== "null")
    {
        $("#username").text(username);
        setLevel(score,"userscore");
        //$("#userscore").text("积分："+score);
        getUserImg.getUserImgsrc(tel,callBackimg);
        getUserMsg.checkUserMsgstr(tel,callBackMsgCheck);
    }
    else
    {
        $.DialogByZ.Alert({Title:"提示",Content:"登录信息失效，请重新登录！",BtnL:"确认",FunL:alertsBack});
    }    
})(); 
var start = document.getElementById("start");
start.addEventListener('click',animateButtonStart,false);

var newQues = document.getElementById("newQues");
newQues.addEventListener('click',animateButtonInsertNewQues,false);

var sendReport = document.getElementById("sendReport");
sendReport.addEventListener('click',animateButtonSendReport,false);


var getHb = document.getElementById("getHb");
getHb.addEventListener('click',animateButtonGetHb,false);


   var image = '';  
   var base64;//将canvas压缩为base64格式  
   function selectImg(file){  
       if(!file.files || !file.files[0]){  
          return;  
       }  
       var reader = new FileReader();//读取文件  
       reader.onload = function(event){//文件读取完成的回调函数  
          image = document.getElementById('touxiang');  
          image.src = event.target.result;//读入文件的base64数据(可直接作为src属性来显示图片)  
          //alert(event.target.result);  
          //图片读取完成的回调函数（必须加上否则数据读入不完整导致出错！）  
          image.onload = function(){  
               base64=event.target.result
               $.post(   
                "UploadImg", //服务器接口(返回图片路径)  
                {image:base64},   
                function(data) {  
                    var success = data.success;
                    $.DialogByZ.Alert({Title:"提示",Content:success,BtnL:"确认",FunL:alerts});
                }, "json");  
          }  
       }  
       //将文件已Data URL的形式读入页面  
       reader.readAsDataURL(file.files[0]);  
   }  

</script>
    </body>
    
</html>
