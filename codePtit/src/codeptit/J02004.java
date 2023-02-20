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
public class J02004 {
    public static boolean check(int a[], int n) {
        for(int i = 0; i < n; i++) {
            if(a[i] != a[n - i - 1]) {
                return false;
                
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int[] a = new int[100];
            int n = sc.nextInt();
            for(int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            if(check(a, n)) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        
    }
}
