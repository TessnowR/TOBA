/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TOBA.servlets;

import TOBA.business.Account;
import TOBA.business.data.AccountDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TransactionServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();


        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(500);
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");

       String  url = "/tranfer_funds.jsp";

        if (action == null) {
            action = "invalid";
        }

        //  perform action and set URL to appropriate page
        if (action.equals("invalid")) {
            url = "/transfer_funds.jsp";
        }

        if (action.equals("toSavings") || action.equals("toChecking")) {

            double transferAmount = Double.parseDouble(request.getParameter("amount"));

            Account checking = (Account) session.getAttribute("checking");
            Account savings = (Account) session.getAttribute("savings");

            String message = null;

            if (transferAmount <= 0) {
                message = "Please enter an amount to tranfer.";
                url = "/transfer_funds.jsp";
            } else {
                if (action.equals("toSavings")) {
                    checking.debit(transferAmount);
                    savings.credit(transferAmount);
                } else if (action.equals("toChecking")) {
                    checking.credit(transferAmount);
                    savings.debit(transferAmount);
                }
               
                session.setAttribute("checking", checking);
                session.setAttribute("savings", savings);
               

                AccountDB.UpdateAccount(checking);
                AccountDB.UpdateAccount(savings);
                message = "Your funds have been Transfered";
                url = "/transfer_funds.jsp";

            }
        
            request.setAttribute("message", message);

        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
