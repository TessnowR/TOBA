package TOBA.servlets;


import TOBA.business.Account;
import static TOBA.business.Account.AccountType.accountsavings;
import TOBA.business.PasswordUtil;
import TOBA.business.Users;
import TOBA.business.data.AccountDB;
import TOBA.business.data.UserDB;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NewCustomerServlet extends HttpServlet {

    private Users user;

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

        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(500);
        response.setContentType("text/html;charset=UTF-8");
        String url;
        url = "/new_customer.jsp";
       
        String action = request.getParameter("action");

        if (action.equals("add")) {

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phoneNumber = request.getParameter("phoneNumber");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zipcode = request.getParameter("zipcode");
            String email = request.getParameter("email");


            if (firstName.equals("") || lastName.equals("") || phoneNumber.equals("")
                    || address.equals("") || city.equals("") || state.equals("")
                    || zipcode.equals("") || email.equals("")) {

                String message = "Please fill out all the form fields";
                request.setAttribute("message", message);

                url = "/new_customer.jsp";
            } 
                else {
                user = new Users(firstName, lastName, phoneNumber, address, city,
                        state, zipcode, email);
                
               
                Account savings = new Account(0, accountsavings );
                savings.credit(25.00);
                Account checking = new Account();
               checking.credit(0.00);
               session.setAttribute("user", user);
               session.setAttribute("savings", savings);
               session.setAttribute("checking", checking);
               request.setAttribute("savings", savings);
              
              UserDB.insert(user);
              
                
                    
               
                url = "/success.jsp";
                
            }
               
        } 
        else if (action.equals("reset")) {
            
            user.setPassword(request.getParameter("password"));
            
            Users user = (Users) session.getAttribute("user");
            
            UserDB.update(user);
            session.setAttribute("user", user);
            
            
           
            String password = request.getParameter("password");
            
           
            
            String saltedAndHashedPassword;
            try {
                saltedAndHashedPassword = PasswordUtil.hashAndSaltPassword(password);                    
            
            } catch (NoSuchAlgorithmException ex) {
                saltedAndHashedPassword = ex.getMessage();
            }
            
            request.setAttribute("saltedAndHashedPassword", saltedAndHashedPassword);
            user.setPassword(saltedAndHashedPassword);
            

            url = "/account_activity.jsp";
        }
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private String hashAndSaltPassword(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
