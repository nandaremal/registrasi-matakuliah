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
import Model.Kelas;
import Model.Mahasiswa;
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
    
    public ArrayList<Mahasiswa> loadMahasiswa() throws SQLException {
        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();
        Mahasiswa m = null;
        String query = "select * from tabel_mahasiswa";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            m = new Mahasiswa(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            listMahasiswa.add(m);
        }
        return listMahasiswa;
    }
    
    public ArrayList<Kelas> loadKelas() throws SQLException {
        ArrayList<Kelas> listKelas = new ArrayList<>();
        Kelas k= null;
        String query = "select * from tabel_kelas";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            k = new Kelas(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            listKelas.add(k);
        }
        return listKelas;
    }
    
    public void saveMahasiswa(Mahasiswa m) throws SQLException {
        String query = "insert into tabel_mahasiswa (nama, NIM, alamat, jenisKelamin, jurusan) values("
                + "'" + m.getNama()+ "',"
                + "'" + m.getNim()+ "',"
                + "'" + m.getAlamat()+ "',"
                + "'" + m.getJenisK()+ "',"
                + "'" + m.getJurusan()+ "' )";
        statement.execute(query);
    }
    
    public void saveKelas(Kelas k) throws SQLException {
        String query = "insert into tabel_kelas (namaMatkul, jumlahSks, kodeMatkul, namaDosen, kodeDosen) values("
                + "'" + k.getNamaMatkul()+ "',"
                + "'" + k.getJumlahSks()+ "',"
                + "'" + k.getKode()+ "',"
                + "'" + k.getNamaDosen()+ "',"
                + "'" + k.getKodeDosen()+ "' )";
        statement.execute(query);
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
        
        public void saveJadwal(Mahasiswa m,String a) throws SQLException{
            ArrayList<Kelas> listKelas = new ArrayList<>();
            ResultSet rs=null;
            String query1 ="select * from tabel_kelas where kodeMatkul='"+a+"'";
            rs =  statement.executeQuery(query1);
            while (rs.next()) {
            Kelas k = new Kelas(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            listKelas.add(k);
            }
            String query = "insert into tabel_registrasi(nmMatkul, jumlahSKS, kode, nmDosen, kdDosen,nimMahasiswa) values("
                + "'" + listKelas.get(0).getNamaMatkul() + "',"
                + "'" + listKelas.get(0).getJumlahSks()+ "',"
                + "'" + listKelas.get(0).getKode()+ "',"
                + "'" + listKelas.get(0).getNamaDosen()+ "',"
                + "'" + listKelas.get(0).getKodeDosen()+ "',"
                + "'" + m.getNim().intern()+ "')";
            statement.executeUpdate(query);
        
}
        public ArrayList<Kelas> loadJadwal(Mahasiswa m) throws SQLException {
        ArrayList<Kelas> listkelas = new ArrayList<>();
        Kelas k = null;
        String query = "select * from tabel_registrasi where nimMahasiswa='"+m.getNim()+"'";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            k = new Kelas(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            listkelas.add(k);
        }
        return listkelas;
    }
        
    public Mahasiswa getlog(String a) throws SQLException{
        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();
        ResultSet rs=null;
        String query1 ="select * from tabel_mahasiswa where NIM='"+a+"'";
        rs =  statement.executeQuery(query1);
        while (rs.next()) {
        Mahasiswa k = new Mahasiswa(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
        listMahasiswa.add(k);
        }
        
        if(listMahasiswa.get(0).getNim().intern()==a.intern()){
            Mahasiswa n= new Mahasiswa(listMahasiswa.get(0).getNama().intern(),listMahasiswa.get(0).getNim().intern(),listMahasiswa.get(0).getAlamat().intern(),listMahasiswa.get(0).getJenisK().intern(),listMahasiswa.get(0).getJurusan().intern());
            return n;
        }else{
            return null;
        }
    } 
    
    public boolean login(String a) throws SQLException{
        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();
        ResultSet rs=null;
        String query1 ="select * from tabel_mahasiswa where NIM='"+a+"'";
        rs =  statement.executeQuery(query1);
        while (rs.next()) {
        Mahasiswa k = new Mahasiswa(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
        listMahasiswa.add(k);
        }
        boolean b =false;
        String c= listMahasiswa.get(0).getNim();
        if(c.equals(a)){
         b=true;
        }return b;
    }    
}
