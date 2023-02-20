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
public class J01021 {
    public static long Mod = 1000000007;
    public static long pow(long a, long b) {
        long res = 1;
        while(b >= 1){
            if(b % 2 == 1) {
                res *= a;
                res %= Mod;
            }
            a *= a;
            a %= Mod;
            b /= 2;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
           long a = sc.nextLong();
           long b = sc.nextLong();
           if(a == 0 && b == 0){
               break;
           }
            System.out.println(pow(a, b));
        }
            
    }
}
