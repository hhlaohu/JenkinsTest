/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-01-20 10:09:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view.sys;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.util.*;

public final class sysRole_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("            <label class=\"ui-label\">角色名称:</label> \r\n");
      out.write("            <input name=\"roleName\" class=\"easyui-box ui-text\">\r\n");
      out.write("        </p>  \r\n");
      out.write("        <a href=\"#\" id=\"btn-search\" class=\"easyui-linkbutton\" iconCls=\"icon-search\">查询</a>\r\n");
      out.write("      </form>  \r\n");
      out.write("     </div> \r\n");
      out.write("     <!--  Search panel end -->\r\n");
      out.write("     \r\n");
      out.write("     <!-- DataList  -->\r\n");
      out.write("     <form id=\"listForm\" method=\"post\">\r\n");
      out.write("     <table id=\"data-list\"></table>\r\n");
      out.write("\t </form> \r\n");
      out.write("     <!-- Edit Form -->\r\n");
      out.write("     <div id=\"edit-win\" class=\"easyui-dialog\" title=\"角色管理\" data-options=\"closed:true,iconCls:'icon-save',modal:true\" style=\"width:400px;height:520px;\">  \r\n");
      out.write("     \t<form id=\"editForm\" class=\"ui-form\" method=\"post\">  \r\n");
      out.write("     \t\t <input class=\"hidden\" type=\"text\" name=\"id\">\r\n");
      out.write("     \t\t <div class=\"ui-edit\">\r\n");
      out.write("\t     \t   <div class=\"ftitle\">角色信息</div>    \r\n");
      out.write("\t           <div class=\"fitem\">  \r\n");
      out.write("\t               <label>角色名:</label>  \r\n");
      out.write("\t               <input class=\"easyui-validatebox\" type=\"text\" name=\"roleName\" data-options=\"required:true,validType:'length[1,20]'\">\r\n");
      out.write("\t           </div>  \r\n");
      out.write("\t           <div class=\"fitem\">  \r\n");
      out.write("\t               <label>状态:</label>  \r\n");
      out.write("\t               <select class=\"easyui-combobox\" name=\"state\" data-options=\"required:true,width:150\">\r\n");
      out.write("                    \t<option value=\"0\" selected=\"selected\">可用</option>\r\n");
      out.write("                    \t<option value=\"1\">禁用</option>\r\n");
      out.write("                   \t</select>\r\n");
      out.write("\t           </div>  \r\n");
      out.write("\t            <div class=\"fitem\" style=\"\">  \r\n");
      out.write("\t               <label>权限项:</label>\r\n");
      out.write("\t               <div style=\"border: 1px solid #A4BED4; width:230px;height:200px;margin-left: 105px ;overflow: auto; \">  \r\n");
      out.write("\t               \t<ul id=\"menu-tree\"  >\r\n");
      out.write("\t               \t</ul>\r\n");
      out.write("\t               </div>\r\n");
      out.write("\t           </div>\r\n");
      out.write("\t           <div class=\"fitem\">  \r\n");
      out.write("\t               <label>角色描述:</label>  \r\n");
      out.write("\t               <input class=\"easyui-validatebox\" id=\"descr\" name=\"descr\" >\r\n");
      out.write("\t           </div>\r\n");
      out.write("\t         </div>\r\n");
      out.write("     \t</form>\r\n");
      out.write("  \t </div> \r\n");
      out.write("  \r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/commons/YDataGrid.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/ux/sys/sysRole.js\"></script>\r\n");
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
}
