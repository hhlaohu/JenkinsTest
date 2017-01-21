$(document).ready(function() {
	var count = 1;
	
		$("body").on("click",".js-showImg img",function(){
			if(count){
				var imgsrc = $(this).attr("data-rel") || $(this).attr("src");
				$("body").append('<img src="' + imgsrc + '" style="display:none">');
				setTimeout(function(){
					$("body").append('<div class="pop-img"><img src="' + imgsrc + '"><a href="javascript:void(0)" class="pop-imgclose">X</a></div>');
					$(".pop-img img").css({'max-width':'800px','max-height':'700px','width':'expression(this.width > 800 && this.width > this.height ? 800 : auto)','height':'expression(this.height > 700 ? 700 : auto)'});
					var imgw   = $(".pop-img img").width(), 
						imgh   = $(".pop-img img").height();
					$(".pop-img").addClass("mov-sacle").css({"marginTop":-imgh/2+"px","marginLeft":-imgw/2+"px"});
					
					$(".pop-imgclose").on("click",function(){
						count = 1; 
						$(this).parent(".pop-img").remove();
						return;
					});
					count = 0 ;
				},500);
			}
		});
	
	//返回顶部
	$(window).scroll(function() {
		if($(window).scrollTop() >= 200){ //向下滚动像素大于这个值时，即出现小火箭~
		$('.scroll-top').fadeIn(600); //火箭淡入的时间，越小出现的越快~
		}else{    
		$('.scroll-top').fadeOut(600); //火箭淡出的时间，越小消失的越快~
		}
	}); 
	$(".scroll-top").on("click",function(){
		$('html,body').animate({scrollTop: '0px'}, 350);
	});
});