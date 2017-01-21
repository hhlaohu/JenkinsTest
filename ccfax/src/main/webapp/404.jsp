<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>404找不到页面</title>
    <script type="text/javascript" src="/tsfkxt/js/commons/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/tsfkxt/css/404.css">
	<script type="text/javascript">
            $(function() {
                var h = $(window).height();
                $('body').height(h);
                $('.mianBox').height(h);
                centerWindow(".tipInfo");
            });

            function centerWindow(a) {
                center(a);
                //自适应窗口
                $(window).bind('scroll resize',
                        function() {
                            center(a);
                        });
            }

            function center(a) {
                var wWidth = $(window).width();
                var wHeight = $(window).height();
                var boxWidth = $(a).width();
                var boxHeight = $(a).height();
                var scrollTop = $(window).scrollTop();
                var scrollLeft = $(window).scrollLeft();
                var top = scrollTop + (wHeight - boxHeight) / 2;
                var left = scrollLeft + (wWidth - boxWidth) / 2;
                $(a).css({
                    "top": top,
                    "left": left
                });
            }
        </script>
  </head>
  
  <body>
       <div class="mianBox">
           <img src="../images/yun0.png" alt="" class="yun yun0" />
           <img src="../images/yun1.png" alt="" class="yun yun1" />
           <img src="../images/yun2.png" alt="" class="yun yun2" />
           <img src="../images/bird.png" alt="" class="bird" />
           <img src="../images/san.png" alt="" class="san" />
           <div class="tipInfo">
               <div class="in">
                   <div class="textThis">
			       <h2>HTTP 404错误:您访问的页面错误或不存在.</h2>
			       <p><span>请与网站管理员联系!</span></p>
<!--                         <p><span>页面自动<a id="href" href="http://192.168.0.70:8080/tscps_background/main.shtml">跳转</a></span><span>等待<b id="wait">6</b>秒</span></p>
                    <script type="text/javascript">                            
                        (function() {
                               var wait = document.getElementById('wait'), href = document.getElementById('href').href;
                               var interval = setInterval(function() {
                                   var time = --wait.innerHTML;
                                   if (time <= 0) {
                                       location.href = href;
                                       clearInterval(interval);
                                   }
                                   ;
                               }, 1000);
                           })();
                       </script> -->
                   </div>
               </div>
           </div>
       </div>
  </body>
</html>
