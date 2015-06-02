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
            String flag = (String)request.getAttribute("flag");
            String username = (String)session.getAttribute("username");
            pageContext.setAttribute("flag",flag);
            pageContext.setAttribute("username",username);
        %>
        
        <c:choose>
            <c:when test="${flag != 'true'}">
                <%
                    request.setAttribute("url", "/index.jsp" );
                %>
                <jsp:forward page="/checkIfLoggedIn" />
            </c:when>
        </c:choose>
        
        <c:choose>
            <c:when test="${username != null}">
                Logged in as:  <%= session.getAttribute("username") %>
                <form action="logoutServlet">
                    <input type="submit" value="Log Out">
                </form>
                <br>
            </c:when>
        </c:choose>
        
        <form action="reservation.jsp">
            <input type="submit" value="Book it!">
        </form>
    </body>
</html>
