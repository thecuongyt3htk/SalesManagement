/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class SanPham {
    private int id;
    private String tensanpham;
    private String tendanhmuc;
    private String tennhacungcap;
    private double gia;
    private int soluong;
    private int id_danhmuc;
    private int id_nhacungcap;
  
 

    public SanPham(int id, String tensanpham, String tendanhmuc,String tennhacungcap, double gia, int soluong,int id_danhmuc,int id_nhacungcap) {
        this.id = id;
        this.tensanpham = tensanpham;
        this.tendanhmuc = tendanhmuc;
        this.tennhacungcap=tennhacungcap;
        this.gia = gia;
        this.soluong = soluong;
        this.id_danhmuc=id_danhmuc;
        this.id_nhacungcap=id_nhacungcap;
    
    }

    public int getId_danhmuc() {
        return id_danhmuc;
    }

    public void setId_danhmuc(int id_danhmuc) {
        this.id_danhmuc = id_danhmuc;
    }

    public int getId_nhacungcap() {
        return id_nhacungcap;
    }

    public void setId_nhacungcap(int id_nhacungcap) {
        this.id_nhacungcap = id_nhacungcap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getTendanhmuc() {
        return tendanhmuc;
    }

    public void setTendanhmuc(String tendanhmuc) {
        this.tendanhmuc = tendanhmuc;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

  

    public String getTennhacungcap() {
        return tennhacungcap;
    }

    public void setTennhacungcap(String tennhacungcap) {
        this.tennhacungcap = tennhacungcap;
    }

  
    
}
