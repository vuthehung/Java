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
public class J02012 {
    public static void xuLy(int a[], int n) {
        for(int i = 0; i < n; i++) {
            int tmp = a[i];
            int idx = i - 1;
            while(idx >= 0 && a[idx] > tmp) {
                a[idx + 1] = a[idx];
                idx--;
            }
            a[idx + 1] = tmp;
            System.out.print("Buoc " + i + ": ");
            for(int k = 0; k < i + 1; k++) {
                System.out.print(a[k] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[100];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        xuLy(a, n);
    }
}
