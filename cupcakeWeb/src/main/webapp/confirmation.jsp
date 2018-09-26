<%-- 
    Document   : confirmation
    Created on : Sep 26, 2018, 6:20:42 PM
    Author     : Christian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Order received</h1>
        <ul>
            <%double price = (double) request.getAttribute("confirmationprice");%>
            <%
                out.print("<li>" + price + "</li>");
            %>
        </ul>
    </body>
</html>
