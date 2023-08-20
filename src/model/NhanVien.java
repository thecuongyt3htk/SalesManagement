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
public class NhanVien {
    private int id;
    private String ten;
    private String diaChi;
    private String sdt;
    private String email;
    private String matKhau;
    private Date ngaySinh;


    public NhanVien(int id, String ten, String diaChi, String sdt, String email, String matKhau, Date ngaySinh) {
        this.id = id;
        this.ten = ten;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.matKhau = matKhau;
        this.ngaySinh = ngaySinh;
    
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }



    
}
