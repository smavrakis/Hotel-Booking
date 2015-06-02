<%-- 
    Document   : manageAccount
    Created on : Jun 2, 2015, 7:28:18 PM
    Author     : Stavros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Account</title>
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
                    request.setAttribute("url", "/manageAccount.jsp" );
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
                Make any changes to your info and press the submit button:
                <form action="changeInfoServlet" method="post">
                    First Name: <input type="text" name="firstName" value= <%= session.getAttribute("firstName") %> > <br>
                    Last Name: <input type="text" name="lastName" value= <%= session.getAttribute("lastName") %> > <br>
                    Email address: <input type="text" name="emailAddress" value= <%= session.getAttribute("email") %> > <br>            
                    <input type="submit" value="Submit">            
                </form>
            </c:when>
        </c:choose>
        
        <form action="index.jsp">
            <input type="submit" value="Home">
        </form>
    </body>
</html>
