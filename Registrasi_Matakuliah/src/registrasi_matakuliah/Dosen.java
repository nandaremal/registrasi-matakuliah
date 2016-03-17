/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrasi_matakuliah;

/**
 *
 * @author Rizky_Afrizal_AW
 */
public class Dosen {
	private int i; 
	private String kode;
	private String Nip;
	private String Nama;
	private Kelas[] nKelas;
	
public Dosen(String Nip, String Nama){
	this.Nip=Nip;
	this.Nama=Nama;
	nKelas=new Kelas[5];
	i=5;
	
}

public Dosen(String Nip, String Nama, int i){
	this.Nip=Nip;
	this.Nama=Nama;
	this.i=i;
	nKelas=new Kelas[i];
}

public void seti(int i){
	this.i=i;
}

public void setNip(String Nip){
	this.Nip=Nip;
}

public String getNip(){
    return Nip;
}

public void setNama(String Nama){
    return Nama;
} 

public String getNama(){
    return Nama;
}
    
    
}
