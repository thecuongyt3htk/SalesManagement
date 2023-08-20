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
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;
import model.NhanVien;

/**
 *
 * @author ACER
 */
public class NhanVienDAO implements DAOInterface<NhanVien> {
    
    Connection connection = JDBCUtil.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    @Override

    public int khoiTaoID() {

        int r = 0;
        try {
            st = connection.createStatement();
            rs = st.executeQuery("select max(id_nhanvien) from nhanvien");
            while (rs.next()) {
                
                r = rs.getInt(1);
            }
        } catch (Exception e) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return r + 1;
    }

    
    
    @Override
    public int insert(NhanVien t) {
        int ketqua = 0;
        try {
            java.util.Date utilDate = t.getNgaySinh();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            Connection con = JDBCUtil.getConnection();

            String sql = "INSERT INTO nhanvien (ID_nhanvien, tennhanvien, diachi, sodienthoai, email, matkhau,ngaysinh) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, t.getId());
            statement.setString(2, t.getTen());
            statement.setString(3, t.getDiaChi());
            statement.setString(4, t.getSdt());
            statement.setString(5, t.getEmail());
            statement.setString(6, t.getMatKhau());
            statement.setDate(7, t.getNgaySinh());


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
    public int update(NhanVien t) {
        int ketqua = 0;
        try {
            java.util.Date utilDate = t.getNgaySinh();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE nhanvien SET tennhanvien = ?, diachi = ?, sodienthoai = ?, email = ?, matkhau = ?,ngaysinh=? WHERE ID_nhanvien = ?";

            PreparedStatement statement = con.prepareStatement(sql);
 
            statement.setString(1, t.getTen());
            statement.setString(2, t.getDiaChi());
            statement.setString(3, t.getSdt());
            statement.setString(4, t.getEmail());
            statement.setString(5, t.getMatKhau());
            statement.setDate(6, t.getNgaySinh());
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
    public int delete(NhanVien t) {
        int ketqua = 0;
        try {

            Connection con = JDBCUtil.getConnection();

            String sql = "delete from nhanvien where id_nhanvien=?";

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

    public boolean kiemTraEmailTonTai(NhanVien t) {
        try {
            ps = connection.prepareStatement("select * from nhanvien where email=?");
            ps.setString(1, t.getEmail());
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    
    public boolean kiemTraEmailKhongDuocThayDoi(NhanVien t) {
        try {
            ps = connection.prepareStatement("select * from nhanvien where email=?");
            ps.setString(1, t.getEmail());
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
    public boolean kiemTraIDKhongDuocThayDoi(NhanVien t) {
        try {
            ps = connection.prepareStatement("select * from nhanvien where id_nhanvien=?");
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
            ps = connection.prepareStatement("select * from nhanvien where ID_nhanvien=?");
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
            String sql = "SELECT * FROM nhanvien ORDER BY id_nhanvien ASC";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("ID");
            model.addColumn("Họ và tên");
            model.addColumn("Địa chỉ");
            model.addColumn("Số điện thoại");
            model.addColumn("Email");
            model.addColumn("Mật khẩu");
            model.addColumn("Ngày sinh");
           // model.addColumn("Doanh thu");
            while (rs.next()) {
                Object[] r = new Object[8];
                r[0] = rs.getInt("id_nhanvien");
                r[1] = rs.getString("tennhanvien");
                r[2] = rs.getString("diachi");
                r[3] = rs.getString("sodienthoai");
                r[4] = rs.getString("email");
                r[5] = rs.getString("matkhau");
                r[6] = rs.getDate("ngaysinh");
             //   r[7] = rs.getDate("doanhthu");

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
            String sql = "SELECT NV.ID_NHANVIEN, TENNHANVIEN, SUM(DOANHTHU) TONGDOANHTHU FROM DOANHTHU_NHANVIEN DTNV JOIN NHANVIEN NV WHERE DTNV.ID_NHANVIEN = NV.ID_NHANVIEN GROUP BY NV.ID_NHANVIEN, TENNHANVIEN";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("Mã nhân viên");
            model.addColumn("Họ và tên");
            model.addColumn("Tổng doanh thu");
           // model.addColumn("Doanh thu");
            while (rs.next()) {
                Object[] r = new Object[3];
                r[0] = rs.getInt("id_nhanvien");
                r[1] = rs.getString("tennhanvien");
                r[2] = rs.getString("tongdoanhthu");

                model.addRow(r);
            }

            JT.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadDataTopBest(JTable JT,int n) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT NV.ID_NHANVIEN, TENNHANVIEN, SUM(DOANHTHU) TONGDOANHTHU FROM DOANHTHU_NHANVIEN DTNV JOIN NHANVIEN NV "
                    + "WHERE DTNV.ID_NHANVIEN = NV.ID_NHANVIEN GROUP BY NV.ID_NHANVIEN, TENNHANVIEN ORDER BY TONGDOANHTHU DESC ;";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("Mã nhân viên");
            model.addColumn("Họ và tên");
            model.addColumn("Tổng doanh thu");
            double a = -1;
            while (rs.next() && n>=0) {
                
                Object[] r = new Object[3];
                double tg = a;
                r[0] = rs.getInt("id_nhanvien");
                r[1] = rs.getString("tennhanvien");
                r[2] = rs.getString("tongdoanhthu");
                a = Double.parseDouble(r[2].toString());
                if(tg==Double.parseDouble(r[2].toString())&& n==0) n = n+1;
                else if (n==0) break;
                model.addRow(r);
                n--;
            }
            
            JT.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadDataTopWorst(JTable JT, int n) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT NV.ID_NHANVIEN, TENNHANVIEN, SUM(DOANHTHU) TONGDOANHTHU FROM DOANHTHU_NHANVIEN DTNV JOIN NHANVIEN NV "
                    + "WHERE DTNV.ID_NHANVIEN = NV.ID_NHANVIEN GROUP BY NV.ID_NHANVIEN, TENNHANVIEN ORDER BY TONGDOANHTHU ASC LIMIT 5;";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("Mã nhân viên");
            model.addColumn("Họ và tên");
            model.addColumn("Tổng doanh thu");
            double a = -1;
            while (rs.next() && n>=0) {
                
                Object[] r = new Object[3];
                double tg = a;
                r[0] = rs.getInt("id_nhanvien");
                r[1] = rs.getString("tennhanvien");
                r[2] = rs.getString("tongdoanhthu");
                a = Double.parseDouble(r[2].toString());
                if(tg==Double.parseDouble(r[2].toString())&& n==0) n = n+1;
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
            ps = connection.prepareStatement("select id_nhanvien from nhanvien where email=?");
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

    
    public String tinhtbDT()
    {
        String a ="";
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT NV.ID_NHANVIEN, TENNHANVIEN, SUM(DOANHTHU) TONGDOANHTHU FROM DOANHTHU_NHANVIEN DTNV JOIN NHANVIEN NV WHERE DTNV.ID_NHANVIEN = NV.ID_NHANVIEN GROUP BY NV.ID_NHANVIEN, TENNHANVIEN";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("Mã nhân viên");
            model.addColumn("Họ và tên");
            model.addColumn("Tổng doanh thu");
            int count=0;
            double sum = 0;
            while (rs.next()) {
                Object[] r = new Object[3];
                r[0] = rs.getInt("id_nhanvien");
                r[1] = rs.getString("tennhanvien");
                r[2] = rs.getString("tongdoanhthu");

                count++;
                sum += Double.parseDouble(r[2].toString());
            }
            sum = sum/(double) count;
            a = String.format(Locale.US,"%.2f",sum);

        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
    @Override
    public String getTen(String e) {
        String ten = "";
        try {
            ps = connection.prepareStatement("select tennhanvien from khachhang where email=?");
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
            String sql = "SELECT * FROM nhanvien WHERE ID_nhanvien = " + id;
            PreparedStatement statement = con.prepareStatement(sql);
            rs = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("ID");
            model.addColumn("Họ và tên");
            model.addColumn("Địa chỉ");
            model.addColumn("Số điện thoại");
            model.addColumn("Email");
            model.addColumn("Mật khẩu");
            model.addColumn("Ngày sinh");
           // model.addColumn("Doanh thu");
            while (rs.next()) {
                Object[] r = new Object[8];
                r[0] = rs.getInt("id_nhanvien");
                r[1] = rs.getString("tennhanvien");
                r[2] = rs.getString("diachi");
                r[3] = rs.getString("sodienthoai");
                r[4] = rs.getString("email");
                r[5] = rs.getString("matkhau");
                r[6] = rs.getDate("ngaysinh");
             //   r[7] = rs.getDate("doanhthu");

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
            String sql = "SELECT * FROM nhanvien WHERE SODIENTHOAI = '" + sdt + "' ";
            PreparedStatement statement = con.prepareStatement(sql);
            rs = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();

              model.addColumn("ID");
            model.addColumn("Họ và tên");
            model.addColumn("Địa chỉ");
            model.addColumn("Số điện thoại");
            model.addColumn("Email");
            model.addColumn("Mật khẩu");
            model.addColumn("Ngày sinh");
           // model.addColumn("Doanh thu");
            while (rs.next()) {
                Object[] r = new Object[8];
                r[0] = rs.getInt("id_nhanvien");
                r[1] = rs.getString("tennhanvien");
                r[2] = rs.getString("diachi");
                r[3] = rs.getString("sodienthoai");
                r[4] = rs.getString("email");
                r[5] = rs.getString("matkhau");
                r[6] = rs.getDate("ngaysinh");
             //   r[7] = rs.getDate("doanhthu");

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
            String sql = "SELECT * FROM nhanvien WHERE tennhanvien LIKE N'%" + Name + "%'";
            PreparedStatement statement = con.prepareStatement(sql);
            rs = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();

             model.addColumn("ID");
            model.addColumn("Họ và tên");
            model.addColumn("Địa chỉ");
            model.addColumn("Số điện thoại");
            model.addColumn("Email");
            model.addColumn("Mật khẩu");
            model.addColumn("Ngày sinh");
           // model.addColumn("Doanh thu");
            while (rs.next()) {
                Object[] r = new Object[8];
                r[0] = rs.getInt("id_nhanvien");
                r[1] = rs.getString("tennhanvien");
                r[2] = rs.getString("diachi");
                r[3] = rs.getString("sodienthoai");
                r[4] = rs.getString("email");
                r[5] = rs.getString("matkhau");
                r[6] = rs.getDate("ngaysinh");
             //   r[7] = rs.getDate("doanhthu");

                model.addRow(r);
            }

            JT.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
