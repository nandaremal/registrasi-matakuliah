/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrasi_matakuliah;

/**
 *
 * @author Nuzulul
 */
public class Mahasiswa extends Orang
{
	private int nKelas=0;
	private Kelas[] pilihan;
	private int maxKelas;
	private String nim;
        private String password;
        private String Jurusan;
	
	public void setNim(String nim)
	{
		this.nim = nim;
	}
	
	public String getNim()
	{
		return nim;
	}
	public Mahasiswa(String nama,String nim,String alamat, String jenisk, String Jurusan)
	{
		super(nama,alamat,jenisk);
		this.nim = nim;
                password=nim;
		pilihan = new Kelas[5]; //Default max Kelas = 5, jika tidak di set
		maxKelas = 5;
                this.Jurusan=Jurusan;
	}
	
	public Mahasiswa(String nama, String nim, String jenisk, String alamat, int maxKelas,String Jurusan)
	{
		super(nama,alamat, jenisk);
		this.nim = nim;
		this.maxKelas = maxKelas;
		pilihan = new Kelas[maxKelas];
                this.Jurusan=Jurusan;
	}
	
	public void addKelas(Kelas k)
	{
		if(nKelas<maxKelas){
			this.pilihan[nKelas]=k;
			nKelas++; 
		}
	}
	
        
        public void removeKelas(Kelas id){
		int b;
		for(b=0;b<nKelas;b++){
			if(pilihan[b]==id){
				pilihan[b]=null;
                                break;
			}
		}
                if(pilihan[b]==null){
                    if(b>=1 && b<nKelas){
                        for(b=b;b<nKelas;b++){
                            pilihan[b]=pilihan[b+1];
                        }nKelas=nKelas-1;
                    }
                    else if(b==nKelas){
                        nKelas=nKelas-1;
                    }
                }
        }
	
	public Kelas getKelas(int i)
	{
             return pilihan[i];   
	}
	public int getJumlahKelas()
	{
		return nKelas;
	}
        public String getJurusan()
	{
		return Jurusan;
	}
}
