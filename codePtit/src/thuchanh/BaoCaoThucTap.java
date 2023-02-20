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
class SinhVien {
    String maSV, hoTen, soDT, email;
    
    public SinhVien(String maSV, String hoTen, String soDT, String email) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.soDT = soDT;
        this.email = email;
    }
}

class DeTai {
    String maDT, tenGV, tenDT;
    
    public DeTai(int n, String tenGV, String tenDT) {
        this.maDT = String.format("DT%03d", n);
        this.tenGV = tenGV;
        this.tenDT = tenDT;
    }
}

class NhiemVu implements Comparable<NhiemVu> {
    SinhVien sv;
    DeTai dt;

    public NhiemVu(SinhVien sv, DeTai dt) {
        this.sv = sv;
        this.dt = dt;
    }
    
    @Override
    public int compareTo(NhiemVu o) {
        return this.sv.maSV.compareTo(o.sv.maSV);
    }
    
    @Override
    public String toString() {
        return sv.maSV + " " + sv.hoTen + " " + dt.tenDT + " " + dt.tenGV;
    }
    
}
public class BaoCaoThucTap {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<SinhVien> sv = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String maSV = sc.nextLine();
            String hoTen = sc.nextLine();
            String soDT = sc.nextLine();
            String email = sc.nextLine();
            sv.add(new SinhVien(maSV, hoTen, soDT, email));
        }
        
        sc = new Scanner(new File("DETAI.in"));
        n = Integer.parseInt(sc.nextLine());
        ArrayList<DeTai> dt = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String tenGV = sc.nextLine();
            String tenDT = sc.nextLine();
            dt.add(new DeTai(i + 1, tenGV, tenDT));
        }
        
        sc = new Scanner(new File("HOIDONG.in"));
        n = Integer.parseInt(sc.nextLine());
        ArrayList<ArrayList<NhiemVu>> nv = new ArrayList<>(9);
        for(int i = 0; i < 9; i++) {
            nv.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++) {
            String maSV = sc.next();
            String maDT = sc.next();
            String maHD = sc.next();
            int l = maHD.length();
            int k = maHD.charAt(l - 1) - '0';
            for(SinhVien x : sv) {
                if(x.maSV.equals(maSV)) {
                    for(DeTai y : dt) {
                        if(y.maDT.equals(maDT)) {
                            nv.get(k).add(new NhiemVu(x, y));
                            break;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < 9; i++) 
            Collections.sort(nv.get(i));
        for(int i = 0; i < 9; i++) {
            if(!nv.get(i).isEmpty()) {
                System.out.println("DANH SACH HOI DONG " + i + ":");
                for(NhiemVu x : nv.get(i)) {
                    System.out.println(x);
                }
            }
        }
    }
}
