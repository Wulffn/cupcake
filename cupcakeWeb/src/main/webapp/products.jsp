<%-- 
    Document   : products
    Created on : Sep 25, 2018, 1:05:50 PM
    Author     : Christian
--%>

<%@page import="DTO.LineItem"%>
<%@page import="DTO.User"%>
<%@page import="DTO.Cupcake"%>
<%@page import="java.util.List"%>
<%@page import="data.DataMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%List<Cupcake> listbottom = (List) request.getAttribute("productlistsbottom");%>
<%List<Cupcake> listtop = (List) request.getAttribute("productliststop");%>
<%List<LineItem> listlineitem = (List) request.getSession().getAttribute("shoppingcart");%>
<%User currentUser = (User) request.getSession().getAttribute("currentUser");%>

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
                    <a class="navbar-brand" href="#">Cupcake Shop</a>
                </div>
                <div class="pull-right" id="userBar">
                    <a class="navbar-brand">Logged in as: <% out.print(currentUser.getName()); %></a>
                    <a class="navbar-brand">Balance: <% out.print(currentUser.getBalance()); %></a>
                </div>
            </div>
        </nav>

        <div class="col-md-12">
            <h3>Compose cupcakes from 1 bottom and 1 top and add to the shopping cart</h3>
            <hr> 
        </div>

        <div>
            <form action="Control" method="post">
                <div class="col-md-3">
                    <h5>Bottom</h5>

                    <select name="bottom"> 
                        <option>Choose Bottom</option>  
                        <% for (Cupcake cupcake : listbottom) {
                                out.print("<option value=" + cupcake.getBottom() + "," + cupcake.getBottomPrice() + ">" + cupcake.getBottom() + " " + cupcake.getBottomPrice() + "</option>");
                            }
                        %>
                    </select>

                </div>
                <div class="col-md-3">
                    <h5>Top</h5>
                    <select name="top"> 
                        <option>Choose Top</option>  
                        <% for (Cupcake cupcake : listtop) {
                                out.print("<option value=" + cupcake.getTopping() + "," + cupcake.getToppingPrice() + ">" + cupcake.getTopping() + " " + cupcake.getToppingPrice() + "</option>");
                            }
                        %>
                    </select>
                </div>
                <div class="col-md-6">
                    <h5>selecting</h5>
                    <input type="text" name="quantity" value="" placeholder="Quantity">
                    <input type="submit" value="addtocart">
                    <input type="hidden" name="origin" value="products">
                </div>
            </form>
        </div>
        <div class="col-md-12">
            <%
                
                    //out.print(listlineitem.get(i).getCupcake().getBottom());
               
                    

                //out.print(listlineitem.get(0).getCupcake().getBottom());
            %>
        </div>
    </body>
</html>
