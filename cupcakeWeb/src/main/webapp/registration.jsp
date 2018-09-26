<%-- 
    Document   : registration
    Created on : Sep 25, 2018, 11:57:29 AM
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
        <h1>Hello World!</h1>
          <div align="center">
        <h1>Registration</h1>
        <form action="registration?login" method="post"> 
            Name:<br>
            <%  %>
            <input type="text" name="name" value="">
            <br>
            Username:<br>
            <input type="text" name="username" value="">
            <br>
            Password:<br>
            <input type="text" name="password" value="">
            <br><br>
            <input type="submit" value="Submit">
        </form> 
        </div>
    </body>
</html>
