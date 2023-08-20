/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public abstract class NguoiDung implements Interface{
    private int id;
    private String ten;
    private String sdt;
    private String email;
    private String matKhau;
    private String diaChi;
    public NguoiDung(){
    
    }
    public NguoiDung(int id,String ten,String diaChi,String sdt,String email,String matKhau){
    
        this.id=id;
        this.ten=ten;
        this.diaChi=diaChi;
        this.sdt=sdt;
        this.email=email;
        this.matKhau=matKhau;
        
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "NguoiDung{" + "id=" + id + ", ten=" + ten + ", sdt=" + sdt + ", email=" + email + ", matKhau=" + matKhau + ", diaChi=" + diaChi + '}';
    }
    
    
}
