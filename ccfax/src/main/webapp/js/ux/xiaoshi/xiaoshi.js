$package('YiYa.xiaoshi');

$(function(){
	
	$.ajax({										
		url     : "../xiaoshi/configStatus.do",
		type    : "POST",
		cache   : false,	
		success : function(data){
		   if(data.code==0){
			   
			   if(data.resultText.id_name_face_status){
				   $("input:radio[name='id_name_face']").get(0).checked=true;
			   }else{
				   $("input:radio[name='id_name_face']").get(1).checked=true;
			   }
			   $("#score_standard").val(data.resultText.score_standard);
			   
			   if(data.resultText.check_live_status){
				   $("input:radio[name='check_alive']").get(0).checked=true;
			   }else{
				   $("input:radio[name='check_alive']").get(1).checked=true;
			   }
		   }else{
			   YiYa.alert("提示",data.msg,"info");
		   }
		}
	});
	
	$("#confirmConfig").click(function(){
		
		var check_alive =  $("input:radio[name='check_alive']").get(0).checked;
		var id_name_face =  $("input:radio[name='id_name_face']").get(0).checked;
		var score_standard = $("#score_standard").val();
		
		$.ajax({										
			url     : "../xiaoshi/setConfig.do",
			type    : "POST",
			cache   : false,
			data:{"id_name_face":id_name_face,"check_alive":check_alive,"score_standard":score_standard},
			success : function(data){
			   if(data.code==0){
				   YiYa.alert("提示","修改成功","info");				
			   }else{
				   YiYa.alert("提示",data.msg,"info");
			   }
			}
		});
		
		
	});
	
	
	
	
	
	
	

});		