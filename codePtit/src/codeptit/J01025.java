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
public class J01025 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();

        int m1 = sc.nextInt();
        int n1 = sc.nextInt();
        int m2 = sc.nextInt();
        int n2 = sc.nextInt();

        int min1 = Math.min(b1, n1);
        int max1 = Math.max(b2, n2);

        int min2 = Math.min(a1, m1);
        int max2 = Math.max(a2, m2);
        int x = Math.max(max1 - min1, max2 - min2);
        System.out.println(x * x);
    }
}
