$package('YiYa.modifyBiddingInfo');
YiYa.modifyBiddingInfo = function(){
    
	var _this = {
		
	  initForm:function(){
		//引入图片上传控件JS
		$.getScript(config.siteurl + "/js/ux/borrowManager/borrow_manager_upload.js");
		  
		  $("#modifyBiddingInfo").click(function(){
				
				var bidding_id = $("#bidding_id").val();
				var borrow_money = $.trim($("#borrow_money").val());
				var borrow_interest_rate = $.trim($("#borrow_interest_rate").val());
				var jiaxi_rate = $.trim($("#jiaxi_rate").val());
				var borrow_duration = $.trim($("#borrow_duration").val());
				var collect_day = $.trim($("#collect_day").val());
				var borrow_name = $.trim($("#borrow_name").val());
				var colligate = $.trim($("#colligate").val());
				var repayment_type = $.trim($("#repayment_type").val());
				
			
				var byTheDay;
				if($("#byTheDay").attr("checked")){
					byTheDay = true;	
				}else{
					byTheDay = false;
				}
				if(borrow_money == ""){
					alert("借款金额不能为空");
					return;
				}
				if(borrow_interest_rate == ""){
					alert("利率不能为空");
					return;
				}
				if(borrow_duration == ""){
					alert("借款期限不能为空");
					return;
				}
				if(colligate == ""){
					alert("平台综合服务费不能为空");
					return;
				}
				
				if(borrow_interest_rate < 0.05 || borrow_interest_rate > 24){
					alert("利率范围应该限制为0.05%-24%");
					return;
				}
				
		        var borrow_infoEditor = CKEDITOR.instances["borrow_info"];
		        var borrow_info = borrow_infoEditor.getData();
				
				if($.trim(borrow_infoEditor.getData()) == ""){
					alert("项目阐述不能为空");
					return;
				}
				
				var warehousingEditor = CKEDITOR.instances["warehousing"];
				var warehousing = warehousingEditor.getData();
				var updata = "";
				$("#picTd").find("img").each(function(){
					updata += ($(this).attr("src")+"|")
				});
				var dataArray={
						'borrow_money':borrow_money,
						'borrow_interest_rate':borrow_interest_rate,		
						'borrow_duration':borrow_duration,
						'collect_day':collect_day,
						'colligate':colligate,
						'borrow_name':borrow_name,
						'borrow_info':borrow_info,
						'warehousing':warehousing,
						'byTheDay':byTheDay,
						'bidding_id':bidding_id,
						'repayment_type':repayment_type,
						'updata':updata,
						'jiaxi_rate':jiaxi_rate
				};
				
				$.ajax({										
					url     : "../borrowList/modifyBiddingInfo.do",
					type    : "POST",
					cache   : false,
					dataType : 'json',
					data 	: dataArray,
					success : function(data){
						if(data.code==0){
							alert("发标信息修改成功");
							window.location.href = config.siteurl+"/borrowList/list.shtml";
						}else{
							alert("发标信息修改失败,原因："+data.msg);
						}
					},
				});
				
			});
		  
		  $(".deletePic").click(function(e){
				$(e.target).parent().remove();
			});
	  },
	  init:function(){
			_this.initForm();
			
		}
	}
	return _this;
}();

$(function(){
	YiYa.modifyBiddingInfo.init();
});
