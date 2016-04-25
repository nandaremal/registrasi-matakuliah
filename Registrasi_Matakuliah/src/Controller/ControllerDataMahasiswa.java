/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.Mahasiswa;
import View.dataMahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nuzulul
 */
public class ControllerDataMahasiswa extends MouseAdapter implements ActionListener{
    private dataMahasiswa view;
    private Database connection;
    private int selected;
    private ControllerHUAdmin view2;
    
    public ControllerDataMahasiswa(){
        try{
        connection = new Database();
        connection.connect();
        view = new dataMahasiswa();
        view.viewAll(connection.loadMahasiswa());
        view.addListener(this);
        view.addAdapter(this);
        view.setVisible(true);
        view.setLocationRelativeTo(null);}
        catch(SQLException e){
            Logger.getLogger(ControllerDataMahasiswa.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public dataMahasiswa getView() {
        return view;
    }
    
    public void mouseClicked(MouseEvent me) {
        Object source = me.getSource();
        
        if (source.equals(view.getTblMahasiswa())) {
            try {
                int selected = view.getSelectedMahasiswa();
                Mahasiswa m = connection.loadMahasiswa().get(selected);
                view.view(m);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerDataMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if (source.equals(view.getBtnInsert())) {
            try {
                Mahasiswa m = new Mahasiswa(view.getNama(),view.getNim(),view.getAlamat(),view.getJenisk(),view.getJurusan());
                connection.saveMahasiswa(m);
                javax.swing.JOptionPane.showMessageDialog(null," Insert Berhasil!");
                view.reset();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerDataMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
        else if (source.equals(view.getBtnView())) {     
            int i = 0;
            ResultSet rs = null;
            try{
                rs = connection.getData("select * from tabel_mahasiswa");
                while(rs.next()){
                    view.getTblMahasiswa().setValueAt(rs.getString("nama"), i , 0);
                    view.getTblMahasiswa().setValueAt(rs.getString("NIM"), i , 1);
                    view.getTblMahasiswa().setValueAt(rs.getString("alamat"), i , 2);
                    view.getTblMahasiswa().setValueAt(rs.getString("jenisKelamin"), i , 3);
                    view.getTblMahasiswa().setValueAt(rs.getString("jurusan"), i , 4);
                    i++;
                }
                rs.close();
            } catch(Exception ex){
                Logger.getLogger(ControllerDataMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (source.equals(view.getBtnHome())) {
            view.dispose();
            view2 =  new ControllerHUAdmin();
            view2.getView().setVisible(true);
        }
    }
}
