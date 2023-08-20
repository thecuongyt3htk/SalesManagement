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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import model.DanhMuc;
import model.HoaDon;
import model.KhachHang;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;
import model.CTHD;
/**
 *
 * @author ACER
 */
public class CTDHDAO {

    Connection connection = JDBCUtil.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    //  @Override
      public int insert(CTHD t) {

        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "INSERT INTO CTHD (ID_hoadon, stt, tensanpham, soluong, giatong, id_sanpham) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, t.getId_hoadon());
            statement.setInt(2, t.getStt());
            statement.setString(3, t.getTensanpham());
            statement.setInt(4, t.getSoluong());
            statement.setDouble(5, t.getGiatong());
            statement.setInt(6, t.getId_sp());

            ketqua = statement.executeUpdate();
            System.out.println("Câu truy vấn được thực thi: " + sql);
            System.out.println("Có " + ketqua + " dòng bị thay đổi");

            //JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return ketqua;
    }
      public void loadData(JTable JT,int ID) {
        try {
            String sql = "SELECT stt, id_sanpham, tensanpham, soluong, giatong "
            + "FROM CTHD where id_hoadon=?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, ID);
            rs = ps.executeQuery();       
            DefaultTableModel model = new DefaultTableModel();        
            model.addColumn("STT");
            model.addColumn("ID Sản phẩm");
            model.addColumn("Sản phẩm");
            model.addColumn("Số lượng");
            model.addColumn("Giá tổng");

            Object[] r;
            while (rs.next()) {
                r = new Object[5];
           
                r[0] = rs.getInt("stt");
                r[1] = rs.getInt("id_sanpham");
                r[2] = rs.getString("tensanpham");
                r[3] = rs.getInt("soluong");
                r[4] = rs.getDouble("giatong");
      
                model.addRow(r);
            }

            JT.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
