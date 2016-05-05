/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TOBA.business.data;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database_Connection 
{
    public static Connection Connection()
    {
        
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn =null;
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/toba?zeroDateTimeBehavior=convertToNull","root","sesame");
            } catch (SQLException ex) {
                Logger.getLogger(Database_Connection.class.getName()).log(Level.SEVERE, null, ex);
            }
            
          
            return conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return null;
    }
}