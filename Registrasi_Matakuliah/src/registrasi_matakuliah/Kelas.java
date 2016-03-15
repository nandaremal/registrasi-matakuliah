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
public class Kelas {
    	private Matakuliah matakuliah;
	private Dosen dosen;
	
	public kelas(Matakuliah matakuliah){
		this.matakuliah=matakuliah;
	}
	
	public void setDosen(Dosen d){
		dosen=d;
	}

	public void setMatakuliah(Matakuliah m){
		matakuliah=m;
	}
	
}
