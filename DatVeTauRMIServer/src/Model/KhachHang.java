/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;


/**
 *
 * @author duong
 */
public class KhachHang implements Serializable {
   private String UserName;
   private String FullName;
   private  String Address;
   private String Email;
   private String  SDT;
    public KhachHang(){

    }
   public KhachHang (String FullName,String UserName,String Address,String Email,String SDT)
    {
            this.FullName=FullName;
            this.UserName=UserName;
        
            this.Address=Address;
            this.Email=Email;
    
            this.SDT=SDT;
   }
//ham khoi tao lay thong tin khach hang theo username
    public KhachHang(String userName, String FullName, String addRess, String eMail) {
       // throw new UnsupportedOperationException("Not yet implemented");
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }


    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

   
    public String getSDT() {
        return SDT;
    }

 
    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
   

   
}
