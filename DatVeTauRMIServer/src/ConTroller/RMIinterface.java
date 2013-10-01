/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ConTroller;

import Model.ChuyenDi;
import Model.VeTau;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author duong
 */
public interface  RMIinterface extends Remote{
   public ChuyenDi[] timkiemChuyenDi(String NgayXP, String DiemXP, String DiemDen)throws RemoteException;
   public boolean Dangky(VeTau vt)throws RemoteException;

}
