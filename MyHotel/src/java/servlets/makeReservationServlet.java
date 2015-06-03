/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
