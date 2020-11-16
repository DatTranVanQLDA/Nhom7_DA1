package DAO;


import NullLayou.XacNhanMK;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author My PC
 */
public class DAO_QuenMK {

    public static String maXacNhan = null;

    public static ResultSet KtrMail(String TK) {

        try {
            String sql = "Select * from TaiKhoan\n"
                    + "where TenEmail = N'" + TK + "'";

            return KetNoi.Select(sql);

        } catch (Exception e) {
            return null;
        }

    }

    public static boolean KtraXN(String OTP, String MK, String MK1) {
        if (OTP.equals("")) {
            System.out.println("Mã OTP không được để trống");
            return false;
        }
        if (!OTP.matches(maXacNhan)) {
            System.out.println("Mã OTP không khớp vui lòng nhập lại");
            return false;
        }
        if (MK.equals("")) {
            System.out.println("Mật khẩu không được để trống");
            return false;
        }
        if (!MK1.matches(MK)) {
            System.out.println("Mật khẩu 2 không không khớp vui lòng nhập lại");
            return false;
        }

        return true;
    }
    
    

    public static boolean TaiKhoan(String TK) {
        ResultSet rs = DAO_QuenMK.KtrMail(TK);
        try {
            if (rs.next()) {
                if (TK.matches(rs.getString(2))) {
                    XacNhanMK x = new XacNhanMK();
                    x.setVisible(true);
                    return true;
                } else {
                    System.out.println("Tài khoản không tồn tại");
                    return false;
                }
            } else {
                System.out.println("Đăng nhập thất bại");
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static void GuiMail(String Den) {
        Properties p = new Properties();
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.post", 587);

        String userName = "dattran151001@gmail.com";
        String password = "xxxxx";
        Session s = Session.getDefaultInstance(p, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }

        });
        try {
            Message m = ThongDiepGui(s, userName, Den);
            Transport.send(m);
            System.out.println("Gửi thành công");
        } catch (Exception e) {
            System.out.println("Gửi thất bại");
        }

    }

    public static Message ThongDiepGui(Session s, String NguoiGui, String NguoiNhan) {
        try {
            Random r = new Random();
            int soma = 6;
            String CT = "abcdefghijklmnopqrstvwxyz";
            String CH = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String S = "0123456789";
            String HopNhat = CT + CH + S;
            char[] ma = new char[soma];
            for (int i = 0; i < soma; i++) {
                ma[i] = HopNhat.charAt(r.nextInt(HopNhat.length()));
            }
            maXacNhan = String.valueOf(ma);
            Message m = new MimeMessage(s);
            m.setFrom(new InternetAddress(NguoiGui));
            m.setRecipient(Message.RecipientType.TO, new InternetAddress(NguoiNhan));
            m.setSubject("Chào bạn, chúng tôi đã xác nhận bạn đăng ký tài khoản Snapchat vui lòng nhập mã dưới đây để xác minh");
            m.setText("Mã xác nhận của bạn là: " + maXacNhan);
            return m;
        } catch (Exception e) {
        }
        return null;
    }
}
