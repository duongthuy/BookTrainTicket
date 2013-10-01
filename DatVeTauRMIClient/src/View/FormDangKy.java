/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DangKy.java
 *
 * Created on Aug 29, 2011, 8:22:09 PM
 */
package View;

import Model.VeTau;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author hong
 */
public class FormDangKy extends javax.swing.JFrame {

    VeTau vt;

    public FormDangKy(VeTau vt) {
        
        initComponents();
        this.getContentPane().setBackground(new Color(204, 204, 255));
        this.pack();
        this.setLocationRelativeTo(null);
        this.vt = vt;
        txtdiemxp.setText(vt.getCd().getDiemXP());
        txtdiemden.setText(vt.getCd().getDiemDen());
        txtgiochay.setText(vt.getCd().getGioXP());
        txtngaydi.setText(vt.getCd().getNgayXP());
        txtgiave.setText(String.valueOf(vt.getCd().getGiaVe()) + " vnd");
    }

    public FormDangKy() {
        initComponents();
    }

    public String get_User() {
        return txtusername.getText();
    }

    public String get_Name() {
        return txtfullname.getText();
    }

    public String get_Address() {
        return txtaddress.getText();
    }

    public String get_Email() {
        return txtemail.getText();
    }

    public String get_Telephone() {
        return (txtSDT.getText());
    }

    public String get_NgayDi() {
        return txtngaydi.getText();
    }

    public String get_Diemxp() {
        return txtdiemxp.getText();
    }

    public String get_Diemden() {
        return txtdiemden.getText();
    }

    public String get_GioXP() {
        return txtgiochay.getText();
    }

    public void dangKyActionPerform(ActionListener evt) {
        btnsummit.addActionListener(evt);

    }
//Hàm kiểm tra các điều kiện khi khách hàng nhập thông tin vào

    public boolean checkForm() {
        //Kiểm tra tên đăng nhập
        String exp_username = "[a-z]+";
        String Name = txtusername.getText().trim();//Hàm trim () để cắt khoảng trống ở đẫu cuối của chuỗi
        Pattern pattern = Pattern.compile(exp_username, Pattern.CASE_INSENSITIVE);
        Matcher matcher_UserName = pattern.matcher(Name);

        if (matcher_UserName.matches() == false || txtusername.getText().equals("")) {
            JOptionPane.showConfirmDialog(this, "Vui long nhập lại tên đăng nhập!", "Lỗi", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
            txtusername.setText("");
            txtusername.requestFocus();
            return false;
        }
        //Kiểm tra tên đầy đủ
        if (txtfullname.getText().equals("")) {
            JOptionPane.showConfirmDialog(this, "Vui lòng nhập lại tên đầy đủ!", "Lỗi", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
            txtfullname.setText("");
            txtfullname.requestFocus();
            return false;
        }
        //Kiểm tra địa chỉ
        if (txtaddress.getText().equals("")) {
            JOptionPane.showConfirmDialog(this, "Vui lòng nhập lại địa chỉ!", "Lỗi", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
            txtaddress.setText("");
            txtaddress.requestFocus();
            return false;
        }
        //Kiểm tra email
        String exp_Email = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        String Email = txtemail.getText();
        Pattern parrern_Email = Pattern.compile(exp_Email, Pattern.CASE_INSENSITIVE);
        Matcher matchers_Email = parrern_Email.matcher(Email);
        if (matchers_Email.matches() == false || txtemail.getText().equals("")) {
            JOptionPane.showConfirmDialog(this, "Vui lòng nhập lại email!", "Lỗi", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
            txtemail.setText("");
            txtemail.requestFocus();
            return false;
        }
        //Kiểm tra SĐT
        if (txtSDT.getText().equals("")) {
            JOptionPane.showConfirmDialog(this, "Vui lòng nhập lại SĐT!", "Lỗi", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
            txtSDT.setText("");
            txtSDT.requestFocus();
            return false;
        }
        return true;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtfullname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtaddress = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtdiemxp = new javax.swing.JTextField();
        txtngaydi = new javax.swing.JTextField();
        txtgiochay = new javax.swing.JTextField();
        Cancel = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtdiemden = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtgiave = new javax.swing.JTextField();
        btnsummit = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        jLabel13.setText("jLabel13");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Tên đăng nhập");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Tên đầy đủ");

        txtfullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfullnameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("THÔNG TIN KHÁCH HÀNG");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Địa chỉ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Email");

        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(java.awt.Color.red);
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("THÔNG TIN CHUYẾN ĐI");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Điểm XP");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Ngày đi");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Giờ XP");

        txtdiemxp.setEditable(false);

        txtngaydi.setEditable(false);

        txtgiochay.setEditable(false);

        Cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Cancel.setText("Nhập Lại");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("SDT");

        txtdiemden.setEditable(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Giá vé");

        txtgiave.setEditable(false);
        txtgiave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgiaveActionPerformed(evt);
            }
        });

        btnsummit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnsummit.setText("Đặt vé");
        btnsummit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsummitActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Điểm đến");

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\hong\\Desktop\\images (1).jpg")); // NOI18N
        jLabel14.setText("jLabel14");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtaddress)
                                    .addComponent(txtemail)
                                    .addComponent(txtSDT)
                                    .addComponent(txtfullname, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtusername))
                                .addGap(39, 39, 39))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(23, 23, 23))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtdiemxp)
                                                .addComponent(txtngaydi)
                                                .addComponent(txtgiochay, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(Cancel)
                                                .addComponent(txtgiave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(46, 46, 46)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnsummit)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addGap(41, 41, 41)
                                                .addComponent(txtdiemden, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtfullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdiemxp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12)
                    .addComponent(txtdiemden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtngaydi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtgiave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtgiochay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cancel)
                    .addComponent(btnsummit))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtfullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfullnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfullnameActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed
    //Summit cac thong tin cua khach hang va cac thong tin dat ve tau
    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        // TODO add your handling code here:
        txtusername.setText("");
        txtfullname.setText("");
        txtaddress.setText("");
        txtemail.setText("");
        txtSDT.setText("");
    }//GEN-LAST:event_CancelActionPerformed

    private void btnsummitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsummitActionPerformed
        // TODO add your handling code here:
        //   btnsummit.addActionListener((ActionListener) evt);
    }//GEN-LAST:event_btnsummitActionPerformed

    private void txtgiaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgiaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgiaveActionPerformed
   
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    public javax.swing.JButton btnsummit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtdiemden;
    private javax.swing.JTextField txtdiemxp;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfullname;
    private javax.swing.JTextField txtgiave;
    private javax.swing.JTextField txtgiochay;
    private javax.swing.JTextField txtngaydi;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
