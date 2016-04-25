/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Mahasiswa;
import View.HUMahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author Remal
 */
public class ControllerHUMahasiswa implements ActionListener {
    private HUMahasiswa view;
    private ControllerKelas view2;
    private ControllerLogin view3;
    private ControllerJadwal view4;
    private Mahasiswa m;
    
    public Mahasiswa getMahasiswa(Mahasiswa m){
        return m;
    }

    public ControllerHUMahasiswa(Mahasiswa m) {
        this.m=m;
        view = new HUMahasiswa();
        view.addListener(this);
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if (source.equals(view.getBtnRegistrasi())) {
            javax.swing.JOptionPane.showMessageDialog(null,"Registrasi "+m.getNim());
            view.dispose();
            view2 = new ControllerKelas(m);    
            view2.getView().setVisible(true);
        }
        else if(source.equals(view.getBtnLogout())) {
            view.dispose();
            view3 = new ControllerLogin();
            view3.getView().setVisible(true);
        } 
        else if(source.equals(view.getBtnJadwal())) {
            view.dispose();
            view4 = new ControllerJadwal(m);   
            view4.getView().setVisible(true);
        } 
        
    }

    public HUMahasiswa getView() {
        return view;
    }
}