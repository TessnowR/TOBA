package TOBA.servlets;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import TOBA.business.data.ConnectionPool;



@WebServlet(name = "ReportsServlet", urlPatterns = {"/ReportsServlet"})
public class ReportsServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("User Report");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Users Joined");

       
        row = sheet.createRow(2);
        row.createCell(0).setCellValue("UserID");
        row.createCell(1).setCellValue("FirstName");
        row.createCell(2).setCellValue("LastName");
        row.createCell(3).setCellValue("UserName");

        try {
           
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM user";
            ResultSet rset = statement.executeQuery(query);

            
            int i = 3;
            while (rset.next()) {
                row = sheet.createRow(i);
                row.createCell(0).setCellValue(rset.getInt("UserID"));
                row.createCell(1).setCellValue(rset.getInt("FirstName"));
                row.createCell(2).setCellValue(rset.getInt("LastName"));
                row.createCell(3).setCellValue(rset.getInt("UserName"));
            }
            rset.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            this.log(e.toString());
        }


     
        response.setHeader("content-disposition", 
                "attachment; filename=users.xls");
        response.setHeader("cache-control", "no-cache");

        // get the output stream and send the workbook to the browser
        OutputStream out = response.getOutputStream();
        workbook.write(out);
        out.close();
    }
}