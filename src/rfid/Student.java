/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfid;

/**
 *
 * @author Bayu
 */
public class Student {

    String nama;
    String nim = "";
    String jurusan;
    String thnmasuk;
    String kelas;

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getThnmasuk() {
        return thnmasuk;
    }

    public void setThnmasuk(String thnmasuk) {
        this.thnmasuk = thnmasuk;
    }

}
