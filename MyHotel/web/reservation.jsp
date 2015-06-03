<%-- 
    Document   : reservation
    Created on : Jun 1, 2015, 6:19:56 PM
    Author     : Stavros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservation</title>
    </head>
    <body>
        <%
            String username = request.getRemoteUser();
            String roomError = (String)session.getAttribute("roomError");
            String reserveError = (String)session.getAttribute("reserveError");
            pageContext.setAttribute("username",username);
            pageContext.setAttribute("roomError",roomError);
            pageContext.setAttribute("reserveError",reserveError);
        %>
        
        <c:choose>
            <c:when test="${username != null}">
                Logged in as:  <%= username %>
                <form action="getUserInfoServlet">
                    <input type="submit" value="Manage Account">
                </form>
                <form action="getReservationServlet">
                    <input type="submit" value="Show my reservation">
                </form>
                <form action="logoutServlet">
                    <input type="submit" value="Log Out">
                </form>
                <br>
                <form action="makeReservationServlet" method="post">
                    Type of room:<br>
                    <input type="radio" name="roomNumber" value="1">1<br>
                    <input type="radio" name="roomNumber" value="2">2<br>
                    <input type="radio" name="roomNumber" value="3">3<br>
                    <input type="radio" name="roomNumber" value="4">4<br>
                    Arrival: <input type="date" name="from" max="2016-06-30"><br>
                    Departure: <input type="date" name="to" max="2016-07-31">
                    <input type="submit" value="Book">            
                </form>                
                <c:choose>
                    <c:when test="${roomError != null}">
                        <br>
                        <p>Please choose a room type and/or Arrival/Departure dates</p>
                    </c:when>
                    <c:when test="${reserveError != null}">
                        <br>
                        <p>Please choose different dates or room, those are unavailable</p>
                    </c:when>   
                </c:choose>
            </c:when>
        </c:choose>                
        
        <form action="index.jsp">
            <input type="submit" value="Home">
        </form>        
    </body>
</html>
