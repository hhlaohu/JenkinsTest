if ($.fn.pagination){
	$.fn.pagination.defaults.beforePageText = '第';
	$.fn.pagination.defaults.afterPageText = '页，共{pages}页';
	$.fn.pagination.defaults.displayMsg = '显示 {from} 到 {to},共 {total}条记录数';
}
if ($.fn.datagrid){
	$.fn.datagrid.defaults.loadMsg = '正在加载, 请稍后 ...';
}
if ($.fn.treegrid && $.fn.datagrid){
	$.fn.treegrid.defaults.loadMsg = $.fn.datagrid.defaults.loadMsg;
}
if ($.messager){
	$.messager.defaults.ok = '确定';
	$.messager.defaults.cancel = '取消';
}
if ($.fn.validatebox){
	$.fn.validatebox.defaults.missingMessage = '该字段为必填字段.';
	$.fn.validatebox.defaults.rules.email.message = '请输入有效邮箱地址.';
	$.fn.validatebox.defaults.rules.url.message = '请输入有效 URL地址.';
	$.fn.validatebox.defaults.rules.length.message = '请输入 {0} 到 {1}的值.';
	$.fn.validatebox.defaults.rules.remote.message = '请检查该字段.';
}
if ($.fn.numberbox){
	$.fn.numberbox.defaults.missingMessage = '该字段为必填字段.';
}
if ($.fn.combobox){
	$.fn.combobox.defaults.missingMessage = '该字段为必填字段.';
}
if ($.fn.combotree){
	$.fn.combotree.defaults.missingMessage = '该字段为必填字段.';
}
if ($.fn.combogrid){
	$.fn.combogrid.defaults.missingMessage = '该字段为必填字段.';
}
if ($.fn.calendar){
	$.fn.calendar.defaults.weeks = ['S','M','T','W','T','F','S'];
	$.fn.calendar.defaults.months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
}
if ($.fn.datebox){
	$.fn.datebox.defaults.currentText = 'Today';
	$.fn.datebox.defaults.closeText = 'Close';
	$.fn.datebox.defaults.okText = 'Ok';
	$.fn.datebox.defaults.missingMessage = '该字段为必填字段.';
}
if ($.fn.datetimebox && $.fn.datebox){
	$.extend($.fn.datetimebox.defaults,{
		currentText: $.fn.datebox.defaults.currentText,
		closeText: $.fn.datebox.defaults.closeText,
		okText: $.fn.datebox.defaults.okText,
		missingMessage: $.fn.datebox.defaults.missingMessage
	});
}
