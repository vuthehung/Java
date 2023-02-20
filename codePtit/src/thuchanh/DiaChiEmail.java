/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuchanh;

import java.io.*;
import java.util.*;

/**
 *
 * @author Admin
 */
public class DiaChiEmail {
    public static void email(String[] s, int n) {
        String[] dcEmail = new String[n];
        for(int i = 0; i < n; i++) {
            s[i] = s[i].toLowerCase();
            s[i] = s[i].trim();
            String[] tmp = s[i].split(" ");
            int t = tmp.length;
            String temp = tmp[t - 1];
            for(int j = 0; j < t - 1; j++) {
                if(tmp[j].length() > 0)
                    temp = temp + tmp[j].charAt(0);
            }
            dcEmail[i] = temp;
            int d = 0;
            for(int j = 0; j < n; j++) {
                if(temp.equals(dcEmail[j])) 
                    d++;
            }
            System.out.print(dcEmail[i]);
            if(d > 1)
                System.out.print(d);
            System.out.print("@ptit.edu.vn");
            System.out.println();
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        int n = Integer.parseInt(sc.nextLine());
        String[] hoTen = new String[n];
        for(int i = 0; i < n; i++) {
            hoTen[i] = sc.nextLine();
        }
        email(hoTen, n);
    }
}
