
package TOBA.servlets;

import TOBA.business.Users;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class LoginServlet extends HttpServlet {
 

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        String url = "/login.jsp";
        String action = request.getParameter("action");
        
        if (action == null) {
            url = "/login.jsp"; 
        }
        
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
       
        if (request.getSession().getAttribute("user") == null) {
            url = "/new_customer.jsp";
            request.getRequestDispatcher(url).forward(request, response);

        } else if (user.getUsername().equals(username)
                && user.getPassword().equals(password)) {
            url = "/account_activity.jsp";
            request.getRequestDispatcher(url).forward(request, response);
        } else {
            //forward to login failure
            url = "/login_failure.jsp";
            request.getRequestDispatcher(url).forward(request, response);
        }
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
