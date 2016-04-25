/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Nuzulul
 */
public class Kelas {
    private String Kode;
    private Matakuliah matakuliah;
    private Dosen dosen;
    private String namaMatkul;
    private String jumlahSks;
    private String namaDosen;
    private String kodeDosen;

    public Kelas(String namaMatkul, String jumlahSks, String Kode, String namaDosen, String kodeDosen){
        this.namaMatkul = namaMatkul;
        this.jumlahSks = jumlahSks;
        this.Kode = Kode;
        this.namaDosen = namaDosen;
        this.kodeDosen = kodeDosen;
    }

    public Kelas(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    public Kelas(String Kode, Matakuliah matakuliah, Dosen dosen) {
//        this.Kode = Kode;
//        this.matakuliah = matakuliah;
//        this.dosen = dosen;
//    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }

    public String getJumlahSks() {
        return jumlahSks;
    }

    public void setJumlahSks(String jumlahSks) {
        this.jumlahSks = jumlahSks;
    }

    public String getNamaDosen() {
        return namaDosen;
    }

    public void setNamaDosen(String namaDosen) {
        this.namaDosen = namaDosen;
    }

    public String getKodeDosen() {
        return kodeDosen;
    }

    public void setKodeDosen(String kodeDosen) {
        this.kodeDosen = kodeDosen;
    }

    public String getKode() {
        return Kode;
    }

    public void setKode(String Kode) {
        this.Kode = Kode;
    }

    public Matakuliah getMatakuliah() {
        return matakuliah;
    }

    public void setMatakuliah(Matakuliah matakuliah) {
        this.matakuliah = matakuliah;
    }

    public Dosen getDosen() {
        return dosen;
    }

    public void setDosen(Dosen dosen) {
        this.dosen = dosen;
    }  
}
