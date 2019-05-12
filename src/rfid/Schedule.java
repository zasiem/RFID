/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfid;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Bayu
 */
public class Schedule extends Course {

    String waktuAwal;
    String waktuAkhir;
    String matkul;

    //menampilkan jam kuliah pertama dari file
    public String getWaktuAwal(String room) {

        try {
            FileReader fr = new FileReader("schedules.txt");
            BufferedReader br = new BufferedReader(fr);
            String temp;
            while ((temp = br.readLine()) != null) {
                if (temp.substring(0, 1).equals(room)) {                 
                    setWaktuAwal(temp.substring(2, 10));
                }
            }
        } catch (IOException e) {
            System.out.println("Error di : " + e);
        }

        return waktuAwal;
    }

    //mengatur jam kuliah awal
    public void setWaktuAwal(String waktuAwal) {
        this.waktuAwal = waktuAwal;
    }

    //menampilkan jam kuliah akhir dari file
    public String getWaktuAkhir(String room) {
         try {
            FileReader fr = new FileReader("schedules.txt");
            BufferedReader br = new BufferedReader(fr);
            String temp;
            while ((temp = br.readLine()) != null) {
                if (temp.substring(0, 1).equals(room)) {                 
                    setWaktuAkhir(temp.substring(11, 19));
                }
            }
        } catch (IOException e) {
            System.out.println("Error di : " + e);
        }

        return waktuAkhir;
    }

    //memasukan jam kuliah akhir dari file
    public void setWaktuAkhir(String waktuAkhir) {
        this.waktuAkhir = waktuAkhir;
    }

}
