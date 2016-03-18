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
        String nama;
	String alamat;
	String jenisk;
	
	public Orang(String nama,String alamat, String jenisk){
		this.nama=nama;
		this.alamat=alamat;
		this.jenisk=jenisk;
	}
	
	public Orang(String nama, String alamat){
		this.nama=nama;
		this.alamat=alamat;
	}
	
	public Orang(String nama){
		this.nama=nama;
	}
        
        public void setNama(String nama){
            this.nama=nama;
        }
        
        public String getNama(){
            return nama;
        }
}
