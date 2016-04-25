/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.Dosen;
import View.dataDosen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nuzulul
 */
public class ControllerDataDosen extends MouseAdapter implements ActionListener {
    private dataDosen view;
    private Database connection;
    private int selected;
    private ControllerHUAdmin view2;
    
    public ControllerDataDosen(){
        try{
        connection = new Database();
        connection.connect();
        view = new dataDosen();
        view.reset();
        view.viewAll(connection.loadDosen());
        view.addListener(this);
        view.addAdapter(this);
        view.setVisible(true);
        view.setLocationRelativeTo(null);}
        catch(SQLException e){
            Logger.getLogger(ControllerDataDosen.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public dataDosen getView() {
        return view;
    }
    
    public void mouseClicked(MouseEvent me) {
        Object source = me.getSource();
        
        if (source.equals(view.getTblDosen())) {
            try {
                int selected = view.getSelectedDosen();
                Dosen d = connection.loadDosen().get(selected);
                view.view(d);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerDataDosen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if (source.equals(view.getBtnInsert())) {
            try {
                Dosen d = new Dosen(view.getNama(),view.getNip(),view.getKode(),view.getAlamat(),view.getJenisk());
                connection.saveDosen(d);
                javax.swing.JOptionPane.showMessageDialog(null," Insert Berhasil!");
                view.reset();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerDataDosen.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
        else if (source.equals(view.getBtnView())) {     
            int i = 0;
            ResultSet rs = null;
            try{
                rs = connection.getData("select * from tabel_dosen");
                while(rs.next()){
                    view.getTblDosen().setValueAt(rs.getString("nama"), i , 0);
                    view.getTblDosen().setValueAt(rs.getString("NIP"), i , 1);
                    view.getTblDosen().setValueAt(rs.getString("kodeDosen"), i , 2);
                    view.getTblDosen().setValueAt(rs.getString("alamat"), i , 3);
                    view.getTblDosen().setValueAt(rs.getString("jenisKelamin"), i , 4);
                    i++;
                }
                rs.close();
            } catch(Exception ex){
                Logger.getLogger(ControllerDataDosen.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        else if (source.equals(view.getBtnHome())) {
            view.dispose();
            view2 =  new ControllerHUAdmin();
            view2.getView().setVisible(true);
        }
    }
}
