/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-12-26 14:34:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
 String path = request.getContextPath(); 
      out.write("\n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<meta name=\"renderer\" content=\"webkit|ie-comp|ie-stand\">\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no\" />\n");
      out.write("<meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" />\n");
      out.write("\n");
      out.write("<link href=\"");
      out.print(path);
      out.write("/css/H-ui.min.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("<link href=\"");
      out.print(path);
      out.write("/css/H-ui.admin.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("<link href=\"");
      out.print(path);
      out.write("/css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("<link href=\"");
      out.print(path);
      out.write("/lib/Hui-iconfont/1.0.1/iconfont.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/lib/jquery/1.9.1/jquery.min.js\"></script> \n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/lib/layer/1.9.3/layer.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/lib/My97DatePicker/WdatePicker.js\"></script> \n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/js/H-ui.js\"></script> \n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/js/H-ui.admin.js\"></script> \n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/js/common.js\"></script>\n");
      out.write("\n");
      out.write("<link href=\"");
      out.print(path);
      out.write("/skin/default/skin.css\" rel=\"stylesheet\" type=\"text/css\" id=\"skin\" />\n");
      out.write("<title>在线考试后台管理系统</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<header class=\"Hui-header cl\"> \n");
      out.write("    <a class=\"Hui-logo l\" title=\"在线考试后台管理系统\">在线考试后台管理系统</a> \n");
      out.write("\t<ul class=\"Hui-userbar\">\n");
      out.write("\t\t<li class=\"dropDown dropDown_hover\"><a class=\"dropDown_A\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${studentInfo.name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(" <i class=\"Hui-iconfont\">&#xe6d5;</i></a>\n");
      out.write("\t\t\t<ul class=\"dropDown-menu radius box-shadow\">\n");
      out.write("\t\t\t\t<li><a onclick=\"showLayer('修改密码','");
      out.print(path);
      out.write("/student/updatePassword',600,371)\">修改密码</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(path);
      out.write("/student/logout\">退出</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</li>\n");
      out.write("\t\t<li id=\"Hui-skin\" class=\"dropDown right dropDown_hover\"><a href=\"javascript:;\" title=\"换肤\"><i class=\"Hui-iconfont\" style=\"font-size:18px\">&#xe62a;</i></a>\n");
      out.write("\t\t\t<ul class=\"dropDown-menu radius box-shadow\">\n");
      out.write("\t\t\t\t<li><a href=\"javascript:;\" data-val=\"default\" title=\"默认（黑色）\">默认（黑色）</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</li>\n");
      out.write("\t</ul>\n");
      out.write("\t<a aria-hidden=\"false\" class=\"Hui-nav-toggle\" href=\"#\"></a> </header>\n");
      out.write("    <aside class=\"Hui-aside\">\n");
      out.write("    \t<input runat=\"server\" id=\"divScrollValue\" type=\"hidden\" value=\"\" />\n");
      out.write("    \t<div class=\"menu_dropdown bk_2\">\n");
      out.write("    \t\t<dl id=\"menu-picture\">\n");
      out.write("    \t\t\t<dt><i class=\"Hui-iconfont\">&#xe613;</i>服务学生<i class=\"Hui-iconfont menu_dropdown-arrow\">&#xe6d5;</i></dt>\n");
      out.write("    \t\t\t<dd>\n");
      out.write("    \t\t\t\t<ul>\n");
      out.write("                        <li><a _href=\"");
      out.print(path);
      out.write("/exam/list\" href=\"javascript:void(0)\">考试管理</a></li>\n");
      out.write("                        <li><a _href=\"");
      out.print(path);
      out.write("/studentScore/list\" href=\"javascript:void(0)\">查询学生成绩</a></li>\n");
      out.write("                        <li><a _href=\"");
      out.print(path);
      out.write("/wrongBank/list\" href=\"javascript:void(0)\">错题库</a></li>\n");
      out.write("\t\t\n");
      out.write("    \t\t\t\t</ul>\n");
      out.write("    \t\t\t</dd>\n");
      out.write("    \t\t</dl>\n");
      out.write("    \t\t\n");
      out.write("    \t</div>\n");
      out.write("    </aside>\n");
      out.write("<div class=\"dislpayArrow\"><a class=\"pngfix\" href=\"javascript:void(0);\" onClick=\"displaynavbar(this)\"></a></div>\n");
      out.write("<section class=\"Hui-article-box\">\n");
      out.write("\t<div id=\"Hui-tabNav\" class=\"Hui-tabNav\">\n");
      out.write("\t\t<div class=\"Hui-tabNav-wp\">\n");
      out.write("\t\t\t<ul id=\"min_title_list\" class=\"acrossTab cl\">\n");
      out.write("\t\t\t\t<li class=\"active\"><span title=\"我的桌面\" data-href=\"");
      out.print(path);
      out.write("/welcome\">我的桌面</span><em></em></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"Hui-tabNav-more btn-group\"><a id=\"js-tabNav-prev\" class=\"btn radius btn-default size-S\" href=\"javascript:;\"><i class=\"Hui-iconfont\">&#xe6d4;</i></a><a id=\"js-tabNav-next\" class=\"btn radius btn-default size-S\" href=\"javascript:;\"><i class=\"Hui-iconfont\">&#xe6d7;</i></a></div>\n");
      out.write("\t</div>\n");
      out.write("\t<div id=\"iframe_box\" class=\"Hui-article\">\n");
      out.write("\t\t<div class=\"show_iframe\">\n");
      out.write("\t\t\t<div style=\"display:none\" class=\"loading\"></div>\n");
      out.write("\t\t\t<iframe scrolling=\"yes\" frameborder=\"0\" src=\"");
      out.print(path);
      out.write("/welcome\"></iframe>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</section>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
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
