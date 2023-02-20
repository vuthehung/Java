/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

/**
 *
 * @author Admin
 */
import java.util.*;
import java.io.*;

class GiangDay implements Comparable<GiangDay> {

    private String MaMon, TenMon, LyThuyet, ThucHanh, SoTin;

    GiangDay(String MaMon, String TenMon, String SoTin, String LyThuyet, String ThucHanh) {
        this.MaMon = MaMon;
        this.TenMon = TenMon;
        this.SoTin = SoTin;
        this.LyThuyet = LyThuyet;
        this.ThucHanh = ThucHanh;
    }

    public String getMaMon() {
        return this.MaMon;
    }

    public boolean isThucHanhOnline() {
        return this.ThucHanh.endsWith(".ptit.edu.vn") || this.ThucHanh.equals("Truc tuyen");
    }

    @Override
    public int compareTo(GiangDay x) {
        return this.getMaMon().compareTo(x.getMaMon());
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s", this.MaMon, this.TenMon, this.SoTin, this.LyThuyet, this.ThucHanh);
    }
}

public class J07073 {

    public static void main(String[] args) throws FileNotFoundException {
        //Scanner sc=new Scanner(System.in);
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int n = Integer.valueOf(sc.nextLine());
        ArrayList<GiangDay> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            GiangDay x = new GiangDay(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            if (x.isThucHanhOnline()) {
                a.add(x);
            }
        }
        Collections.sort(a);
        for (GiangDay x : a) {
            System.out.println(x);
        }
    }
}
