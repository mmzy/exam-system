/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-12-29 08:14:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("  \t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<meta name=\"renderer\" content=\"webkit|ie-comp|ie-stand\">\r\n");
      out.write("\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no\" />\r\n");
      out.write("\t<meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" />\r\n");
      out.write("    <title>学生登录页面</title>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("\t<!--\r\n");
      out.write("\tbody {\r\n");
      out.write("\t\tmargin-left: 0px;\r\n");
      out.write("\t\tmargin-top: 0px;\r\n");
      out.write("\t\tmargin-right: 0px;\r\n");
      out.write("\t\tmargin-bottom: 0px;\r\n");
      out.write("\t\tbackground-color: #1D3647;\r\n");
      out.write("\t}\r\n");
      out.write("\t.STYLE1 {color: #E6EBF1}\r\n");
      out.write("\t-->\r\n");
      out.write("\t</style>\r\n");
      out.write("\t<link href=\"");
      out.print(path );
      out.write("/images/skin.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("\t  <table width=\"100%\" height=\"166\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t  <tr>\r\n");
      out.write("\t    <td height=\"42\" valign=\"top\"><table width=\"100%\" height=\"42\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"login_top_bg\">\r\n");
      out.write("\t      <tr>\r\n");
      out.write("\t        <td width=\"1%\" height=\"21\">&nbsp;</td>\r\n");
      out.write("\t        <td height=\"42\">&nbsp;</td>\r\n");
      out.write("\t        <td width=\"17%\">&nbsp;</td>\r\n");
      out.write("\t      </tr>\r\n");
      out.write("\t    </table></td>\r\n");
      out.write("\t  </tr>\r\n");
      out.write("\t  <tr>\r\n");
      out.write("\t    <td valign=\"top\"><table width=\"100%\" height=\"532\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"login_bg\">\r\n");
      out.write("\t      <tr>\r\n");
      out.write("\t        <td width=\"49%\" align=\"right\"><table width=\"91%\" height=\"532\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"login_bg2\">\r\n");
      out.write("\t            <tr>\r\n");
      out.write("\t              <td height=\"138\" valign=\"top\"><table width=\"89%\" height=\"427\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t                <tr>\r\n");
      out.write("\t                  <td height=\"149\">&nbsp;</td>\r\n");
      out.write("\t                </tr>\r\n");
      out.write("\t                <!-- <tr>\r\n");
      out.write("\t                  <td height=\"80\" align=\"right\" valign=\"top\">&nbsp;</td>\r\n");
      out.write("\t                </tr> -->\r\n");
      out.write("\t                <tr>\r\n");
      out.write("\t                  <td height=\"198\" align=\"right\" valign=\"top\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t                    <tr>\r\n");
      out.write("\t                      <td width=\"35%\">&nbsp;</td>\r\n");
      out.write("\t                      <td width=\"65%\" height=\"25\" class=\"left_txt\"><p>1- 学生查看考试信息</p></td>\r\n");
      out.write("\t                    </tr>\r\n");
      out.write("\t                    <tr>\r\n");
      out.write("\t                      <td>&nbsp;</td>\r\n");
      out.write("\t                      <td height=\"25\" class=\"left_txt\"><p>2- 学生进行考试</p></td>\r\n");
      out.write("\t                    </tr>\r\n");
      out.write("\t                    <tr>\r\n");
      out.write("\t                      <td>&nbsp;</td>\r\n");
      out.write("\t                      <td height=\"25\" class=\"left_txt\"><p>3- 学生查询自己的成绩</p></td>\r\n");
      out.write("\t                    </tr>\r\n");
      out.write("\t                  </table></td>\r\n");
      out.write("\t                </tr>\r\n");
      out.write("\t              </table></td>\r\n");
      out.write("\t            </tr>\r\n");
      out.write("\t            \r\n");
      out.write("\t        </table></td>\r\n");
      out.write("\t        <td width=\"1%\" >&nbsp;</td>\r\n");
      out.write("\t        <td width=\"50%\" valign=\"bottom\"><table width=\"100%\" height=\"59\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t            <tr>\r\n");
      out.write("\t              <td width=\"4%\">&nbsp;</td>\r\n");
      out.write("\t              <td width=\"96%\" height=\"38\"><span class=\"login_txt_bt\">学生登录</span></td>\r\n");
      out.write("\t            </tr>\r\n");
      out.write("\t            <tr>\r\n");
      out.write("\t              <td>&nbsp;</td>\r\n");
      out.write("\t              <td height=\"21\"><table cellSpacing=\"0\" cellPadding=\"0\" width=\"100%\" border=\"0\" id=\"table211\" height=\"328\">\r\n");
      out.write("\t                  <tr>\r\n");
      out.write("\t                    <td height=\"164\" colspan=\"2\" align=\"middle\">\r\n");
      out.write("\t                    \r\n");
      out.write("\t                    \t<form name=\"myform\" action=\"");
      out.print(path );
      out.write("/student/login\" method=\"post\">\r\n");
      out.write("\t                        <table cellSpacing=\"0\" cellPadding=\"0\" width=\"100%\" border=\"0\" height=\"143\" id=\"table212\">\r\n");
      out.write("\t                          <tr>\r\n");
      out.write("\t                          \t<td colspan=\"2\"><FONT color=\"red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("<s:actionerror/></FONT></td><!--显示错误信息 -->\r\n");
      out.write("\t                          </tr>\r\n");
      out.write("\t                          <tr>\r\n");
      out.write("\t                            <td width=\"14%\" height=\"38\" class=\"top_hui_text\"><span class=\"login_txt\">编号：&nbsp;&nbsp; </span></td>\r\n");
      out.write("\t                            <td height=\"38\" colspan=\"2\" class=\"top_hui_text\"><input name=\"id\" class=\"editbox4\" value=\"\" size=\"20\">                            </td>\r\n");
      out.write("\t                          </tr>\r\n");
      out.write("\t                          <tr>\r\n");
      out.write("\t                            <td width=\"14%\" height=\"35\" class=\"top_hui_text\"><span class=\"login_txt\"> 密 码： &nbsp;&nbsp; </span></td>\r\n");
      out.write("\t                            <td height=\"35\" colspan=\"2\" class=\"top_hui_text\"><input class=\"editbox4\" type=\"password\" size=\"20\" name=\"password\">\r\n");
      out.write("\t                              <img src=\"");
      out.print(path );
      out.write("/images/luck.gif\" width=\"19\" height=\"18\"> </td>\r\n");
      out.write("\t                          </tr>\r\n");
      out.write("\t                          <tr>\r\n");
      out.write("\t                            <!-- <td width=\"14%\" height=\"35\" ><span class=\"login_txt\">登录角色：</span></td>\r\n");
      out.write("\t                            <td height=\"35\" colspan=\"2\" class=\"login_txt\"><input type=\"radio\" name=\"role\" value=\"teacher\" checked=\"checked\">教师\r\n");
      out.write("\t                                <input type=\"radio\" name=\"role\" value=\"student\">学生</td> -->\r\n");
      out.write("\t                          </tr>\r\n");
      out.write("\t                          <tr>\r\n");
      out.write("\t                            <td height=\"35\" >&nbsp;</td>\r\n");
      out.write("\t                            <td width=\"19%\" height=\"35\" ><input name=\"Submit\" type=\"submit\" class=\"button\" id=\"Submit\" value=\"登 录\"> </td>\r\n");
      out.write("\t                            <td width=\"67%\" class=\"top_hui_text\"><input name=\"cs\" type=\"button\" class=\"button\" id=\"cs\" value=\"取 消\" onClick=\"showConfirmMsg1()\"></td>\r\n");
      out.write("\t                          </tr>\r\n");
      out.write("\t                        </table>\r\n");
      out.write("\t                        <br>\r\n");
      out.write("\t                    </form></td>\r\n");
      out.write("\t                  </tr>\r\n");
      out.write("\t                  <tr>\r\n");
      out.write("\t                    <td width=\"433\" height=\"164\" align=\"right\" valign=\"bottom\"><img src=\"");
      out.print(path );
      out.write("/images/login-wel.gif\" width=\"242\" height=\"138\"></td>\r\n");
      out.write("\t                    <td width=\"57\" align=\"right\" valign=\"bottom\">&nbsp;</td>\r\n");
      out.write("\t                  </tr>\r\n");
      out.write("\t              </table></td>\r\n");
      out.write("\t            </tr>\r\n");
      out.write("\t          </table>\r\n");
      out.write("\t          </td>\r\n");
      out.write("\t      </tr>\r\n");
      out.write("\t    </table></td>\r\n");
      out.write("\t  </tr>\r\n");
      out.write("\t  <tr>\r\n");
      out.write("\t    <td height=\"20\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"login-buttom-bg\">\r\n");
      out.write("\t      <tr>\r\n");
      out.write("\t        <td align=\"center\"><span class=\"login-buttom-txt STYLE1\">在线考试后台管理系统</span></td>\r\n");
      out.write("\t      </tr>\r\n");
      out.write("\t    </table></td>\r\n");
      out.write("\t  </tr>\r\n");
      out.write("\t</table>\r\n");
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
