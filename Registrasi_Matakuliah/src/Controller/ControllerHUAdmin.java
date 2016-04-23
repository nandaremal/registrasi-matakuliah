/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import View.HUAdmin;
import View.dataDosen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author Nuzulul
 */
public class ControllerHUAdmin implements ActionListener {
    private HUAdmin view;
    private ControllerDosen view2;

    public ControllerHUAdmin() {
        view = new HUAdmin();
        view.addListener(this);
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if (source.equals(view.getBtnDataDosen())) {
            view.dispose();
            view2 = new ControllerDosen();       
            view2.getView().setVisible(true);
        }
    }

    public HUAdmin getView() {
        return view;
    }
}

