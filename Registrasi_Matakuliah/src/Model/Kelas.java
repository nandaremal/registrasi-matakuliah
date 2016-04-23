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

    public Kelas(String Kode, Matakuliah matakuliah, Dosen dosen) {
        this.Kode = Kode;
        this.matakuliah = matakuliah;
        this.dosen = dosen;
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
