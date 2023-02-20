/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuchanh;

import java.io.*;
import java.util.*;

/**
 *
 * @author Admin
 */
public class TongNhoNhat {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DAYSO.in"));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
    
            String s1 = "", s2 = "";
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    s1 += Integer.toString(a[i]);
                } else {
                    s2 += Integer.toString(a[i]);
                }
            }
            int num1 = Integer.parseInt(s1);
            int num2 = Integer.parseInt(s2);
            System.out.println(num1 + num2);
        }

    }
}
