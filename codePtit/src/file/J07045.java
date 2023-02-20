/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import java.util.*;
import java.io.*;

/**
 *
 * @author Admin
 */
class LoaiPhong implements Comparable<LoaiPhong>{
    private String ma, ten;
    private int gia;
    private float phi;
    
    public LoaiPhong(String s) {
        String[] a_s = s.split(" ");
        this.ma = a_s[0];
        this.ten = a_s[1];
        this.gia = Integer.parseInt(a_s[2]);
        this.phi = Float.parseFloat(a_s[3]);
    }
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + gia + " " + phi;
    }
    
    @Override
    public int compareTo(LoaiPhong p) {
       return this.ten.compareTo(p.ten);
    }
  
}
public class J07045 {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
    }
        
}
