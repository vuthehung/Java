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
public class J03007 {
    public static boolean check(String s) {
        String tmp = "";
        int digit_sum = 0;
        int n = s.length();
        if(s.charAt(0) != '8' && s.charAt(n - 1) != '8') {
            return false;
        }
        for(int i = 0; i < n; i++) {
            digit_sum += s.charAt(i) - '0';
            tmp = s.charAt(i) + tmp;
        }
        if(digit_sum % 10 == 0 && tmp.compareTo(s) == 0) {
            return true;
        }else {
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            String s = sc.next();
            if(check(s)) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
