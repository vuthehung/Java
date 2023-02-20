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
public class J02022 {
    public static int n;
    public static int[] a = new int[100];
    public static int[] used = new int[100];
    
    public static boolean check() {
        for(int i = 1; i <= n - 1; i++) {
            if(Math.abs(a[i] - a[i + 1]) == 1) return false;
        }
        return true;
    }
    public static void Try(int i) {
        for(int j = 1; j <= n; j++) {
            if(used[j] == 0) {
                a[i] = j;
                used[j] = 1;
                if(i == n) {
                    if(check()) {
                        for(int k = 1; k <= n; k++) {
                            System.out.print(a[k]);
                        }
                    }
                    System.out.println();
                }
                else Try(i + 1);
                used[j] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0) {
            t--;
            n = sc.nextInt();
            Try(1);
        } 
    }
}
