package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.zelot.ModelDo.User;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <!-- 响应式设置viewport -->\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <!-- 图标 -->\r\n");
      out.write("    <link rel=\"icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/img/icon.png\">\r\n");
      out.write("    <!-- 标题 -->\r\n");
      out.write("    <title>物联网管理系统</title>\r\n");
      out.write("    <!-- Bootstrap CSS -->\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- jQuery -->\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("    <!-- Bootstrap JS -->\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <!-- 样式 CSS-->\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/main.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<!-- 头部导航栏 -->\r\n");
      out.write("<nav class=\"navbar navbar-default navbar-fixed-top\">\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("        <div class=\"navbar-header\">\r\n");
      out.write("            <!-- 屏幕变窄出现一个下拉菜单 -->\r\n");
      out.write("            <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\r\n");
      out.write("                <!-- 按钮图标 -->\r\n");
      out.write("                <span class=\"sr-only\"></span>\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("                <!-- /按钮图标 -->\r\n");
      out.write("            </button>\r\n");
      out.write("            <!-- /屏幕变窄出现一个下拉菜单 -->\r\n");
      out.write("            <a href=\"jsp/main.jsp\" class=\"navbar-left\">\r\n");
      out.write("                <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/img/icon.png\" width=\"50px\">\r\n");
      out.write("                <a class=\"navbar-brand\" href=\"html/main.html\">物联网管理系统</a>\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"navbar\" class=\"navbar-collapse collapse\">\r\n");
      out.write("            <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("                <li>\r\n");
      out.write("                    <a href=\"#\">\r\n");
      out.write("                        ");
 User user = (User) request.getSession().getAttribute("userSession");
      out.write("\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-info\">欢迎!");
      out.print(user.getUserName());
      out.write("</button>\r\n");
      out.write("                    </a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <a>\r\n");
      out.write("                    <button type=\"button\"  class=\"btn btn-default\" onclick=\"exit()\" >登出</button>\r\n");
      out.write("                    </a>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("<!-- /头部导航栏 -->\r\n");
      out.write("\r\n");
      out.write("<!-- 主体 -->\r\n");
      out.write("<div class=\"container-fluid\">\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("        <!-- 左侧导航栏 -->\r\n");
      out.write("        <div class=\"col-sm-3 col-md-2 sidebar\">\r\n");
      out.write("            <ul class=\"nav nav-sidebar\">\r\n");
      out.write("                <li class=\"active\"><a href=\"main\"><span class=\"glyphicon glyphicon-home\"></span>&emsp;首页</a> </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <ul class=\"nav nav-sidebar\">\r\n");
      out.write("                <li class=\"active\"><a><span class=\"glyphicon glyphicon-th-list\"></span>&emsp;用户管理</a></li>\r\n");
      out.write("                <li><a href=\"user\" target=\"mainframe\">&emsp;&emsp;用户列表</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <ul class=\"nav nav-sidebar\">\r\n");
      out.write("                <li class=\"active\"><a> <span class=\"glyphicon glyphicon-th-list\"></span>&emsp;设备管理</a></li>\r\n");
      out.write("                <li><a href=\"device\" target=\"mainframe\">&emsp;&emsp;设备列表</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /左侧导航栏 -->\r\n");
      out.write("\r\n");
      out.write("        <!-- 主体内容 -->\r\n");
      out.write("\r\n");
      out.write("        ");

            String realPath = "http://" + request.getServerName() + ":" + request.getServerPort()
                    + request.getContextPath()+request.getServletPath().substring(0,request.getServletPath().lastIndexOf("/")+1);
        
      out.write("\r\n");
      out.write("        <div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\">\r\n");
      out.write("            <iframe src= ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${realpath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"welcome\" id=\"mainframe\" name=\"mainframe\" frameborder=\"0\" width=\"100%\" height=\"850\">\r\n");
      out.write("\r\n");
      out.write("            </iframe>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /主体内容 -->\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- /主体 -->\r\n");
      out.write("<!-- 页脚 -->\r\n");
      out.write("<div class=\"navbar-fixed-bottom footer\">@物联网管理系统</div>\r\n");
      out.write("<!-- /页脚 -->\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    function exit() {\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            type:'post',\r\n");
      out.write("            url:'user/logout',\r\n");
      out.write("            data:\"\",\r\n");
      out.write("            dataType:'json',\r\n");
      out.write("        })\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
