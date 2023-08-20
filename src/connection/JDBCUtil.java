/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;
import java.sql.Connection;
import java.sql.SQLException;

import java.sql.DriverManager;
import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.jdbc.Driver;

/**
 *
 * @author ACER
 */
public class JDBCUtil {
    public static Connection getConnection(){
    
        Connection c=null;
        try {
            
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url ="jdbc:mySQL://localhost:3306/QLBH";
            String username="root";
            String password="Thecuong2003";
            c=(Connection) DriverManager.getConnection(url, username, password);
        } catch(SQLException e) {
            
            e.printStackTrace();
        }
        return c;
    }
    public static void closeConnection(Connection c){
    
        try {
            if(c!=null){
            
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public static void printInfor(Connection c){
    
        try {
            if(c!=null){
            
                DatabaseMetaData mtdt=(DatabaseMetaData) c.getMetaData();
                System.out.println(mtdt.getDatabaseProductName());
                System.out.println(mtdt.getDatabaseProductVersion());
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
