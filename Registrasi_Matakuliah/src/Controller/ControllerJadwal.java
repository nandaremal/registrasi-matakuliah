/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.Mahasiswa;
import View.jadwal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Remal
 */
public class ControllerJadwal extends MouseAdapter implements ActionListener {
    private jadwal view;
    private Database connection;
    private int selected;
    private ControllerHUMahasiswa view2;
    private Mahasiswa m;
    
    public Mahasiswa getMahasiswa(Mahasiswa m){
        return m;
    }
    
    public ControllerJadwal(Mahasiswa m){
        try{
        this.m=m;
        connection = new Database();
        connection.connect();
        view = new jadwal();
        view.viewAll(connection.loadJadwal(m));
        view.addListener(this);
        view.addAdapter(this);
        view.setVisible(true);
        view.setLocationRelativeTo(null);}
        catch(SQLException e){
            Logger.getLogger(ControllerDataDosen.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public jadwal getView(){
        return view;
    }
    
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnHome())) {
            view.dispose();
            view2 =  new ControllerHUMahasiswa(m);
            view2.getView().setVisible(true);
        }
    }
}
