package DAO;

import Class.Class_NV;
import java.awt.Image;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAO_NhanVien {

    public static ResultSet LayTat() {
        String sql = "Select * from NhanVien";
        return KetNoi.Select(sql);

    }

    public static void LayIcon(String anh, JLabel lblAnh) {
        try {
            ImageIcon icon = new ImageIcon("E:\\1 Tai Nguyen JAVA3\\SOF203\\Lythuyet5\\src\\img\\" + anh);
            Image img = icon.getImage();
            ImageIcon icon1 = new ImageIcon(img.getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), img.SCALE_SMOOTH));
            lblAnh.setIcon(icon1);

        } catch (Exception e) {
        }

    }

    public static void dolenList(JTable tblNV) {
        try {
            DefaultTableModel model = (DefaultTableModel) tblNV.getModel();
            ResultSet rs = DAO_NhanVien.LayTat();
            Vector v = null;
            model.setRowCount(0);
            while (rs.next()) {
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                String a;
                if (rs.getString(6).equals("0")) {
                    a = "Nữ";
                } else {
                    a = "Nam";
                }
                v.add(a);

                v.add(rs.getString(7));
                v.add(rs.getString(8));
                model.addRow(v);
            }
            tblNV.setModel(model);
        } catch (Exception e) {
        }
    }

    public static void Insert(Class_NV n) {
        try {
            String sql = "insert into NhanVien(MaNV,HoTen,NgaySinh,Phone,DiaChi,GioiTinh,TenEmail,HinhAnh ) \n"
                    + "values(N'" + n.getMaNV() + "'"
                    + ",N'" + n.getHoTen() + "'"
                    + ",'" + n.getNgaySinh() + "'"
                    + ",'" + n.getSDT() + "'"
                    + ",N'" + n.getDiaChi() + "'"
                    + "," + n.getGioiTinh() + ""
                    + ",'" + n.getEmail() + "'"
                    + ",N'" + n.getHinhAnh() + "')";

            if (KetNoi.Update(sql) > 0) {
                System.out.println("Thêm mới thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
    }

    public static void Delete(Class_NV n) {
        try {
            String sql = "delete from NhanVien\n"
                    + "where MaNV = N'" + n.getMaNV() + "'";

            if (KetNoi.Update(sql) > 0) {
                System.out.println("Xóa thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
    }

    public static void update(Class_NV n) {
        try {
            String sql = "update NhanVien\n"
                    + "set HoTen = N'"+n.getHoTen()+"'"
                    + ",NgaySinh = '"+n.getNgaySinh()+"'"
                    + ",Phone='"+n.getSDT()+"'"
                    + ",DiaChi=N'"+n.getDiaChi()+"'"
                    + ",GioiTinh="+n.getGioiTinh()+""
                    + ",TenEmail =N'"+n.getEmail()+"'"
                    + ",HinhAnh=N'"+n.getHinhAnh()+"'"
                    + "where MaNV = '"+n.getMaNV()+"'";
            if (KetNoi.Update(sql) > 0) {
                System.out.println("Cập nhật thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
    }

}
