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
public class getUserInfoServlet extends HttpServlet {
    
    @EJB(beanName="User")
    private UserBean user;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
         String username = request.getRemoteUser();
         
         String firstName = user.getFirstName(username);
         String lastName = user.getLastName(username);
         String email = user.getEmail(username);
         
         session.setAttribute("firstName", firstName);
         session.setAttribute("lastName", lastName);
         session.setAttribute("email", email);
         
         String url = "manageAccount.jsp";
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
