/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-01-20 10:09:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view.scoring;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.util.*;

public final class scoringModelField_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/view/resource.jsp", Long.valueOf(1484816294703L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("   ");
      out.write("\r\n");
      out.write("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\">\r\n");
      out.write("<meta content=\"always\" name=\"referrer\">\r\n");
      out.write("<meta name=\"theme-color\" content=\"#2932e1\">\r\n");
      out.write("<!-- 公共资源CSS,JS  -->\r\n");
      out.write("<!--Css -->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${easyuiUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/themes/bootstrap/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${easyuiUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/themes/icon.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/base.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/buttons.css\">\r\n");
      out.write("<!-- ** Javascript ** -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/commons/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/commons/jquery.form.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/layer/layer.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/commons/package.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${easyuiUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${easyuiUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/commons/urls.js?v=11\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/commons/base.js?v=11\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var config = {\r\n");
      out.write("\tsiteurl: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("};\r\n");
      out.write("</script>");
      out.write("\r\n");
      out.write("  </head>\r\n");
      out.write("\t<body>\r\n");
      out.write("<div class=\"warp easyui-panel\" data-options=\"border:false\">\r\n");
      out.write("\t<!-- Search panel start -->\r\n");
      out.write(" \t <div id=\"searchPanel\" class=\"easyui-panel ui-search-panel\" title=\"\" data-options=\"striped: true,collapsible:true,iconCls:'icon-search'\">  \r\n");
      out.write(" \t <form id=\"searchForm\">\r\n");
      out.write(" \t \t<p class=\"ui-fields\">\r\n");
      out.write(" \t \t    <label class=\"ui-label\">字段名:</label>\r\n");
      out.write(" \t \t    <input name=\"search_field_name\" id=\"search_field_name\" class=\"easyui-box ui-text\" style=\"width:150px;\">\r\n");
      out.write("        </p>\r\n");
      out.write("         <p class=\"ui-fields\">\r\n");
      out.write("\t        <a href=\"#\" id=\"btn-search\" class=\"easyui-linkbutton\" iconCls=\"icon-search\">查询</a>&nbsp;&nbsp;\r\n");
      out.write("\t        <!--<a href=\"#\" id=\"btn-back\" class=\"easyui-linkbutton\" iconCls=\"icon-back\">返回字段类型管理</a>  -->\r\n");
      out.write("        </p>\r\n");
      out.write("      </form>  \r\n");
      out.write("     </div>\r\n");
      out.write("     <!--  Search panel end -->\r\n");
      out.write("     \r\n");
      out.write("     <!-- DataList  -->\r\n");
      out.write("     <form id=\"listForm\" method=\"post\">\r\n");
      out.write("     <table id=\"data-list\"></table>\r\n");
      out.write("     </form>\r\n");
      out.write("     \r\n");
      out.write("\r\n");
      out.write("     <!-- Edit Form -->\r\n");
      out.write("     <div style=\"display:none\">\r\n");
      out.write("     <div id=\"edit-win\" class=\"easyui-dialog\" title=\"字段管理\" buttons=\"#edit_model_field\" data-options=\"closed:true,iconCls:'icon-save',modal:true\" style=\"width:500px;height:550px;\">  \r\n");
      out.write("     \t<form id=\"editForm\" class=\"ui-form\" method=\"post\">  \r\n");
      out.write("     \t\t <input class=\"hidden\" id=\"scoring_field_id\">\r\n");
      out.write("     \t\t <input class=\"hidden\" id=\"field_name_temp\">\r\n");
      out.write("     \t\t <div class=\"ui-edit\">\r\n");
      out.write("  \t     \t   <table width=\"100%\" class=\"tbBaseInfo\">\r\n");
      out.write("           \t    <tr style=\"height:30px;\">\r\n");
      out.write("     \t\t\t\t<th align=\"right\"style=\"width:100px\">字段名：</th>\r\n");
      out.write("     \t\t\t\t<td align=\"left\">\r\n");
      out.write("     \t\t\t\t\t<input class=\"easyui-validatebox\" type=\"text\" name=\"field_name\" id=\"field_name\" maxlength=\"64\" style=\"width:300px\"  onkeyup=\"value=value.replace(/[\\u4E00-\\u9FA5]/g,'')\">\r\n");
      out.write("     \t\t\t\t\t<span style=\"color:red;\">*</span>\r\n");
      out.write("     \t\t\t\t</td>\r\n");
      out.write("     \t\t\t</tr>\r\n");
      out.write("     \t\t\t<tr style=\"height:30px;\">\r\n");
      out.write("     \t\t\t\t<th align=\"right\"style=\"width:100px\">字段中文名：</th>\r\n");
      out.write("     \t\t\t\t<td align=\"left\">\r\n");
      out.write("     \t\t\t\t\t<input class=\"easyui-validatebox\" type=\"text\" name=\"field_name_ch\" id=\"field_name_ch\" maxlength=\"64\" style=\"width:300px\">\r\n");
      out.write("     \t\t\t\t</td>\r\n");
      out.write("     \t\t\t</tr>\r\n");
      out.write("     \t\t\t<tr style=\"height:30px;\">\r\n");
      out.write("     \t\t\t\t<th align=\"right\"style=\"width:100px\">业务分类：</th>\r\n");
      out.write("     \t\t\t\t<td align=\"left\">\r\n");
      out.write("  \t     \t    \t \t    <select class=\"easyui-combobox\" id=\"field_type_id\" name=\"field_type_id\" style=\"width:200px;\">\r\n");
      out.write("\t\t\t \t \t    \t\t<!--");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("-->\r\n");
      out.write("\t\t\t \t \t   \t\t </select>\r\n");
      out.write("\t\t\t \t \t   \t\t <span style=\"color:red;\">*</span>\r\n");
      out.write("     \t\t\t\t</td>\r\n");
      out.write("     \t\t\t</tr>\r\n");
      out.write("     \t\t\t<tr style=\"height:30px;\">\r\n");
      out.write("     \t\t\t\t<th align=\"right\"style=\"width:100px\">字段值类型：</th>\r\n");
      out.write("     \t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t               <select class=\"easyui-combobox\" name=\"field_value_type\" id=\"field_value_type\" style=\"width:200px;\">\r\n");
      out.write("\t\t               \t\t<option value=\"9\">---请选择---</option>\r\n");
      out.write("\t\t\t                <option value=\"0\">字符串</option>\r\n");
      out.write("\t\t\t             \t<option value=\"1\">整型</option>\r\n");
      out.write("\t\t\t             \t<option value=\"2\">浮点型（2位小数）</option>\r\n");
      out.write("\t\t\t             \t<option value=\"3\">枚举</option>\r\n");
      out.write("\t                   \t</select>\r\n");
      out.write("\t                   \t<span style=\"color:red;\">*</span>\r\n");
      out.write("     \t\t\t\t</td>\r\n");
      out.write("     \t\t\t</tr>\r\n");
      out.write("     \t\t\t<tr style=\"height:30px;display:none;\" id=\"dictionary_type_TR\">\r\n");
      out.write("     \t\t\t\t<th align=\"right\"style=\"width:100px\">数据字典类型：</th>\r\n");
      out.write("     \t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t               <select class=\"easyui-combobox\" name=\"dictionary_type_id\" id=\"dictionary_type_id\" style=\"width:200px;\">\r\n");
      out.write("\t                   \t</select>\r\n");
      out.write("\t                   \t<span style=\"color:red;\">*</span>\r\n");
      out.write("     \t\t\t\t</td>\r\n");
      out.write("     \t\t\t</tr>\r\n");
      out.write("     \t\t\t<tr style=\"height:30px;\">\r\n");
      out.write("     \t\t\t\t<th align=\"right\"style=\"width:100px\">字段类型：</th>\r\n");
      out.write("     \t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t<label><input name=\"is_combined\" type=\"radio\" value=\"1\" />组合字段 </label> &nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t<label><input name=\"is_combined\" type=\"radio\" value=\"0\" />非组合字段 </label> &nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t<span style=\"color:red;\">*</span>\r\n");
      out.write("     \t\t\t\t</td>\r\n");
      out.write("     \t\t\t</tr>\r\n");
      out.write("     \t\t\t<tr style=\"height:30px;display:none;\" id=\"field_id_1\">\r\n");
      out.write("     \t\t\t\t<th align=\"right\"style=\"width:100px\">组合字段一：</th>\r\n");
      out.write("     \t\t\t\t<td align=\"left\">\r\n");
      out.write("     \t\t\t\t\t<select class=\"easyui-combobox\" id=\"combined_field_id_1\" name=\"combined_field_id_1\" style=\"width:200px;\">\r\n");
      out.write("\t\t\t \t \t    \t\t<!-- <option value=\"000000\">---请选择---</option>\r\n");
      out.write("\t\t\t \t \t    \t\t");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write(" -->\r\n");
      out.write("\t\t\t \t \t   \t</select>\r\n");
      out.write("\t\t\t \t \t   \t<span style=\"color:red;\">*</span>\r\n");
      out.write("     \t\t\t\t</td>\r\n");
      out.write("     \t\t\t</tr>\r\n");
      out.write("     \t\t\t<tr style=\"height:30px;display:none;\" id=\"field_id_2\">\r\n");
      out.write("     \t\t\t\t<th align=\"right\"style=\"width:100px\">组合字段二：</th>\r\n");
      out.write("     \t\t\t\t<td align=\"left\">\r\n");
      out.write("     \t\t\t\t\t<select class=\"easyui-combobox\" id=\"combined_field_id_2\" name=\"combined_field_id_2\" style=\"width:200px;\">\r\n");
      out.write("\t\t\t \t \t    \t\t<!--<option value=\"000000\">---请选择---</option>\r\n");
      out.write("\t\t\t \t \t    \t\t");
      if (_jspx_meth_c_005fforEach_005f2(_jspx_page_context))
        return;
      out.write(" -->\r\n");
      out.write("\t\t\t \t \t   \t</select>\r\n");
      out.write("\t\t\t \t \t   \t<span style=\"color:red;\">*</span>\r\n");
      out.write("     \t\t\t\t</td>\r\n");
      out.write("     \t\t\t</tr>\r\n");
      out.write("     \t\t\t<tr style=\"height:30px;display:none;\" id=\"operate\">\r\n");
      out.write("     \t\t\t\t<th align=\"right\"style=\"width:100px\">运算符：</th>\r\n");
      out.write("     \t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t               <select class=\"easyui-combobox\" name=\"combined_operate\" id=\"combined_operate\" style=\"width:200px;\">\r\n");
      out.write("\t\t               \t\t<option value=\"0\">---请选择---</option>\r\n");
      out.write("\t\t\t                <option value=\"1\">+</option>\r\n");
      out.write("\t\t\t             \t<option value=\"-\">-</option>\r\n");
      out.write("\t\t\t             \t<option value=\"*\">*</option>\r\n");
      out.write("\t\t\t             \t<option value=\"/\">/</option>\r\n");
      out.write("\t                   \t</select>\r\n");
      out.write("\t                   \t<span style=\"color:red;\">*</span>\r\n");
      out.write("     \t\t\t\t</td>\r\n");
      out.write("     \t\t\t</tr>\r\n");
      out.write("     \t\t\t<tr style=\"height:150px;\">\r\n");
      out.write("     \t\t\t\t<th align=\"right\" style=\"width:100px\">字段描述：</th>\r\n");
      out.write("     \t\t\t\t<td align=\"left\">\r\n");
      out.write("     \t\t\t\t<textarea style=\"height:130px;width:300px;\"  id=\"field_desc\" name=\"field_desc\" cols=\"20\" rows=\"8\"> </textarea>\r\n");
      out.write("     \t\t\t\t</td>\r\n");
      out.write("     \t\t\t</tr>\r\n");
      out.write("     \t\t\t</table>\r\n");
      out.write("\t         </div>\r\n");
      out.write("\t          <div id=\"edit_model_field\" class=\"dialog-button\">\r\n");
      out.write("\t          <a href=\"#\" id=\"btn-model_field-submit\" class=\"easyui-linkbutton\" iconCls=\"icon-ok\">保存</a>\r\n");
      out.write("\t\t      <a href=\"#\" id=\"btn-model_field-update\" class=\"easyui-linkbutton\" iconCls=\"icon-ok\">修改</a>\r\n");
      out.write("\t\t      <a href=\"#\" id=\"btn-model_field-cancel\" class=\"easyui-linkbutton\" iconCls=\"icon-cancel\">关闭</a>\r\n");
      out.write("\t          </div>\r\n");
      out.write("     \t</form>\r\n");
      out.write("  \t </div> \r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/commons/YDataGrid.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/ux/scoring/scoringModelField.js\"></script>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /view/scoring/scoringModelField.jsp(57,17) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("item");
    // /view/scoring/scoringModelField.jsp(57,17) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/view/scoring/scoringModelField.jsp(57,17) '${modelTypeList}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${modelTypeList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t \t \t    \t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.field_type_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.field_type_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</option>\r\n");
          out.write("\t\t\t \t \t    \t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f1.setParent(null);
    // /view/scoring/scoringModelField.jsp(98,13) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVar("item");
    // /view/scoring/scoringModelField.jsp(98,13) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/view/scoring/scoringModelField.jsp(98,13) '${modelFieldList}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${modelFieldList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t \t \t    \t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.scoring_field_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.field_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</option>\r\n");
          out.write("\t\t\t \t \t    \t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f2.setParent(null);
    // /view/scoring/scoringModelField.jsp(110,13) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f2.setVar("item");
    // /view/scoring/scoringModelField.jsp(110,13) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f2.setItems(new org.apache.jasper.el.JspValueExpression("/view/scoring/scoringModelField.jsp(110,13) '${modelFieldList}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${modelFieldList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f2 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f2 = _jspx_th_c_005fforEach_005f2.doStartTag();
      if (_jspx_eval_c_005fforEach_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t \t \t    \t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.scoring_field_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.field_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</option>\r\n");
          out.write("\t\t\t \t \t    \t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f2.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f2);
    }
    return false;
  }
}
