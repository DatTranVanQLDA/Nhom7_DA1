package DAO;

import NullLayou.ManHinh;
import NullLayou.ManHinhChinh;
import java.sql.ResultSet;

public class DAO_DangNhap {

    public static String name, pas, vaitro;

    public static ResultSet DNhapTheoMa(String TK, String MK) {
        try {
            String sql = "select * from TaiKhoan where TenEmail =N'" + TK + "'\n"
                    + "and  MatKhau = N'" + MK + "'";
            return KetNoi.Select(sql);

        } catch (Exception e) {
            System.out.println("Loi DAO DN");
            return null;
        }

    }

    public static boolean KT_DangNhap(String TK, String MK) {
        ResultSet rs = DAO.DAO_DangNhap.DNhapTheoMa(TK, MK);

        try {
            if(rs.next()) {
                if (rs.getString(1).matches(TK)) {
                    if (rs.getString(2).matches(MK)) {
                        name = rs.getString(1);
                        pas = rs.getString(2);
                        vaitro = rs.getString(3);
                        System.out.println("Thành công");
                        ManHinhChinh m = new ManHinhChinh();
                        m.setVisible(true);

                        return true;
                    }

                    System.out.println("Tài khoản hoặc mật khẩu sai rồi hi");
                    return false;
                } else {
                    System.out.println("Tiếc quá bạn đã đăng nhập thất bại rồi");
                    return false;
                }
                
            }
            else{
                System.out.println("Đăng nhập thất bại");
                return false;
            }
        } catch (Exception e) {
        }
        return false;
    }
}
