/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrasi_matakuliah;

import java.util.*;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author Remal
 */
public class aplikasi {
    private ArrayList<Orang> orang=new ArrayList<Orang>();
    private Kelas Daftarkelas[]=new Kelas[50];
    private ArrayList<Matakuliah> Daftarmatakuliah=new ArrayList<Matakuliah>();
    private int jmlKelas=0;
    private Scanner id;
    private Scanner pass;
    private Scanner masuk=new Scanner(System.in);
    Matakuliah tempMk;
    Dosen tempDs;
    Kelas tempK;
    String tempnim;
    
     public aplikasi() {
        id = new Scanner(System.in);
        pass = new Scanner(System.in);
    }

    
    public void addDosen(Dosen d){
        this.orang.add(d);
    }
    public void addMahasiswa(Mahasiswa m){
        this.orang.add(m);
    }
    public Mahasiswa getMahasiswa(String nim){
        for(Orang i:orang){
            if(i instanceof Mahasiswa){
                Mahasiswa m=(Mahasiswa) orang.get(this.orang.indexOf(i));
                if(m.getNim()==nim){
                    return m;
                }
            }
        }
        return null;
    }
    public Dosen getDosen(String nip){
        for(Orang i:orang){
            if(i instanceof Dosen){
                Dosen d=(Dosen) orang.get(this.orang.indexOf(i));
                if(d.getNip()==nip){
                    return d;
                }
            }
        }
        return null;
    }
    public void deleteMahasiswa(String nim){
        for(Orang i:orang){
            if(i instanceof Mahasiswa){
                Mahasiswa m=(Mahasiswa) orang.get(this.orang.indexOf(i));
                if(m.getNim()==nim){
                    this.orang.remove(m);
                }
            }
        }
    }
    public void deleteDosen(String nip){
        for(Orang i:orang){
            if(i instanceof Dosen){
                Dosen d=(Dosen) orang.get(this.orang.indexOf(i));
                if(d.getNip()==nip){
                    this.orang.remove(d);
                }
            }
        }
    }
    public void addMatakuliah(Matakuliah m){
        this.Daftarmatakuliah.add(m);
    }
    public void removeMatakuliah(String namaMK){
        for(Matakuliah i:Daftarmatakuliah){
            if(i instanceof Matakuliah){
                Matakuliah m=(Matakuliah) Daftarmatakuliah.get(this.Daftarmatakuliah.indexOf(i));
                if(m.getNamaMK()==namaMK){
                    this.Daftarmatakuliah.remove(m);
                }
            }
        }
    }
    
    public void addkelas(Kelas a){
        if (jmlKelas<50){
        Daftarkelas[jmlKelas]=a;
        jmlKelas=jmlKelas+1;}
        else{
            System.out.println("Jumlah Kelas Sudah Maksimal");
        }
    }
    public void removeKelas(String id){
        if(Daftarkelas[jmlKelas].getId()==id){
        jmlKelas=jmlKelas-1;
        }else if (jmlKelas==0){
            System.out.println("Tidak Ada Kelas Yang Bisa Dihapus");
        }else{
            int o=0;
            for(o=0;o<=jmlKelas;o++){
                if(Daftarkelas[o].getId()==id){
                    int i=0;
                    for(i=o;i<jmlKelas;i++){
                        Daftarkelas[i]=Daftarkelas[i+1];
                    }jmlKelas=jmlKelas-1;
                }
            }
        }
    }

