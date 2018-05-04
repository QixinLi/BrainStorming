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
            $("#mainPanel").css({
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
            $("#mainPanel").css({
                "width":"360px",
                "height":"636px",
                "top":top+"px",
                "left":left+"px"
            });
	}
        $(".bdsharebuttonbox").css({
            "top":panelwidth*1.408333,
            "left":panelwidth*0.226111
        });
        $("#shareImg").css({
            "top":panelwidth*0.1638889,
            "left":panelwidth*0.15,
            "right":panelwidth*0.15
        });
        $("#shareMsg").css({
            "top":panelwidth*0.9083333,
            "left":panelwidth*0.069444,
            "right":panelwidth*0.069444,
            "font-size":panelwidth*0.05555
        });
         $("#shareBt").css({
            "top":panelwidth*1.13333,
            "left":panelwidth*0.2416667,
            "width":panelwidth*0.4972222,
            "right":panelwidth*0.2416667,
            "font-size":panelwidth*0.05555
        });
        $("#beian").css({
            "top":panelwidth*1.763889,
            "left":panelwidth*0.2805556
        })
}

function clickBack(){
    $(window).attr('location','welcomePage.jsp');
}
