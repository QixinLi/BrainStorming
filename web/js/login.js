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
                    top =(height-636)/2;
                }
                $("#loginDiv").css({
                    "width":"360px",
                    "height":"636px",
                    "top":top+"px",
                    "left":left+"px"
		});
	}
        $("#logo").css({
		"height":panelwidth*0.52222,
		"width":panelwidth*0.50276243,
		"left":panelwidth*0.2416667,
		"top":panelwidth*0.205556
	});
        $("#usernameimg").css({
		"top":panelwidth*1.047222,
		"left":panelwidth*0.116667,
		"height":panelwidth*0.097222,
		"width":panelwidth*0.063889
	});
	$("#passwordimg").css({
		"top":panelwidth*1.2,
		"left":panelwidth*0.116667,
		"height":panelwidth*0.097222,
		"width":panelwidth*0.063889
	});
        
        
        $("#tel").css({
		"top":panelwidth*1.02209945,
		"left":panelwidth*0.0805556,
		"height":panelwidth*0.1444,
		"width":panelwidth*0.686111,
		"font-size":panelwidth*0.05,
		"padding-left":panelwidth*0.1527778
	});
	$("#pwd").css({
		"top":panelwidth*1.17222,
		"left":panelwidth*0.0805556,
		"height":panelwidth*0.1444,
		"width":panelwidth*0.686111,
		"font-size":panelwidth*0.05,
		"padding-left":panelwidth*0.1527778
	});
        $("#signin").css({
		"top":panelwidth*1.47778,
		"left":panelwidth*0.0805556,
		"height":panelwidth*0.1444,
		"width":panelwidth*0.838889,
		"font-size":panelwidth*0.05
	});
	$("#signup").css({
		"top":panelwidth*1.675,
		"left":panelwidth*0.258333,
		"font-size":panelwidth*0.04444
	});
        $("#beian").css({
            "top":panelwidth*1.763889,
            "left":panelwidth*0.2805556
        });
        $(".absol").css({
            "display":"inline"
        });
        
}
function alerts()
{
	$.DialogByZ.Close();
}
function clickSignUpBt(){
	$(window).attr('location','register.jsp');
}