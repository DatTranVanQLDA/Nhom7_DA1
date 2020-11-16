package DAO;

import Class.Class_Buffet;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAO_MonAn {

    public static ResultSet LayTat() {
        String sql = "Select * from MonAn";
        return KetNoi.Select(sql);

    }
  public static void Delete(Class_Buffet b) {
        try {
            String sqlMA = "delete from MonAn\n"
                    + "where MaMA = N'" + b.getMaMA() + "'";
         
            if (KetNoi.Update(sqlMA) > 0) {
                System.out.println("Xóa thành công");
            } else {
                System.out.println("Xóa thất bại");
            }
        } catch (Exception e) {
            System.out.println("Lỗi" + e);
        }

    }
    public static void HienCBB(JComboBox cbbMaTL) {
        cbbMaTL.removeAllItems();
        String sql = "select TenTL from TheLoaiMonAn\n";

        try {
            ResultSet rs = KetNoi.Select(sql);

            while (rs.next()) {

                cbbMaTL.addItem(rs.getString(1));

            }
        } catch (Exception e) {
        }
    }

    public static void dolenList(JTable tblMA) {
        try {
            DefaultTableModel model = (DefaultTableModel) tblMA.getModel();
            ResultSet rs = DAO_MonAn.LayTat();
            Vector v = null;
            model.setRowCount(0);
            while (rs.next()) {
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                model.addRow(v);
            }
            tblMA.setModel(model);
        } catch (Exception e) {
        }
    }

    public static void Insert(Class_Buffet b) {
        try {
            String sqlMaTL = "select MaTL from TheLoaiMonAn\n"
                    + "where TenTL =N'" + b.getMaTL() + "'";
            ResultSet rs = KetNoi.Select(sqlMaTL);
            if (rs.next()) {
                System.out.println(rs.getString(1));
                String sql = "insert into MonAn(MaMA,TenMA,Gia,MaTL)\n"
                        + "values(N'" + b.getMaMA() + "'"
                        + ",N'" + b.getTenMA() + "'"
                        + "," + b.getGia() + ""
                        + ",N'" + rs.getString(1) + "')";
                if (KetNoi.Update(sql) > 0) {
                    System.out.println("Thêm thành công");
                } else {
                    System.out.println("Thêm thất bại");
                }

            }
        } catch (Exception e) {
        }

    }

    public static void Update(Class_Buffet b) {
        try {
            String sqlMaTL = "select MaTL from TheLoaiMonAn\n"
                    + "where TenTL =N'" + b.getMaTL() + "'";
            ResultSet rs = KetNoi.Select(sqlMaTL);
            if (rs.next()) {
                System.out.println(rs.getString(1));
                String sql = "update MonAn\n"
                        + "set TenMA = N'" + b.getTenMA() + "'"
                        + ",Gia =" + b.getGia() + ""
                        + ",MaTL = N'" + rs.getString(1) + "'"
                        + "where MaMA = N'" + b.getMaMA() + "'";
                if (KetNoi.Update(sql) > 0) {
                    System.out.println("Sửa thành công");
                } else {
                    System.out.println("Sửa thất bại");
                }

            }
        } catch (Exception e) {

        }

    }

  
}
