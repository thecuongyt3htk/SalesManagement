/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package user;

import java.sql.Date;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import model.NguoiDung;
import model.KhachHang;
import dao.KhachHangDAO;
import dao.DAOInterface;
import dao.NhanVienDAO;
import model.NhanVien;

/**
 *
 * @author ACER
 */
public class DangKyFrame extends javax.swing.JFrame {

    /**
     * Creates new form SignUp
     */
    NguoiDung nd = new NguoiDung() {
    };
    KhachHangDAO khDAO = new KhachHangDAO();
    NhanVienDAO nvDAO=new NhanVienDAO();
    public DangKyFrame() {
        initComponents();
        init();
    }

    int xx, yy;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void init() {

        jTextFieldID.setText(String.valueOf(nvDAO.khoiTaoID()));
    }

    private boolean kiemTraKhongRong() {

        if (jTextFieldHoVaTen.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Nhập họ tên !!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jTextFieldEmail.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Nhập Email !!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (String.valueOf(jPasswordFieldMK.getPassword()).isEmpty()) {

            JOptionPane.showMessageDialog(this, "Nhập mật khẩu ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jTextFieldSDT.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Nhập số điện thoại !!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jTextFieldDiaChi.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Nhập địa chỉ !!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (jDateChooserNgaySinh.getDate() == null) {

            JOptionPane.showMessageDialog(this, "Điền ngày sinh !!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
      
        return true;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldHoVaTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldDiaChi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldSDT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDateChooserNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPasswordFieldMK = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("ĐĂNG KÝ NHÂN VIÊN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 370, 40));

        jTextFieldID.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDActionPerformed(evt);
            }
        });
        jTextFieldID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldIDKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldID, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 90, 20));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("ID ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, -1, -1));
        jPanel1.add(jTextFieldHoVaTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, 220, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Họ và tên");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, -1, -1));
        jPanel1.add(jTextFieldDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 330, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Địa chỉ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, -1, -1));

        jTextFieldSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldSDTKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 330, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Số điện thoại");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, -1, -1));
        jPanel1.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 330, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Email");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Mật khẩu");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, -1, 20));

        jDateChooserNgaySinh.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jDateChooserNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 330, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Ngày sinh");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 51));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("Lưu");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 480, 160, 30));

        jLabel11.setFont(new java.awt.Font("Snap ITC", 1, 20)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("X");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, -1, -1));
        jPanel1.add(jPasswordFieldMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 330, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hidden (1).png"))); // NOI18N
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 280, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 51));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setText("Quay lại");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 480, 170, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/show (1).png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 280, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pink_gradient.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (kiemTraKhongRong()) {
            int id = Integer.parseInt(jTextFieldID.getText());
            String ten = jTextFieldHoVaTen.getText();
            String diaChi = jTextFieldDiaChi.getText();
            String sdt = jTextFieldSDT.getText();
            String email = jTextFieldEmail.getText();
            String matKhau = jPasswordFieldMK.getText();
            java.util.Date utilNgaySinh = jDateChooserNgaySinh.getDate();
            java.sql.Date ngaySinh = new java.sql.Date(utilNgaySinh.getTime());
            NhanVien nv = new NhanVien(id, ten, diaChi, sdt, email, matKhau, ngaySinh);
            if (!nvDAO.kiemTraEmailTonTai((NhanVien) nv)) {

                nvDAO.insert((NhanVien) nv);
                new DangNhapFrame().setVisible(true);
                this.dispose();
                JOptionPane.showMessageDialog(this, "Đăng ký thành công ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - yy);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xx = evt.getX();
        yy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        new DangNhapFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        jPasswordFieldMK.setEchoChar((char) 0);
        jLabel12.setVisible(false);
        jLabel13.setVisible(true);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        jPasswordFieldMK.setEchoChar('*');
        jLabel12.setVisible(true);
        jLabel13.setVisible(false);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jTextFieldIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIDKeyTyped

        evt.consume();

    }//GEN-LAST:event_jTextFieldIDKeyTyped

    private void jTextFieldSDTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSDTKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldSDTKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.DangKyFrameger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.LoDangKyFrameetLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.loggiDangKyFrameger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.DangKyFrameg.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//             //</editor-fold>
//   }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangKyFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooserNgaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldMK;
    private javax.swing.JTextField jTextFieldDiaChi;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldHoVaTen;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldSDT;
    // End of variables declaration//GEN-END:variables
}
