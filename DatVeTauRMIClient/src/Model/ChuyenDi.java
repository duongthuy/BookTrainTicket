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
public class ChuyenDi implements  Serializable {
    private String DiemXP;
    private String DiemDen;
    private String NgayXP;
    private String GioXP;
    private long GiaVe;
    public ChuyenDi(){

    }

    public ChuyenDi(String NgayXP, String DiemXP, String DiemDen,  String GioXP,int GiaVe) {
        this.DiemXP = DiemXP;
        this.DiemDen = DiemDen;
        this.NgayXP = NgayXP;
        this.GioXP = GioXP;
        this.GiaVe=GiaVe;
    }

    
    
   
    public String getDiemDen() {
        return DiemDen;
    }

    public void setDiemDen(String DiemDen) {
        this.DiemDen = DiemDen;
    }

    public String getDiemXP() {
        return DiemXP;
    }

    public void setDiemXP(String DiemXP) {
        this.DiemXP = DiemXP;
    }

    public String getNgayXP() {
        return NgayXP;
    }

    public void setNgayXP(String NgayXP) {
        this.NgayXP = NgayXP;
    }

    public String getGioXP() {
        return GioXP;
    }
    public void setGioXP(String GioXP) {
        this.GioXP = GioXP;
    }

    public long getGiaVe() {
        return GiaVe;
    }

    public void setGiaVe(long GiaVe) {
        this.GiaVe = GiaVe;
    }
    
    
  
    
    
  

}
