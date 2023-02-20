/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J07028;

import java.io.*;
import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, GiangVien> m1 = new HashMap<>();
        Map<String, MonHoc> m2 = new HashMap<>();
        
        Scanner sc = new Scanner(new File("GIANGVIEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        while(n-- > 0) {
            String[] tmp = sc.nextLine().trim().split(" +");
            String ma = tmp[0];
            String x = "";
            for(int i = 1; i < tmp.length; i++) {
                x += tmp[i] + " ";
            }
            String ten = x.trim();
            m1.put(ma, new GiangVien(ma, ten));
        }
        
        sc = new Scanner(new File("MONHOC.in"));
        int m = Integer.parseInt(sc.nextLine());
        while(m-- > 0) {
            String[] tmp = sc.nextLine().trim().split(" +");
            String ma = tmp[0];
            String x = "";
            for(int i = 1; i < tmp.length; i++) {
                x += tmp[i] + " ";
            }
            String ten = x.trim();
            m2.put(ma, new MonHoc(ma, ten));
        }
        
        sc = new Scanner(new File("GIOCHUAN.in"));
        ArrayList<GioChuan> a = new ArrayList<>();
        ArrayList<String> ma = new ArrayList<>();
        Map<String, Float> m3 = new HashMap<>();
        int z = Integer.parseInt(sc.nextLine());
        while(z-- > 0) {
            String maGV = sc.next();
            String maMH = sc.next();
            float gio = sc.nextFloat();
            if(m3.containsKey(maGV)) {
                m3.put(maGV, m3.get(maGV) + gio);
            }else {
                m3.put(maGV, gio);
            }
            
            if(!ma.contains(maGV)) ma.add(maGV);
        }
        for(String s : ma) {
            GiangVien gv = m1.get(s);
            float gio = m3.get(s);
            a.add(new GioChuan(gv, gio));
        }
        for(GioChuan gc : a) {
            System.out.println(gc);
        }
    }
}
