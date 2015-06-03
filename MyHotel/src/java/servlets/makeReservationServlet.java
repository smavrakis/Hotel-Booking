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
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        String username = request.getRemoteUser();
        Integer roomNumber = Integer.parseInt(request.getParameter("roomNumber"));
        String from_temp = request.getParameter("from");
        String to_temp = request.getParameter("to");
        
        try{
            //Date from = format.parse(from_temp);
            //Date to = format.parse(to_temp);
            //System.out.println(from);
            //System.out.println(to);
            java.sql.Date from = new java.sql.Date(format.parse(from_temp).getTime());
            java.sql.Date to = new java.sql.Date(format.parse(to_temp).getTime());            
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
