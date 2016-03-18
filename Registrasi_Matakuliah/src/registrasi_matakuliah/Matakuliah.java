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
public class Matakuliah {
        private String namaMK;
	private int jumlahSKS;
	
	public Matakuliah(String namaMK,int jumlahSKS){
		this.namaMK=namaMK;
		this.jumlahSKS=jumlahSKS;
	}
	
	public Matakuliah(String namaMK){
		this.namaMK=namaMK;
	}
	
	public void setNamaMK(String namaMK){
		this.namaMK=namaMK;
	}
	
	public void setJumlahSKS(int jumlahSKS){
		this.jumlahSKS=jumlahSKS;
	}

	
	public String getNamaMK(){
		return namaMK;
	}
	
	public int getJumlahSKS(){
		return jumlahSKS;
	}
}
