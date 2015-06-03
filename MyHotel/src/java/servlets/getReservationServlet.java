package servlets;

import entities.Reservations;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.json.JsonArray;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;

/**
 *
 * @author Stavros
 */
public class getReservationServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getRemoteUser();
        
        String url = "http://localhost:8080/MyHotel/webresources/entities.reservations/" + username;
        response.sendRedirect(url);
        
        /*String uri = "http://localhost:8080/MyHotel/webresources/entities.reservations/" + username;
        URL url = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/xml");
        
        try{
            JAXBContext jc = JAXBContext.newInstance(Reservations.class);
            InputStream xml = connection.getInputStream();
            Reservations reserv = (Reservations) jc.createUnmarshaller().unmarshal(xml);
            System.out.println("Success: " + reserv);
        }catch (Exception e){
            e.printStackTrace();
        }*/
        
        /*Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/MyHotel/webresources/entities.reservations/" + username);
        JsonArray result = target.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
        Reservations reserv = (Reservations)result.get(0);*/
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
