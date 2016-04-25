/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.Mahasiswa;
import View.Login;
import View.dataMahasiswa;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
/**
 *
 * @author Remal
 */
public class ControllerLogin implements ActionListener{
    private Login view;
    private Database connection;
    private ControllerHUMahasiswa view2;
    private ControllerHUAdmin view3;
    private int selected;
    public Mahasiswa m;
    
    public ControllerLogin(){
        try{
        connection = new Database();
        connection.connect();
        view = new Login();
        view.addListener(this);
        view.setVisible(true);
        view.setLocationRelativeTo(null);}
        catch(SQLException e){
            Logger.getLogger(ControllerKelas.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
//    public boolean Log(ArrayList<Mahasiswa> listMahasiswa,String a) {
////        String[][] data = new String[listMahasiswa.size()][5];
////        for (int i = 0; i < listMahasiswa.size(); i++) {
////            if (listMahasiswa.get(i).getNim()=="1"){
////            data[0][0] = listMahasiswa.get(i).getNama();
////            data[0][1] = listMahasiswa.get(i).getNim();
////            data[0][2] = listMahasiswa.get(i).getAlamat();
////            data[0][3] = listMahasiswa.get(i).getJenisK();
////            data[0][4] = listMahasiswa.get(i).getJurusan();
////            
////            }
////        }if (listMahasiswa.get(b).getNim()=="1"){
////            return true;
////        }else
////            {
////            return false;
////        }
//        
//        }
    
    public Login getView(){
        return view;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Object source = ae.getSource();
        
        if (source.equals(view.getBtnLogin())) {
            
            if(view.getCbJabatan()=="Admin"){
                if((view.getUsername().intern()=="Admin") && (view.getPassword().intern()=="Admin")){
            view.dispose();
            view3 = new ControllerHUAdmin();       
            view3.getView().setVisible(true);}
                else if((view.getUsername().intern()!="Admin") || (view.getPassword().intern()!="Admin")){
                    javax.swing.JOptionPane.showMessageDialog(null,"Username atau Password Salah!");
                    view.reset();
                }}
            
            else if(view.getCbJabatan()=="Mahasiswa"){
                
//                ResultSet rs = null;
//                    try{
//                rs = connection.getData("select NIM from tabel_mahasiswa where NIM='"+view.getUsername()+"'");
                
                    if((view.getPassword().intern()==view.getUsername().intern())) {
                        
                        try {
                            
                            ResultSet rs = null;
                        if  (connection.login(view.getUsername())){
                            m=connection.getlog(view.getUsername());
                        javax.swing.JOptionPane.showMessageDialog(null,"Selamat Datang "+m.getNim());
                        view.dispose();
                        
                        view2 = new ControllerHUMahasiswa(m);   
                        view2.getView().setVisible(true);}
                        
                        else {
                        javax.swing.JOptionPane.showMessageDialog(null,"Login gagal ");
                        }
                        } catch (SQLException ex) {
                            Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
                        }    
                   
                }else{
                        javax.swing.JOptionPane.showMessageDialog(null,"Login gagal ");
                        }
                }
                
                
            }
            
        
    }
    
}
