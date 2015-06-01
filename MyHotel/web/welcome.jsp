<%-- 
    Document   : welcome
    Created on : Jun 1, 2015, 6:52:49 PM
    Author     : Stavros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <h1>Hello  <%= session.getAttribute("username") %>!</h1>
        <form action="reservation.jsp">
            Make an online reservation: <input type="submit" value="Book">
        </form>
    </body>
</html>
