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
        <title>FeedBack</title>
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
            #submit{
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
         function addCheck(){  
            var title=document.getElementById("title").value;  
            if(title==""){  
            	$.DialogByZ.Alert({Title:"提示",Content:"不允许提交空反馈哦！",BtnL:"确认",FunL:alerts});
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
        <p id="returnMSG"></p>
        <form action ="Feedback" method="post" onsubmit="return validate()">
        <b>为了让我们更好，请告诉我们您的宝贵意见：</b>
        <input type="textarea" id="content" name="content"  rows="5" cols="20" placeholder="您的意见是我们进步的动力！"><br/>
        <input type="submit" id="submit" value="提交"><br/>
        </form>
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
