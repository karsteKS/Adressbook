package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import lt.bit.data.Util;
import java.util.List;
import lt.bit.data.Person;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>    \n");
      out.write("              <script>function save() {\n");
      out.write("                let p = {\n");
      out.write("                    firstName: $(\"#firstName\").val(),\n");
      out.write("                    lastName: $(\"#lastName\").val(),\n");
      out.write("                    salary: $(\"#salary\").val()\n");
      out.write("                };\n");
      out.write("                $.ajax({\n");
      out.write("                    url: \"http://localhost:8080/addressbook/rest/person/\",\n");
      out.write("                    contentType: \"application/json\",\n");
      out.write("                    method: \"POST\",\n");
      out.write("                    dataType:\"json\",\n");
      out.write("                   data: JSON.stringify(p),\n");
      out.write("                    error: function (xhr, statusText, errorThrown) {\n");
      out.write("                        alert(\"Failed to get data from Server\");\n");
      out.write("                    },\n");
      out.write("                    success: function (data, statusText, xhr) {\n");
      out.write("                        console.log(data);\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <script>function put() {\n");
      out.write("                let p = {\n");
      out.write("                    id: parseInt($(\"#id\").val()),\n");
      out.write("                    firstName: $(\"#firstName\").val(),\n");
      out.write("                    lastName: $(\"#lastName\").val(),\n");
      out.write("                    salary: $(\"#salary\").val()\n");
      out.write("                };\n");
      out.write("                $.ajax({\n");
      out.write("                    url: \"http://localhost:8080/addressbook/rest/person/\",\n");
      out.write("                    contentType: \"application/json\",\n");
      out.write("                    method: \"PUT\",\n");
      out.write("                    dataType:\"json\",\n");
      out.write("                   data: JSON.stringify(p),\n");
      out.write("                    error: function (xhr, statusText, errorThrown) {\n");
      out.write("                        alert(\"Failed to get data from Server\");\n");
      out.write("                    },\n");
      out.write("                    success: function (data, statusText, xhr) {\n");
      out.write("                        console.log(data);\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <script>\n");
      out.write("            function enter() {\n");
      out.write("                document.getElementById(\"irasymo\").style.display=\"block\";\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function uzdaryti() {\n");
      out.write("                document.getElementById(\"irasymo\").style.display = \"none\";\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <form>\n");
      out.write("            <input name=\"namePart\">\n");
      out.write("            <input type=\"submit\" value=\"Filter\">\n");
      out.write("        </form>            \n");
      out.write("        <h1>-----PRADZIU PRADZIA ----</h1>\n");
      out.write("        ");

            Log log = LogFactory.getLog("jsp");
            EntityManager em = (EntityManager) request.getAttribute("em");
            //Query q = em.createQuery("select p from Person p");

            String namePart = request.getParameter("namePart");

            //jeigu parametro nera
            if (namePart == null) {
                namePart = "";
            }

            //kad ivestus tarpus ismestu
            namePart = namePart.trim(); //grazina stringa pasalines visus whitespace is priekio ir is galo

            Query q;
            if ("".equals(namePart)) {
                q = em.createQuery("select p from Person p");
            } /* jeigu tuscias filtras - imam visus irasus */ else {
                q = em.createQuery("select p from Person p where p.firstName like :namePart or p.lastName like :namePart");
                q.setParameter("namePart", "%" + namePart + "%");
            }

            //pakoreguotas ciklas
            List<Person> l = q.getResultList();
            for (int i = 0; i < l.size(); i++) {
                Person p = l.get(i);

        
      out.write("\n");
      out.write("    <li>\n");
      out.write("        <b>First Name: </b>");
      out.print(Util.escapeHTML(p.getFirstName()));
      out.write(" \n");
      out.write("        <b> Last name: </b>");
      out.print(Util.escapeHTML(p.getLastName()));
      out.write("\n");
      out.write("        <b> Salary: </b>");
      out.print( p.getSalary());
      out.write("\n");
      out.write("        <b> Date of Birth: </b>");
      out.print(p.getBirthDate());
      out.write("\n");
      out.write("        <a href=\"DelPerson?id=");
      out.print(p.getId());
      out.write("\">Delete</a>\n");
      out.write("        <a href=\"edit.jsp?id=");
      out.print(p.getId());
      out.write("\">Edit</a>\n");
      out.write("        ");
      out.write("\n");
      out.write("    </li>\n");
      out.write("    ");
}
      out.write("\n");
      out.write("    <h3>----------------------</h3>\n");
      out.write("    <button onclick=\"enter()\">New Person</button>\n");
      out.write("    \n");
      out.write("    <div style=\"display: none\" id=\"irasymo\"  >\n");
      out.write("        <input name=\"firstName\" id =\"firstName\" value=\"first name\">\n");
      out.write("        <input name=\"lastName\" id =\"lastName\"value=\"last name\">\n");
      out.write("        <input name=\"salary\" id =\"salary\"value=\"salary\">\n");
      out.write("        <button onclick=\"save();\">Save</button>\n");
      out.write("        <button onclick=\"uzdaryti()\">Uzdaryti</button>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
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
