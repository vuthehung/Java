/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import java.io.*;
import java.util.*;

/**
 *
 * @author Admin
 */
class SinhVien implements Comparable<SinhVien>{
    private String ma, hoTen, soDT, mail;
    private String ho, dem, ten;
    
    public SinhVien(String ma, String hoTen, String soDT, String mail) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.soDT = soDT;
        this.mail = mail;
        String[] s = this.hoTen.split(" ");
        this.ho = s[0];
        String tmp = "";
        for(int i = 1; i < s.length - 1; i++) {
            tmp += s[i] + " ";
        }
        this.dem = tmp.trim();
        this.ten = s[s.length - 1];
    }
    
    @Override
    public String toString() {
        return ma + " " + hoTen + " " + soDT + " " + mail;
    }

    @Override
    public int compareTo(SinhVien o) {
        if(!this.ten.equals(o.ten))
            return this.ten.compareTo(o.ten);
        else if(!this.ho.equals(o.ho))
            return this.ho.compareTo(o.ho);
        else if(!this.dem.equals(o.dem))
            return this.dem.compareTo(o.dem);
        else
            return this.ma.compareTo(o.ma);
    }
}
public class J07081 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        ArrayList<SinhVien> a = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        while(n-- > 0) {
            SinhVien sv = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            a.add(sv);
        }
        Collections.sort(a);
        for(SinhVien x : a) {
            System.out.println(x);
        }
    }
}
