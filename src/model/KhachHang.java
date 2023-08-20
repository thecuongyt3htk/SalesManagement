    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;

/**
 *
 * @author ACER
 */
public class KhachHang   {
    private int id;
    private String ten;
    private String sdt;
    private String diaChi;
    private Date ngaySinh;
    private Date ngayDangKy;
    private double diem;

    public KhachHang(int id, String ten, String sdt, String diaChi, Date ngaySinh, Date ngayDangKy, double diem) {
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.ngayDangKy = ngayDangKy;
        this.diem = diem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }
    

   

  

    
  
}
