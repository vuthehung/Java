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
class MatHang implements Comparable<MatHang>{

    private String ma, ten, nhom;
    private float mua, ban, loi;
    
    public MatHang(int n, String ten, String nhom, float mua, float ban) {
        this.ma = "MH" + String.format("%02d", n);
        this.ten = ten;
        this.nhom = nhom;
        this.mua = mua;
        this.ban = ban;
        this.loi = ban - mua;
    }
    @Override
    public String toString() {
        return ma + " " + ten + " " + nhom + " " + String.format("%.2f", loi);
    }
    @Override
    public int compareTo(MatHang o) {
        if(this.loi > o.loi) return -1;
        if(this.loi < o.loi) return 1;
        return 0;
    }
    
    
}
public class J07050 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MATHANG.in"));
        ArrayList<MatHang> a = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 1; i <= n; i++) {
            MatHang tmp = new MatHang(i, sc.nextLine(), sc.nextLine(), Float.parseFloat(sc.nextLine()), Float.parseFloat(sc.nextLine()));
            a.add(tmp);
        }
        Collections.sort(a);
        for(MatHang x : a) {
            System.out.println(x);
        }
    }
}
