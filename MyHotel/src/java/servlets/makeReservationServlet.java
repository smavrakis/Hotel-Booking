package servlets;

import beans.ReservationBean;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Stavros
 */
public class makeReservationServlet extends HttpServlet {
    
    @EJB(beanName="Reservation")
    private ReservationBean reservation;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");        
        
        String username = request.getRemoteUser();
        String from_temp = request.getParameter("from");
        String to_temp = request.getParameter("to");
        
        if (request.getParameter("roomNumber") == null || from_temp.equals("") || to_temp.equals("")){
            session.setAttribute("roomError", "true");            
            String url = "reservation.jsp";
            response.sendRedirect(url);
            return;
        }
        
        if (session.getAttribute("roomError") != null){
            session.removeAttribute("roomError");
        }       
                
        Integer roomNumber = Integer.parseInt(request.getParameter("roomNumber"));        
        
        try{            
            java.sql.Date from = new java.sql.Date(format.parse(from_temp).getTime());
            java.sql.Date to = new java.sql.Date(format.parse(to_temp).getTime());
            
            if (!reservation.isAvailable(from, to, roomNumber)){
                session.setAttribute("reserveError", "true");            
                String url = "reservation.jsp";
                response.sendRedirect(url);
                return;
            }
            
            if (session.getAttribute("reserveError") != null){
                session.removeAttribute("reserveError");
            }
            
            reservation.makeReservation(username, roomNumber, from, to);
            String url = "reservationSuccessful.jsp";
            response.sendRedirect(url);
        }catch (Exception e){
            e.printStackTrace();
            String url = "genericError.jsp";
            response.sendRedirect(url);
        }
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
