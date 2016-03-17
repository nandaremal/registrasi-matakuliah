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
    private String Nip;
	private String Nama;
}

Dosen(String Nip, String Nama){
	this.Nip=Nip;
	this.Nama=Nama;
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
