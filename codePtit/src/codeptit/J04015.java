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
class LuongGv {
    String ma, hoTen, chucVu;
    int luongCb, heSoL, phuCap;
    static Scanner sc = new Scanner(System.in);
    
    void in() {
        ma = sc.nextLine();
        hoTen = sc.nextLine();
        luongCb = sc.nextInt();
        
        chucVu = ma.substring(0, 2);
        if(chucVu.equals("HT")) phuCap = 2000000;
        else if(chucVu.equals("HP")) phuCap = 900000;
        else phuCap = 500000;
        
        heSoL = Integer.parseInt(ma.substring(2));
    }
    
    int luong() {
        return luongCb * heSoL + phuCap;
    }
    
    void out() {
        System.out.printf("%s %s %d %d %d", ma, hoTen, heSoL, phuCap, luong());
    }
}
public class J04015 {
    public static void main(String[] args) {
        LuongGv l = new LuongGv();
        l.in();
        l.out();
    }
}
