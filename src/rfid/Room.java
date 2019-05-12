/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfid;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Bayu
 */
public class Room extends Schedule {

    String ruangan = "";
    String no;

    public String getRuangan() {
        return ruangan;
    }

    //mengatur ruangan
    public void setRuangan(String ruangan) {
        this.ruangan = "KU3-05-" + ruangan;
        this.no = ruangan;
    }

    //menampilkan nama dosen yang berada di ruangan bersangkutan
    public String getNama() {
        String nip = "";
        String strruang = String.valueOf(no);
        try {
            FileReader fr = new FileReader("schedules.txt");
            BufferedReader br = new BufferedReader(fr);
            String temp;
            while ((temp = br.readLine()) != null) {
                if (temp.substring(0, 1).equals(strruang)) {
                    nip = temp.substring(29, 39);
                }
            }
        } catch (IOException e) {
            System.out.println("Error di : " + e);
        }

        try {

            FileReader fr = new FileReader("dosen.txt");
            BufferedReader br = new BufferedReader(fr);
            String temp;
            while ((temp = br.readLine()) != null) {
                if (temp.substring(0, 10).equals(nip)) {
                    return temp.substring(36, temp.length());
                }
            }
        } catch (IOException e) {
            System.out.println("Error di : " + e);
        }

        return "";
    }

    //menampilkan matakuliah di jadwal sesuai dengan ruangan
    public String getMatkul() {
        String strruang = String.valueOf(no);
        try {
            FileReader fr = new FileReader("schedules.txt");
            BufferedReader br = new BufferedReader(fr);
            String temp;
            while ((temp = br.readLine()) != null) {
                if (temp.substring(0, 1).equals(strruang)) {
                    return temp.substring(40, temp.length());
                }
            }
        } catch (IOException e) {
            System.out.println("Error di : " + e);
        }

        return "";
    }

    //mengecek apakah waktunya tapping atau bukan
    public boolean cekWaktu(String time) {

        String awal = getWaktuAwal(no);
        String akhir = getWaktuAkhir(no);

        //parse jam
        int jamCurrent = Integer.parseInt(time.substring(0, 2));
        int jamAwal = Integer.parseInt(awal.substring(0, 2));
        int jamAkhir = Integer.parseInt(akhir.substring(0, 2));
        if ((jamCurrent >= jamAwal) && (jamCurrent <= jamAkhir)) {
            return true;
        }

        //parse menit
        int minCurrent = Integer.parseInt(time.substring(3, 5));
        int minAwal = Integer.parseInt(awal.substring(3, 5));
        int minAkhir = Integer.parseInt(akhir.substring(3, 5));
        if (minCurrent >= minAwal && minCurrent <= minAkhir) {
            return true;
        }

        //parse detik
        int secCurrent = Integer.parseInt(time.substring(6, 8));
        int secAwal = Integer.parseInt(awal.substring(6, 8));
        int secAkhir = Integer.parseInt(akhir.substring(6, 8));
        if (secCurrent >= secAwal && secCurrent <= secAkhir) {
            return true;
        }
        return false;
    }

    //mengecek apakah dosen sudah tapping atau belum
    public boolean cekDosenTap(String ruangan) {
        try {
            FileReader fr = new FileReader("loglecturer.txt");
            BufferedReader br = new BufferedReader(fr);
            String temp;
            while ((temp = br.readLine()) != null) {
                if (temp.substring(0, 1).equals(ruangan)) {
                    if (temp.substring(13, 14).equals("1")) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error di : " + e);
        }

        return false;
    }

}
