/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-01-20 10:08:58 UTC
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

public final class borrowList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/view/resource.jsp", Long.valueOf(1484816294703L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
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
      out.write("            <label class=\"ui-label\">用户ID:&nbsp;&nbsp;&nbsp; </label><input id=\"yhid\" name=\"borrow_uid\" class=\"easyui-box ui-text\" placeholder=\"请输入用户ID\" style=\"width:150px;color:rgb(85, 84, 84);\">\r\n");
      out.write("        </p>\r\n");
      out.write("         <p class=\"ui-fields\">\r\n");
      out.write("            <label class=\"ui-label\">标号ID: </label>\r\n");
      out.write("            <input id=\"bhid\" name=\"bidding_id\" class=\"easyui-box ui-text\"  onkeypress=\"return event.keyCode>=48&&event.keyCode<=57\" onpaste=\"return !clipboardData.getData(\\'text\\').match(/\\D/)\" ondragenter=\"return false\"\r\n");
      out.write("            placeholder=\"请输入标号ID\" style=\"width:150px;color:rgb(85, 84, 84);\">\r\n");
      out.write("        </p>\r\n");
      out.write("        <p class=\"ui-fields\">\r\n");
      out.write("    \t    <label>借款种类:</label>  \r\n");
      out.write("            <select name=\"product_type\" class=\"easyui-combobox\"\r\n");
      out.write("                   data-options=\"\r\n");
      out.write("\t\t\t     valueField: 'dictionary_value_key',\r\n");
      out.write("                             textField: 'dictionary_value_name',\r\n");
      out.write("\t\t\t     url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/dataManager/getDDVListByTypeName.do?typeName=bidding_product_type'\r\n");
      out.write("\t\t\t   \">\r\n");
      out.write("            </select>\r\n");
      out.write("        </p>\r\n");
      out.write("       \r\n");
      out.write("        <p class=\"ui-fields\">\r\n");
      out.write("\t        <label>发标时间:</label>  \r\n");
      out.write("\t\t    <input id=\"add_time_start_time\" class=\"easyui-datetimebox\" type=\"text\" name=\"add_time_start_time\">\r\n");
      out.write("\t\t    <label>--</label>  \r\n");
      out.write("\t\t    <input id=\"add_time_end_time\" class=\"easyui-datetimebox\" type=\"text\" name=\"add_time_end_time\">\r\n");
      out.write("\t    </p>\r\n");
      out.write("\t    \r\n");
      out.write("\t    <p class=\"ui-fields\">\r\n");
      out.write("          <label class=\"ui-label\">审核状态: </label>\r\n");
      out.write("          \t    <select name=\"borrow_status\" data-options=\"required:true,width:150\">\r\n");
      out.write("\t           \t\t\t<option value=\"3\">全部</option>\r\n");
      out.write("\t                \t<option value=\"0\">待审核</option>\r\n");
      out.write("\t                \t<option value=\"1\">初审失败</option>\r\n");
      out.write("\t                \t<option value=\"2\">初审通过</option>\r\n");
      out.write("\t                \t<option value=\"8\">已审核未发标</option>\r\n");
      out.write("\t            </select>\r\n");
      out.write("        </p>\r\n");
      out.write("        \r\n");
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
      out.write("     <!-- 查看会员资料  -->\r\n");
      out.write("     <div style=\"display:none\">\r\n");
      out.write("     <div id=\"memberInfo-win\" class=\"easyui-dialog\" title=\"用户详细信息\" buttons=\"#memberButton\" data-options=\"closed:true,iconCls:'icon-view',modal:true\" style=\"width:800px;height:450px;overflow-x:hidden;\">  \r\n");
      out.write("     \t<form id=\"memberInfoForm\" class=\"ui-form\" method=\"post\">  \r\n");
      out.write("            \t<table width=\"100%\">\r\n");
      out.write("   \t\t\t\t <tr>\r\n");
      out.write("    \t\t\t\t <td>\r\n");
      out.write("                             <div class=\"member_pic\">\r\n");
      out.write("                             \t<img id=\"id_card_front\" src=\"../images/member2.png\" style=\"width:30px;height:30px;margin-left:10px; \"/>\t\r\n");
      out.write("                             \t<span style=\"line-height:30px;position:absolute;margin:auto 5px;\">会员资料</span>\r\n");
      out.write("                             </div> \r\n");
      out.write("                             <table id=\"tbCustomerInfo\" class=\"tbBaseInfo4\" width=\"100%\">\r\n");
      out.write("                                 <tr>\r\n");
      out.write("                                     <th ><span style=\"color:#0081c2;font-weight:bolder\">用户名：</span></th>\r\n");
      out.write("                                     <td >\r\n");
      out.write("                                      <p class=\"easyui-validatebox member-input\" type=\"text\" id=\"borrow_userName\" name=\"borrow_userName\"></p>\r\n");
      out.write("                                     </td>\r\n");
      out.write("                                     <th ><span style=\"color:#0081c2;font-weight:bolder\">认证情况：</span></th>\r\n");
      out.write("                                     <td >\r\n");
      out.write("                                         <span id=\"vip_ifExist\">\r\n");
      out.write("                                     \t \t<img id=\"vip_front\" src=\"../images/vip.png\" title=\"VIP会员\" style=\"width:30px;height:30px;cursor:pointer;\"/>\t\r\n");
      out.write("                                     \t </span>\r\n");
      out.write("                                     \t <span id=\"id_card_ifExist\">\r\n");
      out.write("                                     \t \t<img id=\"id_card_front\" src=\"../images/id_card.png\" title=\"实名认证\" style=\"width:30px;height:30px;cursor:pointer;\"/>\t\r\n");
      out.write("                                     \t </span>\r\n");
      out.write("                                     \t <span id=\"phone_ifExist\">\r\n");
      out.write("                                     \t \t<img id=\"phone_front\" src=\"../images/phone_o.png\" title=\"手机认证\" style=\"width:30px;height:30px; cursor:pointer;\"/>\t\r\n");
      out.write("                                     \t </span>\r\n");
      out.write("                                     \t <span id=\"email_ifExist\">\r\n");
      out.write("                                     \t \t<img id=\"email_front\" src=\"../images/email.png\" title=\"邮箱认证\" style=\"width:30px;height:30px; cursor:pointer;\"/>\r\n");
      out.write("                                     \t </span>\r\n");
      out.write("\r\n");
      out.write("                                     </td>\r\n");
      out.write("                                 </tr>\r\n");
      out.write("                                 <tr>\r\n");
      out.write("                                     <th align=\"left\">用户类型：</th>\r\n");
      out.write("\t\t\t\t\t                 <td align=\"left\">\r\n");
      out.write("\t\t\t\t\t                    \t<p class=\"easyui-validatebox member-input\" type=\"text\" id=\"user_regtype\" name=\"user_regtype\"></p>\r\n");
      out.write("\t\t\t\t\t                 </td>\r\n");
      out.write("                                     <th align=\"left\">身份：</th>\r\n");
      out.write("                                     <td align=\"left\">\r\n");
      out.write("                                         <p class=\"easyui-validatebox member-input\" type=\"text\" id=\"is_vip\" name=\"is_vip\"></p>\r\n");
      out.write("                                     </td>\r\n");
      out.write("                                 </tr>\r\n");
      out.write("                                 <tr>\r\n");
      out.write("                                     <th align=\"left\">推荐人：</th>\r\n");
      out.write("                                     <td align=\"left\">\r\n");
      out.write("                                     \t<p class=\"easyui-validatebox member-input\" type=\"text\" id=\"recommend_name\" name=\"recommend_name\"></p>\r\n");
      out.write("                                     </td>\r\n");
      out.write("                                     <th align=\"left\">所属客服：</th>\r\n");
      out.write("                                     <td align=\"left\">\r\n");
      out.write("                                     \t<p class=\"easyui-validatebox member-input\" type=\"text\" id=\"customer_services\" name=\"customer_services\"></p>\r\n");
      out.write("                                     </td>\r\n");
      out.write("\r\n");
      out.write("                                 </tr>\r\n");
      out.write("                                 <tr>\r\n");
      out.write("                                     <th align=\"left\">真实姓名：</th>\r\n");
      out.write("                                     <td align=\"left\">\r\n");
      out.write("                                     \t<p class=\"easyui-validatebox member-input\" type=\"text\" id=\"real_name\" name=\"real_name\"></p>\r\n");
      out.write("                                     </td>\r\n");
      out.write("                                     <th align=\"left\">冻结账号：</th>\r\n");
      out.write("                                     <td align=\"left\">\r\n");
      out.write("                                     \t<p class=\"easyui-validatebox member-input\" type=\"text\" id=\"salesman\" name=\"salesman\"></p>\r\n");
      out.write("                                     </td>                                     \r\n");
      out.write("                                 </tr>\r\n");
      out.write("                                 <tr>\r\n");
      out.write("                                     <th align=\"left\">身份证号：</th>\r\n");
      out.write("                                     <td align=\"left\">\r\n");
      out.write("                                     \t<p class=\"easyui-validatebox member-input\" type=\"text\" id=\"idcard\" name=\"idcard\"></p>\r\n");
      out.write("                                     </td>\r\n");
      out.write("                                     <th align=\"left\">认证邮箱：</th>\r\n");
      out.write("                                     <td align=\"left\">\r\n");
      out.write("                                     \t<p class=\"easyui-validatebox member-input\" type=\"text\" id=\"user_email\" name=\"user_email\"></p>\r\n");
      out.write("                                     </td>                                     \r\n");
      out.write("                                 </tr> \r\n");
      out.write("                                 <tr>\r\n");
      out.write("                                     <th align=\"left\">手机号：</th>\r\n");
      out.write("                                     <td align=\"left\">\r\n");
      out.write("                                     \t<p class=\"easyui-validatebox member-input\" type=\"text\" id=\"user_phone\" name=\"user_phone\"></p>\r\n");
      out.write("                                     </td>\r\n");
      out.write("                                 </tr>                                                                   \r\n");
      out.write("                             </table>\r\n");
      out.write("                         </td>\r\n");
      out.write("                     </tr>\r\n");
      out.write("                 </table>\r\n");
      out.write("     \t\t</form>\r\n");
      out.write("     \t <div id=\"memberButton\" >\r\n");
      out.write("        \t <a href=\"#\" id=\"memberInfo-cancel\" class=\"easyui-linkbutton\" iconCls=\"icon-cancel\">返回</a>\r\n");
      out.write("         </div>\r\n");
      out.write("  \t </div> \r\n");
      out.write("  \t </div>\r\n");
      out.write("     <!-- 查看审核记录  -->\r\n");
      out.write("     <div style=\"display:none\">\r\n");
      out.write("\t     <div id=\"borrowCheckRecord-win\" style=\"width:800px;height:400px;\" buttons=\"#borrowCheckRecordButton\" class=\"easyui-dialog\" title=\"审核记录 \" data-options=\"closed:true,iconCls:'icon-select',modal:true\">\r\n");
      out.write("\t     \t <input class=\"hidden\" type=\"text\" id=\"deal_user\" name=\"deal_user\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t     <form id=\"borrowCheckRecordForm\" method=\"post\">\r\n");
      out.write("\t\t         <table width=\"100%\" id=\"borrowCheckRecordTable\">\r\n");
      out.write("   \t\t\t\t \t\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t     </form>\r\n");
      out.write("\t     \t <div id=\"borrowCheckRecordButton\" >\r\n");
      out.write("\t        \t <a href=\"#\" id=\"borrowCheckRecord-cancel\" class=\"easyui-linkbutton\" iconCls=\"icon-cancel\">返回</a>\r\n");
      out.write("\t         </div>\r\n");
      out.write("\t     </div> \r\n");
      out.write("\t </div>\r\n");
      out.write("\t \r\n");
      out.write("\t <!--修改发标时间-->\r\n");
      out.write("\t<div style=\"display:none\">\r\n");
      out.write("\t     <div id=\"modifyAddTime-win\" style=\"width:750px;height:350px;\" buttons=\"#modifyAddTimeButton\" class=\"easyui-dialog\" title=\"修改发标时间\" data-options=\"closed:true,iconCls:'icon-select',modal:true\">\r\n");
      out.write("\t     \t<input type=\"hidden\" id=\"bidding-id\" />\r\n");
      out.write("\t     \t<input type=\"hidden\" id=\"check-remark\" />\r\n");
      out.write("\t     \t<div style=\"padding-left:100px;padding-top:10px\">\r\n");
      out.write("\t     \t  <label style=\"padding: 5px;padding-right:30px\" >原发布时间:&nbsp;&nbsp;&nbsp; </label>\r\n");
      out.write("\t     \t  <label style=\"padding: 5px\" id=\"orignal-addTime\"/>\r\n");
      out.write("\t     \t</div>\r\n");
      out.write("\t     \t\r\n");
      out.write("\t     \t<div style=\"padding-left:100px;padding-top:30px\" id=\"new-add-time-div\">\r\n");
      out.write("\t     \t  <label style=\"padding: 5px;padding-right:30px\" >新发布时间:&nbsp;&nbsp;&nbsp; </label>\r\n");
      out.write("\t     \t  <input id=\"new-add-time\" class=\"easyui-datetimebox\" type=\"text\" name=\"new-add-time\">\r\n");
      out.write("\t     \t</div>\r\n");
      out.write("\t     \t\r\n");
      out.write("\t     \t<div style=\"padding-top:15px\">\r\n");
      out.write("\t     \t  <hr style=\"height:1px;border:none;border-top:1px dashed #0066CC;\" />\r\n");
      out.write("\t     \t</div>\r\n");
      out.write("\t     \t\r\n");
      out.write("\t     \t<div style=\"padding-left:100px;padding-top:30px\">\r\n");
      out.write("\t     \t <div>\r\n");
      out.write("\t     \t \r\n");
      out.write("\t     \t </div>\r\n");
      out.write("\t     \t  <input id=\"isCancel\" type=\"checkbox\" name=\"isCancel\" />\r\n");
      out.write("\t     \t  <label style=\"padding-right:30px\">取消发布</label>\r\n");
      out.write("\t     \t  <label>取消发布后不可还原，该借款为未通过状态，全木行订单状态为已关闭</label>\r\n");
      out.write("\t     \t</div>\r\n");
      out.write("\t     \t\r\n");
      out.write("\t     \t\r\n");
      out.write("\t     \t<div style=\"padding-left:100px;padding-top:20px\">\r\n");
      out.write("\t     \t  <textarea id = \"cancelReason\" class=\"J_Comment_Content\" cols=\"80\" rows=\"5\" > </textarea>\r\n");
      out.write("\t     \t\r\n");
      out.write("\t     \t</div>\r\n");
      out.write("\t     \t\r\n");
      out.write("\t     <div id=\"modifyAddTimeButton\" style=\"text-align:center;\">\r\n");
      out.write("\t        \r\n");
      out.write("\t        <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" id=\"confirmModifyAddTime\">确定</a>\r\n");
      out.write("\t        <a href=\"javascript:void(0)\" id=\"modifyAddTime-cancel\" class=\"easyui-linkbutton\">取消</a>\r\n");
      out.write("\t     </div>\r\n");
      out.write("\t     \r\n");
      out.write("\t     </div>\r\n");
      out.write("\t </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/commons/YDataGrid.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/ux/borrowManager/borrowList.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/upload/webuploader.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/commons/imageshow.js\"></script>\r\n");
      out.write("\r\n");
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
}