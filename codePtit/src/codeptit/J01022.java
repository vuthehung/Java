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
public class J01022 {
    public static int[] fb = new int[100];
    public static int Xaunhiphan(int n, long k) {
        if(n == 1) return 0;
        if(n == 2) return 1;
        if(k <= fb[n - 2]) return Xaunhiphan(n - 2, k);
        return Xaunhiphan(n - 1, k - fb[n - 2]);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        fb[0] = 0;
        fb[1] = 1;
        for(int i = 2; i <= 92; i++) fb[i] = fb[i - 1] + fb[i - 2];
        int t = sc.nextInt();
        for(int i = 1; i <= t; i++){
            int n = sc.nextInt();
            long k = sc.nextLong();
            System.out.println(Xaunhiphan(n, k));
        }
    }
}
