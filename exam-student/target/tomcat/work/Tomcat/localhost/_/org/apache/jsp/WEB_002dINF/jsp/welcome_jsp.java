/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-04-23 14:46:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<meta name=\"renderer\" content=\"webkit|ie-comp|ie-stand\">\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no\" />\n");
      out.write("<meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" />\n");
      out.write("\n");
      out.write("<link href=\"css/H-ui.min.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("<link href=\"css/H-ui.admin.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("\n");
      out.write("<link href=\"lib/Hui-iconfont/1.0.1/iconfont.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("\n");
      out.write("<title>我的桌面</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"pd-20\" style=\"padding-top:20px;min-height: 436px;\">\n");
      out.write("  <p class=\"f-20 text-success\">欢迎使用在线考系统！</p>\n");
      out.write("</div>\n");
      out.write("<footer class=\"footer\">\n");
      out.write("  <p>感谢jQuery、layer、laypage、Validform、UEditor、My97DatePicker、iconfont、Datatables、WebUploaded、icheck、highcharts、bootstrap-Switch<br>Copyright &copy;2015 H-ui.admin v2.3 All Rights Reserved.<br>\n");
      out.write("    本后台系统由<a href=\"http://www.h-ui.net/\" target=\"_blank\" title=\"H-ui前端框架\">H-ui前端框架</a>提供前端技术支持</p>\n");
      out.write("</footer>\n");
      out.write("<script type=\"text/javascript\" src=\"lib/jquery/1.9.1/jquery.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"js/H-ui.js\"></script>\n");
      out.write("<script>\n");
      out.write("var _hmt = _hmt || [];\n");
      out.write("(function() {\n");
      out.write("  var hm = document.createElement(\"script\");\n");
      out.write("  hm.src = \"//hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911\";\n");
      out.write("  var s = document.getElementsByTagName(\"script\")[0]; \n");
      out.write("  s.parentNode.insertBefore(hm, s);\n");
      out.write("})();\n");
      out.write("var _bdhmProtocol = ((\"https:\" == document.location.protocol) ? \" https://\" : \" http://\");\n");
      out.write("document.write(unescape(\"%3Cscript src='\" + _bdhmProtocol + \"hm.baidu.com/h.js%3F080836300300be57b7f34f4b3e97d911' type='text/javascript'%3E%3C/script%3E\"));\n");
      out.write("</script>\n");
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