/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 *
 * @author Admin
 */
class CaThi implements Comparable<CaThi> {

    private String NgayThi, GioThi, PhongThi;
    private int stt;

    CaThi(int stt, String NgayThi, String GioThi, String PhongThi) {
        this.stt = stt;
        this.NgayThi = NgayThi;
        this.GioThi = GioThi;
        this.PhongThi = PhongThi;
    }

    public String getCompare() {
        return String.format("%s %s", this.NgayThi, this.GioThi);
    }

    @Override
    public int compareTo(CaThi x) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dt1 = LocalDateTime.parse(this.getCompare(), formatter);
        LocalDateTime dt2 = LocalDateTime.parse(x.getCompare(), formatter);
        if (dt1.isBefore(dt2)) {
            return -1;
        } else if (dt1.isAfter(dt2)) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("C%03d %s %s %s", this.stt, this.NgayThi, this.GioThi, this.PhongThi);
    }
}

public class J07059 {

    public static void main(String[] args) throws FileNotFoundException {
        //Scanner sc=new Scanner(System.in);
        Scanner sc = new Scanner(new File("CATHI.in"));
        int n = Integer.valueOf(sc.nextLine());
        ArrayList<CaThi> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            CaThi x = new CaThi(i + 1, sc.nextLine(), sc.nextLine(), sc.nextLine());
            a.add(x);
        }
        Collections.sort(a);
        for (CaThi x : a) {
            System.out.println(x);
        }
    }
}
