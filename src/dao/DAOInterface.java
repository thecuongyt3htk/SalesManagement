/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.ArrayList;
import javax.swing.JTable;
import model.NguoiDung;

/**
 *
 * @author ACER
 */
public interface DAOInterface<T> {

    public int khoiTaoID();

    public int insert(T t);

    public int update(T t);

    public int delete(T t);

    //public boolean kiemTraEmailTonTai(T t);

   // public boolean kiemTraEmailKhongDuocThayDoi(T t);

    public boolean kiemTraIDKhongDuocThayDoi(T t);

    public String[] selectInfor(int id);

    public void loadData(JTable JT);

    public int getId(String e);

    public String getTen(String e);

    public void searchForID(int id, JTable JT);

    public void searchForSDT(String sdt, JTable JT);

    public void searchForName(String Name, JTable JT);
}