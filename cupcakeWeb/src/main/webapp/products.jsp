<%-- 
    Document   : products
    Created on : Sep 25, 2018, 1:05:50 PM
    Author     : Christian
--%>

<%@page import="DTO.Cupcake"%>
<%@page import="java.util.List"%>
<%@page import="data.DataMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%List<Cupcake> listbottom = (List) request.getAttribute("productlistsbottom");%>
<%List<Cupcake> listtop = (List) request.getAttribute("productliststop");%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">cupcake shop</a>
                </div>
            </div>
        </nav>
        <div>
            <div class="col-md-3">
                <h5>Bottom</h5>
                <select> 
                    
                    <option>Choose Bottom</option>
                    <%for (int i = 0; i < listbottom.size();i++)
                    {
                        out.print("<option> "+listbottom.get(i).getBottom() +" </option>");
                    }
}%>
                </select>
            </div>
            <div class="col-md-3"></div>
            <div class="col-md-3"></div>
            <div class="col-md-3"></div>
        </div>
    </body>
</html>
