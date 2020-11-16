package DAO;

import Class.Class_KM;
import Class.Class_TaiKhoan;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAO_KM {

    public static ResultSet LayTT() {
        String sql = "select * from KhuyenMai";
        return KetNoi.Select(sql);
    }

    public static void doLenTable(JTable tblKM) {
        DefaultTableModel model = (DefaultTableModel) tblKM.getModel();
        ResultSet rs = DAO_KM.LayTT();
        Vector v = null;
        model.setRowCount(0);
        try {
            while (rs.next()) {
                v = new Vector();
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                model.addRow(v);
            }
            tblKM.setModel(model);

        } catch (Exception e) {
        }
    }

    public static void Insert(Class_KM k) {
        try {
            String sql = "insert into KhuyenMai(TenKH,Giam,NgayBDau,NgayKT)\n"
                    + "values(N'" + k.getTenKM() + "'"
                    + "," + k.getGiamGia() + ""
                    + ",N'" + k.getNgayBD() + "'"
                    + ",N'" + k.getNgayKT() + "')";
            if (KetNoi.Update(sql) > 0) {
                System.out.println("Thêm mới thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
    }

    public static void Update(Class_KM k) {
        try {
            String sql = "select MaKM from KhuyenMai\n"
                    + "where TenKH =	N'" + k.getTenKM() + "'";
            ResultSet rs = KetNoi.Select(sql);
            if (rs.next()) {
                String sqlKM = "update KhuyenMai\n"
                        + "set TenKH = N'" + k.getTenKM() + "'"
                        + ",Giam=" + k.getGiamGia() + ""
                        + ",NgayBDau =	N'" + k.getNgayBD() + "'"
                        + ",NgayKT =N'" + k.getNgayKT() + "'"
                        + "where MaKM ="+rs.getString(1)+"";
                if (KetNoi.Update(sqlKM) > 0) {
                    System.out.println("Cập nhật thành công");
                } else {
                    System.out.println("Thất bại");
                }
            }
        } catch (Exception e) {
        }
    }
     public static void Delete(Class_KM k) {
         try {
            String sql = "select MaKM from KhuyenMai\n"
                    + "where TenKH =	N'" + k.getTenKM() + "'";
            ResultSet rs = KetNoi.Select(sql);
            if (rs.next()) {
                String sqlKM = "Delete from KhuyenMai\n"
                        + "where MaKM="+rs.getString(1)+"";
                if (KetNoi.Update(sqlKM) > 0) {
                    System.out.println("Xóa thành công");
                } else {
                    System.out.println("Thất bại");
                }
            }
        } catch (Exception e) {
        }
    }
}
