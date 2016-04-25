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
    private ControllerDataDosen view2;
    private ControllerDataMahasiswa view3;
    private ControllerDataKelas view4;
    private ControllerLogin view5;
    
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
            view2 = new ControllerDataDosen();       
            view2.getView().setVisible(true);
        }
        else if (source.equals(view.getBtnDataMahasiswa())){
            view.dispose();
            view3 = new ControllerDataMahasiswa();
            view3.getView().setVisible(true);
        }
        else if (source.equals(view.getBtnDataKelas())){
            view.dispose();
            view4 = new ControllerDataKelas();
            view4.getView().setVisible(true);
        }
        else{
            view.dispose();
            view5= new ControllerLogin();
            view5.getView().setVisible(true);
        }
    }

    public HUAdmin getView() {
        return view;
    }
}

