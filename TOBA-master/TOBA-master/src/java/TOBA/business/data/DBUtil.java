package TOBA.business.data;

import java.sql.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DBUtil {
    public static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("TOBA-TessnowPU");
    
    public static EntityManagerFactory getEmFactory() {
        return emf;
    
    }
    
    public static void closeStatement(Statement s) {
        try{
            if (s != null){
                s.close();
            }
        }        
        catch (SQLException e) {
            System.out.println(e);
        }
    }
} 

    
    