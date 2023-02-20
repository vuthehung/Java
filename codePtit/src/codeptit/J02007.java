/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeptit;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class J02007 {
    public static void xuLy(int a[], int n) {
        int[] b = new int[100];
        Arrays.fill(b, 0);
        for(int i = 0; i < n; i++) {
            if(b[i] == 0) {
                b[i] = 1;
                for(int j = i + 1; j < n; j++) {
                    if(a[i] == a[j]) {
                        b[i]++;
                        b[j] = -1;
                    }
                }
            }
        }
        for(int k = 0; k < n; k++) {
            if(b[k] != -1) {
                System.out.println(a[k] + " xuat hien " + b[k] + " lan");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1; i <= t; i++){
            int n = sc.nextInt();
            int[] a = new int[100];
            for(int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            System.out.println("Test " + i + ":");
            xuLy(a, n);
        }
    }
}
