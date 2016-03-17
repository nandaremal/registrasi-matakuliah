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
public class Mahasiswa
{
	private int nKelas=0;
	private Kelas[] pilihan;
	private int maxKelas;
	private String nim;
	private String nama;
	
	public void setNama(String nama)
	{
		this.nama = nama;
	}
	
	public String getNama()
	{
		return nama;
	}
	
	public void setNim(String nim)
	{
		this.nim = nim;
	}
	
	public String getNim()
	{
		return nim;
	}
	
	public Mahasiswa(String nama, String nim)
	{
		this.nama = nama;
		this.nim = nim;
		pilihan = new Kelas[5]; //Default max Kelas = 5, jika tidak di set
		maxKelas = 5;
	}
	
	public Mahasiswa(String nama, String nim, int maxKelas)
	{
		this.nama = nama;
		this.nim = nim;
		this.maxKelas = maxKelas;
		pilihan = new Kelas[maxKelas];
	}
	
	void addKelas(kelas k)
	{
		if(nKelas<maxKelas){
			this.pilihan[nKelas]=pilihan;
			nKelas++; 
		}
	}
	
	public void removeKelas(Kelas id)
	{
		
	}
	
	public int getJumlahKelas()
	{
		return nKelas;
	}
}
