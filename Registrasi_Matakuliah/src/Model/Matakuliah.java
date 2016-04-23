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
public class Matakuliah {
    private String Matakuliah;
    private String JumlahSks;

    public Matakuliah(String Matakuliah, String JumlahSks) {
        this.Matakuliah = Matakuliah;
        this.JumlahSks = JumlahSks;
    }

    public String getMatakuliah() {
        return Matakuliah;
    }

    public void setMatakuliah(String Matakuliah) {
        this.Matakuliah = Matakuliah;
    }

    public String getJumlahSks() {
        return JumlahSks;
    }

    public void setJumlahSks(String JumlahSks) {
        this.JumlahSks = JumlahSks;
    }
    
    
}
