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
public class Dosen extends Orang{
	private String Kode;
	private String Nip;
	
public Dosen(String nama, String alamat, String jenisk, String Nip, String Kode){
        super(nama,alamat,jenisk);
        this.Nip=Nip;
        this.Kode=Kode;
	
}

public void setNip(String Nip){
	this.Nip=Nip;
}

public String getNip(){
    return Nip;
} 

public void setKode(String Kode){
	this.Kode=Kode;
}

public String getKode(){
    return Kode;
} 



}
