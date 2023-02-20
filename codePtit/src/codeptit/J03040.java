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
public class J03040 {

    public static String catChuoi(String s) {
        s = s.substring(5, 8) + s.substring(9, 11);
        return s;
    }

    public static boolean check1(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) >= s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean check2(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean check3(String s) {
        return (s.charAt(0) == s.charAt(1) && s.charAt(1) == s.charAt(2) && s.charAt(3) == s.charAt(4));
    }

    public static boolean check4(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '6' && s.charAt(i) != '8') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String b = sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            s = catChuoi(s);
            if (check1(s) || check2(s) || check3(s) || check4(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
