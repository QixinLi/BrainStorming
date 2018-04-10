<%-- 
    Document   : insertNewQues
    Created on : 2018-4-3, 13:32:26
    Author     : lee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>题目插入接口</title>
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
            #ok{
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
            var classes=document.getElementById("classes").value;  
            var optionA=document.getElementById("optionA").value;
            var optionB=document.getElementById("optionB").value;
            var optionC=document.getElementById("optionC").value;
            var optionD=document.getElementById("optionD").value;
            if(title==""){  
            	$.DialogByZ.Alert({Title:"提示",Content:"问题不能为空！",BtnL:"确认",FunL:alerts});
                document.getElementById("title").focus();    
                return false;  
            }
            if(classes==""){  
            	$.DialogByZ.Alert({Title:"提示",Content:"类别不能为空！",BtnL:"确认",FunL:alerts});
                document.getElementById("classes").focus();  
                return false;  
            } 
            if(optionA==""){  
            	$.DialogByZ.Alert({Title:"提示",Content:"选项A不能为空！",BtnL:"确认",FunL:alerts});
                document.getElementById("optionA").focus();  
                return false;  
            } 
            if(optionB==""){  
            	$.DialogByZ.Alert({Title:"提示",Content:"选项B不能为空！",BtnL:"确认",FunL:alerts});
                document.getElementById("optionB").focus();  
                return false;  
            } 
            if(optionC==""){  
            	$.DialogByZ.Alert({Title:"提示",Content:"选项C不能为空！",BtnL:"确认",FunL:alerts});
                document.getElementById("optionC").focus();  
                return false;  
            } 
            if(optionD==""){  
            	$.DialogByZ.Alert({Title:"提示",Content:"选项D不能为空！",BtnL:"确认",FunL:alerts});
                document.getElementById("optionD").focus();  
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
        <form action ="insertNewQues" method="post" onsubmit="return validate()">
            <input type="text" id="title" name="title" placeholder="问题主干"><br/>
            <input type="text" id="classes" name="classes" placeholder="类别"><br/>
            <input type="text" id="optionA" name="optionA" placeholder="选项A（正确答案）"><br/>
            <input type="text" id="optionB" name="optionB" placeholder="选项B"><br/>
            <input type="text" id="optionC" name="optionC" placeholder="选项C"><br/>
            <input type="text" id="optionD" name="optionD" placeholder="选项D"><br/>
            <input type="submit" id="ok" value="确认提交"><br/>
            Tips:<br/>
            <b>文科</b>：语文、外语、历史、经济、军事<br/>
            <b>理科</b>：数学、理化、天文、地理、生物<br/>
            <b>文艺</b>：文化、文学、演艺、艺术、设计<br/>
            <b>流行</b>：名人、时尚、体育、商业、科技<br/>
            <b>娱乐</b>：电影、电视、音乐、动漫、游戏<br/>
            <b>生活</b>：常识、世界、日常、健康、饮食<br/>
        </form>
    <script>
        (function(){
            var returnMSG=getQueryString("success");
            if(returnMSG!=="")
            {
                $("#returnMSG").text("插入成功！");
            }
        })(); 
    </script>
    </body>
</html>
