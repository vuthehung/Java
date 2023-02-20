/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05080;

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
    
    public String getGv() {
        return gv;
    }

    @Override
    public int compareTo(LopHoc o) {
        if(this.ma.equals(o.ma))
            return this.nhom.compareTo(o.nhom);
        return this.ma.compareTo(o.ma);
    }
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + nhom;
    }
}
