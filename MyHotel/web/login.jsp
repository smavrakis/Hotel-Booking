<%-- 
    Document   : login
    Created on : Jun 2, 2015, 5:16:44 PM
    Author     : Stavros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form method="POST" action="j_security_check">
            Username: <input type="text" name="j_username" />
            Password: <input type="password" name="j_password" />
            <br />
            <input type="submit" value="Login" />
            <input type="reset" value="Reset" />
        </form>
        <br>
        <form action="signup.jsp">
            Don't have an account yet? <input type="submit" value="Sign up"> 
        </form>
        <form action="index.jsp">
            <input type="submit" value="Home">
        </form>
    </body>
</html>
