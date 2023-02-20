/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeptit;

import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class J01014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            long n = sc.nextLong();
            long res = 0;
            for(int j = 2; j <= sqrt(n); j++){
                while(n % j == 0) {
                    res = j;
                    n /= j;
                }
            }
            if(n != 1) res = n;
            System.out.println(res);
        }
 
    }
}
