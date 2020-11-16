package DAO;

import Class.Class_TaiKhoan;
import NullLayou.QuenMatKhau;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAO_TaiKhoan {

    public static ResultSet LayTat() {
        String sql = "Select * from TaiKhoan";
        return KetNoi.Select(sql);

    }

    public static void Insert(Class_TaiKhoan tk) {
        try {
            String sql = "insert into TaiKhoan(MaTK,TenEmail,MatKhau,VaiTro)\n"
                    + " values(N'" + tk.getMaTK() + "'"
                    + ",'N" + tk.getTenMail() + "'"
                    + ",N'" + tk.getMatKhau() + "'"
                    + "," + tk.getVaiTro() + ")";

            if (KetNoi.Update(sql) > 0) {
                System.out.println("Thêm mới thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
    }

    public static void Delete(Class_TaiKhoan tk) {
        try {
            String sql = "delete from TaiKhoan\n"
                    + "where MaTK= N'" + tk.getMaTK() + "'";

            if (KetNoi.Update(sql) > 0) {
                System.out.println("Xóa thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
    }

    public static void updateTB(Class_TaiKhoan tk) {
        try {
            String sql = "update TaiKhoan\n"
                    + "set TenEmail = N'" + tk.getTenMail() + "'"
                    + ",MatKhau = N'" + tk.getMatKhau() + "'\n"
                    + ",VaiTro = " + tk.getVaiTro() + "\n"
                    + "where MaTK =N'" + tk.getMaTK() + "'";
            if (KetNoi.Update(sql) > 0) {
                System.out.println("Cập nhật thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
    }

    public static void update(String MK) {
        try {
            String sql = "update TaiKhoan\n"
                    + "set MatKhau = N'" + MK + "'\n"
                    + "where TenEmail = N'" + QuenMatKhau.tk + "'";
            if (KetNoi.Update(sql) > 0) {
                System.out.println("Cập nhật thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
    }

    public static void dolenList(JTable tblTK) {
        try {
            DefaultTableModel model = (DefaultTableModel) tblTK.getModel();
            ResultSet rs = DAO_TaiKhoan.LayTat();
            Vector v = null;
            model.setRowCount(0);
            while (rs.next()) {
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                String a ;
                if(rs.getString(4).equals("0")){
                 a= "Lễ Tân";
                }
                else{
                a = "Quản Lý";
                }
                v.add(a);
                v.add(rs.getString(5));
                model.addRow(v);
            }
            tblTK.setModel(model);
        } catch (Exception e) {
        }
    }
}
