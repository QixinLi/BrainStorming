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
        $("#start").css({
		"left":panelwidth*0.2138889,
		"top":panelwidth*-0.175
	});
        $("#newQues").css({
		"left":panelwidth*0.2138889,
		"top":panelwidth*0.0638889
	});
        $("#sendReport").css({
		"left":panelwidth*0.2138889,
		"top":panelwidth*0.308333
	});
        $("#getHb").css({
		"left":panelwidth*0.2138889,
		"top":panelwidth*0.55
	});
        $("#userimg").css({
		"left":panelwidth*0.069444,
		"top":panelwidth*0.069444,
                "right":panelwidth*0.4805556,
                "bottom":panelwidth*0.1527778
	});
        $("#username").css({
		"left":panelwidth*0.333333,
		"top":panelwidth*0.0694444,
                "font-size":panelwidth*0.055556
	});
        $("#userscore").css({
		"left":panelwidth*0.333333,
		"top":panelwidth*0.227778,
                "font-size":panelwidth*0.055556
	});
        $("#welcomemsg").css({
		"left":panelwidth*0.069444,
		"top":panelwidth*0.34444,
                "font-size":panelwidth*0.066667
	});
}

function callBack(data)
{
    if(data !== "null")
    {
        $("#touxiang").attr("src",data);
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
