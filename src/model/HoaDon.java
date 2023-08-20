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
public class HoaDon {
    private int id;
    private String tenkhachhang;
    private String sodienthoai;
    private double gia;
    private Date ngaymua;
    private int id_nv;
    private int id_kh;

    public HoaDon(int id, String tenkhachhang, String sodienthoai, double gia, Date ngaymua, int id_nv, int id_kh) {
        this.id = id;
        this.tenkhachhang = tenkhachhang;
        this.sodienthoai = sodienthoai;
        this.gia = gia;
        this.ngaymua = ngaymua;
        this.id_nv = id_nv;
        this.id_kh = id_kh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public Date getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(Date ngaymua) {
        this.ngaymua = ngaymua;
    }

    public int getId_nv() {
        return id_nv;
    }

    public void setId_nv(int id_nv) {
        this.id_nv = id_nv;
    }

    public int getId_kh() {
        return id_kh;
    }

    public void setId_kh(int id_kh) {
        this.id_kh = id_kh;
    }

    
    
          
}
