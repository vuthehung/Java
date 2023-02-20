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
  
    
}
public class J04003 {
    public static void main(String[] args) {
        PhanSo p = new PhanSo();
        p.in();
        p.rutgon();
        p.out();
    }
}
