/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeptit;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
class PhanSo {
    long tu, mau;
    static Scanner sc = new Scanner(System.in);
    
    void in() {
        tu = sc.nextLong();
        mau = sc.nextLong();
    }
    
    void out() {
        System.out.printf("%d/%d", tu, mau);
    }
    
    void rutgon() {
        Long a = tu;
        Long b = mau;
        while(b != 0) {
            Long x = a % b;
            a = b;
            b = x;
        }
        tu /= a;
        mau /= a;
    }
    
    PhanSo tong(PhanSo a) {
        PhanSo c = new PhanSo();
        c.mau = mau * a.mau;
        c.tu = tu * a.mau + a.tu * mau;
        c.rutgon();
        return c;
    }
}
public class J04004 {
    public static void main(String[] args) {
        PhanSo p1 = new PhanSo();
        PhanSo p2 = new PhanSo();
        p1.in();
        p2.in();
        p1.rutgon();
        p2.rutgon();
        PhanSo p3 = p1.tong(p2);
        p3.rutgon();
        p3.out();
        
    }
}
