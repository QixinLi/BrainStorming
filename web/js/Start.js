/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function AutoLoad(){
	changeWindowAuto();
}

function changeWindowAuto(){
	var width=$(document).width();
	var height=$(document).height();
	var panelwidth;
	if(width<360)
	{
            panelwidth=width;
            $("#gameDiv").css({
		"width":width,
		"height":"636px",
		"top":"0px",
		"left":"0px"
            });
	}
	else
	{
            panelwidth=360;
            var left=(width-360)/2;
            var top;
            if(height<636){
                top="0px";
            }
            else{
                top =(height-636)/2;
            }
            $("#gameDiv").css({
                "width":"360px",
                "height":"636px",
                "top":top+"px",
                "left":left+"px"
            });
	}
        
        $("#title").css({
            "top":panelwidth*0.46388889,
            "left":panelwidth*0.119444,
            "right":panelwidth*0.119444,
            "font-size":panelwidth*0.0638889
        });
        $("#classes").css({
            "top":panelwidth*0.655556,
            "right":panelwidth*0.097222,
            "font-size":panelwidth*0.04444
        });
        $("#optA").css({
            "top":panelwidth*0.883333,
            "left":panelwidth*0.14444,
            "width":panelwidth*0.71111,
            "font-size":panelwidth*0.055556
        });
        $("#optB").css({
            "top":panelwidth*1.072222,
            "left":panelwidth*0.14444,
            "width":panelwidth*0.71111,
            "font-size":panelwidth*0.055556
        });
        $("#optC").css({
            "top":panelwidth*1.261111,
            "left":panelwidth*0.14444,
            "width":panelwidth*0.71111,
            "font-size":panelwidth*0.055556
        });
        $("#optD").css({
            "top":panelwidth*1.455556,
            "left":panelwidth*0.14444,
            "width":panelwidth*0.71111,
            "font-size":panelwidth*0.055556
        });
        $("#user").css({
            "top":panelwidth*1.686111,
            "right":panelwidth*0.097222,
            "font-size":panelwidth*0.0416667
        });
        $("#score").css({
            "top":panelwidth*0.0694444,
            "left":panelwidth*0.355556,
            "right":panelwidth*0.355556,
            "bottom":panelwidth*1.408333,
            "font-size":panelwidth*0.24444
        });
        $("#beian").css({
            "top":panelwidth*1.763889,
            "left":panelwidth*0.2805556
        })
        $(".absol").css({
            "display":"inline"
        });

}
function alertsTologin()
{
	$.DialogByZ.Close();
        $(window).attr('location','login.jsp');
}

function alertsToGG()
{
	$.DialogByZ.Close();
        //$(window).attr('location','login.jsp');
}
function alerts()
{
	$.DialogByZ.Close();
}

function callBack(data)
{
    var myques=data;
    var strs= new Array(); //定义一数组 
    strs=myques.split("##"); //字符分割
    $("#title").text(strs[0]);//问题
    $("#classes").text("类别："+strs[1]);//类型
    $("#optA").text(strs[2]);//选项A
    $("#optB").text(strs[3]);//选项B
    $("#optC").text(strs[4]);//选项C
    $("#optD").text(strs[5]);//选项D
    if(strs[6]==="admin")
    {
        $("#user").text("内容来源于网络");
    }
    else
    {
        $("#user").text("该题由用户‘"+strs[6]+"'提供");
    }
    correctAns=strs[7];
    
    canClick=true;
    $("#optA").css({
        "background-color":"#ff7800"
    });
    $("#optB").css({
        "background-color":"#ff7800"
    });
    $("#optC").css({
        "background-color":"#ff7800"
    });
    $("#optD").css({
        "background-color":"#ff7800"
    });
}
function setCorrectBt(){
    if(correctAns==="A")
    {
        $("#optA").css({
            "background-color":"green"
        });
    }
    else if(correctAns==="B")
    {
        $("#optB").css({
            "background-color":"green"
        });
    }
    else if(correctAns==="C")
    {
        $("#optC").css({
            "background-color":"green"
        });
    }
    else if(correctAns==="D")
    {
        $("#optD").css({
            "background-color":"green"
        });
    }
}
function clickA()
{
    if(canClick)
    {
        canClick=false;
        if(correctAns==="A")
        {
            numofCorrect++;
            $("#score").text(numofCorrect);
            $("#optA").css({
                "background-color":"green"
            });
            setTimeout("getQues.getOneQues(callBack)",1000);
        }
        else
        {
            $("#optA").css({
                "background-color":"red"
            });
            setCorrectBt();
            setTimeout("whenURGG()",1000);
        }
    }
    
}
function clickB()
{
    if(canClick)
    {
        canClick=false;
        if(correctAns==="B")
        {
            numofCorrect++;
            $("#score").text(numofCorrect);
            $("#optB").css({
                "background-color":"green"
            });
            setTimeout("getQues.getOneQues(callBack)",1000);
        }
        else
        {
            $("#optB").css({
                "background-color":"red"
            });
            setCorrectBt();
            setTimeout("whenURGG()",1000);
        }
    }
}
function clickC()
{
    if(canClick)
    {
        canClick=false;
        if(correctAns==="C")
        {
            numofCorrect++;
            $("#score").text(numofCorrect);
            $("#optC").css({
                "background-color":"green"
            });
            setTimeout("getQues.getOneQues(callBack)",1000);
        }
        else
        {
            $("#optC").css({
                "background-color":"red"
            });
            setCorrectBt();
            setTimeout("whenURGG()",1000);
        }
    }
}
function clickD()
{
    if(canClick)
    {
        canClick=false;
        if(correctAns==="D")
        {
            numofCorrect++;
            $("#score").text(numofCorrect);
            $("#optD").css({
                "background-color":"green"
            });
            setTimeout("getQues.getOneQues(callBack)",1000);
        }
        else
        {
            $("#optD").css({
                "background-color":"red"
            });
            setCorrectBt();
            setTimeout("whenURGG()",1000);
        }
    }
}
function whenURGG()
{
    score+=numofCorrect;
    $.get("setScore?score="+score, function(result){
       if(result == 'nullExist') {
           //result就是servlet返回的数据
           $.DialogByZ.Alert({Title:"提示",Content:"登录信息失效，请重新登录！",BtnL:"确认",FunL:alertsTologin});
       }
       else if(result == 'success'){
           $(window).attr('location','GameOver.jsp?score='+numofCorrect);
       }
       else if(result == 'fail'){
           $.DialogByZ.Alert({Title:"提示",Content:"数据库操作失败！",BtnL:"确认",FunL:alerts});
       }
    },"text");//可根据需要选用不同数据类型
}