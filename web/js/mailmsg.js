$('.fa-search').click(function(){
 $(this).stop().toggleClass('fa-close');
 $('.search').stop().animate({height: "toggle", opacity: "toggle"}, 300);
});

 $('.chat').draggable({ handle: 'header' });