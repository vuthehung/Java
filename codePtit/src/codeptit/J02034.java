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
public class J02034 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[201];
        int max = 0;
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[a[i]] = 1;
            max = Math.max(max, a[i]);
        }
        boolean check = false;
        for(int i = 1; i <= max; i++) {
            if(b[i] == 0) {
                System.out.println(i);
                check = true;
            }
        }
        if(check == false) System.out.println("Excellent!");
    }
}
