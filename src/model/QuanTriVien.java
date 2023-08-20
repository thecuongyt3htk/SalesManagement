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
public class QuanTriVien extends NguoiDung  {
    private Date ngaySinh;

    
    public QuanTriVien(int id, String ten, String sdt, String email, String matkhau,Date ngaySinh) {
        super(id, ten, sdt, email, email, matkhau);
        this.ngaySinh=ngaySinh;
  
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }


}
