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
public class Dosen extends orang{
	private int i; 
	private String kode;
	private String Nip;
	private Kelas[] nKelas;
	private Matakuliah matakuliah;
	
public Dosen(String nama,String alamat, String jenisk){
		super(nama)=nama;
		super(alamat)=alamat;
		super(jenisk)=jenisk;
}
	
public Dosen(String Nip, String Nama){
	this.Nip=Nip;
	super(nama)=nama;
	nKelas=new Kelas[5];
	i=5;
	
}

public Dosen(String Nip, String Nama, int i){
	this.Nip=Nip;
	super(nama)=nama;
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
    return nama;
}
    
    
}
