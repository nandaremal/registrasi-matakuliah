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
        private String id;
    	private Matakuliah matakuliah;
	private Dosen dosen;
 
	
	public Kelas(Matakuliah matakuliah,Dosen dosen, String id){
		this.matakuliah=matakuliah;
                this.dosen=dosen;
                this.id=id;
	}
	
	public void setDosen(Dosen dosen){
		this.dosen=dosen;
	}

	public void setMatakuliah(Matakuliah matakuliah){
		this.matakuliah=matakuliah;
	}
	public Dosen getDosen(){
		return dosen;
	}
        
        public Matakuliah getMatakuliah(){
		return matakuliah;
	}
        public String getId(){
                return id;
        }
}
