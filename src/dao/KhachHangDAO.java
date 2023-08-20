/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import admin.GiaoDienQuanLyFrame;
import java.sql.Connection;
import connection.JDBCUtil;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.KhachHang;
import user.DangNhapFrame;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class KhachHangDAO implements DAOInterface<KhachHang> {

    Connection connection = JDBCUtil.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    @Override

    public int khoiTaoID() {

        int r = 0;
        try {
            st = connection.createStatement();
            rs = st.executeQuery("select max(id_khachhang) from khachhang");
            while (rs.next()) {

                r = rs.getInt(1);
            }
        } catch (Exception e) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return r + 1;
    }

    @Override
    public int insert(KhachHang t) {
        int ketqua = 0;
        try {
            java.util.Date utilDate = t.getNgaySinh();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            Connection con = JDBCUtil.getConnection();

            String sql = "INSERT INTO khachhang (ID_khachhang, tenkhachhang, diachi, sodienthoai, ngaysinh, ngaydangky,diem) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, t.getId());
            statement.setString(2, t.getTen());
            statement.setString(3, t.getDiaChi());
            statement.setString(4, t.getSdt());
            statement.setDate(5, t.getNgaySinh());
            statement.setDate(6, t.getNgayDangKy());
            statement.setDouble(7, t.getDiem());

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
    public int update(KhachHang t) {
        int ketqua = 0;
        try {
            java.util.Date utilDate = t.getNgaySinh();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE khachhang SET tenkhachhang = ?, diachi = ?, sodienthoai = ?, ngaysinh = ?, ngaydangky = ?,diem=? WHERE ID_khachhang = ?";

            PreparedStatement statement = con.prepareStatement(sql);

            
            statement.setString(1, t.getTen());
            statement.setString(2, t.getDiaChi());
            statement.setString(3, t.getSdt());
            statement.setDate(4, t.getNgaySinh());
            statement.setDate(5, t.getNgayDangKy());
            statement.setDouble(6, t.getDiem());
            statement.setInt(7, t.getId());
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
    public int delete(KhachHang t) {
        int ketqua = 0;
        try {

            Connection con = JDBCUtil.getConnection();

            String sql = "delete from khachhang where id_khachhang=?";

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

  //  @Override

    public boolean kiemTraSDTTonTai(KhachHang t) {
        try {
            ps = connection.prepareStatement("select * from khachhang where sodienthoai=?");
            
            ps.setString(1, t.getSdt());
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

//    @Override
//    public boolean kiemTraEmailKhongDuocThayDoi(KhachHang t) {
//        try {
//            ps = connection.prepareStatement("select * from khachhang where email=?");
//            ps.setString(1, t.getEmail());
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                return false;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return true;
//    }

    
    @Override
    public boolean kiemTraIDKhongDuocThayDoi(KhachHang t) {
        try {
            ps = connection.prepareStatement("select * from khachhang where id_khachhang=?");
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
    public String[] selectInfor(int id) {
        String[] infor = new String[8];
        try {
            ps = connection.prepareStatement("select * from khachhang where ID_khachhang=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                infor[0] = rs.getString(1);
                infor[1] = rs.getString(2);
                infor[2] = rs.getString(3);
                infor[3] = rs.getString(4);
                infor[4] = rs.getString(5);
                infor[5] = rs.getString(6);
                infor[6] = rs.getString(7);
                infor[7] = rs.getString(8);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return infor;
    }

    @Override
    public void loadData(JTable JT) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM khachhang ORDER BY id_khachhang ASC";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("ID");
            model.addColumn("Họ và tên");
            model.addColumn("Địa chỉ");
            model.addColumn("Số điện thoại");
            model.addColumn("Ngày sinh");
            model.addColumn("Ngày đăng ký");
            model.addColumn("Điểm");
            while (rs.next()) {
                Object[] r = new Object[7];
                r[0] = rs.getInt("id_khachhang");
                r[1] = rs.getString("tenkhachhang");
                r[2] = rs.getString("diachi");
                r[3] = rs.getString("sodienthoai");
                r[4] = rs.getDate("ngaysinh");
                r[5] = rs.getDate("ngaydangky");
                r[6] = rs.getDouble("diem");

                model.addRow(r);
            }

            JT.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadDataTK(JTable JT) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT KH.ID_KHACHHANG,KH.TENKHACHHANG,KH.SODIENTHOAI,SUM(GIA) TONGGIATRI FROM HOADON HD JOIN KHACHHANG KH WHERE KH.ID_KHACHHANG = HD.ID_KHACHHANG GROUP BY KH.ID_KHACHHANG,KH.TENKHACHHANG,KH.SODIENTHOAI";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("Mã khách hàng");
            model.addColumn("Họ và tên");
            model.addColumn("Số điện thoại");
            model.addColumn("Tổng tiền");
            while (rs.next()) {
                Object[] r = new Object[4];
                r[0] = rs.getInt("id_khachhang");
                r[1] = rs.getString("tenkhachhang");
                r[2] = rs.getString("sodienthoai");
                r[3] = rs.getString("tonggiatri");
                
                model.addRow(r);
            }

            JT.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadDataTop(JTable JT, int n) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT KH.ID_KHACHHANG,KH.TENKHACHHANG,KH.SODIENTHOAI,SUM(GIA) TONGGIATRI FROM HOADON HD JOIN KHACHHANG KH WHERE KH.ID_KHACHHANG = HD.ID_KHACHHANG GROUP BY KH.ID_KHACHHANG,KH.TENKHACHHANG,KH.SODIENTHOAI ORDER BY TONGGIATRI DESC";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("Mã khách hàng");
            model.addColumn("Họ và tên");
            model.addColumn("Số điện thoại");
            model.addColumn("Tổng tiền");
            double a = -1;
            while (rs.next() && n>=0) {
                Object[] r = new Object[4];
                double tg=a;
                r[0] = rs.getInt("id_khachhang");
                r[1] = rs.getString("tenkhachhang");
                r[2] = rs.getString("sodienthoai");
                r[3] = rs.getString("tonggiatri");
                a = Double.parseDouble(r[3].toString());
                if(tg==Double.parseDouble(r[3].toString())&& n==0) n = n+1;
                else if (n==0) break;
                model.addRow(r);
                n--;
            }

            JT.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getId(String e) {
        int id = 0;
        try {
            ps = connection.prepareStatement("select id_khachhang from khachhang where sodienthoai=?");
            ps.setString(1, e);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    
    @Override
    public String getTen(String e) {
        String ten = "";
        try {
            ps = connection.prepareStatement("select tenkhachhang from khachhang where sodienthoai=?");
            ps.setString(1, e);
            rs = ps.executeQuery();
            if (rs.next()) {
                ten = rs.getString(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ten;
    }

    @Override
    public void searchForID(int id, JTable JT) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM khachhang WHERE ID_KHACHHANG = " + id;
            PreparedStatement statement = con.prepareStatement(sql);
            rs = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();

             model.addColumn("ID");
            model.addColumn("Họ và tên");
            model.addColumn("Địa chỉ");
            model.addColumn("Số điện thoại");
            model.addColumn("Ngày sinh");
            model.addColumn("Ngày đăng ký");
            model.addColumn("Điểm");
            while (rs.next()) {
                Object[] r = new Object[7];
                r[0] = rs.getInt("id_khachhang");
                r[1] = rs.getString("tenkhachhang");
                r[2] = rs.getString("diachi");
                r[3] = rs.getString("sodienthoai");
                r[4] = rs.getDate("ngaysinh");
                r[5] = rs.getDate("ngaydangky");
                r[6] = rs.getDouble("diem");
                model.addRow(r);
            }

            JT.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override

    public void searchForSDT(String sdt, JTable JT) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM khachhang WHERE SODIENTHOAI = '" + sdt + "' ";
            PreparedStatement statement = con.prepareStatement(sql);
            rs = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("ID");
            model.addColumn("Họ và tên");
            model.addColumn("Địa chỉ");
            model.addColumn("Số điện thoại");
            model.addColumn("Ngày sinh");
            model.addColumn("Ngày đăng ký");
            model.addColumn("Điểm");
            while (rs.next()) {
                Object[] r = new Object[7];
                r[0] = rs.getInt("id_khachhang");
                r[1] = rs.getString("tenkhachhang");
                r[2] = rs.getString("diachi");
                r[3] = rs.getString("sodienthoai");
                r[4] = rs.getDate("ngaysinh");
                r[5] = rs.getDate("ngaydangky");
                r[6] = rs.getDouble("diem");
                model.addRow(r);
            }

            JT.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void searchForName(String Name, JTable JT) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM khachhang WHERE TENKHACHHANG LIKE N'%" + Name + "%'";
            PreparedStatement statement = con.prepareStatement(sql);
            rs = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();

           model.addColumn("ID");
            model.addColumn("Họ và tên");
            model.addColumn("Địa chỉ");
            model.addColumn("Số điện thoại");
            model.addColumn("Ngày sinh");
            model.addColumn("Ngày đăng ký");
            model.addColumn("Điểm");
            while (rs.next()) {
                Object[] r = new Object[7];
                r[0] = rs.getInt("id_khachhang");
                r[1] = rs.getString("tenkhachhang");
                r[2] = rs.getString("diachi");
                r[3] = rs.getString("sodienthoai");
                r[4] = rs.getDate("ngaysinh");
                r[5] = rs.getDate("ngaydangky");
                r[6] = rs.getDouble("diem");
                model.addRow(r);
            }

            JT.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void searchForIDTK(int id, JTable JT) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT KH.ID_KHACHHANG,KH.TENKHACHHANG,KH.SODIENTHOAI,SUM(GIA) TONGGIATRI FROM HOADON HD JOIN KHACHHANG KH WHERE KH.ID_KHACHHANG = HD.ID_KHACHHANG AND KH.ID_KHACHHANG = " + id + " GROUP BY KH.ID_KHACHHANG,KH.TENKHACHHANG,KH.SODIENTHOAI";
            PreparedStatement statement = con.prepareStatement(sql);
            rs = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("Mã khách hàng");
            model.addColumn("Họ và tên");
            model.addColumn("Số điện thoại");
            model.addColumn("Tổng tiền");
            while (rs.next()) {
                Object[] r = new Object[4];
                r[0] = rs.getInt("id_khachhang");
                r[1] = rs.getString("tenkhachhang");
                r[2] = rs.getString("sodienthoai");
                r[3] = rs.getString("tonggiatri");
                
                model.addRow(r);
            }

            JT.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    public void searchForSDTTK(String sdt, JTable JT) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT KH.ID_KHACHHANG,KH.TENKHACHHANG,KH.SODIENTHOAI,SUM(GIA) TONGGIATRI FROM HOADON HD JOIN KHACHHANG KH WHERE KH.ID_KHACHHANG = HD.ID_KHACHHANG AND KH.SODIENTHOAI = '" + sdt + "' GROUP BY KH.ID_KHACHHANG,KH.TENKHACHHANG,KH.SODIENTHOAI";
            PreparedStatement statement = con.prepareStatement(sql);
            rs = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("Mã khách hàng");
            model.addColumn("Họ và tên");
            model.addColumn("Số điện thoại");
            model.addColumn("Tổng tiền");
            while (rs.next()) {
                Object[] r = new Object[4];
                r[0] = rs.getInt("id_khachhang");
                r[1] = rs.getString("tenkhachhang");
                r[2] = rs.getString("sodienthoai");
                r[3] = rs.getString("tonggiatri");
                
                model.addRow(r);
            }

            JT.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void searchForNameTK(String Name, JTable JT) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT KH.ID_KHACHHANG,KH.TENKHACHHANG,KH.SODIENTHOAI,SUM(GIA) TONGGIATRI FROM HOADON HD JOIN KHACHHANG KH WHERE KH.ID_KHACHHANG = HD.ID_KHACHHANG AND KH.TENKHACHHANG LIKE N'%" + Name + "%' GROUP BY KH.ID_KHACHHANG,KH.TENKHACHHANG,KH.SODIENTHOAI";
            PreparedStatement statement = con.prepareStatement(sql);
            rs = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("Mã khách hàng");
            model.addColumn("Họ và tên");
            model.addColumn("Số điện thoại");
            model.addColumn("Tổng tiền");
            while (rs.next()) {
                Object[] r = new Object[4];
                r[0] = rs.getInt("id_khachhang");
                r[1] = rs.getString("tenkhachhang");
                r[2] = rs.getString("sodienthoai");
                r[3] = rs.getString("tonggiatri");
                
                model.addRow(r);
            }

            JT.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public String getDiemBySDT(String e) {
        String diem = "";
        try {
            ps = connection.prepareStatement("select diem from khachhang where sodienthoai=?");
            ps.setString(1, e);
            rs = ps.executeQuery();
            if (rs.next()) {
                diem = rs.getString(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return diem;
    }

    public double getDiem(int  id) {

        int sl = 0;
        try {
            st = connection.createStatement();
            rs = st.executeQuery("select diem from khachhang where id_khachhang ='" + id + "'");
            if (rs.next()) {

                sl = rs.getInt(1);
            }
        } catch (SQLException e) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return sl;
    }
     public void updateDiem(int  id, double diem) {

        String sql = "update khachhang set diem=? where id_khachhang=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setDouble(1,diem);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
