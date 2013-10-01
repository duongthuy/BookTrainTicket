/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import ConTroller.RMIServerControl;
import View.ServerView;

/**
 *
 * @author duong
 */
public class Main {

    public static void main(String[] args) {
        ServerView view = new ServerView();
        try {
            RMIServerControl control = new RMIServerControl(view);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
