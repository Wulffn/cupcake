<%-- 
    Document   : newjsp
    Created on : 24-Sep-2018, 09:37:49
    Author     : Mark
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page Testing</title>
    </head>
    <body>
        <div id="container">
            <div> 
                <h1>Hello World!</h1>
                <hr>
                <form action="Control" method="POST"
                    <input type="text" name="username"/>
                    <input type="hidden" name="origin"/>
                    <input type="submit" value="Submit"/>
                    <% out.println("javacode"); %>
                </form>
            </div>
        </div>
    </body>
</html>
