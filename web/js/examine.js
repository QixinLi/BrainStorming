/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Comment
 */
//一个问题列表结构：[问题，类型，A,B,C,D，作者，答案]
function AutoLoad(){
	changeWindowAuto();
}

function changeWindowAuto(){
	var width=$(document.body).width();
	var height=$(window).height();
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
            "font-size":panelwidth*0.0527778
        });
        $("#examine_img_div").css({
            "top":panelwidth*0.0694444,
            "left":panelwidth*0.55556,
            "right":panelwidth*0.355556,
            "bottom":panelwidth*1.408333

        });
        $("#examine_img_bt_p").css({
            "top":panelwidth*0.105555
        });
        $("#examine_img_bt_up").css({
            "top":panelwidth*0.105555,
            "right":panelwidth*-0.5,
            "bottom":panelwidth*0.808333
        });
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
        "background-color":"green"
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
function getCookie(name)
{
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    if(arr=document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return null;
}

//事件
function click_pass()
{
    if(canClick)
    {
        canClick=false;
    }
    examineQ.pass();
    setTimeout("examineQ.getOneQues(callBack)",1000);
}

function click_unpass()
{
    if(canClick)
    {
        canClick=false;
    }
    examineQ.unpass();
    setTimeout("examineQ.getOneQues(callBack)",1000);
}   

function save()
{
    if(canClick)
    {
        canClick=false;
    }
    alert("更新");
    setTimeout("examineQ.deleted(saveCallBack)",1000);
}

function saveCallBack(data)
{
    if (data!==-1)
    {
        alert("更新成功");
        $(window).attr('location','welcomePage.jsp');
    }
}

function alertsTologin()
{
	$.DialogByZ.Close();
        $(window).attr('location','login.jsp');
}