    public void mainmenu(){
     int pil = 0;
        do {
            try {

                System.out.println("Menu");
                System.out.println("1. Mahasiswa");
                System.out.println("2. Admin");
                System.out.println("0. exit");
                System.out.print("Input menu : ");
                pil= masuk.nextInt();
                switch (pil) {
                    case 1:
                              
                              System.out.println("Menu Login Mahasiswa");
                              System.out.print("Id = ");
                              String a= masuk.next();
                              System.out.print("Password = ");
                              String b= masuk.next();     
                              for(Orang i:orang){
                                    if(i instanceof Mahasiswa){
                                        Mahasiswa m=(Mahasiswa) orang.get(this.orang.indexOf(i));
                                        if(m.getNim()==a && m.getNim()==b){
                                            while (pil!=4){ 
                                            System.out.println("1.Profil Mahasiswa");
                                            System.out.println("2.Registrasi Matakuliah");
                                            System.out.println("3.Jadwal Perkuliahan");
                                            System.out.println("4.Log Out");
                                            System.out.print("Input menu : ");
                                            pil= masuk.nextInt();
                                            switch (pil) {
                                                case 1:
                                                    System.out.println(m.getNama());
                                                    System.out.println(m.getNim());
                                                    System.out.println(m.getJenisK());
                                                    System.out.println(m.getAlamat());
                                                    System.out.println(m.getJurusan());
                                                    break;
                                                case 2:
                                                    int total=0;
                                                    for(total=0;total<=jmlKelas;total++){
                                                    System.out.println(Daftarkelas[total].getMatakuliah().getNamaMK());
                                                    System.out.println(Daftarkelas[total].getMatakuliah().getJumlahSKS());
                                                    System.out.println(Daftarkelas[total].getDosen().getNama());
                                                    System.out.println(Daftarkelas[total].getDosen().getKode());
                                                    System.out.println();
                                                    }
                                                    System.out.print("masukkan id kelas =");
                                                    String apa= masuk.nextLine();
                                                    if(this.Daftarkelas[jmlKelas].getId()==apa){
                                                        this.tempK=this.Daftarkelas[jmlKelas];
                                                    }else if (jmlKelas==0){
                                                        System.out.println("Tidak Ada Kelas Yang Bisa daftar");
                                                    }else{
                                                    int o=0;
                                                        for(o=0;o<=jmlKelas;o++){
                                                            if(Daftarkelas[o].getId()==apa){
                                                                this.tempK=this.Daftarkelas[jmlKelas];
                                                            }
                                                        }
                                                    }
                                                    this.tempnim=m.getNim();
                                                    
                                                case 3:
                                                    int n=0;
                                                    for(n=0;n<=5;n++){
                                                        if(m.getKelas(n)!=null){
                                                            System.out.println("Pelajaran ke-"+n+1);
                                                            System.out.println(m.getKelas(n).getMatakuliah().getNamaMK());
                                                            System.out.println(m.getKelas(n).getMatakuliah().getJumlahSKS());
                                                            System.out.println(m.getKelas(n).getDosen().getNama());
                                                            System.out.println(m.getKelas(n).getDosen().getKode());
                                                            System.out.println();
                                                        }
                                                    }break;
                                                case 4:
                                                    System.out.println("berhasil log out");
                                                    break;
                                            }
                                        }
                                    }
                              }
                            }break;
    
                    case 2:
                              System.out.println("Menu Login Admin");
                              System.out.print("Id = ");
                              String p= masuk.next();
                              System.out.print("Password = ");
                              String n= masuk.next();
                              if (p ==p && n == n){
                                  while (pil!=5){ 
                                            System.out.println("1. Data Mahasiswa");
                                            System.out.println("2. Data Dosen");
                                            System.out.println("3. Data Kelas");
                                            System.out.println("4. ACC Registrasi");
                                            System.out.println("5. Log Out");
                                            System.out.print("Input menu : ");
                                            pil= masuk.nextInt();
                                            switch (pil) {
                                                case 1:
                                                     for(Orang i:orang){
                                                        if(i instanceof Mahasiswa){
                                                        Mahasiswa m=(Mahasiswa) orang.get(this.orang.indexOf(i));
                                                        System.out.println(m.getNama());
                                                        System.out.println(m.getNim());
                                                        System.out.println(m.getJenisK());
                                                        System.out.println(m.getAlamat());
                                                        System.out.println(m.getJurusan());
                                                        System.out.println();
                                                        }
                                                     }
                                                     System.out.println("1. Tambah Mahasiswa");
                                                     System.out.println("2. Hapus Mahasiswa");
                                                     System.out.print("Input menu : ");
                                                     pil= masuk.nextInt();
                                                     switch (pil){
                                                        case 1:
                                                            System.out.print("Nama : ");String nm= masuk.nextLine();String nma= masuk.nextLine();
                                                            System.out.print("NIM : "); String nim= masuk.nextLine();
                                                            System.out.print("Alamat : "); String al= masuk.nextLine();
                                                            System.out.print("Jenis Kelamin : "); String jk= masuk.nextLine();
                                                            System.out.print("Jumlah Kelas Yang Diambil : "); int max= masuk.nextInt();
                                                            System.out.print("Jurusan : "); String jr= masuk.nextLine();
                                                            Mahasiswa x = new Mahasiswa(nma, nim,al, jk, max, jr);
                                                            addMahasiswa(x);
                                                            break;
                                                            
                                                        case 2:
                                                            System.out.print("Masukkan NIM yang mau dihapus : "); String nimx= masuk.nextLine();
                                                            deleteMahasiswa(nimx);
                                                            break;      
                                                     }
                                                    break;
                                                case 2:
                                                    for(Orang i:orang){
                                                        if(i instanceof Dosen){
                                                        Dosen d=(Dosen) orang.get(this.orang.indexOf(i));
                                                        System.out.println(d.getNama());
                                                        System.out.println(d.getNip());
                                                        System.out.println(d.getJenisK());
                                                        System.out.println(d.getAlamat());
                                                        System.out.println(d.getKode());
                                                        System.out.println();
                                                        }
                                                     }
                                                     System.out.println("1. Tambah Dosen");
                                                     System.out.println("2. Hapus Dosen");
                                                     System.out.print("Input menu : ");
                                                     pil= masuk.nextInt();
                                                     switch (pil){
                                                        case 1:
                                                            System.out.print("Nama : "); String nm= masuk.nextLine();
                                                            System.out.print("NIP : "); String nip= masuk.nextLine();
                                                            System.out.print("Alamat : "); String al= masuk.nextLine();
                                                            System.out.print("Jenis Kelamin : "); String jk= masuk.nextLine();
                                                            System.out.print("Kode Dosen : "); String kd= masuk.nextLine();
                                                            Dosen x = new Dosen(nm, al, jk, nip, kd);
                                                            addDosen(x);
                                                            break;
                                                            
                                                        case 2:
                                                            System.out.print("Masukkan NIP yang mau dihapus : "); String nipx= masuk.nextLine();
                                                            deleteDosen(nipx);
                                                            break;      
                                                     }
                                                    break;
                                                case 3:
                                                        int total=0;
                                                        for(total=0;total<=jmlKelas;total++){
                                                        System.out.println(Daftarkelas[total].getMatakuliah().getNamaMK());
                                                        System.out.println(Daftarkelas[total].getMatakuliah().getJumlahSKS());
                                                        System.out.println(Daftarkelas[total].getDosen().getNama());
                                                        System.out.println(Daftarkelas[total].getDosen().getKode());
                                                        System.out.println();
                                                        }
                                                        System.out.println("1. Tambah Kelas");
                                                        System.out.println("2. Hapus Kelas");
                                                        System.out.print("Input menu : ");
                                                        pil= masuk.nextInt();
                                                        switch (pil){
                                                            case 1:
                                                                System.out.print("Nama Matakuliah : "); String nm= masuk.nextLine();
                                                                System.out.print("NIP Dosen : "); String nip= masuk.nextLine();
                                                                System.out.print("Id Kelas : "); String id= masuk.nextLine();
                                                                for(Matakuliah i:Daftarmatakuliah){
                                                                    if(i instanceof Matakuliah){
                                                                        Matakuliah m=(Matakuliah) Daftarmatakuliah.get(this.Daftarmatakuliah.indexOf(i));
                                                                        if(m.getNamaMK()==nm){
                                                                            this.tempMk=m;
                                                                        }
                                                                    }
                                                                }
                                                                for(Orang i:orang){
                                                                    if(i instanceof Dosen){
                                                                        Dosen d=(Dosen) orang.get(this.orang.indexOf(i));
                                                                        if(d.getNip()==nip){
                                                                            this.tempDs=d;
                                                                        }
                                                                    }
                                                                }
                                                                Kelas k=new Kelas(tempMk,tempDs,id);
                                                                addkelas(k);
                                                                break;
                                                            case 2:
                                                                System.out.print("Masukkan id Kelas yang mau dihapus : "); String idx= masuk.nextLine();
                                                                removeKelas(idx);
                                                                break;      
                                                        }
                                                    break;
                                                case 4:
                                                    for(Orang i:orang){
                                                        if(i instanceof Mahasiswa){
                                                            Mahasiswa m=(Mahasiswa) orang.get(this.orang.indexOf(i));
                                                            if(m.getNim()==this.tempnim){
                                                                m.addKelas(tempK);
                                                            }
                                                        }
                                                    }
                                                    break;
                                                case 5:
                                                    System.out.println("berhasil log out");
                                                    break;
                                            }
                                        }
                                    }
                              
                            
                              
                        break;
                    case 0:
                        System.out.println("Thank You");
                        break;
                    default:
                        throw new IllegalStateException("Wrong Menu Input");
                }
            } catch (Exception e) {
                System.out.println("error : " + e.getMessage());
            } finally {
                id = new Scanner(System.in);
                pass = new Scanner(System.in);
            }
        } while (pil != 0);
    }
}
