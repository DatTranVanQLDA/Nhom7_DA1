package DAO;

import Class.Class_Ban;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAO_Ban {

    public static ResultSet LayTat() {
        String sql = "select * from DatBan";
        return KetNoi.Select(sql);

    }


    public static void Insert(Class_Ban b) {
        try {
            String sql = "insert into DatBan\n"
                    + " values(N'" + b.getMaBan() + "'"
                    + "," + b.getSoGhe() +")";

            if (KetNoi.Update(sql) > 0) {
                System.out.println("Thêm mới thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
    }

    public static void Delete(Class_Ban b) {
        try {
            String sql = "exec sp_deleteBan @maban = N'" + b.getMaBan() + "'";

            if (KetNoi.Update(sql) > 0) {
                System.out.println("Xóa thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
    }

    public static void updateTB(Class_Ban b) {
        try {
            String sql = "update DatBan\n"
                    + "set SoGhe = " + b.getSoGhe() + ""
                    + "where MaDB = N'" + b.getMaBan() + "'";
            if (KetNoi.Update(sql) > 0) {
                System.out.println("Cập nhật thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
    }

    public static void dolenList(JTable tblB) {
        try {
            DefaultTableModel model = (DefaultTableModel) tblB.getModel();
            ResultSet rs = DAO_Ban.LayTat();
            Vector v = null;
            model.setRowCount(0);
            while (rs.next()) {
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
              
                model.addRow(v);
            }
            tblB.setModel(model);
        } catch (Exception e) {
        }
    }
}
