/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.HoaDon;

/**
 *
 * @author ACER
 */
public class DoanhThuDAO {

    Connection connection = JDBCUtil.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    public String DTQuy(int m)
    {
        String a ="";
        try {
            Connection con = JDBCUtil.getConnection();
            String sql="";
            if(m==1) {
                sql = "SELECT THANG,SUM(DOANHTHU) DT FROM DOANHTHU_NHANVIEN WHERE THANG IN (1,2,3) GROUP BY THANG";
            }
            else if(m==2) {
                sql = "SELECT THANG,SUM(DOANHTHU) DT FROM DOANHTHU_NHANVIEN WHERE THANG IN (4,5,6) GROUP BY THANG";
            }
            else if(m==3) {
                sql = "SELECT THANG,SUM(DOANHTHU) DT FROM DOANHTHU_NHANVIEN WHERE THANG IN (7,8,9) GROUP BY THANG";
            }
            else if(m==4) {
                sql = "SELECT THANG,SUM(DOANHTHU) DT FROM DOANHTHU_NHANVIEN WHERE THANG IN (10,11,12) GROUP BY THANG";
            }
            
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();


            double sum = 0;
            while (rs.next()) {
                Object[] r = new Object[4];
                r[0] = rs.getInt("THANG");
                r[1] = rs.getString("DT");
                
                sum += Double.parseDouble(r[1].toString());
            }
            a = String.format(Locale.US,"%.2f",sum);

        
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
    public String tongDT()
    {
        String a ="";
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT THANG,SUM(DOANHTHU) DT FROM DOANHTHU_NHANVIEN GROUP BY THANG";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();


            double sum = 0;
            while (rs.next()) {
                Object[] r = new Object[4];
                r[0] = rs.getInt("THANG");
                r[1] = rs.getString("DT");
                
                sum += Double.parseDouble(r[1].toString());
            }
            a = String.format(Locale.US,"%.2f",sum);

        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
    public void loadDataTK(JTable JT) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT THANG,SUM(DOANHTHU) DT FROM DOANHTHU_NHANVIEN GROUP BY THANG";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("Tháng");
            model.addColumn("Doanh Thu");
            while (rs.next()) {
                Object[] r = new Object[4];
                r[0] = rs.getInt("THANG");
                r[1] = rs.getString("DT");

                model.addRow(r);
            }

            JT.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public double getDoanhThu(int id, int thang) {
        double doanhThu = 0;
        try {
            String query = "SELECT DOANHTHU FROM DOANHTHU_NHANVIEN WHERE ID_NHANVIEN = ? AND THANG = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, thang);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                doanhThu = resultSet.getDouble("DOANHTHU");
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return doanhThu;
    }


    public void updateDoanhThu(int id, int thang, double doanhthu) {

        String sql = "update doanhthu_nhanvien set doanhthu=? where id_nhanvien=? and thang=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setDouble(1, doanhthu);
            ps.setInt(2, id);
            ps.setInt(3, thang);

            ps.executeUpdate();
       
        } catch (SQLException e) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
