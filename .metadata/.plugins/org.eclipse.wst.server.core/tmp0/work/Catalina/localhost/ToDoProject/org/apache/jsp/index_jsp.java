/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.23
 * Generated at: 2017-12-23 11:09:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("\thref=\"https://unpkg.com/angular-toastr/dist/angular-toastr.css\" />\n");
      out.write("\n");
      out.write("<link\n");
      out.write("\thref=\"bower_components/angular-image-preloader/dist/angular-image-preloader.min.js\" />\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("\thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("\thref=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("\thref=\"http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("<!------------------------- angular  ---------------------------->\n");
      out.write("\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.min.js\"></script>\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"bower_components/angular-base64/angular-base64.min.js\"></script>\n");
      out.write("<script\n");
      out.write("\tsrc=\"bower_components/angular-base64-upload/dist/angular-base64-upload.min.js\"></script>\n");
      out.write("<script src=\"bower_components/ng-file-upload/ng-file-upload.min.js\"></script>\n");
      out.write("\n");
      out.write("<script src=\"https://connect.facebook.net/en_US/sdk.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/1.0.3/angular-ui-router.min.js\"></script>\n");
      out.write("\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("<script\n");
      out.write("\tsrc=\"http://ajax.googleapis.com/ajax/libs/angularjs/1.3.8/angular-sanitize.js\"></script>\n");
      out.write("<script src=\"https://connect.facebook.net/enUS/all.js\"></script>\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/2.5.0/ui-bootstrap-tpls.js\"></script>\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\"></script>\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.min.js\"></script>\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\"></script>\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js\"></script>\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://unpkg.com/angular-toastr/dist/angular-toastr.tpls.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-------------------------   Script .js ---------------------------->\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"script/TodoApp.js\"></script>\n");
      out.write("\n");
      out.write("<!-------------------------   Controllers .js ---------------------------->\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"controller/loginController.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"controller/registerController.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"controller/ForgotPassword.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"controller/homeController.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"controller/dummyController.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-------------------------   sevices .js ---------------------------->\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"services/loginService.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"services/registerService.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"services/forgotPasswordService.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"services/homeService.js\"></script>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"services/dummyService.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"script/scripts.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-------------------------   css  .css ---------------------------->\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"css/login.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/registrationPage.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/forgetpassword.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/Home.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/TopNavBar.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/SideNavBar.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/card.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-------------------------   custom Directives ---------------------------->\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"directives/CustomDirectives.js\"></script>\n");
      out.write("\n");
      out.write("<title>Todo App</title>\n");
      out.write("</head>\n");
      out.write("<body ng-app=\"ToDo\">\n");
      out.write("\t<div ui-view></div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
