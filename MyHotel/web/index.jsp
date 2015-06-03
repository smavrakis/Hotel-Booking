<%-- 
    Document   : index
    Created on : Jun 2, 2015, 5:56:06 PM
    Author     : Stavros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <%            
            String username = request.getRemoteUser();            
            pageContext.setAttribute("username",username);
        %>
        
        <c:choose>
            <c:when test="${username != null}">
                Logged in as:  <%= username %>
                <form action="getUserInfoServlet">
                    <input type="submit" value="Manage Account">
                </form>
                <form action="logoutServlet">
                    <input type="submit" value="Log Out">
                </form>
                <br>
                <form action="getReservationServlet">
                    <input type="submit" value="Show my reservation">
                </form>
            </c:when>
        </c:choose>
        
        <form action="reservation.jsp">
            <input type="submit" value="Book it!">
        </form>        
    </body>
</html>
