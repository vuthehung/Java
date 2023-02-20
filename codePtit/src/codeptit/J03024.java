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
public class J03024 {

    public static boolean checkHopLe(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean checkUuThe(String s) {
        int dc = 0, dl = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) - '0') % 2 == 0) {
                dc++;
            } else {
                dl++;
            }
        }
        if (dc == dl) {
            return false;
        }
        if ((dc > dl && s.length() % 2 == 0) || (dc < dl && s.length() % 2 != 0)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String b = sc.nextLine();
        while (t-- > 0) {
            String n = sc.nextLine();
            if (checkHopLe(n)) {
                if (checkUuThe(n)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("INVALID");
            }
        }
    }
}
