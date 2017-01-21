$package('YiYa');
var YiYa={
	/*Json 工具类*/
	isJson:function(str){
		var obj = null; 
		try{
			obj = YiYa.paserJson(str);
		}catch(e){
			return false;
		}
		var result = typeof(obj) == "object" && Object.prototype.toString.call(obj).toLowerCase() == "[object object]" && !obj.length; 
		return result;
	},
	paserJson:function(str){
		return eval("("+str+")");
	},
	/*弹出框*/
	alert:function(title, msg, icon, callback){
		$.messager.alert(title,msg,icon,callback);
	},
	/*弹出框*/
	confirm:function(title, msg,callback){
		$.messager.confirm(title,msg,callback);
	},
	/*初始化右下角的提示框 */
	rightCornerAlert:function(title, msg,timeout){
		$.messager.show({
            title : '我的消息',
            msg : '登录成功,欢迎使用此系统',
            timeout : 3000,
            showType : 'slide'
    });
	},
	progress:function(title,msg){
		 var win = $.messager.progress({  
            title: title ||'请稍后',  
            msg: msg ||'加载数据中...'  
         }); 
	},
	closeProgress:function(){
		$.messager.progress('close');
	},
	/*重新登录页面*/
	toLogin:function(){
		window.top.location= urls['msUrl']+"/login.shtml";
	},
	checkLogin:function(data){//检查是否登录超时
		if(data==null){
			YiYa.alert('提示',"服务器异常,请联系管理员.",'error');
			return false;
		}else if(data.logoutFlag){
			YiYa.closeProgress();
			YiYa.alert('提示',"登录超时,点击确定重新登录.",'error');
			return false;
		}
		return true;
	},
	ajaxSubmit:function(form,option){
		form.ajaxSubmit(option);
	},
	ajaxJson: function(url,option,callback){
		$.ajax(url,{
			type:'post',
			 	dataType:'json',
			 	data:option,
			 	success:function(data){
			 		//坚持登录
			 		if(!YiYa.checkLogin(data)){
			 			return false;
			 		}		 	
			 		if($.isFunction(callback)){
			 			callback(data);
			 		}
			 	},
			 	error:function(response, textStatus, errorThrown){
			 		try{
			 			YiYa.closeProgress();
			 			var data = $.parseJSON(response.responseText);
				 		//检查登录
				 		if(!YiYa.checkLogin(data)){
				 			return false;
				 		}else{
					 		YiYa.alert('提示', data.msg || "请求出现异常,请联系管理员",'error');
					 	}
			 		}catch(e){
			 			alert(e);
			 			YiYa.alert('提示',"请求出现异常,请联系管理员",'error');
			 		}
			 	},
			 	complete:function(){
			 	
			 	}
		});
	},
	submitForm:function(form,callback,dataType){
			var option =
			{
			 	type:'post',
			 	dataType: dataType||'json',
			 	success:function(data){
			 		if($.isFunction(callback)){
			 			callback(data);
			 		}
			 	},
			 	error:function(response, textStatus, errorThrown){
			 		try{
			 			YiYa.closeProgress();
			 			var data = $.parseJSON(response.responseText);
				 		//检查登录
				 		if(!YiYa.checkLogin(data)){
				 			return false;
				 		}else{
					 		YiYa.alert('提示', data.msg || "请求出现异常,请联系管理员",'error');
					 	}
			 		}catch(e){
			 			alert(e);
			 			YiYa.alert('提示',"请求出现异常,请联系管理员",'error');
			 		}
			 	},
			 	complete:function(){
			 	
			 	}
			 }
			 YiYa.ajaxSubmit(form,option);
	},
	saveForm:function(form,callback){
		if(form.form('validate')){
			YiYa.progress('请稍后','正在保存...');
			//ajax提交form
			YiYa.submitForm(form,function(data){
				YiYa.closeProgress();
			 	if(data.success){
			 		if(callback){
				       	callback(data);
				    }else{
			       		YiYa.alert('提示','保存成功.','info');
			        } 
		        }else{
		       	   YiYa.alert('提示',data.msg,'error');  
		        }
			});
		 }
	},
	/**
	 * 
	 * @param {} url
	 * @param {} option {id:''} 
	 */
	getById:function(url,option,callback){
		YiYa.progress();
		YiYa.ajaxJson(url,option,function(data){
			YiYa.closeProgress();
			if(data.success){
				if(callback){
			       	callback(data);
			    }
			}else{
				YiYa.alert('提示',data.msg,'error');  
			}
		});
	},
	deleteForm:function(url,option,callback){
		YiYa.progress();
		YiYa.ajaxJson(url,option,function(data){
				YiYa.closeProgress();
				if(data.success){
					if(callback){
				       	callback(data);
				    }
				}else{
					YiYa.alert('提示',data.msg,'error');  
				}
		});
	}
}

/* 自定义密码验证*/
$.extend($.fn.validatebox.defaults.rules, {  
    equals: {  
        validator: function(value,param){  
            return value == $(param[0]).val();  
        },  
        message: '密码匹配验证失败.'  
    },
    selectValueRequired: {   
        validator: function(value,param){             
            if (value == "" || value.indexOf('请选择') >= 0) {   
               return false;  
            }else {  
               return true;  
            }    
       },   
       message: '该下拉框为必选项'   
   },
   integer : {// 验证整数  
       validator : function(value) {  
           return /^[+]?[1-9]+\d*$/i.test(value);  
       },  
       message : '请输入整数'  
   },
   carNo : {  
       validator : function(value) {  
           return /^[\u4E00-\u9FA5][\da-zA-Z]{6}$/.test(value);  
       },  
       message : '车牌号码无效（例：粤B12350）'  
   },
   
});  

