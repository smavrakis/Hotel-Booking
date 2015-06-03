<%-- 
    Document   : signup
    Created on : May 31, 2015, 7:06:09 PM
    Author     : Stavros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Signup</title>
    </head>
    <body>
        <%
            String registerError = (String)session.getAttribute("registerError");            
            pageContext.setAttribute("registerError",registerError);
        %>
        
        <h1>Please fill out the following fields</h1>
        
        <form action="registerServlet" method="post">
            First Name: <input type="text" name="firstName"> <br>
            Last Name: <input type="text" name="lastName"> <br>
            Email address: <input type="text" name="emailAddress"> <br>
            Username : <input type="text" name="username"> <br>
            Password : <input type="password" name="password"> <br>
            <input type="submit" value="Register">            
        </form>
        <br>
        <c:choose>
            <c:when test="${registerError != null}">
                <p>Please fill out all the fields</p>
            </c:when>
        </c:choose>
        <br>
        <form action="index.jsp">
            <input type="submit" value="Home">
        </form>
    </body>
</html>
