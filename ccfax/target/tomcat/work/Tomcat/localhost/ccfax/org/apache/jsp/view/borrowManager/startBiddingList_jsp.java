/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-01-20 10:06:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view.borrowManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.util.*;

public final class startBiddingList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    ");
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
      out.write("   <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/main.css\">\r\n");
      out.write("   <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/style.css\" />\r\n");
      out.write("   <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/user_login.css\">\r\n");
      out.write("   <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/webuploader.css\" />\r\n");
      out.write("   <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/viewer.min.css\" />\r\n");
      out.write("   <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/commons/viewer-jquery.min.js\"></script>\r\n");
      out.write("   <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/ckeditor/ckeditor.js\"></script>\r\n");
      out.write("   <style type=\"text/css\">\r\n");
      out.write("      .datagrid-toolbar{display:none;}\r\n");
      out.write("   </style>\r\n");
      out.write("  </head>\r\n");
      out.write("\t<body>\r\n");
      out.write("<div class=\"warp easyui-panel\" data-options=\"border:false\">\r\n");
      out.write("\t<!-- Search panel start -->\r\n");
      out.write(" \t <div id=\"searchPanel\" class=\"easyui-panel ui-search-panel\" title=\"\" data-options=\"striped: true,collapsible:true,iconCls:'icon-search'\">  \r\n");
      out.write(" \t <form id=\"searchForm\">\r\n");
      out.write(" \t  \t <p class=\"ui-fields\">\r\n");
      out.write("            <label class=\"ui-label\">真实姓名:&nbsp;&nbsp;&nbsp; </label>\r\n");
      out.write("            <input name=\"real_name\" class=\"easyui-box ui-text\" style=\"width:150px;color:rgb(85, 84, 84);\">\r\n");
      out.write("        </p>\r\n");
      out.write("         <p class=\"ui-fields\">\r\n");
      out.write("            <label class=\"ui-label\">手机号码 </label>\r\n");
      out.write("            <input name=\"user_phone\" class=\"easyui-box ui-text\" \r\n");
      out.write("              style=\"width:150px;color:rgb(85, 84, 84);\">\r\n");
      out.write("        </p>\r\n");
      out.write("        <p class=\"ui-fields\">\r\n");
      out.write("    \t    <label>是否VIP</label>  \r\n");
      out.write("            <select name=\"is_vip\" data-options=\"required:true,width:150\">\r\n");
      out.write("           \t   <option value=\"0\">所有人</option>\r\n");
      out.write("           \t   <option value=\"1\">借款人</option>\r\n");
      out.write("            </select>\r\n");
      out.write("        </p>\r\n");
      out.write("        <a href=\"#\" id=\"btn-search\" class=\"easyui-linkbutton\" iconCls=\"icon-search\">查询</a>\r\n");
      out.write("      </form>  \r\n");
      out.write("     </div> \r\n");
      out.write("     <!--  Search panel end -->\r\n");
      out.write("     \r\n");
      out.write("     <!-- DataList  -->\r\n");
      out.write("     <form id=\"listForm\" method=\"post\">\r\n");
      out.write("     <table id=\"data-list\"></table>\r\n");
      out.write("     </form>\r\n");
      out.write("     \r\n");
      out.write("     <div id=\"startBiding-win\" style=\"padding: 20px; display: none\">\r\n");
      out.write("         \r\n");
      out.write("         <div class=\"crumb-wrap\">\r\n");
      out.write("\t\t\t\t<div class=\"crumb-list\">\r\n");
      out.write("\t\t\t\t\t<i class=\"icon-font\"></i>&nbsp;<span class=\"crumb-name\">发标管理</span><span\r\n");
      out.write("\t\t\t\t\t\tclass=\"crumb-step\">&gt;</span><span class=\"crumb-name\">发布借款</span>\r\n");
      out.write("\t\t\t\t\t<a class=\"btn-back\"\r\n");
      out.write("\t\t\t\t\t\thref=\"javascript:window.location.href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/borrowList/startBiddingList.shtml'\">返回</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("         <div style=\"width: 100%; padding: 10px; font-size: 14px; overflow: hidden;\">\r\n");
      out.write("            <form id=\"startBiddingForm\" class=\"ui-form\">\r\n");
      out.write("              \r\n");
      out.write("              <input class=\"hidden\" type=\"text\" id=\"usrid\" name=\"usrid\">\r\n");
      out.write("            \r\n");
      out.write("               <table>\r\n");
      out.write("                 <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                      <table class=\"tbBaseInfo2\" width=\"100%\" >\r\n");
      out.write("                                       \r\n");
      out.write("                        <tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th align=\"left\">借款总金额<span style=\"color:Red\">*</span>：</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"borrow_money\" class=\"easyui-numberbox\" data-options=\"precision:2\" \r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"height:30px\"/>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<th align=\"left\">年利率<span style=\"color:Red\">*</span>：</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"borrow_interest_rate\" class=\"easyui-numberbox\" data-options=\"precision:2\" \r\n");
      out.write("\t\t\t\t\t\t\t\t  style=\"height:30px;width:100px\"/>&nbsp %\r\n");
      out.write("\t\t\t\t\t\t\t\t<span style=\"color:Red;font-size:12px\">(利率范围：0.05%-24%)</span>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t <tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th align=\"left\">借款用途<span style=\"color:Red\">*</span>：</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t   <select id=\"borrow_use\" style=\"height:30px;width:157px;\">\r\n");
      out.write("\t\t\t\t\t\t\t     \t<option value=\"\">--请选择--</option>\r\n");
      out.write("\t\t\t\t\t\t\t     \t<option value=\"1\">短期周转</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"2\">生意周转</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"3\">生活周转</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"4\">购物消费</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"5\">不提现借款</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"6\">创业借款</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"7\">其它借款</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"8\">装修借款</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"9\">信用千金</option>\r\n");
      out.write("\t\t\t\t\t\t\t   </select>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<th align=\"left\">借款期限<span style=\"color:Red\">*</span>：</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"borrow_duration\"  style=\"height:30px;width:157px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t   <option value=\"\">--请选择--</option>\r\n");
      out.write("\t\t\t\t\t\t\t     \t<option value=\"1\">1个月</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"2\">2个月</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"3\">3个月</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"4\">4个月</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"5\">5个月</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"6\">6个月</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"7\">7个月</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"8\">8个月</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"9\">9个月</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"10\">10个月</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"11\">11个月</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"12\">12个月</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t <input id=\"byTheDay\" type=\"checkbox\" style=\"width:15px;height:15px;margin-left:10px;\" /> 按天\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t <tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th align=\"left\">最低投标金额<span style=\"color:Red\">*</span>：</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"borrow_min\" style=\"height:30px;width:157px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t    <option value=\"\">--请选择--</option>\r\n");
      out.write("\t\t\t\t\t\t\t     \t<option value=\"50\">50</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"100\">100</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"200\">200</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"300\">300</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"500\">500</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"1000\">1000</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"2000\">2000</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"3000\">3000</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"4000\">4000</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"5000\">5000</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"10000\">10000</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<th align=\"left\">最多投标金额：</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"borrow_max\" style=\"height:30px;width:157px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t    <option value=\"\">--没有限制--</option>\r\n");
      out.write("\t\t\t\t\t\t\t     \t<option value=\"1500\">1500</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"2000\">2000</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"3000\">3000</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"4000\">4000</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"5000\">5000</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"6000\">6000</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"10000\">10000</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t </tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t <tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th align=\"left\">有效时间<span style=\"color:Red\">*</span>：</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"collect_day\" style=\"height:30px;width:157px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<th align=\"left\">还款方式<span style=\"color:Red\">*</span>：</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"repayment_type\" style=\"height:30px;width:157px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t    <option value=\"\">--请选择--</option>\r\n");
      out.write("\t\t\t\t\t\t\t     \t<option value=\"1\">按天计息，一次性还本付息</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"2\">等额本息</option>\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"3\">按季分期还款</option>\r\n");
      out.write("<!-- \t\t\t\t\t              \t<option value=\"4\">每月还息到期还本</option> -->\r\n");
      out.write("<!-- \t\t\t\t\t              \t<option value=\"5\">一次性还款</option> -->\r\n");
      out.write("<!-- \t\t\t\t\t              \t<option value=\"6\">利息复投</option> -->\r\n");
      out.write("\t\t\t\t\t              \t<option value=\"7\">等额本金</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t <tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th align=\"left\">产品类型<span style=\"color:Red\">*</span>：</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"product_type\" style=\"height:30px;width:157px;\" class=\"easyui-combobox\" \r\n");
      out.write("\t\t\t\t\t\t\t\t   data-options=\"\r\n");
      out.write("\t\t\t\t\t\t\t\t     valueField: 'dictionary_value_key',\r\n");
      out.write("\t                                 textField: 'dictionary_value_name',\r\n");
      out.write("\t\t\t\t\t\t\t\t     url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/dataManager/getDDVListByTypeName.do?typeName=bidding_product_type'\r\n");
      out.write("\t\t\t\t\t\t\t\t \">\r\n");
      out.write("\t\t\t\t\t\t\t\t   \r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<th align=\"left\">担保公司：</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"danbao\" style=\"height:30px;width:157px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t    <option value=\"\">无担保机构</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th align=\"left\">平台综合服务费<span style=\"color:Red\">*</span>：</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"left\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"colligate\"  class=\"easyui-numberbox\" data-options=\"precision:2\" \r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"height:30px\"/>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<th align=\"left\">加息率：</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"left\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"jiaxi_rate\"  class=\"easyui-numberbox\" data-options=\"precision:2\" \r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"height:30px\"/>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t <tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th align=\"left\">担保公司服务费：</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"vouch_money\" class=\"easyui-numberbox\" data-options=\"precision:2\" \r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"height:30px\"/>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<th align=\"left\">投标密码：</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"bidding_pwd\" style=\"height:30px;width:150px\"/>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t <tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th align=\"left\">标题<span style=\"color:Red\">*</span>：</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"left\" colspan=\"4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"borrow_name\" style=\"height:30px;width:150px\"/>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th align=\"left\">是否是测试标<span style=\"color:Red\">*</span>：</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"left\" colspan=\"4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"test\" type=\"checkbox\" style=\"height:30px;width:40px;float:left\"/>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t <tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th align=\"left\">货物入仓单</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"left\" colspan=\"4\">\r\n");
      out.write("\t\t\t\t\t\t\t   <textarea id=\"warehousing\" name=\"warehousing\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t\t   <script type=\"text/javascript\">CKEDITOR.replace(\"warehousing\")</script>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th align=\"left\">项目阐述<span style=\"color:Red\">*</span></th>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"left\" colspan=\"4\">\r\n");
      out.write("\t\t\t\t\t\t\t   <textarea name=\"borrow_info\" id=\"borrow_info\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t\t   <script type=\"text/javascript\">CKEDITOR.replace(\"borrow_info\")</script>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t    <th align=\"left\">商品图片</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"left\" colspan=\"4\">\r\n");
      out.write("\t\t\t\t\t\t\t      <div id=\"uploader\">\r\n");
      out.write("\t\t\t\t\t\t\t\t        <div class=\"queueList\">\r\n");
      out.write("\t\t\t\t\t\t\t\t            <div id=\"dndArea\" class=\"placeholder\">\r\n");
      out.write("\t\t\t\t\t\t\t\t                <div id=\"filePicker\"></div>\t\t\t\t            \t\t\t\t            \r\n");
      out.write("\t\t\t\t\t\t\t\t            </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t        </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t        <div class=\"statusBar\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t            <div class=\"progress\">\r\n");
      out.write("\t\t\t\t\t\t\t\t                <span class=\"text\">0%</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t                <span class=\"percentage\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t            </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t            <div class=\"info\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t            <div class=\"btns\">\r\n");
      out.write("\t\t\t\t\t\t\t\t                <div id=\"filePicker2\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t                <div class=\"uploadBtn\">开始上传</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t            </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t        </div>\r\n");
      out.write("   \t\t\t\t                      </div>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t    <th align=\"left\">图片预览</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"left\" colspan=\"4\" id=\"picTd\">\r\n");
      out.write("\t\t\t\t\t\t     \r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("                      </table>\r\n");
      out.write("                    </td>                 \r\n");
      out.write("                 </tr>\r\n");
      out.write("               </table>\r\n");
      out.write("            </form>\r\n");
      out.write("         </div>\r\n");
      out.write("         \r\n");
      out.write("         <div style=\"margin:10px 300px;width:300px;\">\r\n");
      out.write("\t\t\t \t<input id=\"startBiddingBtn\" class=\"btn-primary\" value=\"确定\" type=\"button\" >\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("     </div>\r\n");
      out.write("\t \r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/commons/YDataGrid.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/upload/webuploader.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/commons/imageshow.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/ux/borrowManager/startBiddingList.js\"></script>\r\n");
      out.write(" </body>\r\n");
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
    // /view/borrowManager/startBiddingList.jsp(190,9) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("list");
    // /view/borrowManager/startBiddingList.jsp(190,9) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/view/borrowManager/startBiddingList.jsp(190,9) '${companyList}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${companyList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t          \t\t      <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.uid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.company_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</option>\r\n");
          out.write("\t\t\t\t          \t        ");
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
}
