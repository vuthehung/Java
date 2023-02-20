/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuc_hanh;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class C_Uocnguyentomax {
    public static void solve(long n) {
        long res = 0;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            while(n % i == 0) {
                res = i;
                n /= i;
            }
        }
        if(n != 1)
            res = n;
        System.out.println(res);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            long n = sc.nextLong();
            solve(n);
        }
            
    }
}
