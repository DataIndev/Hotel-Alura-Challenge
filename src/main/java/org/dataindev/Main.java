package org.dataindev;

import org.dataindev.services.ConnectionService;
import org.dataindev.views.Login;
import org.dataindev.views.MenuPrincipal;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ConnectionService().recoveryConnection();
                    MenuPrincipal frame = new MenuPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
