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
public class Course extends Lecturer {

    boolean cekCourse;
    public String dataLogDosen[] = new String[10];

    //mengecek apakah dosen sesuai dengan ruangan
    public boolean cekCourse(String nip, String ruangan) {
        try {
            FileReader fr = new FileReader("loglecturer.txt");
            BufferedReader br = new BufferedReader(fr);
            String temp;
            while ((temp = br.readLine()) != null) {
                if (temp.substring(0, 1).equals(ruangan) && temp.substring(2, 12).equals(nip)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error di : " + e);
        }
        return false;
    }

    //mengecek posisi ruangan dan dosen pada file
    public int lineCourse(String ruangan) {
        int line = 1;
        try {
            FileReader fr = new FileReader("loglecturer.txt");
            BufferedReader br = new BufferedReader(fr);
            String temp;
            int counter = 1;

            while ((temp = br.readLine()) != null) {
                if (temp.substring(0, 1).equals(ruangan)) {
                    line = counter;
                }
                dataLogDosen[counter] = temp;
                counter++;
            }
        } catch (IOException e) {
            System.out.println("Error di : " + e);
        }

        return line;
    }

}
