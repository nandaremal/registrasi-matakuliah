/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrasi_matakuliah;

/**
 *
 * @author Remal
 */
public abstract class Orang {
        private String nama;
	private String alamat;
	private String jenisk;
	
	public orang(String nama,String alamat, String jenisk){
		this.nama=nama;
		this.alamat=alamat;
		this.jenisk=jenisk;
	}
	
	public orang(String nama, String alamat){
		this.nama=nama;
		this.alamat=alamat;
	}
	
	public orang(String nama){
		this.nama=nama;
	}
}
