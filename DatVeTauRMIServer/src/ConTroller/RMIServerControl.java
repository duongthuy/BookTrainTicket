/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConTroller;

/**
 *
 * @author duong
 */
import MainPackage.Main;
import Model.ChuyenDi;
import Model.KhachHang;
import Model.VeTau;
import View.ServerView;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RMIServerControl extends UnicastRemoteObject implements RMIinterface {

    private int serverPort = 1990;
    private Registry registry;
    private Connection con;
    private String rmiService = "rmiLoginServer";
    private ServerView view;

    public RMIServerControl(ServerView view) throws RemoteException {
        this.view = view;
        getConnect();
        
// Đăng ký RMI server
        try {
            registry = LocateRegistry.createRegistry(serverPort);
            registry.rebind(rmiService, this);
            view.showMessage("running...........");
        } catch (RemoteException e) {
            view.showMessage("can not run...........");
            throw e;
        }
    }

    // Kết nối CSDL
    private void getConnect() {
        String server = "localhost";
        String port = "1433";
        String database = "DatVeTau";
        String username = "sa";
        String password = "123456";
        String url = "jdbc:sqlserver://" + server + ":" + port + ";databaseName=" + database;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, username, password);
            view.showMessage("Connect database success!");
        } catch (SQLException ex) {
            view.showMessage("Connect database fail!");
        } catch (ClassNotFoundException ex) {
            view.showMessage("Connect database fail!");
        }
    }
    //Lưu thông tin khách hàng và thông tin đặt vé tàu vào trong CSDL

    public boolean Dangky(VeTau vt) throws RemoteException {
        try {
            KhachHang kh = vt.getKh();
            ChuyenDi cd = vt.getCd();
            String sql = "Insert Into dbo.VeTau values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, kh.getUserName());
            ps.setString(2, kh.getFullName());
            ps.setString(3, kh.getAddress());
            ps.setString(4, kh.getEmail());
            ps.setString(5, kh.getSDT());
            ps.setString(6, cd.getDiemXP());
            ps.setString(7, cd.getDiemDen());
            ps.setString(8, cd.getNgayXP());
            ps.setString(9, cd.getGioXP());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RMIServerControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //Tìm kiếm thông tin chuyến đi

    public ChuyenDi[] timkiemChuyenDi(String NgayXP, String DiemXP, String DiemDen) throws RemoteException {
        System.out.println("sssssss");
        int i = 1;
        ArrayList<ChuyenDi> listRs = new ArrayList<ChuyenDi>();
        String sql = "SELECT * FROM ChuyenDi WHERE NgayXP='" + NgayXP 
                + "' AND DiemXP=N'" + DiemXP 
                + "' AND DiemDen=N'" + DiemDen 
                + "'";
        System.out.println(sql);
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("fsfsdf");
            while (rs.next()) {
                //đóng gói thực thể
                ChuyenDi cd = new ChuyenDi();
                cd.setNgayXP(rs.getString(1));
                cd.setDiemXP(rs.getString(2));
                cd.setDiemDen(rs.getString(3));
                cd.setGioXP(rs.getString(4));
                cd.setGiaVe(rs.getInt(5));
                
                listRs.add(cd);
            }
            System.out.println(listRs.size());
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        ChuyenDi[] array = new ChuyenDi[listRs.size()];
        return listRs.toArray(array);
    }
}
