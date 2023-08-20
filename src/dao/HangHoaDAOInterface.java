package dao;
import javax.swing.JTable;

public interface HangHoaDAOInterface<T> {

    public int khoiTaoID();

    public int insert(T t);

    public int update(T t);

    public int delete(T t);

    public void loadData(JTable JT);

    public boolean kiemTraIDKhongDuocThayDoi(T t);

    public int getID(String e);
}