$.extend($.fn.validatebox.methods, {  
    remove: function(jq, newposition){  
        return jq.each(function(){  
            $(this).removeClass("validatebox-text validatebox-invalid").unbind('focus').unbind('blur');
        });  
    },
    reduce: function(jq, newposition){  
        return jq.each(function(){  
           var opt = $(this).data().validatebox.options;
           $(this).addClass("validatebox-text").validatebox(opt);
        });  
    }   
});
//使用
//$('#id').validatebox('remove'); //删除
//$('#id').validatebox('reduce'); //恢复

/*表单转成json数据*/
$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [ o[this.name] ];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
}

/* easyui datagrid 添加和删除按钮方法*/
$.extend($.fn.datagrid.methods, {  
    addToolbarItem: function(jq, items){  
        return jq.each(function(){  
            var toolbar = $(this).parent().prev("div.datagrid-toolbar");
            for(var i = 0;i<items.length;i++){
                var item = items[i];
                if(item === "-"){
                    toolbar.append('<div class="datagrid-btn-separator"></div>');
                }else{
                    var btn=$("<a href=\"javascript:void(0)\"></a>");
                    btn[0].onclick=eval(item.handler||function(){});
                    btn.css("float","left").appendTo(toolbar).linkbutton($.extend({},item,{plain:true}));
                }
            }
            toolbar = null;
        });  
    },
    removeToolbarItem: function(jq, param){  
        return jq.each(function(){  
            var btns = $(this).parent().prev("div.datagrid-toolbar").children("a");
            var cbtn = null;
            if(typeof param == "number"){
                cbtn = btns.eq(param);
            }else if(typeof param == "string"){
                var text = null;
                btns.each(function(){
                    text = $(this).data().linkbutton.options.text;
                    if(text == param){
                        cbtn = $(this);
                        text = null;
                        return;
                    }
                });
            } 
            if(cbtn){
                var prev = cbtn.prev()[0];
                var next = cbtn.next()[0];
                if(prev && next && prev.nodeName == "DIV" && prev.nodeName == next.nodeName){
                    $(prev).remove();
                }else if(next && next.nodeName == "DIV"){
                    $(next).remove();
                }else if(prev && prev.nodeName == "DIV"){
                    $(prev).remove();
                }
                cbtn.remove();    
                cbtn= null;
            }                        
        });  
    }   
});

//计算字符串长度(英文占1个字符，中文汉字占2个字符)
function strlen(str){
    var len = 0;
    for (var i=0; i<str.length; i++) { 
     var c = str.charCodeAt(i); 
    //单字节加1 
     if ((c >= 0x0001 && c <= 0x007e) || (0xff60<=c && c<=0xff9f)) { 
       len++; 
     } 
     else { 
      len+=2; 
     } 
    } 
    return len;
}

function timeStampFormat(time, format){
	if(time=="0"||typeof(time) == "undefined"){
		return "";
	}
    var t = new Date(time);
    var tf = function(i){return (i < 10 ? '0' : '') + i};
    return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function(a){
        switch(a){
            case 'yyyy':
                return tf(t.getFullYear());
                break;
            case 'MM':
                return tf(t.getMonth() + 1);
                break;
            case 'mm':
                return tf(t.getMinutes());
                break;
            case 'dd':
                return tf(t.getDate());
                break;
            case 'HH':
                return tf(t.getHours());
                break;
            case 'ss':
                return tf(t.getSeconds());
                break;
        }
    })
	
}

//保留两位小数位
function toDecimal(x) {  
	var f = parseFloat(x);  
    if (isNaN(f)) {  
        return false;  
    }  
    var f = Math.round(x*100)/100;  
    var s = f.toString();  
    var rs = s.indexOf('.');  
    if (rs < 0) {  
        rs = s.length;  
        s += '.';  
    }  
    while (s.length <= rs + 2) {  
        s += '0';  
    }  
    return s; 
}

/**
 * 合并单元格
 *
 **/
$.extend($.fn.datagrid.methods, {
    autoMergeCells : function (jq, fields) {
        return jq.each(function () {
            var target = $(this);
            if (!fields) {
                fields = target.datagrid("getColumnFields");
            }
            var rows = target.datagrid("getRows");
            var i = 0,
            j = 0,
            temp = {};
            for (i; i < rows.length; i++) {
                var row = rows[i];
                j = 0;
                for (j; j < fields.length; j++) {
                    var field = fields[j];
                    var tf = temp[field];
                    if (!tf) {
                        tf = temp[field] = {};
                        tf[row[field]] = [i];
                    } else {
                        var tfv = tf[row[field]];
                        if (tfv) {
                            tfv.push(i);
                        } else {
                            tfv = tf[row[field]] = [i];
                        }
                    }
                }
            }
            $.each(temp, function (field, colunm) {
                $.each(colunm, function () {
                    var group = this;
                    
                    if (group.length > 1) {
                        var before,
                        after,
                        megerIndex = group[0];
                        for (var i = 0; i < group.length; i++) {
                            before = group[i];
                            after = group[i + 1];
                            if (after && (after - before) == 1) {
                                continue;
                            }
                            var rowspan = before - megerIndex + 1;
                            if (rowspan > 1) {
                                target.datagrid('mergeCells', {
                                    index : megerIndex,
                                    field : field,
                                    rowspan : rowspan
                                });
                            }
                            if (after && (after - before) != 1) {
                                megerIndex = after;
                            }
                        }
                    }
                });
            });
        });
    }
});
