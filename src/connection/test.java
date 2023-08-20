/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLDataException;

/**
 *
 * @author ACER
 */
public class test {
    public static void main(String[] args) {
        Connection conection=(Connection) JDBCUtil.getConnection();
        JDBCUtil.printInfor((java.sql.Connection) conection);
    }
}
