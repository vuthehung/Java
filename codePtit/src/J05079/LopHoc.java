/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05079;

import java.util.*;

/**
 *
 * @author Admin
 */
public class LopHoc implements Comparable<LopHoc>{
    public static Map<String, ArrayList<LopHoc>> m = new HashMap<>();
    private String ma, ten, nhom, gv;
    
    public LopHoc(String ma, String ten, String nhom, String gv) {
        this.ma = ma;
        this.ten = ten;
        this.nhom = nhom;
        this.gv = gv;
    }
    
    public String getTen() {
        return ten;
    }
    
    @Override
    public String toString() {
        return nhom + " " + gv;
    }

    @Override
    public int compareTo(LopHoc o) {
        return this.nhom.compareTo(o.nhom);
    }
}
