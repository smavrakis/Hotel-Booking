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
        <link href="templatemo_style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
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
                    <div class="content_title_01">Log In</div>
                    <form method="POST" action="j_security_check">
                        Username: <input type="text" name="j_username" />
                        <div class="cleaner">&nbsp;</div>
                        Password: <input type="password" name="j_password" />
                        <div class="cleaner">&nbsp;</div>
                        <input type="submit" value="Login" />
                        <input type="reset" value="Reset" />
                    </form>
                    <div class="cleaner_h30">&nbsp;</div>
                    <form action="signup.jsp">
                        Don't have an account yet? <input type="submit" value="Sign up"> 
                    </form>
                    <div class="cleaner">&nbsp;</div>
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
