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
public class Mahasiswa {
    private String nama;
    private String nim;
    private String alamat;
    private String jenisK;
    private String jurusan;
    private Kelas kelas[] = new Kelas[7];
    private int jumlahKelas;

    public Mahasiswa(String nama, String nim, String alamat, String jenisK, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.alamat = alamat;
        this.jenisK = jenisK;
        this.jurusan = jurusan;
        jumlahKelas = 0;
    }

    public Mahasiswa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenisK() {
        return jenisK;
    }

    public void setJenisK(String jenisK) {
        this.jenisK = jenisK;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
    
    public void addKelas(Kelas k){
        if(jumlahKelas<7){
			this.kelas[jumlahKelas]=k;
			jumlahKelas++; 
		}
    }

    public Kelas getKelas(int i) {
        return kelas[i];
    }

    public int getJumlahKelas() {
        return jumlahKelas;
    }
    
    
}
