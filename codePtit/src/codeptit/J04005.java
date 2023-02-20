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
public class J04005 {
    static Scanner sc = new Scanner(System.in);
    
    static class sinhVien {
        String name;
        String dob;
        float d1, d2, d3, sum;
        
        public void input() {
            name = sc.nextLine();
            dob = sc.nextLine();
            d1 = sc.nextFloat();
            d2 = sc.nextFloat();
            d3 = sc.nextFloat();
            sum = d1 + d2 + d3;
        }
        public void output() {
            System.out.printf("%s %s %.1f", name, dob, sum);
        }
    }
    
    public static void main(String[] args) {
        sinhVien sv = new sinhVien();
        sv.input();
        sv.output();
    }
}
