package NullLayou;

import DAO.KetNoi;
import MDI.MDI_Ban;
import MDI.MDI_KM;
import MDI.MDI_QLDatBan;
import MDI.MDI_QLKH;
import MDI.MDI_QLMA;
import MDI.MDI_QLNV;
import MDI.MDI_QLTK;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

public class ManHinhChinh extends javax.swing.JFrame {

    int rong;
    int x = 0;

    public ManHinhChinh() {
        initComponents();
        this.setSize(1470, 800);
        this.setIconImage(new ImageIcon("E:\\1 Tai Nguyen JAVA3\\SOF203\\Lythuyet5\\File rieng\\foursquare.png").getImage());
        ImageIcon i = new ImageIcon("E:\\1 Tai Nguyen JAVA3\\SOF203\\Lythuyet5\\File rieng\\Side Menu.png");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        pnlDoc = new javax.swing.JPanel();
        lblLichSu = new javax.swing.JLabel();
        lblNhanVien = new javax.swing.JLabel();
        lblTrangChu = new javax.swing.JLabel();
        lblTaiKhoan = new javax.swing.JLabel();
        lblDatBan = new javax.swing.JLabel();
        lblKhachHang = new javax.swing.JLabel();
        lblBan = new javax.swing.JLabel();
        lblBuffet = new javax.swing.JLabel();
        lblKhuyenMai = new javax.swing.JLabel();
        lblThongKe = new javax.swing.JLabel();
        lblDi = new javax.swing.JLabel();
        lblThanhDoc = new javax.swing.JLabel();
        pnlDesktop = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 153));
        getContentPane().setLayout(null);

        pnlDoc.setBackground(new java.awt.Color(67, 66, 93));
        pnlDoc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlDoc.setLayout(null);

        lblLichSu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblLichSu.setForeground(new java.awt.Color(255, 255, 255));
        lblLichSu.setIcon(new javax.swing.ImageIcon("C:\\Users\\My PC\\Desktop\\ERD\\File rieng\\icon_help-center.png")); // NOI18N
        lblLichSu.setText("Lịch sử thanh toán");
        lblLichSu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLichSuMouseClicked(evt);
            }
        });
        pnlDoc.add(lblLichSu);
        lblLichSu.setBounds(10, 570, 180, 50);

        lblNhanVien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lblNhanVien.setIcon(new javax.swing.ImageIcon("C:\\Users\\My PC\\Desktop\\ERD\\File rieng\\Union 11.png")); // NOI18N
        lblNhanVien.setText("Quản lý nhân viên");
        lblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseClicked(evt);
            }
        });
        pnlDoc.add(lblNhanVien);
        lblNhanVien.setBounds(10, 210, 170, 50);

        lblTrangChu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        lblTrangChu.setIcon(new javax.swing.ImageIcon("C:\\Users\\My PC\\Desktop\\ERD\\File rieng\\icon_home.png")); // NOI18N
        lblTrangChu.setText("Trang chủ");
        lblTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTrangChuMouseClicked(evt);
            }
        });
        pnlDoc.add(lblTrangChu);
        lblTrangChu.setBounds(10, 30, 150, 50);

        lblTaiKhoan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        lblTaiKhoan.setIcon(new javax.swing.ImageIcon("C:\\Users\\My PC\\Desktop\\ERD\\File rieng\\icon_lock-open.png")); // NOI18N
        lblTaiKhoan.setText("Quản lý tài khoản");
        lblTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTaiKhoanMouseClicked(evt);
            }
        });
        pnlDoc.add(lblTaiKhoan);
        lblTaiKhoan.setBounds(10, 150, 170, 50);

        lblDatBan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDatBan.setForeground(new java.awt.Color(255, 255, 255));
        lblDatBan.setIcon(new javax.swing.ImageIcon("C:\\Users\\My PC\\Desktop\\ERD\\File rieng\\icon_calendar.png")); // NOI18N
        lblDatBan.setText("Quản lý đặt bàn");
        lblDatBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDatBanMouseClicked(evt);
            }
        });
        pnlDoc.add(lblDatBan);
        lblDatBan.setBounds(10, 90, 150, 50);

        lblKhachHang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        lblKhachHang.setIcon(new javax.swing.ImageIcon("C:\\Users\\My PC\\Desktop\\ERD\\File rieng\\icon_add-user.png")); // NOI18N
        lblKhachHang.setText("Quản lý khách hàng");
        lblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKhachHangMouseClicked(evt);
            }
        });
        pnlDoc.add(lblKhachHang);
        lblKhachHang.setBounds(10, 270, 180, 50);

        lblBan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBan.setForeground(new java.awt.Color(255, 255, 255));
        lblBan.setIcon(new javax.swing.ImageIcon("C:\\Users\\My PC\\Desktop\\ERD\\File rieng\\icon_chat-room.png")); // NOI18N
        lblBan.setText("Quản lý bàn");
        lblBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBanMouseClicked(evt);
            }
        });
        pnlDoc.add(lblBan);
        lblBan.setBounds(10, 330, 180, 50);

        lblBuffet.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBuffet.setForeground(new java.awt.Color(255, 255, 255));
        lblBuffet.setIcon(new javax.swing.ImageIcon("C:\\Users\\My PC\\Desktop\\ERD\\File rieng\\icon_Invoices.png")); // NOI18N
        lblBuffet.setText("Quản lý Buffet");
        lblBuffet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuffetMouseClicked(evt);
            }
        });
        pnlDoc.add(lblBuffet);
        lblBuffet.setBounds(10, 390, 180, 50);

        lblKhuyenMai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        lblKhuyenMai.setIcon(new javax.swing.ImageIcon("C:\\Users\\My PC\\Desktop\\ERD\\File rieng\\icon_products.png")); // NOI18N
        lblKhuyenMai.setText("Quản lý khuyến mại");
        lblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKhuyenMaiMouseClicked(evt);
            }
        });
        pnlDoc.add(lblKhuyenMai);
        lblKhuyenMai.setBounds(10, 450, 180, 50);

        lblThongKe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblThongKe.setForeground(new java.awt.Color(255, 255, 255));
        lblThongKe.setIcon(new javax.swing.ImageIcon("C:\\Users\\My PC\\Desktop\\ERD\\File rieng\\icon_dashboard.png")); // NOI18N
        lblThongKe.setText("Thống kê");
        lblThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThongKeMouseClicked(evt);
            }
        });
        pnlDoc.add(lblThongKe);
        lblThongKe.setBounds(10, 510, 180, 50);

        lblDi.setIcon(new javax.swing.ImageIcon("C:\\Users\\My PC\\Desktop\\ERD\\File rieng\\Hover.png")); // NOI18N
        pnlDoc.add(lblDi);
        lblDi.setBounds(0, 30, 210, 50);
        pnlDoc.add(lblThanhDoc);
        lblThanhDoc.setBounds(0, -50, 210, 734);

        getContentPane().add(pnlDoc);
        pnlDoc.setBounds(0, 0, 210, 740);

        pnlDesktop.setBackground(new java.awt.Color(240, 240, 247));
        pnlDesktop.add(jLabel1);
        jLabel1.setBounds(0, 0, 1260, 730);

        getContentPane().add(pnlDesktop);
        pnlDesktop.setBounds(210, 1, 1260, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents
 public void chayLui() {
        Thread t = new Thread() {

            public void run() {
                try {

                    rong = lblThanhDoc.getWidth();
                    Thread t = new Thread();

                    for (int i = 75; i < rong; rong--) {
                        try {

                            lblThanhDoc.setSize(rong, 734);

                            t.sleep(10);

                        } catch (Exception e) {
                        }

                    }
                    System.out.println(rong);
                } catch (Exception e) {
                    System.out.println("Li" + e);
                }
            }

        };
        t.start();
    }

    public void chayTien() {
        Thread y = new Thread() {

            public void run() {
                rong = lblThanhDoc.getWidth();
                Thread t = new Thread();

                for (int i = 194; i > rong; rong++) {
                    try {
                        lblThanhDoc.setSize(rong, 734);

                        t.sleep(10);

                    } catch (Exception e) {
                        System.out.println("Loi" + e);
                    }

                }
                System.out.println(rong);
            }

        };
        y.start();
    }

    private void lblDatBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDatBanMouseClicked

        int y = lblDatBan.getY();
        lblDi.setLocation(x, y);
        for (JInternalFrame x : pnlDesktop.getAllFrames()) {
            x.dispose();
        }

        MDI_QLDatBan f1 = new MDI_QLDatBan();
        System.out.println(f1.getWidth() + "-" + f1.getHeight());
        pnlDesktop.add(f1);
        f1.setVisible(true);
        f1.setLocation(pnlDesktop.getWidth() / 2 - f1.getWidth() / 2, (pnlDesktop.getHeight() - 10) / 2 - f1.getHeight() / 2 - 16);


    }//GEN-LAST:event_lblDatBanMouseClicked

    private void lblTrangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTrangChuMouseClicked
        for (JInternalFrame x : pnlDesktop.getAllFrames()) {
            x.dispose();
        }
        lblTrangChu.setVisible(true);
        int y = lblTrangChu.getY();
        lblDi.setLocation(x, y);
    }//GEN-LAST:event_lblTrangChuMouseClicked

    private void lblTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTaiKhoanMouseClicked
        for (JInternalFrame x : pnlDesktop.getAllFrames()) {
            x.dispose();
        }
        MDI_QLTK f1 = new MDI_QLTK();
        pnlDesktop.add(f1);
        f1.setVisible(true);
        f1.setLocation(pnlDesktop.getWidth() / 2 - f1.getWidth() / 2, (pnlDesktop.getHeight() - 10) / 2 - f1.getHeight() / 2 - 12);

        int y = lblTaiKhoan.getY();
        lblDi.setLocation(x, y);
    }//GEN-LAST:event_lblTaiKhoanMouseClicked

    private void lblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseClicked

        for (JInternalFrame x : pnlDesktop.getAllFrames()) {
            x.dispose();
        }
        MDI_QLNV f1 = new MDI_QLNV();
        pnlDesktop.add(f1);
        f1.setVisible(true);
        f1.setLocation(pnlDesktop.getWidth() / 2 - f1.getWidth() / 2, (pnlDesktop.getHeight() - 10) / 2 - f1.getHeight() / 2 - 16);

        int y = lblNhanVien.getY();
        lblDi.setLocation(x, y);
    }//GEN-LAST:event_lblNhanVienMouseClicked

    private void lblLichSuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLichSuMouseClicked

        int y = lblLichSu.getY();
        lblDi.setLocation(x, y);
    }//GEN-LAST:event_lblLichSuMouseClicked

    private void lblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhachHangMouseClicked
        for (JInternalFrame x : pnlDesktop.getAllFrames()) {
            x.dispose();
        }
        MDI_QLKH f1 = new MDI_QLKH();
        pnlDesktop.add(f1);
        f1.setVisible(true);
        f1.setLocation(pnlDesktop.getWidth() / 2 - f1.getWidth() / 2, (pnlDesktop.getHeight() - 10) / 2 - f1.getHeight() / 2 - 16);

        int y = lblKhachHang.getY();
        lblDi.setLocation(x, y);
    }//GEN-LAST:event_lblKhachHangMouseClicked

    private void lblBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBanMouseClicked
        for (JInternalFrame x : pnlDesktop.getAllFrames()) {
            x.dispose();
        }
        MDI_Ban f1 = new MDI_Ban();
        pnlDesktop.add(f1);
        f1.setVisible(true);
        f1.setLocation(pnlDesktop.getWidth() / 2 - f1.getWidth() / 2, (pnlDesktop.getHeight() - 10) / 2 - f1.getHeight() / 2 - 17);

        int y = lblBan.getY();
        lblDi.setLocation(x, y);
    }//GEN-LAST:event_lblBanMouseClicked

    private void lblBuffetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuffetMouseClicked
        for (JInternalFrame x : pnlDesktop.getAllFrames()) {
            x.dispose();
        }
        MDI_QLMA f1 = new MDI_QLMA();
        System.out.println(f1.getWidth() + "-" + f1.getHeight());
        pnlDesktop.add(f1);
        f1.setVisible(true);
        f1.setLocation(pnlDesktop.getWidth() / 2 - f1.getWidth() / 2, (pnlDesktop.getHeight() - 10) / 2 - f1.getHeight() / 2 - 16);
        int y = lblBuffet.getY();
        lblDi.setLocation(x, y);
    }//GEN-LAST:event_lblBuffetMouseClicked

    private void lblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhuyenMaiMouseClicked
        for (JInternalFrame x : pnlDesktop.getAllFrames()) {
            x.dispose();
        }
        MDI_KM f1 = new MDI_KM();
        pnlDesktop.add(f1);
        f1.setVisible(true);
        f1.setLocation(pnlDesktop.getWidth() / 2 - f1.getWidth() / 2, (pnlDesktop.getHeight() - 10) / 2 - f1.getHeight() / 2 - 16);
        int y = lblKhuyenMai.getY();
        lblDi.setLocation(x, y);
    }//GEN-LAST:event_lblKhuyenMaiMouseClicked

    private void lblThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongKeMouseClicked

        int y = lblThongKe.getY();
        lblDi.setLocation(x, y);
    }//GEN-LAST:event_lblThongKeMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManHinhChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManHinhChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManHinhChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManHinhChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManHinhChinh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JLabel lblBan;
    private javax.swing.JLabel lblBuffet;
    private javax.swing.JLabel lblDatBan;
    private javax.swing.JLabel lblDi;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblKhuyenMai;
    private javax.swing.JLabel lblLichSu;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblTaiKhoan;
    private javax.swing.JLabel lblThanhDoc;
    private javax.swing.JLabel lblThongKe;
    private javax.swing.JLabel lblTrangChu;
    private javax.swing.JDesktopPane pnlDesktop;
    private javax.swing.JPanel pnlDoc;
    // End of variables declaration//GEN-END:variables
}
