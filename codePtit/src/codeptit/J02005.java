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
public class J02005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[m + 1];
        int[] c = new int[1001];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            if(c[a[i]] == 0) c[a[i]]++;
        }
        for(int j = 0; j < m; j++) {
            b[j] = sc.nextInt();
            if(c[b[j]] == 1) c[b[j]]++;
        }
        for(int i = 0; i < 1000; i++) {
            if(c[i] == 2) {
                System.out.print(i + " ");
            }
        }
    }
}
