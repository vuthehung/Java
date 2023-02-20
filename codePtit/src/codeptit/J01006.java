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
public class J01006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long f1 = 1;
            long f2 = 1;
            long fb = 0;
            for(int j = 3; j <= n; j++) {
                fb = f1 + f2;
                f1 = f2;
                f2 = fb;
            }
            if(n == 1 || n == 2) {
                System.out.println("1");
            }else {
                System.out.println(fb);
            }
        }
    }
}
