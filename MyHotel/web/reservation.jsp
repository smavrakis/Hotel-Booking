<%-- 
    Document   : reservation
    Created on : Jun 1, 2015, 6:19:56 PM
    Author     : Stavros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservation</title>
    </head>
    <body>
        <form action="index.html" method="post">
            Arrival: <input type="date" name="arrivDay" max="2016-06-30"><br>
            Departure: <input type="date" name="departDay" max="2016-07-31">
            <input type="submit" value="Book">            
        </form>
    </body>
</html>
