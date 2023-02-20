/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05065;

import java.util.*;

/**
 *
 * @author Admin
 */
public class NhanVien implements Comparable<NhanVien>{
    public static Map<String, ArrayList<NhanVien>> m = new LinkedHashMap<>();
    private String ma, ten, chucVu;
    
    public NhanVien(String data) {
        this.ma = data.split(" +", 2)[0];
        this.ten = data.split(" +", 2)[1];
        this.chucVu = ma.substring(0, 2);
    }
    
    public void setChucVu(String cv) {
        this.chucVu = cv;
    }

    @Override
    public int compareTo(NhanVien o) {
        if(this.ma.substring(2, 4).equals(o.ma.substring(2, 4))) {
            return this.ma.substring(4, 7).compareTo(o.ma.substring(4, 7));
        }
        return o.ma.substring(2, 4).compareTo(this.ma.substring(2, 4));
    }
    
    
    @Override
    public String toString() {
        return ten + " "  + chucVu + " " + ma.substring(4, 7) + " " + ma.substring(2, 4);
    }
}
