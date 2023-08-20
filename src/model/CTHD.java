/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class CTHD {
    private int id_hoadon;
    private int stt;
    private String tensanpham;
    private int id_sp;
    private int soluong;
    private double giatong;

    public CTHD(int id_hoadon, int stt, String tensanpham, int id_sp, int soluong, double giatong) {
        this.id_hoadon = id_hoadon;
        this.stt = stt;
        this.tensanpham = tensanpham;
        this.id_sp = id_sp;
        this.soluong = soluong;
        this.giatong = giatong;
    }

    public int getId_hoadon() {
        return id_hoadon;
    }

    public void setId_hoadon(int id_hoadon) {
        this.id_hoadon = id_hoadon;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public int getId_sp() {
        return id_sp;
    }

    public void setId_sp(int id_sp) {
        this.id_sp = id_sp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getGiatong() {
        return giatong;
    }

    public void setGiatong(double giatong) {
        this.giatong = giatong;
    }
    
    
            
            
}
