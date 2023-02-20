/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeptit;

import java.util.*;

/**
 *
 * @author Admin
 */
public class J03021 {

    public static boolean check(String s) {
        int[] a = new int[s.length()];
        int d = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A' || s.charAt(i) == 'B' || s.charAt(i) == 'C') {
                a[d++] = 2;
            }
            if (s.charAt(i) == 'D' || s.charAt(i) == 'E' || s.charAt(i) == 'F') {
                a[d++] = 3;
            }
            if (s.charAt(i) == 'G' || s.charAt(i) == 'H' || s.charAt(i) == 'I') {
                a[d++] = 4;
            }
            if (s.charAt(i) == 'J' || s.charAt(i) == 'K' || s.charAt(i) == 'L') {
                a[d++] = 5;
            }
            if (s.charAt(i) == 'M' || s.charAt(i) == 'N' || s.charAt(i) == 'O') {
                a[d++] = 6;
            }
            if (s.charAt(i) == 'P' || s.charAt(i) == 'Q' || s.charAt(i) == 'R' || s.charAt(i) == 'S') {
                a[d++] = 7;
            }
            if (s.charAt(i) == 'T' || s.charAt(i) == 'U' || s.charAt(i) == 'V') {
                a[d++] = 8;
            }
            if (s.charAt(i) == 'W' || s.charAt(i) == 'X' || s.charAt(i) == 'Y' || s.charAt(i) == 'Z') {
                a[d++] = 9;
            }
        }
        for (int i = 0; i <= d / 2; i++) {
            if (a[i] != a[d - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String b = sc.nextLine();
        while (n-- > 0) {
            String s = sc.nextLine();
            s = s.toUpperCase();
            if (check(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
