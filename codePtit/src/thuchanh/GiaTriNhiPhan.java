/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuchanh;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class GiaTriNhiPhan {
    public static void chuyenDoi(String s) {
        String tmp = "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0' || s.charAt(i) == '1') 
                tmp += s.charAt(i);
        }
        String bina = tmp;
        while(tmp.length() % 2 != 0) {
            tmp = "0" + tmp;
        }
        long res = 0;
        for(int i = 0; i < tmp.length(); i++) {
            if(tmp.charAt(i) == '1') {
                res += Math.pow(2, tmp.length() - i - 1);
            }
        }
        System.out.println(bina + " " + res);
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> a = (ArrayList<String>) ois.readObject();
        for(String x : a) {
            chuyenDoi(x);
        }
    }
}
