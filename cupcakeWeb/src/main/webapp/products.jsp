<%-- 
    Document   : products
    Created on : Sep 25, 2018, 1:05:50 PM
    Author     : Christian
--%>

<%@page import="java.util.List"%>
<%@page import="data.DataMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%List listbottom = (List) request.getAttribute("productlistsbottom");%>
        <%List listtop = (List) request.getAttribute("productliststop");%>


        <ul>
            <% for (int i = 0; i < listbottom.size(); i++) {
                    out.print("<li>" + listbottom.get(i) + "</li>");
                }
                for (int i = 0; i < listtop.size(); i++) {
                    out.print("<li>" + listtop.get(i) + "</li>");
                }
            %>
        </ul>
    </body>
</html>
