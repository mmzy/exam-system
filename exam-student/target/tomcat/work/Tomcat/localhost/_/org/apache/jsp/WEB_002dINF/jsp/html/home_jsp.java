/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-12-29 06:56:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');
 String path = request.getContextPath(); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"renderer\" content=\"webkit|ie-comp|ie-stand\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no\" />\r\n");
      out.write("<meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" />\r\n");
      out.write("<!--[if lt IE 9]>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/lib/html5.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/lib/respond.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/lib/PIE_IE678.js\"></script>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(path);
      out.write("/css/home.css\" type=\"text/css\" />\r\n");
      out.write("<!--[if IE 6]>\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js\" ></script>\r\n");
      out.write("<script>DD_belatedPNG.fix('*');</script>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/lib/jquery/1.9.1/jquery.min.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/lib/layer/1.9.3/layer.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/lib/My97DatePicker/WdatePicker.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/js/H-ui.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/js/H-ui.admin.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/js/common.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<title>在线考试后台管理系统</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var examId = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${publishexam.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("function homeClickEnter() {\r\n");
      out.write("  \twindow.location.href = '/html/login?id=' + examId;\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("  <div class=\"content-div\">\r\n");
      out.write("    <div class=\"title\">\r\n");
      out.write("      <i></i>\r\n");
      out.write("      <span>湖南省安全生产培训理论考试平台</span>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"panel\">\r\n");
      out.write("      <div class=\"posi-label\">座位号</div>\r\n");
      out.write("      <div class=\"posi-num\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${studentInfo.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</div>\r\n");
      out.write("      <div class=\"enter-btn\" onClick=\"homeClickEnter()\">进入系统</div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"footer-div\">\r\n");
      out.write("      <p>湖南省应急管理厅</p>\r\n");
      out.write("      <p>？？市广联科技有限公司</p>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</body>\r\n");
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
