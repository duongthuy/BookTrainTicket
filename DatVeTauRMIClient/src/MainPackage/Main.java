/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import ConTroller.RMIClientControl;
import View.FormTimChuyenDi;

/**
 *
 * @author hong
 */
public class Main {
    public static void main(String args[]) {
        FormTimChuyenDi view = new FormTimChuyenDi();
        RMIClientControl control = new RMIClientControl(view);
        view.setVisible(true);
    }
}
