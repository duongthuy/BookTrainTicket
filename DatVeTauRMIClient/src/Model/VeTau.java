/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;

/**
 *
 * @author hong
 */
public class VeTau implements Serializable {
    private ChuyenDi cd;
    private KhachHang kh;
   
   
    private int GiaVe;

    public VeTau() {

    }
     public VeTau(ChuyenDi cd, KhachHang kh) {
        this.cd = cd;
        this.kh = kh;
    }
    public VeTau(int giaVe) {
        this.GiaVe = giaVe;
    }
    public ChuyenDi getCd() {
        return cd;
    }

    public void setCd(ChuyenDi cd) {
        this.cd = cd;
    }

    public KhachHang getKh() {
        return kh;
    }

    
    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    
    public int getGiaVe() {
        return GiaVe;
    }

    public void setGiaVe(int GiaVe) {
        this.GiaVe = GiaVe;
    }
    
}
