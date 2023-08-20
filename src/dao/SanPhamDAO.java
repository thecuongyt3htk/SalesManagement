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
import model.SanPham;

/**
 *
 * @author ACER
 */
public class SanPhamDAO implements HangHoaDAOInterface<SanPham> {

    Connection connection = JDBCUtil.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    @Override
    public int khoiTaoID() {

        int r = 0;
        try {
            st = connection.createStatement();
            rs = st.executeQuery("select max(id_sanpham) from sanpham");
            while (rs.next()) {

                r = rs.getInt(1);
            }
        } catch (Exception e) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return r + 1;
    }

    @Override
    public int insert(SanPham t) {
        int ketqua = 0;
        try {

            Connection con = JDBCUtil.getConnection();

            String sql = "INSERT INTO sanpham (id_sanpham,tensanpham,tendanhmuc,tennhacungcap,gia,soluong,id_danhmuc,id_nhacungcap) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, t.getId());
            statement.setString(2, t.getTensanpham());
            statement.setString(3, t.getTendanhmuc());
            statement.setString(4, t.getTennhacungcap());
            statement.setDouble(5, t.getGia());
            statement.setInt(6, t.getSoluong());
            statement.setInt(7, t.getId_danhmuc());
            statement.setInt(8, t.getId_nhacungcap());

            ketqua = statement.executeUpdate();
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketqua + " dòng bị thay đổi");

            //  JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(SanPham t) {
        int ketqua = 0;
        try {

            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE sanpham SET tensanpham=?, tendanhmuc = ?, tennhacungcap= ?, gia = ?, soluong=? WHERE id_sanpham= ?";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, t.getTensanpham());
            statement.setString(2, t.getTendanhmuc());
            statement.setString(3, t.getTennhacungcap());
            statement.setDouble(4, t.getGia());
            statement.setInt(5, t.getSoluong());
            statement.setInt(6, t.getId());
            ketqua = statement.executeUpdate();
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketqua + " dòng bị thay đổi");

            //JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(SanPham t) {
        int ketqua = 0;
        try {

            Connection con = JDBCUtil.getConnection();

            String sql = "delete from sanpham where id_sanpham=?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, t.getId());

            ketqua = statement.executeUpdate();
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketqua + " dòng bị thay đổi");

            // JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public void loadData(JTable JT) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM sanpham ORDER BY id_sanpham ASC";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("ID");
            model.addColumn("Tên sản phẩm");
            model.addColumn("Danh mục");
            model.addColumn("Nhà cung cấp");
            model.addColumn("Giá");
            model.addColumn("Số lượng");

            while (rs.next()) {
                Object[] r = new Object[6];
                r[0] = rs.getInt("id_sanpham");
                r[1] = rs.getString("tensanpham");
                r[2] = rs.getString("tendanhmuc");
                r[3] = rs.getString("tennhacungcap");
                r[4] = rs.getDouble("gia");
                r[5] = rs.getInt("soluong");

                model.addRow(r);
            }

            JT.setModel(model);
            // JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadDataTK(JTable JT) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT ID_SANPHAM, TENSANPHAM, sum(SOLUONG) SL FROM CTHD GROUP BY ID_SANPHAM,TENSANPHAM";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("Mã sản phẩm");
            model.addColumn("Tên sản phẩm");
            model.addColumn("Số lượng");

            while (rs.next()) {
                Object[] r = new Object[3];
                r[0] = rs.getInt("id_sanpham");
                r[1] = rs.getString("tensanpham");
                r[2] = rs.getInt("SL");

                model.addRow(r);
            }

            JT.setModel(model);
            // JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadDataTop(JTable JT, int n) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT ID_SANPHAM, TENSANPHAM, sum(SOLUONG) SL FROM CTHD GROUP BY ID_SANPHAM,TENSANPHAM order by sl desc";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("Mã sản phẩm");
            model.addColumn("Tên sản phẩm");
            model.addColumn("Số lượng");
            int a = -1;
            while (rs.next() && n>=0) {
                Object[] r = new Object[3];
                int tg=a;
                r[0] = rs.getInt("id_sanpham");
                r[1] = rs.getString("tensanpham");
                r[2] = rs.getInt("SL");
                a = Integer.parseInt(r[2].toString());
                if(tg==Integer.parseInt(r[2].toString())&& n==0) n = n+1;
                else if (n==0) break;
                model.addRow(r);
                n--;
            }

            JT.setModel(model);
            // JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean kiemTraIDKhongDuocThayDoi(SanPham t) {
        try {
            ps = connection.prepareStatement("select * from sanpham where id_sanpham=?");
            ps.setInt(1, t.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public int getID(String e) {
        int id = 0;
        try {
            ps = connection.prepareStatement("select id_sanpham from sanpham where tensanpham=?");
            ps.setString(1, e);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public int soLuongDanhMuc() {
        int s = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT COUNT(*) AS total FROM danhmucsanpham";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                s = rs.getInt("total");
            }
        } catch (SQLException e) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return s;
    }

    public String[] danhMuc() {
        int soLuong = soLuongDanhMuc();
        String[] infor = new String[soLuong];
        try {
            ps = connection.prepareStatement("SELECT * FROM danhmucsanpham");
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next() && i < soLuong) {
                infor[i] = rs.getString(2);
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return infor;
    }

    public int soLuongNhaCungCap() {
        int s = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT COUNT(*) AS total FROM nhacungcap";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                s = rs.getInt("total");
            }
        } catch (SQLException e) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return s;
    }

    public String[] nhaCungCap() {
        int soLuong = soLuongDanhMuc();
        String[] infor = new String[soLuong];
        try {
            ps = connection.prepareStatement("SELECT * FROM nhacungcap");
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next() && i < soLuong) {
                infor[i] = rs.getString(2);
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return infor;
    }

    public boolean checkID(int id) {
        try {
            Connection con = JDBCUtil.getConnection();
            ps = con.prepareStatement("select * from sanpham where id_sanpham=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {

                return true;
            }


        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public void loadDataByItem(JTable JT, String item) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM sanpham where tendanhmuc = N'" + item + "'";
            PreparedStatement statement = con.prepareStatement(sql);
            rs = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("ID");
            model.addColumn("Tên sản phẩm");
            model.addColumn("Danh mục");
            model.addColumn("Nhà cung cấp");
            model.addColumn("Giá");
            model.addColumn("Số lượng");

            while (rs.next()) {
                Object[] r = new Object[6];
                r[0] = rs.getInt("id_sanpham");
                r[1] = rs.getString("tensanpham");
                r[2] = rs.getString("tendanhmuc");
                r[3] = rs.getString("tennhacungcap");
                r[4] = rs.getDouble("gia");
                r[5] = rs.getInt("soluong");

                model.addRow(r);
            }

            JT.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void searchForName(JTable JT, String Name) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM sanpham WHERE tensanpham LIKE N'%" + Name + "%'";
            PreparedStatement statement = con.prepareStatement(sql);
            rs = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("ID");
            model.addColumn("Tên sản phẩm");
            model.addColumn("Danh mục");
            model.addColumn("Nhà cung cấp");
            model.addColumn("Giá");
            model.addColumn("Số lượng");

            while (rs.next()) {
                Object[] r = new Object[6];
                r[0] = rs.getInt("id_sanpham");
                r[1] = rs.getString("tensanpham");
                r[2] = rs.getString("tendanhmuc");
                r[3] = rs.getString("tennhacungcap");
                r[4] = rs.getDouble("gia");
                r[5] = rs.getInt("soluong");

                model.addRow(r);
            }

            JT.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}