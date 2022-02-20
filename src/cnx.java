
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc expert
 */
public class cnx {
    public static Connection getConnexion(){   //Connection
        Connection conn=null;
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", "");
            return conn;
        } catch(Exception e) {e.printStackTrace();}
        
        return null;
        
    }

    
    
    
    public static ResultSet executeQur(String req){      //ExecuteQuerry
         ResultSet rs=null;
        try {
                      
            Statement st=getConnexion().createStatement();
            rs=st.executeQuery(req);
            
            return rs;
        } catch(Exception e) {e.printStackTrace();}
        return null;
    }
    
    
    
    public static int executeUpd (String req) {        //ExecuteUpdate
        int rs=0;
        try{
            Statement st=getConnexion().createStatement();
            rs=st.executeUpdate(req);
            
        } catch(Exception e) {e.printStackTrace();}
        return rs;
        
    }
}
