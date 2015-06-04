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
        <title>Sign up</title>
        <link href="templatemo_style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <%
            String registerError = (String)session.getAttribute("registerError"); 
            String usernameExistsError = (String)session.getAttribute("usernameExistsError");
            pageContext.setAttribute("registerError",registerError);
            pageContext.setAttribute("usernameExistsError",usernameExistsError);
        %>
        
        <div id="templatemo_container">
            <div id="templatemo_header">
                <div id="website_title">
                    <div id="title">
                        Hotel &amp; Travel
                    </div>
                    <div id="salgon">
                        The best service at the lowest price
                    </div>
                </div>
            </div>
            
            <div id="templatemo_banner">
                <div id="templatemo_menu">
                    <ul>
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="getUserInfoServlet">Manage account</a></li>
                        <li><a href="getReservationServlet">Show my reservation</a></li>                        
                    </ul> 
                </div>    
            </div>
            
            
            <div id="content_right">
                <div class="content_right_section">
                    <div class="cleaner_h30">&nbsp;</div>
                    <div class="content_title_01">Please fill out the following fields</div>
                    <form action="registerServlet" method="post">
                        First Name: <input type="text" name="firstName"> <br>
                        Last Name: <input type="text" name="lastName"> <br>
                        Email address: <input type="text" name="emailAddress"> <br>
                        Username : <input type="text" name="username"> <br>
                        Password : <input type="password" name="password"> <br>
                        <input type="submit" value="Register">            
                    </form>
                    <div class="cleaner_h30">&nbsp;</div>
                    <c:choose>
                        <c:when test="${registerError != null}">
                            Please fill out all the fields.
                        </c:when>
                        <c:when test="${usernameExistsError != null}">
                            Username already taken. Please choose a different one.
                        </c:when>
                    </c:choose>
                </div>
                <div class="cleaner_h30">&nbsp;</div>                    
            </div>
               
            
            <div id="content_right">        
        	<div class="content_right_section">        	
                    <div class="content_title_01">Welcome to  hotel &amp; travel</div>
                        <img src="images/templatemo_image_01.jpg" alt="image" />
                        <p>The Hotel Porta Faenza is centrally located, very close to the main railway station (Santa Maria Novella), to Palazzo dei Congressi (the Conference Centre) and to the Fortezza da Basso. The most interesting monuments and museums in Florence are within easy walking distance.
                        The Hotel will make you savour the warm atmosphere of the old-time Florentine houses: the tile floor, the exposed beams, the old tools scattered everywhere, together with all the comforts will make it your ideal home in the old Florence.</p>
                        <p></p><p></p>
                </div>
                <br>
                <br>
                <div class="content_right_section">
                    <div class="content_title_01">Gallery</div>
                    <div class="gallery_box">
                        <img src="images/templatemo_image_02.jpg" alt="image" />                        
                    </div>
                    <div class="gallery_box">
                        <img src="images/templatemo_image_03.jpg" alt="image" />                        
                    </div>
                    <div class="gallery_box">
                        <img src="images/templatemo_image_04.jpg" alt="image" />                        
                    </div>                    
                    <div class="gallery_box">
                        <img src="images/templatemo_image_06.jpg" alt="image" />                        
                    </div>
                    
                    <div class="cleaner_h20">&nbsp;</div>                                        
                    <div class="cleaner">&nbsp;</div>
		</div>
                <div class="cleaner_h20">&nbsp;</div>
            </div>
            <div class="cleaner">&nbsp;</div>
            <div id="templatemo_footer">
                Copyright © 2024 <strong>Software Architecture with Java</strong>
            </div>
        </div>            
    </body>
</html>
