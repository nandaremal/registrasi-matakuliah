/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.Kelas;
import Model.Mahasiswa;
import View.Registrasi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Remal
 */
public class ControllerKelas extends MouseAdapter implements ActionListener  {
    private Registrasi view;
    private Database connection;
    private ControllerHUMahasiswa view2;
    private int selected;
    private Mahasiswa m;
    
    public Mahasiswa getMahasiswa(Mahasiswa m){
        return m;
    }
    
    public ControllerKelas(Mahasiswa m){
       try{
        this.m=m;
        connection = new Database();
        connection.connect();
        view = new Registrasi();
        view.reset();
        view.viewAll(connection.loadKelas());
        view.addListener(this);
        view.addAdapter(this);
        view.setVisible(true);
        view.setLocationRelativeTo(null);}
        catch(SQLException e){
            Logger.getLogger(ControllerKelas.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public Registrasi getView() {
        return view;
    }
    
    public void mouseClicked(MouseEvent me) {
        Object source = me.getSource();
        
        if (source.equals(view.getTblKelas())) {
           
        }
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if (source.equals(view.getBtnInput())) {
            try {
                connection.saveJadwal(m,view.getKode());
                javax.swing.JOptionPane.showMessageDialog(null," Insert Berhasil!");
                view.reset();
  } 
                catch (SQLException ex) {
                Logger.getLogger(ControllerKelas.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
        else if (source.equals(view.getBtnHome())) {
            view.dispose();
            view2 =  new ControllerHUMahasiswa(m);
            view2.getView().setVisible(true);
        }
    }
}
