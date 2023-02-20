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
public class J02014 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int sumR = 0, sumL = 0;
            int idx = -1;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                sumR += a[i];
            }
            for (int i = 0; i < n; i++) {
                sumR = sumR - a[i];
                if (sumR == sumL) {
                    idx = i + 1;
                    break;
                }
                sumL = sumL + a[i];
            }
            System.out.println(idx);
        }
    }
}
