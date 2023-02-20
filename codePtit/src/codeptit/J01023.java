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
public class J01023 {

    private static Scanner sc = new Scanner(System.in);

    static boolean isMatched(String target, String predict) {
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != '?') {
                if (target.charAt(i) != predict.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    static void Solve() {
        String s = sc.nextLine();
        if (s.charAt(3) == '*' || s.charAt(3) == '/') {
            System.out.println("WRONG PROBLEM!");
            return;
        }
        for (int i = 10; i < 100; i++) {
            for (int j = 10; j < 100; j++) {
                int add = i + j;
                if (add < 100) {
                    String tmp = Integer.toString(i) + " + " + Integer.toString(j) + " = " + Integer.toString(add);
                    if (isMatched(s, tmp)) {
                        System.out.println(tmp);
                        return;
                    }
                }
                int subtract = i - j;
                if (subtract > 9) {
                    String tmp = Integer.toString(i) + " - " + Integer.toString(j) + " = " + Integer.toString(subtract);
                    if (isMatched(s, tmp)) {
                        System.out.println(tmp);
                        return;
                    }
                }
            }
        }
        System.out.println("WRONG PROBLEM!");
    }

    public static void main(String[] args) {

        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            Solve();
        }
    }
}
