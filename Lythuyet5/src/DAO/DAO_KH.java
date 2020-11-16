package DAO;

import Class.Class_KhachHang;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAO_KH {

    public static ResultSet LayTat() {
        String sql = "Select * from KhachHang";
        return KetNoi.Select(sql);

    }

    public static void dolenList(JTable tblKH) {
        try {
            DefaultTableModel model = (DefaultTableModel) tblKH.getModel();
            ResultSet rs = DAO_KH.LayTat();
            Vector v = null;
            model.setRowCount(0);
            while (rs.next()) {
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));

                v.add(rs.getString(4));
                v.add(rs.getString(3));
                v.add(rs.getString(5));
                v.add(rs.getString(6));

                model.addRow(v);
            }
            tblKH.setModel(model);
        } catch (Exception e) {
        }
    }

    public static void Update(Class_KhachHang kh) {
        try {
            String sql = "select MaKH from KhachHang\n"
                    + "where SoDienThoai = '" + kh.getSoDT() + "'";
            ResultSet rs = KetNoi.Select(sql);
            if (rs.next()) {
                String sqlKM = "update KhachHang\n"
                        + "set HoTen= N'" + kh.getTenKH() + "'"
                        + ",SoNguoi=" + kh.getSoNguoi() + ""
                        + "where MaKH=" + rs.getString(1) + "";
                if (KetNoi.Update(sqlKM) > 0) {
                    System.out.println("Cập nhật thành công");
                } else {
                    System.out.println("Thất bại");
                }
            }
        } catch (Exception e) {
        }
    }

    public static void Delete(Class_KhachHang kh) {
        try {
            String sql = "select MaKH from KhachHang\n"
                    + "where SoDienThoai = '" + kh.getSoDT() + "'";
            ResultSet rs = KetNoi.Select(sql);
            if (rs.next()) {
                String sqlKM = "exec sp_deleteKH @maKH="+rs.getString(1)+"";
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
