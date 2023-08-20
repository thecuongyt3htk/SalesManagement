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
import javax.swing.table.DefaultTableModel;
import model.DanhMuc;
import model.KhachHang;

/**
 *
 * @author ACER
 */
public class DanhMucDAO implements HangHoaDAOInterface<DanhMuc> {

    Connection connection = JDBCUtil.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    @Override
    public int khoiTaoID() {

        int r = 0;
        try {
            st = connection.createStatement();
            rs = st.executeQuery("select max(id_danhmuc) from danhmucsanpham");
            while (rs.next()) {

                r = rs.getInt(1);
            }
        } catch (Exception e) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return r + 1;
    }

    @Override
    public int insert(DanhMuc t) {
        int ketqua = 0;
        try {

            Connection con = JDBCUtil.getConnection();

            String sql = "INSERT INTO danhmucsanpham (id_danhmuc, tendanhmuc, mota) "
                    + "VALUES (?, ?, ?)";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, t.getId());
            statement.setString(2, t.getTendanhmuc());
            statement.setString(3, t.getMota());

            ketqua = statement.executeUpdate();
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketqua + " dòng bị thay đổi");

            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(DanhMuc t) {
        int ketqua = 0;
        try {

            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE danhmucsanpham SET tendanhmuc = ?, mota = ? WHERE id_danhmuc = ?";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, t.getTendanhmuc());
            statement.setString(2, t.getMota());
            statement.setInt(3, t.getId());
            ketqua = statement.executeUpdate();
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketqua + " dòng bị thay đổi");

            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(DanhMuc t) {
        int ketqua = 0;
        try {

            Connection con = JDBCUtil.getConnection();

            String sql = "delete from danhmucsanpham where id_danhmuc=?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, t.getId());

            ketqua = statement.executeUpdate();
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketqua + " dòng bị thay đổi");

            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public void loadData(JTable JT) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM danhmucsanpham ORDER BY id_danhmuc ASC";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("ID");
            model.addColumn("Tên danh mục");
            model.addColumn("Mô tả");

            while (rs.next()) {
                Object[] r = new Object[8];
                r[0] = rs.getInt("id_danhmuc");
                r[1] = rs.getString("tendanhmuc");
                r[2] = rs.getString("mota");

                model.addRow(r);
            }

            JT.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean kiemTraIDKhongDuocThayDoi(DanhMuc t) {
        try {
            ps = connection.prepareStatement("select * from danhmucsanpham where id_danhmuc=?");
            ps.setInt(1, t.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public int getID(String e) {
        int id = 0;
        try {
            ps = connection.prepareStatement("select id_danhmuc from danhmucsanpham where tendanhmuc=?");
            ps.setString(1, e);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public boolean kiemTraDanhMuclTonTai(DanhMuc t) {
        try {
            ps = connection.prepareStatement("select * from danhmucsanpham where tendanhmuc=?");
            ps.setString(1, t.getTendanhmuc());
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}