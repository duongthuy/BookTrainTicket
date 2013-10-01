/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConTroller;

import Model.ChuyenDi;
import Model.KhachHang;
import Model.VeTau;
import View.FormDangKy;
import View.FormTimChuyenDi;
import com.sun.xml.internal.ws.message.saaj.SAAJHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hong
 */
public class RMIClientControl {

    private String serverHost = "192.168.1.101";
    private int serverPort = 1990;
    private RMIinterface rmiServer;
    private Registry registry;
    private String rmiService = "rmiLoginServer";
    FormTimChuyenDi form;
    FormDangKy formDK;
    KhachHang kh;
    ChuyenDi[] cd;
    VeTau vetau;
    VeTau[] vt;

    public RMIClientControl(FormTimChuyenDi form) {
        this.form = form;
        form.timKiemActionPerform(new FormTimKiemListerner());
        form.clickTableActionPerform(new clickTableListener());
        form.dangkyActionPerform(new dangKyListener());

        try {
// Lấy thẻ đăng ký
            registry = LocateRegistry.getRegistry(serverHost,
                    serverPort);
// Tìm kiếm RMI server
            rmiServer = (RMIinterface) (registry.lookup(rmiService));
            System.out.println("Connect Server Success!");
        } catch (NotBoundException ex) {
            Logger.getLogger(RMIClientControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessException ex) {
            Logger.getLogger(RMIClientControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(RMIClientControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Bắt sự kiện trong lớp FormTimChuyenDi (View)
    class FormTimKiemListerner implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                System.out.println("sss");
                cd = rmiServer.timkiemChuyenDi(form.getNgayXP(), form.getDiemXP(), form.getDiemDen());
                form.hienthiketqua(cd);
                if (cd.length <= 0) {
                    form.DangKy.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Không tìm thấy chuyến đi !");
                }
            } catch (RemoteException ex) {
                ex.printStackTrace();

            } catch (IOException ex) {
                Logger.getLogger(RMIClientControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    // Bắt sự kiện cho nút đăng ký
    class dangKyListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.out.println("1!");
            formDK = new FormDangKy(vetau);
            System.out.println("2!");

            formDK.dangKyActionPerform(new FormDangKyListerner());
            System.out.println("3!");

            formDK.setVisible(true);
        }
    }
// Bắt sự kiện trong talbe

    class clickTableListener implements MouseListener {

        public void mouseClicked(MouseEvent e) {
            ChuyenDi cd = new ChuyenDi();
            vetau = new VeTau();
            int index = form.getSelectIndex();
            Vector data = form.getData();
            Vector row = (Vector) data.get(index);
            cd.setNgayXP((String) row.get(0));
            cd.setDiemXP((String) row.get(1));
            cd.setDiemDen((String) row.get(2));
            cd.setGioXP((String) row.get(3));
            System.out.println("test" + (Long) row.get(4));
            cd.setGiaVe((Long) row.get(4));
            System.out.println("test" + cd.getGiaVe());
            vetau.setCd(cd);
            form.DangKy.setEnabled(true);
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }
    }
//Bắt sự kiênk trong lớp FormDangKy(View)

    class FormDangKyListerner implements ActionListener {

        KhachHang kh = new KhachHang();
        ChuyenDi cd = new ChuyenDi();

        public void actionPerformed(ActionEvent e) {
            if (formDK.checkForm()) {
                //HIển thị thông tin lên form đăng ký của khách hàng
                String userInput = formDK.get_User();
                String nameInput = formDK.get_Name();
                String addInput = formDK.get_Address();
                String emailInput = formDK.get_Email();
                String sdt = formDK.get_Telephone();
                String diemxpInput = formDK.get_Diemxp();
                String diemdenInput = formDK.get_Diemden();
                String NgayxpInput = formDK.get_NgayDi();
                String gioxpInput = formDK.get_GioXP();

                kh.setUserName(userInput);
                kh.setFullName(nameInput);
                kh.setAddress(addInput);
                kh.setEmail(emailInput);
                kh.setSDT(sdt);
                cd.setDiemXP(diemxpInput);
                cd.setDiemDen(diemdenInput);
                cd.setNgayXP(NgayxpInput);
                cd.setGioXP(gioxpInput);
                VeTau vt = new VeTau(cd, kh);
                try {
                    //Gọi đến Server để lưu toàn bộ thông tin của khách hàng vao cơ sở dữ liệu
                    if (rmiServer.Dangky(vt)) {
                        JOptionPane.showMessageDialog(null, "Đặt vé thành công!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Đặt vé thất bại!");
                    }

                } catch (RemoteException ex) {
                    Logger.getLogger(RMIClientControl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
