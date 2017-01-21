$package('YiYa.info_handle');
YiYa.info_handle = function(){
	var _box = null;
	var _this = {
		listForm:$("#listForm"),

		initForm:function(){
			$("#checkApply-win").hide();
			$("#edit_info_handle_Pic").show();
			var usrinf_id =$("#usrinf_id").val();
			var pic_type = $("#pic_type").val();

			//显示未打码图片
			YiYa.ajaxJson('../userManager/userFindUsrInfo_2.do', {'usrinf_id':usrinf_id},function(data){
				if(data.success){
					var msUrl = config.siteurl;
					$.getScript(msUrl + "/images/upload/upload_sequence.js");
					var id_card_front = data.tabUsrinf.id_card_front_pic;
					$("#id_card_front").attr("src",id_card_front);
					var id_card_front = data.tabUsrinf.id_card_front_pic;
					$("#id_card_reverse").attr("src",id_card_front);
					var id_card_reverse = data.tabUsrinf.id_card_reverse;
					//返回其他增信资料:
					var tabUsrOtherPic_List = data.tabUsrOtherPic_List;
					if(tabUsrOtherPic_List!=null&&tabUsrOtherPic_List.length>0){
						$("#zhengxin_pic").show();
						$("#tabUsrOtherPic_div").text("");
						var addImage = 0;
						$.each(tabUsrOtherPic_List, function(i, n) {
							var div = "";
							div += "<div style='float:left;position: relative;'>" +"<div class='div_show_img js-showImg' style='float:left;position: relative;'>"+"<img src="+n.pic_addr+" style='cursor: pointer;width:180px; height:150px;'/>"+"</div>"+"</div>";
							$("#tabUsrOtherPic_div").append(div);
						});
						
					}else{
						$("#tabUsrOtherPic_div").hide();
						
					}
					//返回补充资料:
					var tabUsrComplementPic_List = data.tabUsrComplementPic_List;
					if(tabUsrComplementPic_List!=null&&tabUsrComplementPic_List.length>0){
						$("#query_tabUsrComplementPic").show();
						$("#tabUsrComplementPic_div").text("");
						$.each(tabUsrComplementPic_List, function(i, n) {
							var div = "";
							div += "<div class='div_show'>" +"<div class='div_show_img js-showImg'>"+"<img src="+ n.com_pic_addr+" style='cursor: pointer;width:180px; height:150px;'/>"+"</div>"+"</div>";
							$("#tabUsrComplementPic_div").append(div);
						});
					}else{
//						$("#tabUsrComplementPic_div").text("无补充资料!");
						$("#query_tabUsrComplementPic").hide();
					}
					
				}
				YiYa.closeProgress();
			}); 
			
			//显示已打码图片
			YiYa.ajaxJson('../userManager/find_mosmic_pic.do', {'usrinf_id':usrinf_id},function(data){
				if(data.success){
					var msUrl = config.siteurl;
					$.getScript(msUrl + "/images/upload/upload_sequence.js");
					//返回补充资料:
					var tabUsrComplementPic_List = data.tabUsrComplementPic_List;
					if(tabUsrComplementPic_List!=null&&tabUsrComplementPic_List.length>0){
						$("#show_mosmic_tabUsrComplementPic").show();
						$("#show_mosmic_tabUsrComplementPic_div").text("");
						$.each(tabUsrComplementPic_List, function(i, n) {
							var div = "";
							div += "<div class='div_show'>" +"<div class='div_show_img js-showImg'>"+"<img src="+ n.com_pic_addr+" style='cursor: pointer;width:180px; height:150px;'/>"+"</div>"+"</div>";
							$("#show_mosmic_tabUsrComplementPic_div").append(div);
						});
					}else{
						$("#show_mosmic_tabUsrComplementPic").hide();
					}
				}else{
					alert("查询资料处理中所有打码图片！");
				}
			});
			
			//下载基本资料和补充资料图片
			$("#download_pic").click(function(){
				var usrinf_id =$("#usrinf_id").val();
				var all_pic_resource=new Array();
				YiYa.ajaxJson('../userManager/userFindUsrInfo_2.do',{'usrinf_id':usrinf_id},function(data){
					
					if(data.success){
						
						var id_card_front = data.tabUsrinf.id_card_front_pic;
						$("#id_card_front").attr("src",id_card_front);
						var id_card_front = data.tabUsrinf.id_card_front_pic;
						$("#id_card_reverse").attr("src",id_card_front);
						var id_card_reverse = data.tabUsrinf.id_card_reverse;
						
						all_pic_resource.push(id_card_front);
						all_pic_resource.push(id_card_reverse);
						window.location.href='download_pic.do?urlString='+all_pic_resource+"&pic_type=0"; //下载基本类型图片
						
					}
					
				}); 
			});
			
		},
		
		config:{
  			dataGrid:{
  				title:'',
  				striped:true,
	   			url:'dataList.do',
	   			columns:[[
						
				]],
				toolbar:['']
			}
		},
		init:function(){
			_this.initForm();
			_box = new YDataGrid(_this.config); 
			_box.init();
		}
	}
	return _this;
}();


$(function(){
	YiYa.info_handle.init();
	resizeIframe();
	$(window).resize(resizeIframe);
	function resizeIframe(){

	}
});		

