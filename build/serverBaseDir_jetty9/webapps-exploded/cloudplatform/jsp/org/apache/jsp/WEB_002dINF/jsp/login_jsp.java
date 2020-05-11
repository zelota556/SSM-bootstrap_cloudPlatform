package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html  lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <base href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <title>User Login</title>\r\n");
      out.write("    <!--bootstrap.min.css-->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("    <!--style.css-->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("    <!--jquery.js-->\r\n");
      out.write("    <script src=\"js/jquery-3.4.1.js\"></script>\r\n");
      out.write("    <!--bootstrap.min.js-->\r\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("    <!--bootstrap-show-password.min.js-->\r\n");
      out.write("    <script src=\"js/bootstrap-show-password.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<!-- ç»å½ -->\r\n");
      out.write("<div class=\"container-fluid\">\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("        <!-- å·¦ -->\r\n");
      out.write("        <div class=\"col-sm-6\">\r\n");
      out.write("            <!-- å·¦ä¾§å¾ç -->\r\n");
      out.write("            <div class=\"sign-bgleft\">\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- å³ -->\r\n");
      out.write("        <div class=\"col-sm-6\">\r\n");
      out.write("            <div class=\"sign-content\">\r\n");
      out.write("                <h2>Login</h2>\r\n");
      out.write("                <!-- ç»å½è¡¨å -->\r\n");
      out.write("                <div class=\"signin-form\">\r\n");
      out.write("                    <form id=\"userLoginInfo\">\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label>UserName</label>\r\n");
      out.write("                        <input type=\"text\" name=\"userName\" class=\"form-control\" placeholder=\"Enter your username......\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label>Password</label>\r\n");
      out.write("                        <input type=\"password\" name=\"password\" id=\"password\" class=\"form-control\" placeholder=\"Enter your password......\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!-- è®°ä½å¯ç  -->\r\n");
      out.write("                <div class=\"signin-password\">\r\n");
      out.write("                    <div class=\"checkbox-list\">\r\n");
      out.write("                        <ul class=\"list\">\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input class=\"password-checkbox\" type=\"checkbox\">\r\n");
      out.write("                                <label for=\"label-checkbox\">remember me!</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"#\">Forget?</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!-- ç»å½æé® -->\r\n");
      out.write("                <div class=\"signin-footer\">\r\n");
      out.write("                    <button type=\"button\" class=\"btn signin_btn\" onclick=\"login()\">Login!</button>\r\n");
      out.write("                    <p>\r\n");
      out.write("                        Don't have an account? enroll one!\r\n");
      out.write("                        <a href=\"signup.html\">Enroll</a>\r\n");
      out.write("                    </p>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("    $(\"#password\").password({\r\n");
      out.write("    });\r\n");
      out.write("    $('#password').password('show');\r\n");
      out.write("    $('#password').password('hide');\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    function login() {\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            url:'user/login',\r\n");
      out.write("            type:'post',\r\n");
      out.write("            async:false,     //è®¾ç½®åæ­¥æå¯ä¿å­ãæä½æ°æ®\r\n");
      out.write("            data:new FormData($(\"#userLoginInfo\")[0]),\r\n");
      out.write("            cache:false,\r\n");
      out.write("            processData: false,   // jQueryä¸å»å¤çåéçæ°æ®\r\n");
      out.write("            contentType : false,  //jQueryä¸å»å¤çè¡¨å¤´\r\n");
      out.write("            success: function (result) {\r\n");
      out.write("                if(result !=null && result.success){\r\n");
      out.write("                    alert(\"Login success!\");\r\n");
      out.write("                    window.location = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/\"+\"main\";\r\n");
      out.write("                }\r\n");
      out.write("            else{\r\n");
      out.write("                    alert(\"tips:  \"+result.message);\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        })\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</html>");
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
