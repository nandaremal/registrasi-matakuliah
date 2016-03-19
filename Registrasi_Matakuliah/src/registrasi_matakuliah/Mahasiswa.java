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
	
	public void setNim(String nim)
	{
		this.nim = nim;
	}
	
	public String getNim()
	{
		return nim;
	}
	
	public Mahasiswa(String nama, String nim, String jenisk, String alamat)
	{
		super(nama);
		this.nim = nim;
		super(jenisk);
		super(alamat);
		pilihan = new Kelas[5]; //Default max Kelas = 5, jika tidak di set
		maxKelas = 5;
	}
	
	public Mahasiswa(String nama, String nim, String jenisk, String alamat, int maxKelas)
	{
		super(nama);
		this.nim = nim;
		super(jenisk);
		super(alamat);
		this.maxKelas = maxKelas;
		pilihan = new Kelas[maxKelas];
	}
	
	public void addKelas(Kelas k)
	{
		if(nKelas<maxKelas){
			this.pilihan[nKelas]=k;
			nKelas++; 
		}
	}
	
	public void removeKelas(String namaMatkul) 
	{
		while (nKelas = 0; nKelas <= maxKelas; nKelas++)
		{
			if(namaMatkul == pilihan[nKelas].getMatakuliah())
			{	
				this.pilihan[nKelas].setMatakuliah(setNamaMK("")));
				this.pilihan[nKelas].setMatakuliah(setJumlahSKS(0));
			}
		}
	}
	
	public int getJumlahKelas()
	{
		return nKelas;
	}
}
