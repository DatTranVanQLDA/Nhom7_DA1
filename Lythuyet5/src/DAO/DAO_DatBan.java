package DAO;

import Class.Class_DatBan;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAO_DatBan {

    public static String maMA, tenMA;

    public static ResultSet LayTat() {
        String sql = "select HoTen,SoDienThoai,SoNguoi,NgayDen,ThoiGian,TenMA,ChiTietDatBan.MaDB from KhachHang join ChiTietDatBan\n"
                + "on KhachHang.MaKH = ChiTietDatBan.MaKH\n"
                + "join DatBan on DatBan.MaDB = ChiTietDatBan.MaDB\n"
                + "join MonAn on MonAn.MaMA = ChiTietDatBan.MaMA \n"
                + "order by CONVERT(varchar(20),NgayDen,105) asc ,CONVERT(varchar(20),ThoiGian,108) asc\n"
                + "offset 0 rows fetch next 5 rows only";
        return KetNoi.Select(sql);

    }

    public static ResultSet next() {

        String sql = " exec sp_HaHa";
        return KetNoi.Select(sql);

    }

    public static void LoadThucAn(JComboBox cbbLoai, JComboBox cbbBanSo) {

        cbbLoai.removeAllItems();
        String sql = "Select TenMA from MonAn\n";

        try {
            ResultSet rs = KetNoi.Select(sql);

            while (rs.next()) {

                cbbLoai.addItem(rs.getString(1));

            }
        } catch (Exception e) {
        }

        cbbBanSo.removeAllItems();
        String sql1 = "select * from DatBan";
        try {
            ResultSet rs = KetNoi.Select(sql1);

            while (rs.next()) {

                cbbBanSo.addItem(rs.getString(1));

            }
        } catch (Exception e) {
        }

    }

    public static void NutNext(JTable tblDB) {
        try {

            DefaultTableModel model = (DefaultTableModel) tblDB.getModel();
            ResultSet rs = DAO_DatBan.next();
            Vector v = null;
            model.setRowCount(0);
            while (rs.next()) {
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                model.addRow(v);
            }
            tblDB.setModel(model);
        } catch (Exception e) {
        }
    }

    public static void dolenList(JTable tblDB) {
        try {
            DefaultTableModel model = (DefaultTableModel) tblDB.getModel();
            ResultSet rs = DAO_DatBan.LayTat();
            Vector v = null;
            model.setRowCount(0);
            while (rs.next()) {
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));

                model.addRow(v);
            }
            tblDB.setModel(model);
        } catch (Exception e) {
        }
    }

    public static void them(Class_DatBan d) {

        try {
            String sql = "select MaMA,Gia,MaTL from MonAn where TenMA =N'" + d.getLoaiMonAn() + "'";
            ResultSet rsMA = KetNoi.Select(sql);
            if (rsMA.next()) {

                try {
                    String sql1 = "exec sp_KtraKH @HoTen =N'" + d.getHoTen() + "'"
                            + " ,@SoNguoi=" + d.getSoNguoi() + ""
                            + " ,@SoDT= '" + d.getSodienthoai() + "'";
                    if (KetNoi.Update(sql1) > 0) {
                        System.out.println("Thêm khách hàng thành công");
                    } else {
                        System.out.println("Thêm khách hàng thất bại");
                    }
                } catch (Exception e) {
                    System.out.println("Lỗi khách hàng " + e);
                }
                try {
                    String sql2 = "select * from KhachHang\n"
                            + "where HoTen = N'" + d.getHoTen() + "'"
                            + "and SoDienThoai = '" + d.getSodienthoai() + "'";

                    ResultSet rsCTDB = KetNoi.Select(sql2);

                    if (rsCTDB.next()) {
                        System.out.println(rsCTDB.getString(1));
                        System.out.println(rsMA.getString(1));
                        String sql3 = "exec sp_ChiTietDB @MaDB =N'" + d.getBanSo() + "'"
                                + " ,@MaKH=" + rsCTDB.getString(1) + ""
                                + ",@MaMA=N'" + rsMA.getString(1) + "'"
                                + ",@NgayDen=N'" + d.getNgayDen() + "'"
                                + ",@ThoiGian=N'" + d.getThoiGian() + "'";

                        if (KetNoi.Update(sql3) > 0) {
                            System.out.println("Thêm CTDB thành công");
                        } else {
                            System.out.println("Thêm CTDB thất bại");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Lỗi CTDB " + e);
                }

            } else {
                System.out.println("Lỗi món ăn ");
            }

        } catch (Exception e) {
            System.out.println("Lỗi từ đầu " + e);
        }
    }

    public static void Xoa(Class_DatBan d) {
        try {
            String sqlKH = "select MaKH from KhachHang\n"
                    + "where SoDienThoai = '" + d.getSodienthoai() + "'";
            ResultSet rsKH = KetNoi.Select(sqlKH);
            if (rsKH.next()) {
                String sqlXoa = "  delete ChiTietDatBan\n"
                        + "  where MaKH= "+rsKH.getString(1)+"";
                  if (KetNoi.Update(sqlXoa) > 0) {
                            System.out.println("Xóa thành công");
                        } else {
                            System.out.println("Thất bại");
                        }
            }
        } catch (Exception e) {
        }
    }

    public static void Sua(Class_DatBan d) {

        try {
            String sql = "select MaMA,Gia,MaTL from MonAn where TenMA =N'" + d.getLoaiMonAn() + "'";
            ResultSet rsMA = KetNoi.Select(sql);
            if (rsMA.next()) {

                try {
                    String sqlKH = "select MaKH from KhachHang\n"
                            + "where SoDienThoai = '" + d.getSodienthoai() + "'";
                    ResultSet rsKH = KetNoi.Select(sqlKH);
                    if (rsKH.next()) {
                        String sqlKM = "exec sp_KtraKH @HoTen =N'" + d.getHoTen() + "'"
                                + " ,@SoNguoi=" + d.getSoNguoi() + ""
                                + " ,@SoDT= '" + d.getSodienthoai() + "'";
                        if (KetNoi.Update(sqlKM) > 0) {
                            System.out.println("Cập nhật thành công");
                        } else {
                            System.out.println("Thất bại");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Lỗi khách hàng " + e);
                }
                try {
                    String sql2 = "select * from KhachHang\n"
                            + "where HoTen = N'" + d.getHoTen() + "'"
                            + "and SoDienThoai = '" + d.getSodienthoai() + "'";

                    ResultSet rsCTDB = KetNoi.Select(sql2);

                    if (rsCTDB.next()) {
                        System.out.println(rsCTDB.getString(1));
                        String sqlLayMCT = "Select * from ChiTietDatBan\n"
                                + "where MaKH = " + rsCTDB.getString(1) + "";
                        ResultSet rsLayMCT = KetNoi.Select(sqlLayMCT);
                        if (rsLayMCT.next()) {
                            System.out.println(rsMA.getString(1));
                            String sql3 = "exec sp_ChiTietDB @MaDB =N'" + d.getBanSo() + "'"
                                    + " ,@MaKH=" + rsCTDB.getString(1) + ""
                                    + ",@MaMA=N'" + rsMA.getString(1) + "'"
                                    + ",@NgayDen=N'" + d.getNgayDen() + "'"
                                    + ",@ThoiGian=N'" + d.getThoiGian() + "'";
                            if (KetNoi.Update(sql3) > 0) {
                                System.out.println("Cập nhật CTDB thành công");
                            } else {
                                System.out.println("Cập nhật CTDB thất bại");
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Lỗi CTDB " + e);
                }

            } else {
                System.out.println("Lỗi món ăn ");
            }

        } catch (Exception e) {
            System.out.println("Lỗi từ đầu " + e);
        }
    }
}
