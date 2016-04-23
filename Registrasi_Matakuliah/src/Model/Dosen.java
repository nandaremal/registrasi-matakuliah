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
public class Dosen {
    private String nama;
    private String nip;
    private String kode;
    private String alamat;
    private String jenisk;

    public Dosen(String nama, String nip, String kode, String alamat, String jenisk) {
        this.nama = nama;
        this.nip = nip;
        this.kode = kode;
        this.alamat = alamat;
        this.jenisk = jenisk;
    }

    public Dosen() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenisk() {
        return jenisk;
    }

    public void setJenisk(String jenisk) {
        this.jenisk = jenisk;
    }

    @Override
    public String toString() {
        return "Dosen{" + "nama=" + nama + ", nip=" + nip + ", kode=" + kode + ", alamat=" + alamat + ", jenisk=" + jenisk + '}';
    }
}
