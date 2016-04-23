/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import Model.Dosen;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Nuzulul
 */
public class Database {
     private String dbuser = "root";
    private String dbpassword = "";
    private Statement statement;
    private Connection connection;
    private ResultSet rs;
    
    public void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost/db_registrasimatkul",dbuser,dbpassword);
        statement = connection.createStatement();
    }
    
    public void saveDosen(Dosen d) throws SQLException {
        String query = "insert into tabel_dosen (nama, NIP, kodeDosen, alamat, jenisKelamin) values("
                + "'" + d.getNama()+ "',"
                + "'" + d.getNip()+ "',"
                + "'" + d.getKode()+ "',"
                + "'" + d.getAlamat()+ "',"
                + "'" + d.getJenisk() + "' )";
        statement.execute(query);
    }
    
    public ArrayList<Dosen> loadDosen() throws SQLException {
        ArrayList<Dosen> listDosen = new ArrayList<>();
        Dosen d = null;
        String query = "select * from tabel_dosen ";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            d = new Dosen(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            listDosen.add(d);
        }
        return listDosen;
    }
    
    public void updateDosen(Dosen d) throws SQLException {
        String query = "update tabel_dosen set nama = '" + d.getNama() + "',"
                + "NIP = '" + d.getNip() + "',"
                + "kodeDosen = '" + d.getKode() + "',"
                + "alamat = '" + d.getAlamat() + "',"
                + "jenisKelamin = '" + d.getJenisk() + "' "
                + "where NIP = " + d.getNip();
        statement.executeUpdate(query);
    }
    
        public ResultSet getData(String SQLString){
        try {
            rs = statement.executeQuery(SQLString);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error : "+e.getMessage(),"Communication Error",JOptionPane.WARNING_MESSAGE);
        }
        return rs;
    }
}
