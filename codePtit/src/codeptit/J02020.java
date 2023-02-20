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
public class J02020 {
    public static int n, k, cnt;
    public static int[] a = new int[100];
    public static void Try(int i) {
        for(int j = a[i - 1] + 1; j <= n - k + i; j++) {
            a[i] = j;
            if(i == k) {
                cnt++;
                for(int l = 1; l <= k; l++) {
                    System.out.print(a[l] + " ");
                }
                System.out.println();
            }else Try(i + 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        Try(1);
        System.out.println("Tong cong co " + cnt + " to hop");
    }
}
