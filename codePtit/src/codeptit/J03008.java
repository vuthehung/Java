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
public class J03008 {
    public static boolean prime(int x) {
        for(int i = 2; i <= Math.sqrt(x); i++) {
            if(x % i == 0){
                return false;
            }
        }
        return x > 1;
    }
    public static boolean check(String s) {
        String tmp = "";
        for(int i = 0; i < s.length(); i++) {
            if(prime(s.charAt(i) - '0') == false) {
                return false;
            }
            tmp = s.charAt(i) + tmp;
        }
        if(tmp.compareTo(s) == 0) {
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
