<%-- 
    Document   : feedback
    Created on : 2018-4-17, 15:54:39
    Author     : princess
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>反馈问题</title>
        <!--弹出层 开始 -->
        <link type="text/css" rel="stylesheet"  href="css/reset.css" />
	<link type="text/css" rel="stylesheet" href="css/zdialog.css" />
	<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="js/zdialog.js"></script>
        <!--弹出层 结束 -->
        <meta name="viewport"
    	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="content-type" content="text/html charset=utf-8"> 
        
        <style>
            body{
                background-color: #ffda47;
            }
            input{
                width:100%;
                font-size: 15px;
                background: transparent;
                color: #FFFFFF;
                border: 0px;
                border-bottom: 1px solid rgba(255, 255, 255, 0.2);
                margin:10px 10px 10px 10px;
            }
            #submit,button{
                background-color: #ff7800;
                border-radius:30px;
                border:none;
                color: rgba(255, 255, 255, 0.8);
                text-align: center;
                display: table-cell;
                vertical-align:middle;
            }
        </style>
    </head>
    
    <script>
        function getQueryString(name) {
            var result = window.location.search.match(new RegExp("[\?\&]" + name + "=([^\&]+)", "i"));
            if (result == null || result.length < 1) {
                return "";
            }
            return result[1];
        }
        function alerts()
        {
            $.DialogByZ.Close();
        }
        function isContainsErrStr(str) {
            var index=str.indexOf("{")+str.indexOf("}")+str.indexOf("\"")+str.indexOf(",");
            if(index>=0)
            {
                return true;
            }
            else{
                return false;
            }
        }
        function addCheck(){  
            var title=document.getElementById("title").value;  
            if(title==""){  
            	$.DialogByZ.Alert({Title:"提示",Content:"不允许提交空反馈哦！",BtnL:"确认",FunL:alerts});
                document.getElementById("title").focus();    
                return false;  
            }
            else if(isContainsErrStr(title)){
                $.DialogByZ.Alert({Title:"提示",Content:"内容包含违规字符！",BtnL:"确认",FunL:alerts});
                document.getElementById("title").focus();    
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
    
    <body>
        <br><button style="width:120px" onclick="window.location='welcomePage.jsp'">←返回主页</button><br><br>
        <p id="returnMSG"></p>
        <form action ="Feedback" method="post" onsubmit="return validate()">
            <b>为了让我们更好，请告诉我们您的宝贵意见：</b>
            <input type="textarea" id="content" name="content" style="height:200px"  rows="5" cols="20" placeholder="您的意见是我们进步的动力！"><br/>
            <input type="submit" id="submit" value="提交"><br/>
        </form>
        <br/><br/><br/><br/><br/>
        <div id="beian" class="absol" >
            <a  style="position: relative;color: #999" rel="nofollow"target="_blank"  href="http://www.miitbeian.gov.cn/">苏ICP备18023434号</a>
            <img width="13" style="position: relative;width:13px;height:16px" height="16" src="http://ss.bdimg.com/static/superman/img/copy_rignt_24.png">
        </div>
        <script>
        (function(){
            var returnMSG=getQueryString("success");
            if(returnMSG!=="")
            {
                $("#returnMSG").text("提交成功！");
            }
        })(); 
    </script>
    </body>
</html>
