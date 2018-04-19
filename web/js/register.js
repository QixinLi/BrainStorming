function AutoLoad(){
	changeWindowAuto();
}

function changeWindowAuto(){
	var width=$(document).width();
	var height=$(document).height();
	var panelwidth;
	$("#bg").css({
		"height":height
	});

if(width<360)
	{
            panelwidth=width;
            $("#login").css({
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
                $("#login").css({
                    "width":"360px",
                    "height":"636px",
                    "top":top+"px",
                    "left":left+"px"
		});
	}

	$("#logo").css({
		"width":panelwidth*0.4,
		"left":panelwidth*0.297222,
		"top":panelwidth*0.047222
	});

	$("input").css({
		"left":panelwidth*0.0805556,
		"height":panelwidth*0.1444,
		"width":panelwidth*0.836111,
		"font-size":panelwidth*0.05
	});


	$("#username").css({
		"top":panelwidth*0.47778
	});
	$("#password").css({
		"top":panelwidth*0.6444
	});
	$("#repassword").css({
		"top":panelwidth*0.81111
	});
	$("#name").css({
		"top":panelwidth*0.97778
	});

	$("#signup").css({
		"top":panelwidth*1.47778,
		"left":panelwidth*0.0805556,
		"height":panelwidth*0.1444,
		"width":panelwidth*0.838889,
		"font-size":panelwidth*0.05
	});
	$("#signin").css({
		"top":panelwidth*1.675,
		"left":panelwidth*0.258333,
		"font-size":panelwidth*0.04444
	});
}

function clickSignInBt(){
	$(window).attr('location','login.jsp');
}
function alerts()
{
	$.DialogByZ.Close();
}
function alerts_tologin()
{
	$.DialogByZ.Close();
        window.location.href='login.jsp';
}