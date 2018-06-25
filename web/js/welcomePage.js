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
            $("#loginDiv").css({
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
                top = (height-636)/2;
            }
            $("#loginDiv").css({
                "width":"360px",
                "height":"636px",
                "top":top,
                "left":left
            });
	}
        $("#loginDiv").css({
            "display":"inline"
        });
        $("#userDetails").css({
		"height":panelwidth*0.463889,
		"width":panelwidth*0.791667,
		"left":panelwidth*0.1,
		"top":panelwidth*0.127778
	});
        $("#btPanel").css({
		"left":panelwidth*0.097222,
		"top":panelwidth*0.6638889,
                "right":panelwidth*0.105556,
                "bottom":panelwidth*0.02222
	});
        $("#mail").css({
            "width":panelwidth*0.0972222,
            "left":panelwidth*-0.055556,
            "top":panelwidth*-0.02222
	});
        $("#start").css({
		"left":panelwidth*0.2138889,
		"top":panelwidth*-0.2889
	});
        $("#newQues").css({
		"left":panelwidth*0.2138889,
		"top":panelwidth*-0.05
	});
        $("#sendReport").css({
		"left":panelwidth*0.2138889,
		"top":panelwidth*0.186111
	});
        $("#getHb").css({
		"left":panelwidth*0.2138889,
		"top":panelwidth*0.430555
	});
        $("#userimg").css({
		"left":panelwidth*0.069444,
		"top":panelwidth*0.069444,
                "right":panelwidth*0.4805556,
                "bottom":panelwidth*0.1527778
	});
        $("#username").css({
		"left":panelwidth*0.388889,
		"top":panelwidth*0.108333,
                "font-size":panelwidth*0.055556
	});
        $("#userscore").css({
		"left":panelwidth*0.388889,
		"top":panelwidth*0.208333,
                "font-size":panelwidth*0.055556
	});
        $("#welcomemsg").css({
		"left":panelwidth*0.069444,
		"top":panelwidth*0.34444,
                "font-size":panelwidth*0.066667
	});
        $("#beian").css({
            "top":panelwidth*1.688889,
            "left":panelwidth*0.2805556
        })
        $("#logout").css({
            "left":panelwidth*0.838889,
            "top":panelwidth*1.658333
        })
        $("#friend").css({
            "width":panelwidth*0.083333,
            "top":panelwidth*0.083333,
            "left":panelwidth*-0.0472222
        })
}

function callBackimg(data)
{
    if(data !== "null")
    {
        $("#touxiang").attr("src",data);
    }
    else
    {
        $("#touxiang").attr("src","images/logo.png");
    }
}
function callBackmsg(data)
{
    if(data !== "")
    {
        $("#mymsg").empty();
        $("#mymsg").append(data);
    }
    else
    {
        $("#mymsg").empty();
        $("#mymsg").append("<br><br>什么消息也没有~<br><br><br>");
    }
    
}

function callBackMsgCheck(data){
    if(data==true){
        $("#mailimg").attr("src","images/mail_check.png");
    }
    else{
        $("#mailimg").attr("src","images/mail.png");
    }
}

function alertsBack()
{
	$.DialogByZ.Close();
        $(window).attr('location','login.jsp');
}

function alerts()
{
	$.DialogByZ.Close();
}


var animateButtonStart = function(e) {

  e.preventDefault;
  //reset animation
  e.target.classList.remove('animate');
  
  e.target.classList.add('animate');
  setTimeout(function(){
    e.target.classList.remove('animate');
    $(window).attr('location','Start.jsp');
  },700);
};

var animateButtonInsertNewQues = function(e) {

  e.preventDefault;
  //reset animation
  e.target.classList.remove('animate');
  
  e.target.classList.add('animate');
  setTimeout(function(){
    e.target.classList.remove('animate');
    $(window).attr('location','insertNewQues.jsp');
  },700);
};

var animateButtonSendReport = function(e) {

  e.preventDefault;
  //reset animation
  e.target.classList.remove('animate');
  
  e.target.classList.add('animate');
  setTimeout(function(){
    e.target.classList.remove('animate');
    $(window).attr('location','feedback.jsp');
  },700);
};

