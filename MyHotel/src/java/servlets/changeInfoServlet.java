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
public class changeInfoServlet extends HttpServlet {

    @EJB(beanName="User")
    private UserBean user;    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        
        HttpSession session = request.getSession();
        
        String username = request.getRemoteUser();        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("emailAddress");
        
        if (firstName.equals("") || lastName.equals("") || email.equals("")){
            session.setAttribute("updateError", "true");            
            String url = "manageAccount.jsp";
            response.sendRedirect(url);
            return;
        }
        
        if (session.getAttribute("updateError") != null){
            session.removeAttribute("updateError");
        }
        
        user.updateInfo(username, firstName, lastName, email);
        
        String url = "updateSuccessful.jsp";
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
