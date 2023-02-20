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
public class J01011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1; i <= t; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long a1 = a, b1 = b;
            long tmp;
            while(b1 != 0) {
                tmp = a1 % b1;
                a1 = b1;
                b1 = tmp;
            }
            System.out.println(a / a1 * b + " " + a1);
             
            
        }
    }
}
