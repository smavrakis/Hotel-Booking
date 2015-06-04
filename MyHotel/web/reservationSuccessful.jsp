<%-- 
    Document   : reservationSuccessful
    Created on : Jun 3, 2015, 3:46:21 PM
    Author     : Stavros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservation Success</title>
        <link href="templatemo_style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <%
            String username = request.getRemoteUser();            
            pageContext.setAttribute("username",username);
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
                        <c:choose>
                            <c:when test="${username != null}">
                                <li><a href="logoutServlet">Log out</a></li>                       
                            </c:when>
                        </c:choose>
                    </ul> 
                </div>    
            </div>
            
            <c:choose>
                <c:when test="${username != null}">
                    <div id="content_right">
                        <div class="content_right_section">
                            Logged in as:  <%= username %>
                            <div class="cleaner_h30">&nbsp;</div>
                            <div class="content_title_01">Reservation successful</div>
                            <h1>Your reservation has been completed!</h1>
                            <div class="cleaner_h30">&nbsp;</div>
                        </div>                                
                        <div class="cleaner_h30">&nbsp;</div>                
                    </div>
                </c:when>
            </c:choose>
            
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
