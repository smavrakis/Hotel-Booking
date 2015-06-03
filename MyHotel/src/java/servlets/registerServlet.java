package servlets;

import beans.UserBean;
import java.io.IOException;
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
public class registerServlet extends HttpServlet {

    @EJB(beanName="User")
    private UserBean user;    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (firstName.equals("") || lastName.equals("") || emailAddress.equals("") || username.equals("") || password.equals("")){
            session.setAttribute("registerError", "true");            
            String url = "signup.jsp";
            response.sendRedirect(url);
            return;
        }
        
        if (session.getAttribute("registerError") != null){
            session.removeAttribute("registerError");
        }
        
        user.register(firstName, lastName, emailAddress, username, password);
        
        String url = "register.jsp";
        response.sendRedirect(url);        
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
