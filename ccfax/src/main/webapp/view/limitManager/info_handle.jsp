<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@include file="/view/resource.jsp" %>
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/main.css">
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/webuploader.css" />
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/style.css" />
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/style_seq.css" />
   <link rel="stylesheet" type="text/css" href="${msUrl}/css/user_login.css">
  </head>
	<body>
<div class="warp easyui-panel" data-options="border:false">
	
     <!-- 资料处理  -->
     <div id="info_handle-win" style="padding: 10px;overflow:hidden;">
     	<div class="crumb-wrap">
	        <div class="crumb-list"><i class="icon-font"></i>&nbsp;<span class="crumb-name">资料处理</span>
	        <a class="btn-back" href="javascript:window.location.href='${msUrl}/userManager/list.shtml'">返回</a>
	        </div>
    	</div>	
    	<div style="width: 100%;padding: 10px;font-size: 14px;">
     		<input type="hidden" name="usrinf_id" id="usrinf_id" value="${usrinf_id}">
     		<input type="hidden" name="pic_type" id="pic_type" value="1">  
			<p style="font-size:14px;font-weight:bold;margin-top:10px;">请将用户的图片资料打码处理，用于发布借款时前台展示。</p> 
     		 		<table>
	     				 <tr>
		     		 		<td>
                                <table width="100%">
                                    <tr>
										<div style="margin:20px 300px;width:300px;">
								 	 	    <input id="download_pic" class="btn-primary3" value="下载" type="button" >
									    </div>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                    </table>
             <div id="query_tabUsrPic" style="margin-left:10px;">      
             <div  class="ftitle">基本资料:</div>
             <div class="tbBaseInfo2" width="100%">
             <table class="queueList" width="100%">
	     		 <tr>
		     		 <td style="border: 0px solid #f5f5f5;">
							<div style="float:left;border: 0px dashed #c9dae4;">
								<div class="div_show">
									<div class="div_show_img js-showImg">
									<img id="id_card_front" data-rel=""  style="cursor: pointer;width:180px; height:150px;"/>
									</div>
								</div>
							</div>
							<div style="float:left; border: 0px dashed #c9dae4;">
								<div class="div_show">
								    <div class="div_show_img js-showImg">
									<img id="id_card_reverse" data-rel=""  style="cursor: pointer;width:180px; height:150px;"/>
									</div>
								</div>
							</div>
							<div id="zhengxin_pic" style="float:left; border: 0px dashed #c9dae4;display:none">
								<div class="div_show">
									<div id="tabUsrOtherPic_div" class="js-showImg" style="float:left;position:absolute;"><a id="OtherPic_link" href="" class="link"></a></div>
								</div>
							</div>
                      </td>
                  </tr>
             </table>
             </div>
         </div>
             
             <div id="query_tabUsrComplementPic" style="margin-left:10px;display:none">
              <div class="ftitle">补充资料:</div>
                <div class="tbBaseInfo_userManager" width="100%">
           		 <table class="queueList" width="100%">
                   <tr>
	     		     <td>
						<div id="tabUsrComplementPic_div">
							<a id="complementPic_link" href="" class="link"></a>
						</div>
                     </td>
                 </tr>
            	</table>
        	   	</div>
        	   	</div>
               
             
             </div>    
        
       </div>   
                    
         <div id="edit_info_handle_Pic" style="margin-left:10px;">
         	<div class="under_line_style"><span class="tip_info" style="font-size:18px;">请上传打码后的图片:</span></div>
          	<div><span style="float: left;margin:20px;">图片资料:</span></div>
		    <div id="uploader" class="uploader" width="90%" style="overflow-x:hidden;">
		        <div class="queueList" width="90%">
		            <div class='placeholder' style="min-height: 108px;">
		                <div class="filePicker"></div>
		            </div>
		        </div>
		        <div class="statusBar" style="display:none;">
		            <div class="progress">
		                <span class="text">0%</span>
		                <span class="percentage"></span>
		            </div>
		            <div class="info"></div>
		            <div class="btns">
		                <div class="filePicker2" style="float:right;"></div>
		                <div class="uploadBtn" style="float:right;">开始上传</div>
		            </div>
		        </div>
   			 </div>
		</div>
		
            <div id="show_mosmic_tabUsrComplementPic" style="margin-left:10px;display:none">
              <div class="ftitle"><span class="tip_info">补充资料:</span></div>
                <div class="tbBaseInfo_userManager" width="100%">
           		 <table class="queueList" width="100%">
                   <tr>
	     		     <td>
						<div id="show_mosmic_tabUsrComplementPic_div">
							<a id="show_mosmic_complementPic_link" href="" class="link"></a>
						</div>
                     </td>
                 </tr>
            	</table>
        	   	</div>
        	   	</div>
            
	     
</div>

<div class="scroll-top"></div>

<script type="text/javascript" src="${msUrl}/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="${msUrl}/js/commons/imageshow.js"></script>
<script type="text/javascript" src="${msUrl}/images/upload/webuploader.js"></script>
<script type="text/javascript" src="${msUrl}/js/ux/limitManager/info_handle.js"></script>
<script type="text/javascript" src="${msUrl}/images/upload/upload_sequence.js"></script>
<script type="text/javascript" src="${msUrl}/js/commons/jquery.lazyload.js"></script>
<script type="text/javascript">
 $(function(){
 
  	$("img").lazyload({
		effect : "fadeIn"
	});
  });
</script>

 </body>
</html>