var animateButtonGetHb = function(e) {

  e.preventDefault;
  //reset animation
  e.target.classList.remove('animate');
  
  e.target.classList.add('animate');
  setTimeout(function(){
    e.target.classList.remove('animate');
    $(window).attr('location','alipay.html');
  },700);
};

function getCookie(name)
{
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    if(arr=document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return null;
}

clicktime=1;
function gotoAdminPage(){
    if(clicktime>=10)//点击10次进入管理员界面
    {
        var username = getCookie("tel");
        if(username === "admin"){
            $(window).attr('location','examine.jsp');
        }
    }
    else
    {
        clicktime++;
    }
}

function showMailandGetMsg()
{
    getUserMsg.getUserMsgstr(tel,callBackmsg);
    $("#mailMsg").toggle();
}

function showMailMsg()
{
    $("#mailMsg").toggle();
    getUserMsg.checkUserMsgstr(tel,callBackMsgCheck);
}

function readAllMsg()
{
    $.post(   
            "readAllMsg",
    function(data) {  
        var ret = data.ret;
        if(ret === "false")
        {
            $.DialogByZ.Alert({Title:"提示",Content:"出错啦！",BtnL:"确认",FunL:alerts});
        }
        else if(ret === "ok")
        {
            showMailMsg();
        }
        else if(ret === "null")
        {
            $.DialogByZ.Alert({Title:"提示",Content:"没有未读的消息！",BtnL:"确认",FunL:alertsBack});
        }
        else{
            showMailMsg();
        }
    }, "json"); 
}

function addFriend(){
    $("#myFriend").toggle();
    $("#addFriend").toggle();
}

function showFriend()
{
    $("#myFriend").toggle();
    $(".loadingimg").show();
    friend.getAllFriend(tel,showFriendcallback);
}

function showADDFriend()
{
    $("#addFriend").toggle();
}

function showFriendcallback(data){
    if(data==""){
        $("#mybuddy").empty();
        $("#mybuddy").append("<br>您还没有好友哦~~<br>");
    }
    else{
        $("#mybuddy").empty();
        $("#mybuddy").append(data);
    }
    $(".loadingimg").hide();
}

var tel2;
function searchTel()
{
    tel2=document.getElementById("userTel").value;  
    if(tel2===""){
        $.DialogByZ.Alert({Title:"提示",Content:"账号不能为空！",BtnL:"确认",FunL:alerts});
        document.getElementById("userTel").focus();    
    }
    else{
        $("#getUserByTel").empty();
        $(".loadingimg").show();
        friend.getFriendByTel(tel2,searchTelcallback);
    }
}

function searchTelcallback(data){
    $(".loadingimg").hide();
    if(data==="false"){
        $("#getUserByTel").empty();
        $("#getUserByTel").append("<br>出错啦！！<br>");
    }
    else if(data=="null"){
        $("#getUserByTel").empty();
        $("#getUserByTel").append("<br>根本就没有这个人嘛！嘤嘤嘤~~<br>");
    }
    else{
        $("#getUserByTel").empty();
        $("#getUserByTel").append(data);
    }
}

function sendFriendRequest(){
    if(tel===tel2){
        $.DialogByZ.Alert({Title:"提示",Content:"无法添加自己为好友！",BtnL:"确认",FunL:alerts});
    }
    else{
        friend.sendFriendRequest(tel,tel2,sendFRcallback);
    }
}

function sendFRcallback(data){
    if(data==="fail"){
        $.DialogByZ.Alert({Title:"提示",Content:"发生异常，添加失败",BtnL:"确认",FunL:alerts});
    }
    else{
        $("#addFriend").toggle();
        $.DialogByZ.Alert({Title:"提示",Content:"好友请求信息已发送！",BtnL:"确认",FunL:alerts});
    }
}

var myfriend;
function examFriendRequest(friend){
    myfriend=friend;
    $.DialogByZ.Confirm({Title: "好友添加请求", Content: "用户"+friend+"想要添加您为好友",BtnL:"同意",BtnR:"拒绝",FunL:confirmL,FunR:refuseR})
}

function confirmL(){
    friend.addFriendRelationship(tel,myfriend,confirmLcallback);
}

function refuseR(){
    $.DialogByZ.Close();
}

function confirmLcallback(data){
    if(data==="exist"){
        $.DialogByZ.Alert({Title:"提示",Content:"该用户已经是您的好友！",BtnL:"确认",FunL:alerts});
    }
    else if(data==="fail"){
        $.DialogByZ.Alert({Title:"提示",Content:"出错了，添加好友失败！",BtnL:"确认",FunL:alerts});
    }
    else{
        $.DialogByZ.Alert({Title:"提示",Content:"成功添加好友！",BtnL:"确认",FunL:alerts});
    }
}

var chattingFriend;
function sendMessageToFriend(friend,msg){
    $("#myFriend").hide();
    $("#mailMsg").hide();
    chattingFriend=friend;
    if(msg!==""){
        $(".friendid").text("站内信 — To："+friend);
        $(".friendid").append("<br>回复：<"+msg+">");
    }
    else
    {
        $(".friendid").text("站内信 — To："+friend);
    }
    $("#chatwithfriend").toggle();
}

function showChatFriend(){
    $("#chatwithfriend").toggle();
}

function sendMsg(){
    var mtext=document.getElementById("usertextmsg").value;  
    if(mtext===""){
        $.DialogByZ.Alert({Title:"提示",Content:"什么也不想发？",BtnL:"确认",FunL:alerts});
        document.getElementById("usertextmsg").focus();    
    }
    else{
        friend.sendFriendMsg(chattingFriend,tel,mtext,sendMsgcallback);
    }
}

function sendMsgcallback(data){
    if(data==="fail"){
        $.DialogByZ.Alert({Title:"提示",Content:"发送出错，请稍后再试！",BtnL:"确认",FunL:alerts});
    }
    else{
        $("#chatwithfriend").toggle();
        $.DialogByZ.Alert({Title:"提示",Content:"已将消息发送给好友！",BtnL:"确认",FunL:alerts});
    }
}

function getFriendLogoByTel(tel,imgid){
    getUserImg.getUserImgsrc(tel,{callback:function(data){getFLBTcallback(imgid,data);}});
}

function getFLBTcallback(imgid,data){
    if(data !== "null")
    {
        $("#"+imgid).attr("src",data);
    }
    else
    {
        $("#"+imgid).attr("src","images/logo.png");
    }
}

function setLevel(score,id){
    if(score===0){
        $("#"+id).css({
            "background-color":"#fc7ce1"
        });
        $("#"+id).html("&nbsp;宝宝&nbsp;");
    }
    else if(score>=1&&score<=7){
        $("#"+id).css({
            "background-color":"#ff5959"
        });
        $("#"+id).html("&nbsp;读书郎&nbsp;");
    }
    else if(score>=8&&score<=29){
        $("#"+id).css({
            "background-color":"#ff7c3b"
        });
        $("#"+id).html("&nbsp;秀才&nbsp;");
    }
    else if(score>=30&&score<=99){
        $("#"+id).css({
            "background-color":"#ffff2b" 
        });
        $("#"+id).html("&nbsp;举人&nbsp;");
    }
    else if(score>=100&&score<=299){
        $("#"+id).css({
            "background-color":"#58f538"
        });
        $("#"+id).html("&nbsp;贡人&nbsp;");
    }
    else if(score>=300&&score<=999){
        $("#"+id).css({
            "background-color":"#61ffda" 
        });
        $("#"+id).html("&nbsp;探花&nbsp;");
    }
    else if(score>=1000&&score<=9999){
        $("#"+id).css({
            "background-color":"#617bff" 
        });
        $("#"+id).html("&nbsp;榜眼&nbsp;");
    }
    else if(score>=10000&&score<=99999){
        $("#"+id).css({
            "background-color":"#ce31f5" 
        });
        $("#"+id).html("&nbsp;状元&nbsp;");
    }
    else if(score>=100000&&score<=999999){
        $("#"+id).css({
            "background-color":"#a1a19c"
        });
        $("#"+id).html("&nbsp;翰林&nbsp;");
    }
    else if(score>=1000000){
        $("#"+id).css({
            "background-color":"#dbb520"
        });
        $("#"+id).html("&nbsp;大圣人&nbsp;");
    }
    else{
        $("#"+id).css({
            "background-color":"red"
        });
        $("#"+id).html("&nbsp;等级出错...&nbsp;");
    }
}