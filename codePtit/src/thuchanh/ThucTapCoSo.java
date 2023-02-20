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
        return this.dt.tenDT.compareTo(o.dt.tenDT);
    }
    
    @Override
    public String toString() {
        return sv.maSV + " " + sv.hoTen + " " + sv.soDT + " " + sv.email + " " + dt.tenGV + " " + dt.tenDT;
    }
    
}
public class ThucTapCoSo {
    public static void main(String[] args) throws FileNotFoundException {
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
        
        sc = new Scanner(new File("NHIEMVU.in"));
        n = Integer.parseInt(sc.nextLine());
        ArrayList<NhiemVu> nv = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String maSV = sc.next();
            String maDT = sc.next();
            for(SinhVien x : sv) {
                if(x.maSV.equals(maSV)) {
                    for(DeTai y : dt) {
                        if(y.maDT.equals(maDT)) {
                            nv.add(new NhiemVu(x, y));
                        }
                    }
                }
            }
        }
        Collections.sort(nv);
        for(NhiemVu x : nv) {
            System.out.println(x);
        }
    }
}
