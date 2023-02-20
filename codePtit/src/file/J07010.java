/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

/**
 *
 * @author Admin
 */
import java.io.*;
import java.util.*;
import java.text.*;
class SinhVien{
        private String ma, hoten, lop;
        private Date ns;
        private float gpa;
        
        public SinhVien(int n, String hoten, String lop, String ns, float gpa) throws ParseException {
            this.ma = "B20DCCN" + String.format("%03d", n);
            this.hoten = hoten;
            this.lop = lop;
            this.ns = new SimpleDateFormat("dd/MM/yyyy").parse(ns);
            this.gpa = gpa;
        }

        @Override
        public String toString() {
            return ma + " " + hoten + " " + lop + " " + new SimpleDateFormat("dd/MM/yyyy").format(ns) + " " + String.format("%.2f", gpa);
        }
}
public class J07010 {
    
    
    public static void main(String[] args) throws ParseException, FileNotFoundException{
        Scanner in = new Scanner(new File("SV.in"));
    
        int n = Integer.parseInt(in.nextLine());
        for(int i = 1; i <= n; i++) {
            SinhVien tmp = new SinhVien(i, in.nextLine(), in.nextLine(), in.nextLine(), Float.parseFloat(in.nextLine()));
            System.out.println(tmp);
        }
        
        
    }
}
