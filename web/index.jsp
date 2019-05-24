
<%@page import="lt.bit.data.Util"%>
<%@page import="java.util.List"%>
<%@page import="lt.bit.data.Person"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="org.apache.commons.logging.LogFactory"%>
<%@page import="org.apache.commons.logging.Log"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>    
              <script>function save() {
                let p = {
                    firstName: $("#firstName").val(),
                    lastName: $("#lastName").val(),
                    salary: $("#salary").val()
                };
                $.ajax({
                    url: "http://localhost:8080/addressbook/rest/person/",
                    contentType: "application/json",
                    method: "POST",
                    dataType:"json",
                   data: JSON.stringify(p),
                    error: function (xhr, statusText, errorThrown) {
                        alert("Failed to get data from Server");
                    },
                    success: function (data, statusText, xhr) {
                        console.log(data);
                    }
                });
            }
        </script>
        <script>function put() {
                let p = {
                    id: parseInt($("#id").val()),
                    firstName: $("#firstName").val(),
                    lastName: $("#lastName").val(),
                    salary: $("#salary").val()
                };
                $.ajax({
                    url: "http://localhost:8080/addressbook/rest/person/",
                    contentType: "application/json",
                    method: "PUT",
                    dataType:"json",
                   data: JSON.stringify(p),
                    error: function (xhr, statusText, errorThrown) {
                        alert("Failed to get data from Server");
                    },
                    success: function (data, statusText, xhr) {
                        console.log(data);
                    }
                });
            }
        </script>
        <script>
            function enter() {
                document.getElementById("irasymo").style.display="block";
            }

            function uzdaryti() {
                document.getElementById("irasymo").style.display = "none";
            }
        </script>


        <form>
            <input name="namePart">
            <input type="submit" value="Filter">
        </form>            
        <h1>-----PRADZIU PRADZIA ----</h1>
        <%
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

        %>
    <li>
        <b>First Name: </b><%=Util.escapeHTML(p.getFirstName())%> 
        <b> Last name: </b><%=Util.escapeHTML(p.getLastName())%>
        <b> Salary: </b><%= p.getSalary()%>
        <b> Date of Birth: </b><%=p.getBirthDate()%>
        <a href="DelPerson?id=<%=p.getId()%>">Delete</a>
        <a href="edit.jsp?id=<%=p.getId()%>">Edit</a>
        <%--    <a href="address.jsp?personId=<%=p.getId()%>">Addresses</a>
             <a href="contact.jsp?personId=<%=p.getId()%>">Contacts</a> --%>
    </li>
    <%}%>
    <h3>----------------------</h3>
    <button onclick="enter()">New Person</button>
    
    <div style="display: none" id="irasymo"  >
        <input name="firstName" id ="firstName" value="first name">
        <input name="lastName" id ="lastName"value="last name">
        <input name="salary" id ="salary"value="salary">
        <button onclick="save();">Save</button>
        <button onclick="uzdaryti()">Uzdaryti</button>
    </div>


</body>
</html>