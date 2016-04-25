/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.Kelas;
import View.dataKelas;
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
public class ControllerDataKelas extends MouseAdapter implements ActionListener {
    private dataKelas view;
    private Database connection;
    private int selected;
    private ControllerHUAdmin view2;
    
    public ControllerDataKelas(){
        try{
        connection = new Database();
        connection.connect();
        view = new dataKelas();
        view.reset();
        view.viewAll(connection.loadKelas());
        view.addListener(this);
        view.addAdapter(this);
        view.setVisible(true);
        view.setLocationRelativeTo(null);}
        catch(SQLException e){
            Logger.getLogger(ControllerDataDosen.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public dataKelas getView() {
        return view;
    }
    
    public void mouseClicked(MouseEvent me) {
        Object source = me.getSource();
        
        if (source.equals(view.getTblKelas())) {
            try {
                int selected = view.getSelectedKelas();
                Kelas k = connection.loadKelas().get(selected);
                view.view(k);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerDataKelas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if (source.equals(view.getBtnInsert())) {
            try {
                Kelas k = new Kelas(view.getNama(),view.getJumlahSks(),view.getKodeMatkul(),view.getNamaDosen(),view.getKodeDosen());
                connection.saveKelas(k);
                javax.swing.JOptionPane.showMessageDialog(null," Insert Berhasil!");
                view.reset();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerDataKelas.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
        else if (source.equals(view.getBtnView())) {     
            int i = 0;
            ResultSet rs = null;
                try{
                rs = connection.getData("select * from tabel_kelas");
                while(rs.next()){
                    view.getTblKelas().setValueAt(rs.getString("namaMatkul"), i , 0);
                    view.getTblKelas().setValueAt(rs.getString("jumlahSks"), i , 1);
                    view.getTblKelas().setValueAt(rs.getString("kodeMatkul"), i , 2);
                    view.getTblKelas().setValueAt(rs.getString("namaDosen"), i , 3);
                    view.getTblKelas().setValueAt(rs.getString("kodeDosen"), i , 4);
                    i++;
                }
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerDataKelas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (source.equals(view.getBtnHome())) {
            view.dispose();
            view2 =  new ControllerHUAdmin();
            view2.getView().setVisible(true);
        }
    }
}
