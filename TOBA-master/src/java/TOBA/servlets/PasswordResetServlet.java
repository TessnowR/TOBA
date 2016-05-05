/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TOBA.servlets;

import TOBA.business.Users;
import TOBA.business.data.UserDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Robert2
 */

public class PasswordResetServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
       

    String url = "/password_reset.jsp";
    String action = request.getParameter("action");
        
        if (action ==null){
            action = "join";
        }
        if (action.equals("join")){
            url = "/password_reset.jsp";
        }
        else{
            if (action.equals("reset")){
            
           String password = request.getParameter("password");
            if(password == null || password.equals("")){
                String message = "Please enter a New Password";
                request.setAttribute("message",message);
            }else{
               
               
                 HttpSession session = request.getSession();
                Users user = (Users) session.getAttribute("user");
                user.setPassword(password);
               // UserDB.update(user);
                 String message = "password successfully changed";
                request.setAttribute("message", message);
                url =  "/password_reset.jsp";
                
           
           
            }
            

            }
       } 
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        
     }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    
    }
    
 
        
        
       